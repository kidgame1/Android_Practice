package com.ehappy.c5practice3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtName, txtResult;
    private Spinner spnEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtName = (TextView)findViewById(R.id.txtName);
        txtResult = (TextView)findViewById(R.id.txtResult);
        spnEducation = (Spinner)findViewById(R.id.spnEducaion);

        ArrayAdapter<CharSequence> adapterEducaion
                = ArrayAdapter.createFromResource(this, R.array.Education, android.R.layout.simple_spinner_item);

        adapterEducaion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnEducation.setAdapter(adapterEducaion);

        spnEducation.setOnItemSelectedListener(spnEducationListener);

    }

    private Spinner.OnItemSelectedListener spnEducationListener = new Spinner.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
            String sel = parent.getSelectedItem().toString();
            String name = txtName.getText().toString();
            txtResult.setText(name + " 您的學歷為 " + sel);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
}
