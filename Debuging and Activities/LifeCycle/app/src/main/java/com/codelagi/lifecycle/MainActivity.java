package com.codelagi.lifecycle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/*
* LifeCycle
*  onStart
*  onResume
*  onPause
*  onStop
*  onRestart
*  onDestroy
* */

public class MainActivity extends AppCompatActivity {

    int count;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle_Activity", "MainActivity, OnCreate");
        textView = findViewById(R.id.textView);
        count = 0;


        /* ROTATION
         *  Saving data and retrieving in different orientation
         * onSaveInstanceState()
         * onRestoreInstanceState()
         *
         * */
        if(savedInstanceState !=null){
            count = savedInstanceState.getInt("myCount", 0);
        }
        textView.setText("Count: " + count);
    }

    public void increment(View view) {
        count++;
        textView.setText("Count: " + count);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle_Activity", "MainActivity, onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle_Activity", "MainActivity, onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle_Activity", "MainActivity, onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle_Activity", "MainActivity, onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle_Activity", "MainActivity, onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle_Activity", "MainActivity, onDestroy");
    }

    public void goToPageTwo(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Lifecycle_Activity", "MainActivity, onSaveInstanceState");
        outState.putInt("myCount", count);
    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Log.d("Lifecycle_Activity", "MainActivity, onRestoreInstanceState");
//        count = savedInstanceState.getInt("myCount", 0);
//    }
}