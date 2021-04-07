package com.codelagi.menusdialogs;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    Button button;
    ImageView imageView;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button2);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnShow = findViewById(R.id.btnShow);

        // inisiasi menu jika ingin mendapatkan return item click menu
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.inflate(R.menu.image_menu);
                popup.show();
            }
        });

        // mendaftarkan objek tombol
        registerForContextMenu(btnShow);
        registerForContextMenu(imageView);

    }

    // ini untuk inisiasi menu item
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderIcon(R.drawable.ic_launcher_foreground);
        menu.add(0, v.getId(),0, "Upload");
        menu.add(0, v.getId(), 0, "Search");
        menu.add(0, v.getId(), 0, "Share");

//        if (v.getId() == R.id.imageView) {
//            getMenuInflater().inflate(R.menu.image_menu, menu);
//        } else {
//            getMenuInflater().inflate(R.menu.btn_menu, menu);
//        }
    }

    // ini untuk memanggil menu item
    @Override
    public boolean onContextItemSelected( MenuItem item) {
        Toast.makeText(this, "image " + item.getTitle(), Toast.LENGTH_LONG);
        return true;
    }

    // ini untuk inisiasi menu item with icon
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    // impelentation instance menu dialog 1 button 3 child
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings: {
                Toast.makeText(this, "this menu setting", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.action_second: {
                Toast.makeText(this, "this is second menu", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.action_third: {
                Toast.makeText(this, "This is third", Toast.LENGTH_LONG).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    // ini menu inflate onClick
    public void ShowPopUp(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.btn_menu, popup.getMenu());
        popup.show();
    }

    public void showMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.btn_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_LONG).show();
        switch (item.getItemId()){
            case R.id.action_save:
            return true;
            case R.id.action_share:
                return true;
            case R.id.action_delete:
                return true;
            default:
                return false;
        }
    }
}
