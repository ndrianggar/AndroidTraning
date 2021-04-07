 package com.codelagi.preference2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

 public class MainActivity extends AppCompatActivity {

     EditText editText;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         editText = findViewById(R.id.edt_username);

         SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
         editText.setText(sharedPreferences.getString("username", ""));
     }

     public void saveUserName(View view) {
         SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

         SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putString("username", editText.getText().toString());
         editor.commit();
     }

     public void openSettings(View view) {
         Intent intent = new Intent(this, Preference.class);
         startActivity(intent);
     }

     @Override
     protected void onResume() {
         super.onResume();
         SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
         Boolean red = settings.getBoolean("red", false);
         Boolean yellow = settings.getBoolean("yellow", false);
         Boolean blue = settings.getBoolean("blue", false);

         StringBuffer color = new StringBuffer();
         color.append("#");
         if(red){
             color.append("FF");
         }else{
             color.append("00");
         }

         if(yellow){
             color.append("FF");
         }else{
             color.append("00");
         }

         if(blue){
             color.append("ff");
         }else{
             color.append("00");
         }

         View layout = findViewById(R.id.layoutMain);
         layout.setBackgroundColor(Color.parseColor(color.toString()));

     }

 }