package com.ehappy.exphotoplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] imgId = {R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04,
            R.drawable.img05, R.drawable.img06};
    private Button btnPrev, btnNext;
    private ImageView imgPhoto;
    int p = 0;
    int count = imgId.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPrev = (Button)findViewById(R.id.btnPrev);
        btnNext = (Button)findViewById(R.id.btnNext);
        imgPhoto = (ImageView)findViewById(R.id.imgPhoto);

        btnPrev.setOnClickListener(btnPrevListener);
        btnNext.setOnClickListener(btnNextListener);
    }

    private Button.OnClickListener btnPrevListener = new Button.OnClickListener(){
        public void onClick(View v){
            p--;
            if(p < 0)
                p = count - 1;
            imgPhoto.setImageResource(imgId[p]);
            setTitle(" 第 " + (p + 1) + " / " + count);
        }
    };

    private Button.OnClickListener btnNextListener = new Button.OnClickListener(){
        public void onClick(View v){
            p++;
            if(p == count)
                p = 0;
            imgPhoto.setImageResource(imgId[p]);
            setTitle(" 第 " + (p + 1) + " / " + count);
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
