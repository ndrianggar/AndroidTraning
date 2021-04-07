package com.codelagi.toastaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// step two if you activated toast with object button implement in the class
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {

public class MainActivity extends AppCompatActivity{
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       button = (Button) findViewById(R.id.button);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this, "This is a Toas with object and create new object", Toast.LENGTH_SHORT).show();
           }
       });

    }

    // create function toast with id
//    public void showToast(View view) {
//        Toast.makeText(this, "This is a Toast", Toast.LENGTH_SHORT).show();
//    }

    //@Override
//    public void onClick(View v) {
//        Toast.makeText(this, "This is a Toast with object button", Toast.LENGTH_SHORT).show();
//    }
}