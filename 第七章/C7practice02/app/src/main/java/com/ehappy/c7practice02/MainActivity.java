package com.ehappy.c7practice02;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private ListView lstFruit;
    private Button btnDo;
    String[] Balls = new String[] {"香蕉", "西瓜", "梨子", "水蜜桃"};
    int[] Price=new int[] {330,120,250,280};
    int count;

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

        btnDo = (Button)findViewById(R.id.btnDo);
        txtResult = (TextView)findViewById(R.id.txtResult);
        lstFruit = (ListView)findViewById(R.id.lstFruit);

        ArrayAdapter<String> adapterBalls = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, Balls);

        lstFruit.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        lstFruit.setAdapter(adapterBalls);

        count = adapterBalls.getCount();

        btnDo.setOnClickListener(btnDoListener);
        lstFruit.setOnItemClickListener(lstPreferListener);
    }

    private Button.OnClickListener btnDoListener = new Button.OnClickListener(){
        public void onClick(View v){
            String selAll = "";
            int priceAll = 0;
            for(int p = 0; p < count; p++){
                if (lstFruit.isItemChecked(p)) {
                    selAll += Balls[p] + " ";
                    priceAll += Price[p];
                }
            }
            txtResult.setText("選購了 :" + selAll + "\n" + "總額： " + priceAll);
        }
    };

    private ListView.OnItemClickListener lstPreferListener = new ListView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            String sel = parent.getItemAtPosition(position).toString();
            if (lstFruit.isItemChecked(position)){
                setTitle(sel + "每斤" + Price[position] + "元");
            } else{
                setTitle("取消選取：" + sel);
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
