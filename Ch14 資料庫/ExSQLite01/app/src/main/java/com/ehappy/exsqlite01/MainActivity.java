package com.ehappy.exsqlite01;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db = null;

    private final static String CREATE_TABLE = "CREATE TABLE table01(_id INTEGER PRIMARY KEY,num INTERGER,data TEXT)";

    ListView listview01;
    Button btnDo;
    EditText edtSQL;
    String str,itemdata;
    int n=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listview01 = (ListView)findViewById(R.id.ListView01);
        btnDo = (Button)findViewById(R.id.btnDo);
        edtSQL = (EditText)findViewById(R.id.edtSQL);

        btnDo.setOnClickListener(btnDoClick);

        itemdata = "資料項目" + n;
        str = "INSERT INTO table01 (num,data) values (" + n + ",'" + itemdata + "')";
        edtSQL.setText(str);

        db = openOrCreateDatabase("db1.db", MODE_PRIVATE, null);
        try{
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            UpdateAdapter();
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        db.execSQL("DROP TABLE table01");
        db.close();
    }

    private Button.OnClickListener btnDoClick=new Button.OnClickListener(){
        public void onClick(View v){
            try{
                db.execSQL(edtSQL.getText().toString());
                UpdateAdapter();
                n++;
                itemdata="資料項目" + n;
                str="INSERT INTO table01 (num,data) values (" + n + ",'" + itemdata + "')";
                edtSQL.setText(str);
            }catch (Exception err){
                setTitle("SQL 語法錯誤!");
            }
        }
    };

    public void UpdateAdapter(){
        Cursor cursor = db.rawQuery("SELECT * FROM table01", null);
        if (cursor != null && cursor.getCount() >= 0){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[] { "num", "data" },
                    new int[] { android.R.id.text1, android.R.id.text2 },
                    0);
            listview01.setAdapter(adapter);
        }
    }
}