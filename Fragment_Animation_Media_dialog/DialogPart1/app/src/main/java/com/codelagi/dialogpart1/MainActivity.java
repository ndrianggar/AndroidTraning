package com.codelagi.dialogpart1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDialog;
    ImageView imgDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog = findViewById(R.id.button);
        imgDialog = findViewById(R.id.imageButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,"This is menu: " +item.getTitle(), Toast.LENGTH_LONG).show();
        item.getItemId();
        switch (item.getItemId()){
            case R.id.action_allApplication:
                return true;
            case R.id.action_download:
                return true;
            case R.id.action_alarm:
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void showAlert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_baseline_archive_24);
        builder.setTitle("Alert Dialog");
        builder.setMessage("Do You Want To Kill App?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }

    public void showProgress(View view) {
        ProgressDialog progressDialog = new ProgressDialog(this);
       // progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);--> style spinner (circle load)
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); // --> style spinner (line)
        progressDialog.setMessage("Updating Data");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        progressDialog.show();
        progressDialog.setProgress(30);
    }

    public void showCustemDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        dialog.setTitle("Custome Dialog");
        Button button = dialog.findViewById(R.id.button4);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.cancel();
           }
       });
        dialog.show();
    }
}