package com.codelagi.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("mainActivity_App_Activity", "Activity onCreate Called");

// gagal jika menggunakan getFragmentManager();
        Fragment_a fragment_a = new Fragment_a();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layoutMain, fragment_a, "MyFragment");
        fragmentTransaction.commit();

//      getFragmentManager().beginTransaction().add(R.id.layoutMain, fragment_a, "MyFragment").commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("mainActivity_App_Activity", "Activity onStart Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("mainActivity_App_Activity", "Activity onResume Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("mainActivity_App_Activity", "Activity onPause Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("mainActivity_App_Activity", "Activity onStop Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("mainActivity_App_Activity", "Activity onDestroy Called");
    }
}
