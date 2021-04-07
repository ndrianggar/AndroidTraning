package com.codelagi.moreactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


/*
* Course :
* Creating More Than  Activity
* Passing data from one to another
* Getting back result/data
* Finishing an activity with finis()
* */

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView dataBackTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextTextPersonName);
        dataBackTextView = (TextView) findViewById(R.id.dataBackTextView);
    }

    public void goToSecond(View view) {
        // menampung editText pada String str
        String str = editText.getText().toString();
        // mengirim intent pada file SecondActivity
        Intent intent = new Intent(this, SecondActivity.class);
        // deklarasi data yg dikirim dengan mengambil data dari tampungan editText
        intent.putExtra("username", str);


//        startActivity(intent); ==> berfungsi jika hanya satu aktivity


        // berfungsi sebagai mengembalikan nilai balik yang dikirim jika ada 2 aktivity
        startActivityForResult(intent, 123);
    }

    // fungsi untuk mengembalikan aktivity dengan onActivityResult (Getting back result/data)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123){
            // memberikan nilai pada field text dari data kiriman
           String tampung = data.getStringExtra("databack");
            dataBackTextView.setText("Welcome, " + tampung);

        }
    }
}