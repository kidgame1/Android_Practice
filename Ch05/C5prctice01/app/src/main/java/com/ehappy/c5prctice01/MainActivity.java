package com.ehappy.c5prctice01;

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
    private CheckBox chkJAVA, chkC, chkAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtResult = (TextView)findViewById(R.id.txtResult);
        chkJAVA = (CheckBox)findViewById(R.id.chkJAVA);
        chkC = (CheckBox)findViewById(R.id.chkC);
        chkAndroid = (CheckBox)findViewById(R.id.chkAndroid);

        chkJAVA.setOnCheckedChangeListener(myListener);
        chkC.setOnCheckedChangeListener(myListener);
        chkAndroid.setOnCheckedChangeListener(myListener);
    }

    private CheckBox.OnCheckedChangeListener myListener = new CheckBox.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            int n = 0;
            String sel = "";
            String s1 = "", s2 = "", s3 = "";
            if(chkJAVA.isChecked()) {
                n++;
                s1 = chkJAVA.getText().toString() + " ";
            }else {
                s1 = "";
            }

            if(chkC.isChecked()) {
                n++;
                s2 = chkC.getText().toString() + " ";
            }else {
                s2 = "";
            }

            if(chkAndroid.isChecked()) {
                n++;
                s3 = chkAndroid.getText().toString() + " ";
            }else {
                s3 = "";
            }
            sel = s1 + s2 + s3;
            txtResult.setText("最喜歡的程式語言有：" + sel + " 共 " + n + " 項 ");
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
