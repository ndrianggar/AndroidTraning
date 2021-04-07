package com.codelagi.listview_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{// implements AdapterView.OnItemClickListener {

    ListView listView;

    String[] days = {"Monday", "Sunday", "Tuesday","Thursday","Wenesday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        // memanggil list event
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.single_row,R.id.textView, days);
        listView.setAdapter(arrayAdapter);
//        listView.setOnItemClickListener(this); jika ingin menggunakan implements adpter

        // ini untuk membuat event click pada list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                Toast.makeText(MainActivity.this, "Clicked " + textView.getText() + " at " + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void openSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        TextView textView = (TextView) view;
//        Toast.makeText(this, "Clicked " + textView.getText() + " at " + position, Toast.LENGTH_LONG).show();
//    }
}