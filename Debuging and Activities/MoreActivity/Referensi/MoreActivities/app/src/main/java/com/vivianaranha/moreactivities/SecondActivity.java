package com.vivianaranha.moreactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by vivianaranha on 11/13/15.
 */
public class SecondActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText2);

        String str = getIntent().getStringExtra("username");
        textView.setText("Welcome, " + str);
    }

    public void sendDataBack(View view) {

        Intent intent = new Intent();
        intent.putExtra("databack", editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();

    }
}
