package com.codelagi.cacheandexternalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.dataSave);
    }

    public void goToNext(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void saveinternalCache(View view) {
        String theData = editText.getText().toString();
        File folder = getCacheDir();
        File myFile = new File(folder, "myData1.txt");
        writeData(myFile, theData);
    }

    public void saveexternalCache(View view) {
        String theData = editText.getText().toString();
        File folder = getExternalCacheDir();
        File myFile = new File(folder, "myData2.txt");
        writeData(myFile, theData);
    }

    public void saveexternalPrivate(View view) {
        String theData = editText.getText().toString();
        if(getExternalFilesDir("MyPrivateData") !=null) {
            File folder = getExternalFilesDir("MyPrivateData");
            File myFile = new File(folder, "myData3.txt");
            writeData(myFile, theData);
        }
    }

    public void saveexternalPublic(View view) {
        String theData = editText.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "myData4.txt");
        writeData(myFile, theData);
    }

    public void writeData(File myFile, String theData){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(theData.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}