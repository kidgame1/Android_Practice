package com.ehappy.exactivity01;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        Button btnHome = (Button)findViewById(R.id.btnHome);
        btnHome.setOnClickListener(myListener);

        Toast.makeText(getApplicationContext(), "onCreat(2)", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(), "onCreat(2)", Toast.LENGTH_SHORT).show();
    }

    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(), "onCreat(2)", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onCreat(2)", Toast.LENGTH_SHORT).show();
    }

    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(), "onCreat(2)", Toast.LENGTH_SHORT).show();
    }

    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), "onCreat(2)", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onCreat(2)", Toast.LENGTH_SHORT).show();
    }

    private Button.OnClickListener myListener = new Button.OnClickListener(){
        public void onClick(View v){
            finish();
        }
    };
}
