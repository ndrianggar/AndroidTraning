package com.codelagi.debuggingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstNumber;
    EditText secondNumber;


    TextView textView;
    TextView textToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = (EditText) findViewById(R.id.editText1);
        secondNumber = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.textView2);

        textToast = (TextView) findViewById(R.id.textView3);

    }

    public void addNumbers (View view){
        int x = Integer.parseInt(firstNumber.getText().toString());
        int y = Integer.parseInt((secondNumber.getText().toString()));
        int answer = result(x,y);
        int answerToast = (result(x,y));
        textView.setText("Result " + answer);
        textView.setText("Result " + answerToast);


        // toast biasa
      //Toast.makeText(this, "Result :" + answer, Toast.LENGTH_SHORT).show();

        // toast gravity (mengatur posisi toast)
//        Toast toast =  Toast.makeText(this, "Result: " + answer, Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 0,0);
//        toast.show();

        // toast layout inflate
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);

        LayoutInflater layoutInflater = getLayoutInflater();
        View toastView = layoutInflater.inflate(R.layout.toast_message, null);

        toast.setView(toastView);
        toast.show();

         Log.d("MainActivity_Log", " Debuge Message with answer: " + answer );
         Log.e("MainActivity_Log", " Error Message with answer: " + answer);
         Log.i("MainActivity_Log", " Info Message with answer: " + answer);
        Log.w("MainActivity_Log", " Warning Message with answer: " + answer);
        Log.v("MainActivity_Log", " Verbose Message with answer: " + answer);
        Log.wtf("MainActivity_Log", " WTF Message with answer: " + answer);
    }

    private int result(int a, int b) {
        int c = a + b;
        return c;
    }
}