package com.ehappy.exmultibutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtShow;
    private Button btnZero, btnone, btnTwo, btnThree, btnFour, btnFive,
    btnSix, btnSeven, btnEight, btnNine, btnStar, btnPound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtShow = (TextView)findViewById(R.id.txtShow);
        btnone = (Button)findViewById(R.id.btnOne);
        btnTwo = (Button)findViewById(R.id.btnTwo);
        btnThree = (Button)findViewById(R.id.btnThree);
        btnFour = (Button)findViewById(R.id.btnFour);
        btnFive = (Button)findViewById(R.id.btnFive);
        btnSix = (Button)findViewById(R.id.btnSix);
        btnSeven = (Button)findViewById(R.id.btnSeven);
        btnEight = (Button)findViewById(R.id.btnEight);
        btnNine = (Button)findViewById(R.id.btnNine);
        btnStar = (Button)findViewById(R.id.btnStar);
        btnPound = (Button)findViewById(R.id.btnPound);

        btnZero.setOnClickListener(myListener);
        btnone.setOnClickListener(myListener);
        btnTwo.setOnClickListener(myListener);
        btnThree.setOnClickListener(myListener);
        btnFour.setOnClickListener(myListener);
        btnFive.setOnClickListener(myListener);
        btnSix.setOnClickListener(myListener);
        btnSeven.setOnClickListener(myListener);
        btnEight.setOnClickListener(myListener);
        btnNine.setOnClickListener(myListener);
        btnStar.setOnClickListener(myListener);
        btnPound.setOnClickListener(myListener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private Button.OnClickListener myListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            String s = txtShow.getText().toString();
            switch (v.getId()){
                case R.id.btnZero:{
                    txtShow.setText(s + "0");
                    break;
                }
                case R.id.btnOne:{
                    txtShow.setText(s + "1");
                    break;
                }
                case R.id.btnTwo:{
                    txtShow.setText(s + "2");
                    break;
                }
                case R.id.btnThree:{
                    txtShow.setText(s + "3");
                    break;
                }
                case R.id.btnFour:{
                    txtShow.setText(s + "4");
                    break;
                }
                case R.id.btnFive:{
                    txtShow.setText(s + "5");
                    break;
                }
                case R.id.btnSix:{
                    txtShow.setText(s + "6");
                    break;
                }
                case R.id.btnSeven:{
                    txtShow.setText(s + "7");
                    break;
                }
                case R.id.btnEight:{
                    txtShow.setText(s + "8");
                    break;
                }
                case R.id.btnNine:{
                    txtShow.setText(s + "9");
                    break;
                }
                case R.id.btnStar:{
                    txtShow.setText(s + "*");
                    break;
                }
                case R.id.btnPound:{
                    txtShow.setText(s + "#");
                    break;
                }
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
