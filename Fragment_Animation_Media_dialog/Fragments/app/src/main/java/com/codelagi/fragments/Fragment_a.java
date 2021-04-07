package com.codelagi.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * created hendri 19/03/2021
 */


public class Fragment_a extends Fragment  {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
         return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment_App_Fragment", "Fragment onActivityCreated Called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment_App_Activity", "Activity onStart Called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment_App_Activity", "Activity onResume Called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment_App_Activity", "Activity onPause Called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment_App_Activity", "Activity onStop Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment_App_Activity", "Activity onDestroyView Called");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment_App_Activity", "Activity onDestroy Called");
    }
}
