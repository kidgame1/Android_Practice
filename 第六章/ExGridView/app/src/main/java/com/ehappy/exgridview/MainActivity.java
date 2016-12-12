package com.ehappy.exgridview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int[] imageIds = {
            R.drawable.img01, R.drawable.img02, R.drawable.img03,
            R.drawable.img04, R.drawable.img05, R.drawable.img06
    };
    private ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgShow = (ImageView)findViewById(R.id.imgShow);
        GridView gridView = (GridView)findViewById(R.id.GridView01);

        MyAdapter adapter = new MyAdapter(this);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                imgShow.setImageResource(imageIds[position]);
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        private Context mContext;
        public MyAdapter(Context c){
            mContext = c;
        }

        @Override
        public int getCount(){
            return imageIds.length;
        }

        @Override
        public Object getItem(int position){
            return position;
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent){
            ImageView iv = new ImageView(mContext);
            iv.setImageResource(imageIds[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setLayoutParams(new GridView.LayoutParams(80,60));
            return iv;
        }
    }
}
