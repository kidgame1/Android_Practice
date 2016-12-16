package com.ehappy.exintent03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Second extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        TextView txtShow = (TextView)findViewById(R.id.txtShow);
        Button btnHome = (Button)findViewById(R.id.btnHome);

        btnHome.setOnClickListener(btnHomeListener);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("NAME");
        int age = bundle.getInt("AGE");
        Double tall = bundle.getDouble("TALL");

        String s = "姓名：" + name + "\n" +
                    "年齡：" + age +"\n" +
                    "身高：" + tall ;
        txtShow.setText(s);
    }

    private Button.OnClickListener btnHomeListener = new Button.OnClickListener(){
        public void onClick(View v){
            finish();
        }
    };
}
