package com.ehappy.exintent02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Second extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        Button btnHome = (Button)findViewById(R.id.btnHome);

        btnHome.setOnClickListener(btnHomeListener);
    }

    private Button.OnClickListener btnHomeListener = new Button.OnClickListener(){
        public void onClick(View v){
            finish();
        }
    };
}
