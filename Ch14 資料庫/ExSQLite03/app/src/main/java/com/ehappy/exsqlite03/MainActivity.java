package com.ehappy.exsqlite03;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db = null;
    private final static String CREATE_TABLE = "CREATE TABLE table01(_id INTEGER PRIMARY KEY,name TEXT,price INTERGER)";

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

        edtID=(EditText)findViewById(R.id.edtID);
        btnSearch=(Button)findViewById(R.id.btnSaerch);
        btnSearchAll=(Button)findViewById(R.id.btnSearchAll);
        listview01=(ListView)findViewById(R.id.ListView01);

        btnSearch.setOnClickListener(myListener);
        btnSearchAll.setOnClickListener(myListener);
        listview01.setOnItemClickListener(listview01Listener);

        db =openOrCreateDatabase("db1.db", MODE_PRIVATE, null);
        try{
            db.execSQL(CREATE_TABLE);
            db.execSQL("INSERT INTO table01 (name,price) values ('香蕉',30)");
            db.execSQL("INSERT INTO table01 (name,price) values ('西瓜',120)");
            db.execSQL("INSERT INTO table01 (name,price) values ('梨子',250)");
            db.execSQL("INSERT INTO table01 (name,price) values ('水蜜桃',280)");
        }catch (Exception e){
        }
        cursor=getAll();
        UpdateAdapter(cursor);
    }

    private ListView.OnItemClickListener listview01Listener=
            new ListView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    cursor.moveToPosition(position);
                    Cursor c=get(id);
                    String s= "id=" + id + "\r\n" + "name=" + c.getString(1) + "\r\n" + "price=" + c.getInt(2);
                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                }
            };

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
                        long id = Integer.parseInt(edtID.getText().toString());
                        cursor=get(id);
                        UpdateAdapter(cursor);
                        break;
                    }
                    case R.id.btnSearchAll:{
                        cursor=getAll();
                        UpdateAdapter(cursor);
                        break;
                    }
                }
            }catch (Exception err){
                Toast.makeText(getApplicationContext(), "查無此資料!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public void UpdateAdapter(Cursor cursor){
        if (cursor != null && cursor.getCount() >= 0){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    R.layout.mylayout,
                    cursor,
                    new String[] {"_id", "name", "price" },
                    new int[] { R.id.txtId, R.id.txtName, R.id.txtPrice },
                    0);
            listview01.setAdapter(adapter);
        }
    }

    public Cursor getAll(){
        Cursor cursor= db.rawQuery("SELECT _id, _id, name, price FROM table01",null);
        return cursor;
    }

    public Cursor get(long rowId) throws SQLException {
        Cursor cursor= db.rawQuery("SELECT  _id, name, price FROM table01 WHERE _id="+rowId,null);
        if (cursor.getCount()>0)
            cursor.moveToFirst();
        else
            Toast.makeText(getApplicationContext(), "查無此筆資料!", Toast.LENGTH_SHORT).show();
        return cursor;
    }
}