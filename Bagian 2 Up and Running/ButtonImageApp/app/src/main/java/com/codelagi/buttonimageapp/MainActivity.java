package com.codelagi.buttonimageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.codelagi.buttonimageapp.R.id.imageView;

public class MainActivity extends AppCompatActivity {
    
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

    }

    public void showOnFacebook(View view) {
        imageView.setImageResource(R.drawable.ic_fb);


    }

    public void showOnTwitter(View view) {
        imageView.setImageResource(R.drawable.ic_twitter);
    }
}