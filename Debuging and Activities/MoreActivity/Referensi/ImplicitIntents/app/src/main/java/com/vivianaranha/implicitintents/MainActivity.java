package com.vivianaranha.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSecond(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }

    public void whereIsWhiteHouse(View view) {
        //38.8976763,-77.0365298
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:38.8976763,-77.0365298"));
        Intent chooser = Intent.createChooser(intent, "Launch Maps");
        startActivity(chooser);

    }

    public void openApp(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=vivianaranha.com.oglie"));
        Intent chooser = Intent.createChooser(intent, "Open App");
        startActivity(chooser);

    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String to[] = {"vivianaranha@gmail.com", "vivianaranha@yahoo.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "HELLO FROM APP");
        intent.putExtra(Intent.EXTRA_TEXT, "THIS IS TEXT");
        intent.setType("message/rfc822");
        Intent chooser = Intent.createChooser(intent, "Email");
        startActivity(chooser);


    }

    public void shareText(View view) {

        EditText editText = (EditText)findViewById(R.id.editText);
        String str = editText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, str);
        Intent chooser = Intent.createChooser(intent, "Share Text");
        startActivity(chooser);





    }
}
