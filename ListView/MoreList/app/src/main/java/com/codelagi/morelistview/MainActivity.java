package com.codelagi.morelistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // inisiasi Listview
    ListView listView;

    // inisiasi teks
    String[] theTitles;
    String[] theDesc;

    // inisiasi image yg ada di drawable tanpa adaptor single
    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        // memanggil resource teks
        Resources resources = getResources();
        theTitles = resources.getStringArray(R.array.titles);
        theDesc = resources.getStringArray(R.array.desc);

        // diset pada adapter setiap objek teks
     //   MyAdapter adapter = new MyAdapter(this, theTitles, images,theDesc);

        // memasukkan objek ke list view
//        listView.setAdapter(adapter); dipakai ketika menggunakan MyAdapter adapter

          listView.setAdapter(new TheAdapter(this));
    }

    class SingleRow {
        String title;
        String description;
        int image;

        SingleRow(String title, String desc, int image ){
            this.title = title;
            this.description = desc;
            this.image = image;
        }
    }


    class TheAdapter extends BaseAdapter{

        ArrayList<SingleRow> list;
        Context context;

        TheAdapter(Context context){
            this.context = context;
            list = new ArrayList<SingleRow>();
            Resources resources = getResources();
            String[]titles= resources.getStringArray(R.array.titles);
            String[] desc = resources.getStringArray(R.array.desc);
            int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10};

            for(int i=0; i< titles.length; i++){
                list.add(new SingleRow(titles[i], desc[i], images[i]));
            }
        }

        @Override
        public int getCount() {
//            return 0; dipakai ketika belum diset adapter new
            return list.size();
        }

        @Override
        public Object getItem(int position) {
//            return null;
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            return null;
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.single_row, parent, false);


            ImageView myImage = row.findViewById(R.id.imageView);
            TextView myTitle = row.findViewById(R.id.textView);
            TextView myDesc = row.findViewById(R.id.textView2);

              SingleRow temp = list.get(position);
               myImage.setImageResource(temp.image);
               myTitle.setText(temp.title);
               myDesc.setText(temp.description);

               return row;
        }
    }

    // inisiasi isi dari MyAdapter
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        int[] imgs;
        String[] titleArray;
        String[] descArray;

        int count = 0;

        // menampilkan isi dari array dengan masing2 objek
        public  MyAdapter(Context c, String[] titles, int[] img, String[] desc){
            super(c, R.layout.single_row, R.id.textView, titles);
            this.context = c;
            this.imgs = img;
            this.titleArray = titles;
            this.descArray = desc;
        }

        class MyViewHolder{
            ImageView myImage;
            TextView myTitle;
            TextView myDesc;

            MyViewHolder(View v){
                myImage = v.findViewById(R.id.imageView);
                myTitle = v.findViewById(R.id.textView);
                myDesc = v.findViewById(R.id.textView2);
            }
        }
        // membuat array list sesuai image dan set text position
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//          return super.getView(position, convertView, parent);
            View row = convertView;
            MyViewHolder myViewHolder = null;

            if(row == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = layoutInflater.inflate(R.layout.single_row, parent, false);
                myViewHolder = new MyViewHolder(row);
                row.setTag(myViewHolder);

                Log.d("Plates", "Count: " + count++);

            }else{
                myViewHolder = (MyViewHolder) row.getTag();
            }

//            ImageView myImage = row.findViewById(R.id.imageView);
//            TextView myTitle = row.findViewById(R.id.textView);
//            TextView myDesc = row.findViewById(R.id.textView2);

              myViewHolder.myImage.setImageResource(imgs[position]);
              myViewHolder.myTitle.setText(titleArray[position]);
              myViewHolder.myDesc.setText(titleArray[position]);

              // diset jika tanpa myViewHolder
//            myImage.setImageResource(imgs[position]);
//            myTitle.setText(titleArray[position]);
//            myDesc.setText(descArray[position]);

            return row;
        }


    }

}