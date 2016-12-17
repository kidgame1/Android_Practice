package com.ehappy.exwelcome;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtName;
    private EditText edtName;
    private Button btnEnd, btnClear;
    private String sname, msg;
    private SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txtName = (TextView)findViewById(R.id.txtName);
        edtName = (EditText)findViewById(R.id.edtName);
        btnEnd = (Button)findViewById(R.id.btnEnd);
        btnClear = (Button)findViewById(R.id.btnClear);

        btnEnd.setOnClickListener(listener);
        btnClear.setOnClickListener(listener);

        preference = getSharedPreferences("preFile", MODE_PRIVATE);
        sname = preference.getString("name", "");

        if(sname.equals("")){
            txtName.setVisibility(TextView.VISIBLE);
            edtName.setVisibility(TextView.VISIBLE);
            btnClear.setVisibility(Button.INVISIBLE);
            msg = "歡迎使用本應用程式！ \n 你尚未建立基本資料，請輸入姓名！";
        } else{
            msg = " 親愛的 " + sname + " ，你好！\n 歡迎再次使用本應用程式！ ";
        }

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("歡迎使用本軟體！")
                .setMessage(msg)
                .setPositiveButton("確定", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialoginterface, int i)
            {}
        })
                .show();
    }

    private Button.OnClickListener listener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnEnd:
                    finish();
                    break;

                case R.id.btnClear:
                    if(!sname.equals("")) {
                        preference.edit()
                                .clear()
                                .commit();
                        Toast.makeText(getApplicationContext(), "所有資料都已清除！", Toast.LENGTH_LONG) .show();
                    }
                    btnClear.setVisibility(Button.INVISIBLE);
                    break;
            }
        }
    };

    protected void onStop(){
        super.onStop();
        if(sname.equals("")) {
            preference.edit()
                    .putString("name", edtName.getText().toString())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
