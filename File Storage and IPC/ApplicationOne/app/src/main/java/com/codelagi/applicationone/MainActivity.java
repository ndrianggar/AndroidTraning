package com.codelagi.applicationone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText messageBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageBox = findViewById(R.id.messageBox);
    }
    public void saveFile(View view) {
        File file = null;
        String text = messageBox.getText().toString();
        FileOutputStream fileOutputStream = null;
        try {
            file = getFilesDir();
            try {
                fileOutputStream = openFileOutput("myFile.txt", Context.MODE_PRIVATE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            fileOutputStream.write(text.getBytes());
            Toast.makeText(this, "File saved at " + file, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}