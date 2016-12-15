package com.ehappy.c8practice02;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] imgId = {R.drawable.img01, R.drawable.img02, R.drawable.img03,
            R.drawable.img04, R.drawable.img05, R.drawable.img06};
    private Button btnNext;
    private ImageView imgPhoto;
    int p = 0;
    int count = imgId.length;

    String[] BookId={"AEL011200","AEL011300","AEL011400","ACL030131","ACL027400","ACL027100"};
    String[] BookName={"Visual C# 2010程式設計速學對策",
            "Visual Basic 2010 程式設計速學對策",
            "ASP.NET 4.0 網頁程式設計速學對策(使用C#)",
            "挑戰Visual Basic 2008程式設計樂活學",
            "挑戰Visual C# 2008程式設計樂活學",
            "挑戰Visual C++ 2008程式設計樂活學"};

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

        btnNext = (Button)findViewById(R.id.btnNext);
        imgPhoto = (ImageView)findViewById(R.id.imgPhoto);

        btnNext.setOnClickListener(btnNextListener);

        registerForContextMenu(imgPhoto);
    }

    private Button.OnClickListener btnNextListener = new Button.OnClickListener(){
        public void onClick(View v){
            p++;
            if (p==count)
                p = 0;
            imgPhoto.setImageResource(imgId[p]);
            setTitle(" 第 " + (p+1) + "/" + count);
        }
    };

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v==imgPhoto){
            String str="書號： " + BookId[p] + "\n" + "書名： " + BookName[p];
            Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
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
