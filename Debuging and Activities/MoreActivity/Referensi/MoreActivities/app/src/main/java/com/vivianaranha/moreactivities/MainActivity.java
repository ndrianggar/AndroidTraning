package com.vivianaranha.moreactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    TextView dataBackTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        dataBackTextView = (TextView) findViewById(R.id.dataBackTextView);
    }

    public void goToSecond(View view) {

        String str = editText.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("username", str);
//        startActivity(intent);

        startActivityForResult(intent, 123);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 123) {
            dataBackTextView.setText(data.getStringExtra("databack"));
        }
    }
}
