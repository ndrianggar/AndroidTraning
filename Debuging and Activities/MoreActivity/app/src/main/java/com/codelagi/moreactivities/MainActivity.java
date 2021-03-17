package com.codelagi.moreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextTextPersonName);
    }

    public void goToSecond(View view) {
        String str = editText.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("username", str);
        startActivity(intent);
    }
}