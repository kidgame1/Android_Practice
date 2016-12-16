package com.ehappy.c4practice2;

import android.content.DialogInterface;
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

public class MainActivity extends AppCompatActivity {

    private Button btnOne, btnTwo, btnThree, btnFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);

        btnOne.setOnClickListener(listener);
        btnTwo.setOnClickListener(listener);
        btnThree.setOnClickListener(listener);
        btnFour.setOnClickListener(listener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private Button.OnClickListener listener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnOne:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("顯示視窗")
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("您按了<按鈕一>" +
                                    "按<確定>關閉對話方塊")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialoginterface, int i){
                                    finish();
                                }
                            })
                            .show();
                    break;

                case R.id.btnTwo:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("顯示視窗")
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("您按了<按鈕二>" +
                                    "按<確定>關閉對話方塊")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialoginterface, int i){
                                    finish();
                                }
                            })
                            .show();
                    break;

                case R.id.btnThree:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("顯示視窗")
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("您按了<按鈕三>" +
                                    "按<確定>關閉對話方塊")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialoginterface, int i){
                                    finish();
                                }
                            })
                            .show();
                    break;

                case R.id.btnFour:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("顯示視窗")
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("您按了<按鈕四>" +
                                    "按<確定>關閉對話方塊")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialoginterface, int i){
                                    finish();
                                }
                            })
                            .show();
                    break;
            }
        }
    };

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
