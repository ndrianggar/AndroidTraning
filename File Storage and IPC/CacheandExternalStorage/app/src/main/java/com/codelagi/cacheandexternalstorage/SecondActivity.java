package com.codelagi.cacheandexternalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.theDataLoad);
    }


    public void loadInternalCahce(View view) {
        File folder = getCacheDir();
        File myFile = new File(folder, "myData1.txt");
        String data = readData(myFile);
        if (data !=null){
            editText.setText(data);
        }else{
            editText.setText("no data available");
        }

    }

    public void loadExternalCache(View view) {
    File folder = getExternalCacheDir();
    File myFile = new File (folder, "myData2.txt");
    String data = readData(myFile);
    if(data !=null){
        editText.setText(data);
        }else{
            editText.setText("no data external ");
            }

    }

    public void loadPrivateExternalFile(View view) {
        File folder = getExternalFilesDir("myPrivateData");
        File myFile = new File(folder, "myData3.txt");
        String data = readData(myFile);
        if(data != null){
            editText.setText(data);
        }else{
            editText.setText("no data private external file ");
        }
    }

    public void loadPublicExternalFile(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "myData4.txt");
        String data = readData(myFile);
        if(data !=null){
            editText.setText(data);
        }else{
            editText.setText("no data public external file");
        }
    }

    private String readData (File myFile) {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(myFile);
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1) {
                buffer.append((char) read);
            }
            return buffer.toString();
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

        return null;
    }

}