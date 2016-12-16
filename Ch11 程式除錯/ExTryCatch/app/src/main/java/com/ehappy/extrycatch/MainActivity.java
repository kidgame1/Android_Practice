package com.ehappy.extrycatch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtX, edtY;
    private TextView txtResult;
    private Button btnDo;

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

        edtX = (EditText)findViewById(R.id.edtX);
        edtY = (EditText)findViewById(R.id.edtY);
        txtResult = (TextView)findViewById(R.id.txtResult);
        btnDo = (Button)findViewById(R.id.btnDo);

        btnDo.setOnClickListener(btnDoListener);
    }

    private Button.OnClickListener btnDoListener = new Button.OnClickListener() {
        public void onClick(View v) {
            try {
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                int r = x % y;
                txtResult.setText(x + " % " + y + " = " + r);
            } catch (NumberFormatException err) {
                Toast.makeText(getApplicationContext(), "發生輸入非數值的錯誤！", Toast.LENGTH_SHORT).show();
            } catch (Exception err) {
                Toast.makeText(getApplicationContext(),
                        "發生其他的錯誤，包括 分母為  0  的錯誤!\n\r錯誤資訊：" + err.toString(), Toast.LENGTH_SHORT).show();
            } finally {
                Toast.makeText(getApplicationContext(), "finally 中一律執行!", Toast.LENGTH_SHORT).show();
            }
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
