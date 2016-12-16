package com.ehappy.c5practice02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtName, txtResult;
    private RadioButton bloodA, bloodB, bloodO, bloodAB;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtName = (TextView)findViewById(R.id.txtName);
        txtResult = (TextView)findViewById(R.id.txtResult);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        bloodA = (RadioButton)findViewById(R.id.bloodA);
        bloodB = (RadioButton)findViewById(R.id.bloodB);
        bloodO = (RadioButton)findViewById(R.id.bloodO);
        bloodAB = (RadioButton)findViewById(R.id.bloodAB);

        radioGroup.setOnCheckedChangeListener(radioGroupListener);

        }

    private RadioGroup.OnCheckedChangeListener radioGroupListener = new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId){
            String name=txtName.getText().toString();

            if(checkedId == R.id.bloodA)
                txtResult.setText(name + "您的血型為" + bloodA.getText());
            else if (checkedId == R.id.bloodB)
                txtResult.setText(name + "您的血型為" + bloodB.getText());
            else if (checkedId == R.id.bloodO)
                txtResult.setText(name + "您的血型為" + bloodO.getText());
            else if (checkedId == R.id.bloodAB)
                txtResult.setText(name + "您的血型為" + bloodAB.getText());

        }
    };
}
