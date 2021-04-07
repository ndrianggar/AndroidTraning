package com.codelagi.morelistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] theTitles;
    String[] theDesc;
    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        Resources resources = getResources();
        theTitles = resources.getStringArray(R.array.titles);
        theDesc = resources.getStringArray(R.array.desc);

        MyAdapter adapter = new MyAdapter(this, theTitles, images,theDesc);
        listView.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        int[] imgs;
        String[] titleArray;
        String[] descArray;

        public  MyAdapter(Context c, String[] titles, int[] img, String[] desc){
            super(c, R.layout.single_row, R.id.textView, titles);
            this.context = c;
            this.imgs = img;
            this.titleArray = titles;
            this.descArray = desc;
        }

        // membuat array list sesuai image dan set text position
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//          return super.getView(position, convertView, parent);
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.single_row, parent, false);

            ImageView myImage = row.findViewById(R.id.imageView);
            TextView myTitle = row.findViewById(R.id.textView);
            TextView myDesc = row.findViewById(R.id.textView2);

            myImage.setImageResource(imgs[position]);
            myTitle.setText(titleArray[position]);
            myDesc.setText(descArray[position]);

            return row;
        }
    }

}