package com.ehappy.excheckbox01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private CheckBox chkBasketBall, chkBaseBall, chkFootBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtResult = (TextView)findViewById(R.id.txtResult);
        chkBasketBall = (CheckBox)findViewById(R.id.chkBasketBall);
        chkFootBall = (CheckBox)findViewById(R.id.chkFootBall);
        chkBaseBall = (CheckBox)findViewById(R.id.chkBaseBall);

        chkBasketBall.setOnCheckedChangeListener(myListener);
        chkFootBall.setOnCheckedChangeListener(myListener);
        chkBaseBall.setOnCheckedChangeListener(myListener);
    }

    private CheckBox.OnCheckedChangeListener myListener = new  CheckBox.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonVies, boolean isChecked){
            int n = 0;
            String sel = "";
            String s1 = "", s2 = "";
            String s3 = "";
            if(chkBasketBall.isChecked()){
                n++;
                s1 = chkBasketBall.getText().toString() + " ";
            }
            else{
                s1 = "";
            }

            if(chkFootBall.isChecked()){
                n++;
                s2 = chkFootBall.getText().toString() + " ";
            }
            else{
                s2 = "";
            }

            if(chkBaseBall.isChecked()){
                n++;
                s3 = chkBaseBall.getText().toString() + " ";
            }
            else{
                s3 = "";
            }
            sel = s1 + s2 + s3;
            txtResult.setText("最喜歡的球類有： " + sel + "共 " + n + "項");
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
