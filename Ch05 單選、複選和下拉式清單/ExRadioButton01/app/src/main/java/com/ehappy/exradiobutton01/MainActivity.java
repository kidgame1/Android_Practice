package com.ehappy.exradiobutton01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private RadioButton radBasketBall, radFootBall, radBaseBall;
    private RadioGroup radGroupBalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtResult = (TextView)findViewById(R.id.txtResult);
        radGroupBalls = (RadioGroup)findViewById(R.id.radGroupBalls);
        radBasketBall = (RadioButton)findViewById(R.id.radBasketBall);
        radFootBall = (RadioButton)findViewById(R.id.radFootBall);
        radBaseBall = (RadioButton)findViewById(R.id.radBaseBall);

        radGroupBalls.setOnCheckedChangeListener(radGroupBallsListener);
    }

    private RadioGroup.OnCheckedChangeListener radGroupBallsListener = new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId){
            int p = group.indexOfChild((RadioButton)findViewById(checkedId));

            int count = group.getChildCount();

            if(checkedId == R.id.radBasketBall)
                txtResult.setText(count + " 項球類中，最喜歡第 " + (p+1) + " 項 " + radBasketBall.getText());
            else if(checkedId == R.id.radFootBall)
                txtResult.setText(count + " 項球類中，最喜歡第 " + (p+1) + " 項 " + radFootBall.getText());
            else if(checkedId == R.id.radBaseBall)
                txtResult.setText(count + " 項球類中，最喜歡第 " + (p+1) + " 項 " + radBaseBall.getText());
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
