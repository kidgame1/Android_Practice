package com.ehappy.c11practice01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtN;
    private TextView txtResult;
    private Button btnDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtN=(EditText)findViewById(R.id.edtN);
        txtResult=(TextView)findViewById(R.id.txtResult);
        btnDo=(Button)findViewById(R.id.btnDo);

        btnDo.setOnClickListener(btnDoListener);
    }

    private Button.OnClickListener btnDoListener=new Button.OnClickListener(){
        public void onClick(View v){
            try {
                int n=Integer.parseInt(edtN.getText().toString());
                float r=1;
                for (int i=1;i<=n;i++)
                    r*=i;
                txtResult.setText(n + "!= " + r);
            } catch (Exception err){
                Toast.makeText(getApplicationContext(), "發生輸入非數值的錯誤!", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
