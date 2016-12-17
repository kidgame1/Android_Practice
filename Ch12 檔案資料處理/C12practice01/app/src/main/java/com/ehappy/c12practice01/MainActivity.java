package com.ehappy.c12practice01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnEnd, btnPlay, btnStop;
    private String status, msg;
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

        btnEnd = (Button)findViewById(R.id.btnEnd);
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnStop = (Button)findViewById(R.id.btnStop);

        btnEnd.setOnClickListener(listener);
        btnPlay.setOnClickListener(listener);
        btnStop.setOnClickListener(listener);

        preference=getSharedPreferences("preFile", MODE_PRIVATE);
        status=preference.getString("Status", "0");
        if(status.equals("1")) {
            msg="目前音樂為「播放」狀態！";
        } else {
            msg="目前音樂為「停止」狀態！";
        }
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("狀態")
                .setMessage(msg)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i)
                    {	}
                })
                .show();
    }

    private Button.OnClickListener listener=new Button.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnPlay:
                    preference.edit()
                            .putString("Status", "1")
                            .commit();
                    Toast.makeText(getApplicationContext(), "目前音樂為「播放」狀態！", Toast.LENGTH_LONG) .show();
                    break;
                case R.id.btnStop:
                    preference.edit()
                            .putString("Status", "0")
                            .commit();
                    Toast.makeText(getApplicationContext(), "目前音樂為「停止」狀態！", Toast.LENGTH_LONG) .show();
                    break;
                case R.id.btnEnd:
                    finish();
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
