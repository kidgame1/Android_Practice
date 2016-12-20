package com.ehappy.c14practice01;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db = null;
    private final static String	CREATE_TABLE = "CREATE TABLE mytable" +
            "(_id INTEGER PRIMARY KEY,no INTERGER,name TEXT)";

    ListView listview01;
    Button btnSearch,btnSearchAll;
    EditText edtID;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        edtID = (EditText)findViewById(R.id.edtID);
        btnSearch = (Button)findViewById(R.id.btnSaerch);
        btnSearchAll = (Button)findViewById(R.id.btnSearchAll);
        listview01 = (ListView)findViewById(R.id.ListView01);

        btnSearch.setOnClickListener(myListener);
        btnSearchAll.setOnClickListener(myListener);

        db =openOrCreateDatabase("mydb.db", MODE_PRIVATE, null);
        try{
            db.execSQL(CREATE_TABLE);
            db.execSQL("INSERT INTO mytable(no,name) values (1,'玉米')");
            db.execSQL("INSERT INTO mytable (no,name) values (2,'蕃薯')");
            db.execSQL("INSERT INTO mytable(no,name) values (3,'花生')");
            db.execSQL("INSERT INTO mytable (no,name) values (5,'小麥')");
            db.execSQL("INSERT INTO mytable (no,name) values (8,'大豆')");
        }catch (Exception e){
        }
        cursor=getAll();
        UpdataAdapter(cursor);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        db.close();
    }

    private Button.OnClickListener myListener=new Button.OnClickListener(){
        public void onClick(View v){
            try{
                switch (v.getId()){
                    case R.id.btnSaerch:{
                        long no = Integer.parseInt(edtID.getText().toString());
                        cursor=get(no);
                        UpdataAdapter(cursor);
                        break;
                    }
                    case R.id.btnSearchAll:{
                        cursor=getAll();
                        UpdataAdapter(cursor);
                        break;
                    }
                }
            }catch (Exception err){
                Toast.makeText(getApplicationContext(), "查無此資料!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public void UpdataAdapter(Cursor cursor){
        if (cursor != null && cursor.getCount() >= 0){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[] {"no", "name" },
                    new int[] { android.R.id.text1, android.R.id.text2 },
                    0);
            listview01.setAdapter(adapter);
        }
    }

    public Cursor getAll(){
        Cursor cursor= db.rawQuery("SELECT _id, no, name FROM mytable Order by no",null);
        return cursor;
    }

    public Cursor get(long rowId) throws SQLException {
        Cursor cursor= db.rawQuery("SELECT _id, no, name FROM mytable WHERE no="+rowId,null);
        if (cursor.getCount()>0)
            cursor.moveToFirst();
        else
            Toast.makeText(getApplicationContext(), "查無此筆資料!", Toast.LENGTH_SHORT).show();
        return cursor;
    }
}
