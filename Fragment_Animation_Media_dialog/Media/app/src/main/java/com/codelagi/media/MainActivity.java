package com.codelagi.media;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    ImageView imageView;
    Button btnPlayMusic;
    Button btnPlayVideo;
    Button btnTakePicture;
    Button gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);
        imageView = findViewById(R.id.imageView2);
    }

    public void playMusic(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.audio1);
        mediaPlayer.start();
        mediaPlayer.pause();
    }

    public void playVideo(View view) {
        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.video1;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(new MediaController(this));
        videoView.start();
        videoView.requestFocus();
    }

    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 123);
    }

    public void gallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 456);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 123){
            Bitmap bm = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bm);
        }else{
            if(requestCode == 456 && resultCode == RESULT_OK && data !=null){
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();

                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            }
        }
    }
}