package com.vivianaranha.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        count = 0;
        Log.d("LifeCycle_Activity", "MainActivity onCreate");

        if(savedInstanceState != null) {
            count = savedInstanceState.getInt("myCount", 0);
        }
        textView.setText("Count: "+ count);

    }

    public void increment(View view) {
        count++;
        textView.setText("Count: "+ count);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("LifeCycle_Activity", "MainActivity onSaveInstanceState");
        outState.putInt("myCount", count);

    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Log.d("LifeCycle_Activity", "MainActivity onRestoreInstanceState");
//        count = savedInstanceState.getInt("myCount", 0);
//        textView.setText("Count: "+ count);
//
//    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle_Activity", "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle_Activity", "MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle_Activity", "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle_Activity", "MainActivity onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle_Activity", "MainActivity onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle_Activity", "MainActivity onDestroy");
    }

    public void goToSecond(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }


}
