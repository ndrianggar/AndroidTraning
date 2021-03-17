package com.vivianaranha.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.e("LifeCycle_Activity", "SecondActivity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle_Activity", "SecondActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle_Activity", "SecondActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle_Activity", "SecondActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle_Activity", "SecondActivity onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeCycle_Activity", "SecondActivity onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle_Activity", "SecondActivity onDestroy");
    }
}
