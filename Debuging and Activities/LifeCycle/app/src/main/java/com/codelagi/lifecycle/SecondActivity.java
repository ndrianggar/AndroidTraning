package com.codelagi.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.e("Lifecycle_Activity", "activity_second, OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Lifecycle_Activity", "activity_second, onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Lifecycle_Activity", "activity_second, onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Lifecycle_Activity", "activity_second, onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Lifecycle_Activity", "activity_second, onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Lifecycle_Activity", "activity_second, onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Lifecycle_Activity", "activity_second, onDestroy");
    }

    public void goToPageTwo(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

    }
}