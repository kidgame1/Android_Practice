package com.ehappy.exspinner01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spnPrefer;
    String[] Balls = new String[] {" 籃球 ", " 足球 ", " 棒球 ", " 其他 "};
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtResult = (TextView)findViewById(R.id.txtResult);
        spnPrefer = (Spinner)findViewById(R.id.spnPrefer);

        ArrayAdapter<String> adapterBalls = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Balls);

        adapterBalls.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnPrefer.setAdapter(adapterBalls);

        spnPrefer.setOnItemSelectedListener(spnPreferListener);
    }

    private Spinner.OnItemSelectedListener spnPreferListener = new Spinner.OnItemSelectedListener() {

        public void onItemSelectde(AdapterView<?> parent, View view, int position, long id){
            String sel = parent.getSelectedItem().toString();
            txtResult.setText(sel);
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent){

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
