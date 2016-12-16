package com.ehappy.exgallery01;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
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
        Gallery gal = (Gallery)findViewById(R.id.Gallery01);

        MyAdapter adapter = new MyAdapter(this);

        gal.setAdapter(adapter);

        gal.setOnItemSelectedListener(galListener);
    }

    private Gallery.OnItemSelectedListener galListener = new Gallery.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
            imgShow.setImageResource(imageIds[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0){

        }
    };

    class MyAdapter extends BaseAdapter {
         private Context mContext;

        public MyAdapter(Context c){
            mContext = c;
        }

        public int getCount(){
            return imageIds.length;
        }

        public Object getItem(int position){
            return position;
        }

        public long getItemId(int position){
            return position;
        }

        public View getView(int position, View contextView, ViewGroup parent){
            ImageView iv = new ImageView(mContext);
            iv.setImageResource(imageIds[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setLayoutParams(new Gallery.LayoutParams(120, 90));
            return iv;
        }
    }

}
