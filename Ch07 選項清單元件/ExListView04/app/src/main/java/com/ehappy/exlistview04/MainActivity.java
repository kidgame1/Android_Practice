package com.ehappy.exlistview04;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView lstPrefer;
    int[] resIds = new int[] {R.drawable.basketball, R.drawable.football, R.drawable.baseball, R.drawable.other};
    String[] Balls = new String[] {"籃球", "足球", "棒球", "其他"};
    String[] engNames = {"Basket Ball", "Foot  Ball", "Base Ball", "Other"};

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

        lstPrefer = (ListView)findViewById(R.id.lstPrefer);

        MyAdapter adapter = new MyAdapter(this);

        lstPrefer.setAdapter(adapter);

    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater myInflater;
        public MyAdapter(Context c){
            myInflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount(){
            return Balls.length;
        }

        @Override
        public Object getItem(int position){
            return Balls[position];
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            convertView = myInflater.inflate(R.layout.mylayout, null);

            ImageView imgLogo = (ImageView)convertView.findViewById(R.id.imgLogo);
            TextView txtName = ((TextView)convertView.findViewById(R.id.txtName));
            TextView txtengName = ((TextView)convertView.findViewById(R.id.txtengName));

            imgLogo.setImageResource(resIds[position]);
            txtName.setText(Balls[position]);
            txtengName.setText(engNames[position]);

            return convertView;
        }
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
