package com.ehappy.c14practice02;

import android.database.Cursor;
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

    private MyDB db=null;

    ListView listview01;
    Button btnSearch,btnSearchAll;
    EditText edtNo;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNo=(EditText)findViewById(R.id.edtNo);
        btnSearch=(Button)findViewById(R.id.btnSaerch);
        btnSearchAll=(Button)findViewById(R.id.btnSearchAll);
        listview01=(ListView)findViewById(R.id.ListView01);

        btnSearch.setOnClickListener(myListener);
        btnSearchAll.setOnClickListener(myListener);

        db =new MyDB(this);
        db.open();
        cursor=db.getAll();
        if (cursor.getCount() == 0){
            db.append(1,"玉米");
            db.append(2,"蕃薯");
            db.append(3,"花生");
            db.append(5,"小麥");
            db.append(8,"大豆");
        }
        cursor=db.getAll();
        UpdataAdapter(cursor);
    }

    private Button.OnClickListener myListener=new Button.OnClickListener(){
        public void onClick(View v){
            try{
                switch (v.getId()){
                    case R.id.btnSaerch:{
                        long no = Integer.parseInt(edtNo.getText().toString());
                        cursor=db.get(no);
                        UpdataAdapter(cursor);
                        break;
                    }
                    case R.id.btnSearchAll:{
                        cursor=db.getAll();
                        UpdataAdapter(cursor);
                        break;
                    }
                }
            }catch (Exception err){
                Toast.makeText(getApplicationContext(), "查無此資料!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onDestroy(){
        super.onDestroy();
        db.droptable();
        db.close();
    }

    public void UpdataAdapter(Cursor cursor){
        if (cursor != null && cursor.getCount() >= 0){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[] { "no", "name" },
                    new int[] { android.R.id.text1, android.R.id.text2 },
                    0);
            listview01.setAdapter(adapter);
        }
    }
}
