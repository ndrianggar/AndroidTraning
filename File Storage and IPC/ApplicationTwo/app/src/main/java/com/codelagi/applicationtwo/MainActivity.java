package com.codelagi.applicationtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText loadData;
    String packageOne = "com.codelagi.applicationone";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData = findViewById(R.id.loadData);
    }

    public void loadData(View view) {
        PackageManager packageManager = getPackageManager();
        FileInputStream fileInputStream = null;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageOne, PackageManager.GET_META_DATA);

            String fullpath = applicationInfo.dataDir + "/files/myFile.txt";
            fileInputStream = new FileInputStream(new File (fullpath));
            int read = -1;
            StringBuffer stringBuffer = new StringBuffer();
            while ((read = fileInputStream.read()) !=-1){
                stringBuffer.append((char) read);
            }
            loadData.setText(stringBuffer.toString());

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
}