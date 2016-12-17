package com.ehappy.exlogin;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText edtID, edtPW;
    private Button btnOK, btnReset;
    private String[] login;
    private File filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtID = (EditText)findViewById(R.id.edtID);
        edtPW = (EditText)findViewById(R.id.edtPW);
        btnOK = (Button)findViewById(R.id.btnOK);
        btnReset = (Button)findViewById(R.id.btnReset);
        btnOK.setOnClickListener(listener);
        btnReset.setOnClickListener(listener);

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        } else {
            filename = new File(Environment.getExternalStorageDirectory(), "login.txt");
            try {
                FileInputStream fin = new FileInputStream(filename);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
                String line = "", wholedata = "";
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    wholedata = wholedata + line + "\n";
                    i++;
                }
                login = wholedata.split("\n");
                reader.close();
                fin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("取得權限")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("已取得權限，按確定鈕結束應用程式後重新啟動。")
                        .setPositiveButton("確定", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialoginterface, int i) {
                                        finish();
                                    }
                                })
                        .show();
            } else {
                Toast.makeText(this, "未取得權限！", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private Button.OnClickListener listener=new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnOK:
                    if(edtID.getText().toString().equals("") || edtPW.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(), "帳號及密碼都必須輸入！", Toast.LENGTH_LONG) .show();
                        break;
                    }
                    Boolean flag=false;
                    for(int i=0;i<login.length;i+=2){
                        if(edtID.getText().toString().equals(login[i])){
                            flag=true;
                            if(edtPW.getText().toString().equals(login[i+1])){
                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("登入")
                                        .setMessage("登入成功！\n歡迎使用本應用程式！")
                                        .setPositiveButton("確定", new DialogInterface.OnClickListener()
                                        {
                                            public void onClick(DialogInterface dialoginterface, int i) {
                                                finish();
                                            }
                                        })
                                        .show();
                            } else {
                                Toast.makeText(getApplicationContext(), "密碼不正確！", Toast.LENGTH_LONG) .show();
                                edtPW.setText("");
                                break;
                            }
                        }
                    }
                    if(!flag) {
                        Toast.makeText(getApplicationContext(), "帳號不正確！", Toast.LENGTH_LONG) .show();
                        edtID.setText("");
                        edtPW.setText("");
                    }
                    break;
                case R.id.btnReset:
                    edtID.setText("");
                    edtPW.setText("");
                    break;
            }
        }
    };
}
