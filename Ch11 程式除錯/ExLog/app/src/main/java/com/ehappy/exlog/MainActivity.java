package com.ehappy.exlog;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String TAG = "myLog";

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

        Button btnFinish = (Button)findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(btnFinishListener);

        Log.d(TAG, "onCreate()");

    }

    @Override
    protected void onStart(){
        super.onStart();;
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();;
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();;
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onPause(){
        super.onPause();;
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();;
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();;
        Log.d(TAG, "onDestroy()");
    }

    private Button.OnClickListener btnFinishListener = new Button.OnClickListener(){
        public void onClick(View v){
            finish();
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
