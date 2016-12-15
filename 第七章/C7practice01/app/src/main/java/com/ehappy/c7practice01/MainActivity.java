package com.ehappy.c7practice01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView lstFruit;
    private TextView txtResult;
    String[] Fruit = new String[] {"香蕉", "西瓜", "梨子", "水蜜桃"};
    int[] Price=new int[] {330,120,250,280};

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

        lstFruit = (ListView)findViewById(R.id.lstFruit);
        txtResult = (TextView)findViewById(R.id.txtResult);

        ArrayAdapter<String> adapterFruit = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Fruit);

        lstFruit.setAdapter(adapterFruit);

        lstFruit.setOnItemClickListener(lstFruitListener);
    }

    private ListView.OnItemClickListener lstFruitListener = new ListView.OnItemClickListener(){
        @Override
        public void  onItemClick(AdapterView<?> parent, View view, int position, long id){
            String sel = parent.getItemAtPosition(position).toString();
            txtResult.setText(sel + "每斤" + Price[position] + "元");
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
