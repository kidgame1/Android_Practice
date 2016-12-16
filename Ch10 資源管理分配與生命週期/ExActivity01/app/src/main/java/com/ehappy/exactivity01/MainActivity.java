package com.ehappy.exactivity01;

import android.content.Intent;
import android.net.Uri;
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

        Button btnDial = (Button)findViewById(R.id.btnDial);
        Button btnPage2 = (Button)findViewById(R.id.btnPage2);
        Button btnFinish = (Button)findViewById(R.id.btnFinish);

        btnDial.setOnClickListener(myListener);
        btnPage2.setOnClickListener(myListener);
        btnFinish.setOnClickListener(myListener);

        Toast.makeText(getApplicationContext(), "onCreat(1)", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(), "onCreat(1)", Toast.LENGTH_SHORT).show();
    }

    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(), "onCreat(1)", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onCreat(1)", Toast.LENGTH_SHORT).show();
    }

    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(), "onCreat(1)", Toast.LENGTH_SHORT).show();
    }

    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), "onCreat(1)", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onCreat(1)", Toast.LENGTH_SHORT).show();
    }


    private Button.OnClickListener myListener = new Button.OnClickListener(){
        public void onClick(View v){
            if (v.getId() == R.id.btnFinish)
                finish();
            else if (v.getId() == R.id.btnPage2){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Second.class);
                startActivity(intent);
            }
            else if (v.getId() == R.id.btnDial){
                Uri uri = Uri.parse("tel : 0999123456");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
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
