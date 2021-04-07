package com.codelagi.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentB.Counter {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Function fragment using interface
    @Override
    public void incrementValue(int count) {
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragmentb);
        fragmentB.setTheCount(count);
    }

    //Function fragment using interface
    @Override
    public void decrementValue(int count) {
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragmentb);
        fragmentB.setTheCount(count);
    }

    //  Function fragment just the activity
//    public void incrementValue(int count) {
//        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragmentb);
//        fragmentB.setTheCount(count);
//    }

   //  Function fragment just the activity
//    public void decrementValue(int count){
//        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragmentb);
//        fragmentB.setTheCount(count);
//    }

    // Function fragment using interface



}