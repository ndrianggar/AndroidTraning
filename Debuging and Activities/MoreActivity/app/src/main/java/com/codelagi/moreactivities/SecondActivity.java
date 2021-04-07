package com.codelagi.moreactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.viewGetFirstActivity);
        editText = findViewById(R.id.editText);

        // Menangkap data yang dikirim dari page 1
        String str = getIntent().getStringExtra("username");
        textView.setText("Welcome " + str);

    }

    public void sendBackData(View view){
        Intent intent = new Intent();
        intent.putExtra("databack", editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}
