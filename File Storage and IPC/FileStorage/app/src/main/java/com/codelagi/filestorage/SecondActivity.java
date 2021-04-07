package com.codelagi.filestorage;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = (TextView) findViewById(R.id.editTextTextPersonName2);
    }

    public void loadUserName(View view) {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("file.txt");

            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while((read = fileInputStream.read()) != -1){
                buffer.append((char)read);
            }

            textView.setText(buffer.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
