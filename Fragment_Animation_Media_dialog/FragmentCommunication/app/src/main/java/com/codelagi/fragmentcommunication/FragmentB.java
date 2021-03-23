package com.codelagi.fragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FragmentB extends Fragment {

    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
       textView = view.findViewById(R.id.textView);
        return view;
    }

    public void setTheCount(int count){
        textView.setText("Count " + count);
    }

    public interface Counter{
        public void incrementValue(int count);
        public void decrementValue(int count);
    }
}
