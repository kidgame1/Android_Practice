package com.ehappy.exlistview01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView lstPrefer;
    String[] Balls = new String[] {"籃球", "足球", "棒球", "其他"};
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstPrefer = (ListView)findViewById(R.id.lstPrefer);
        txtResult = (TextView)findViewById(R.id.txtResult);

        ArrayAdapter<String> adapterBalls = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Balls);

        lstPrefer.setAdapter(adapterBalls);

        lstPrefer.setOnItemClickListener(lstPreferListener);
    }

    private ListView.OnItemClickListener lstPreferListener = new ListView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            String sel = parent.getItemAtPosition(position).toString();
            txtResult.setText("我最喜歡的球類運動是：" + sel);
        }
    };
}
