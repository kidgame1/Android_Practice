package com.ehappy.exinputdata;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private EditText edtID, edtPW, edtContent;
    private Button btnAppend, btnClear, btnEnd;
    private static final String FILENAME="login.txt";

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

        edtID = (EditText)findViewById(R.id.edtID);
        edtPW = (EditText)findViewById(R.id.edtPW);
        edtContent = (EditText)findViewById(R.id.edtContent);
        btnAppend = (Button)findViewById(R.id.btnAppend);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnEnd = (Button)findViewById(R.id.btnEnd);

        btnAppend.setOnClickListener(listener);
        btnClear.setOnClickListener(listener);
        btnEnd.setOnClickListener(listener);

        DisplayFile(FILENAME);
    }

    private Button.OnClickListener listener=new Button.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnAppend:
                    if(edtID.getText().toString().equals("") || edtPW.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(), "帳號及密碼都必須輸入！", Toast.LENGTH_LONG) .show();
                        break;
                    }
                    FileOutputStream fout=null;
                    BufferedOutputStream buffout=null;
                    try {
                        fout=openFileOutput(FILENAME, MODE_APPEND);
                        buffout=new BufferedOutputStream(fout);
                        buffout.write(edtID.getText().toString().getBytes());
                        buffout.write("\n".getBytes());
                        buffout.write(edtPW.getText().toString().getBytes());
                        buffout.write("\n".getBytes());
                        buffout.close();
                    }	catch(Exception e)	{
                        e.printStackTrace();
                    }
                    DisplayFile(FILENAME);
                    edtID.setText("");
                    edtPW.setText("");
                    break;
                case R.id.btnClear:
                    try {
                        fout=openFileOutput(FILENAME, MODE_PRIVATE);
                        fout.close();
                    }	catch(Exception e)	{
                        e.printStackTrace();
                    }
                    DisplayFile(FILENAME);
                    break;
                case R.id.btnEnd:
                    finish();
            }
        }
    };

    private void DisplayFile(String fname){
        FileInputStream fin = null;
        BufferedInputStream buffin = null;
        try{
            fin = openFileInput(fname);
            buffin = new BufferedInputStream(fin);
            byte[] buffbyte = new byte[20];
            edtContent.setText("");

            do{
                int flag = buffin.read(buffbyte);
                if(flag == -1)
                    break;
                else
                    edtContent.append(new String(buffbyte), 0, flag);
            } while(true);
            buffin.close();
        } catch(Exception e){
            e.printStackTrace();
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
