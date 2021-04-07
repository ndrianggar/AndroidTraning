package com.codelagi.filestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.editTextTextPersonName);
    }

    public void saveUsername(View view) {
        String usernameValue = userName.getText().toString();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("file.txt", MODE_PRIVATE);
            fileOutputStream.write(usernameValue.getBytes());
            Toast.makeText(this, "Saved File "+ getFilesDir().toString() + "/file.txt", Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void goToNext(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void loadUserName(View view) {
    }
}