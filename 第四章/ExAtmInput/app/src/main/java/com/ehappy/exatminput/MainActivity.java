package com.ehappy.exatminput;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtATM;
    private Button btnN1, btnN2, btnN3, btnN4, btnN5,
            btnN6, btnN7, btnN8, btnN9, btnN0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtATM=(EditText)findViewById(R.id.edtATM);
        btnN1=(Button)findViewById(R.id.btnN1);
        btnN2=(Button)findViewById(R.id.btnN2);
        btnN3=(Button)findViewById(R.id.btnN3);
        btnN4=(Button)findViewById(R.id.btnN4);
        btnN5=(Button)findViewById(R.id.btnN5);
        btnN6=(Button)findViewById(R.id.btnN6);
        btnN7=(Button)findViewById(R.id.btnN7);
        btnN8=(Button)findViewById(R.id.btnN8);
        btnN9=(Button)findViewById(R.id.btnN9);
        btnN0=(Button)findViewById(R.id.btnN0);

        btnN1.setOnClickListener(listener);
        btnN2.setOnClickListener(listener);
        btnN3.setOnClickListener(listener);
        btnN4.setOnClickListener(listener);
        btnN5.setOnClickListener(listener);
        btnN6.setOnClickListener(listener);
        btnN7.setOnClickListener(listener);
        btnN8.setOnClickListener(listener);
        btnN9.setOnClickListener(listener);
        btnN0.setOnClickListener(listener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private Button.OnClickListener listener = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.btnN1:
                    displayATM("1");
                    break;

                case R.id.btnN2:
                    displayATM("2");
                    break;

                case R.id.btnN3:
                    displayATM("3");
                    break;

                case R.id.btnN4:
                    displayATM("4");
                    break;

                case R.id.btnN5:
                    displayATM("5");
                    break;

                case R.id.btnN6:
                    displayATM("6");
                    break;

                case R.id.btnN7:
                    displayATM("7");
                    break;

                case R.id.btnN8:
                    displayATM("8");
                    break;

                case R.id.btnN9:
                    displayATM("9");
                    break;

                case R.id.btnN0:
                    displayATM("0");
                    break;
            }
        }
    };

    private void displayATM(String s){
        String str = edtATM.getText().toString();
        edtATM.setText(str + s);
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
