package com.codelagi.edittextapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

//import static com.codelagi.edittextapp.R.id.editTextTextPersonName;
//import static com.codelagi.edittextapp.R.id.startVertical;
//import static com.codelagi.edittextapp.R.id.text;
//import static com.codelagi.edittextapp.R.id.textView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // cara untuk membuat inisiasi tombol textinput dengan bantuan activity_main.xml
   /*     setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.textView);
*/

        // cara untuk membuat inisiasi input dengan bantuan layout dengan java (no layout with java)
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams LayoutBuatanParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(LayoutBuatanParams);
        linearLayout.setPadding(20,20,20, 20);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);

        editText = new EditText(this);
        editText.setHint("Enter Your Name");
        linearLayout.addView(editText);

        Button button = new Button (this);
        button.setText("ClickMe");
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.gravity = Gravity.CENTER_HORIZONTAL;
        button.setLayoutParams(buttonParams);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();
                textView.setTextSize(24);
                textView.setTextColor(getResources().getColor(R.color.purple_500));
//                textView.setBackgroundResource(R.color.purple_200);
                textView.setText("Welcome, " + userName);
            }
        });
        linearLayout.addView(button);


        textView = new TextView(this);
        linearLayout.addView(textView);

    }
//
//    public void showUserName(View view){
//        String userName = editText.getText().toString();
//        textView.setText("Welcome, " + userName);
//
//    }
}