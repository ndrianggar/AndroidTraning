package com.codelagi.fragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class FragmentA extends Fragment {
    FragmentB.Counter counter;


    int count = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Button b = view.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;

                // Function fragment just the activity
//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.incrementValue(count);

                //Function fragment using interface
                counter = (MainActivity) getActivity(); // ini memanggil kelas Main
                counter.incrementValue(count); // ini memanggil fungsi decrement yang ada di main
            }
        });

        Button c = view.findViewById(R.id.button2);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;

                // Function fragment just the activity
//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.incrementValue(count);

                //Function fragment using interface
                counter = (MainActivity) getActivity(); // ini memanggil kelas Main
                counter.decrementValue(count); // ini memanggil fungsi decrement yang ada di main
            }
        });


        return view;


    }
}
