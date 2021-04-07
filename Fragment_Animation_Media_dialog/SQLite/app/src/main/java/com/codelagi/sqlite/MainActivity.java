package com.codelagi.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void retrieveData(View view) {
        SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);

        Cursor cursor = db.rawQuery("SELECT * FROM Person", null);
        cursor.moveToFirst();

        do{
           int cI = cursor.getColumnIndex("FirstName");
           

            Toast.makeText(this, "user: " + cursor.getString(cI), Toast.LENGTH_LONG).show();
        } while (cursor.moveToNext());

        db.close();
    }

    public void insertData(View view) {
        SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Person (FirstName TEXT, LastName TEXT, Age INT (3))");
        db.execSQL("INSERT INTO Person VALUES ('Hendri', 'Anggara', 29)");
        db.execSQL("INSERT INTO Person VALUES ('Bagus', 'Kurniawan', 30)");
        db.execSQL("INSERT INTO Person VALUES ('Fachri', 'Asdiadi', 28)");
        db.execSQL("INSERT INTO Person VALUES ('Bayu', 'Setiadi', 27)");
        db.execSQL("INSERT INTO Person VALUES ('Awal', 'ansyah', 26)");
        db.close();

        Toast.makeText(this, "Database Created", Toast.LENGTH_LONG).show();
    }
}