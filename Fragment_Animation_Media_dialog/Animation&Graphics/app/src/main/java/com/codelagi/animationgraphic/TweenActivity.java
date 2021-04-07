package com.codelagi.animationgraphic;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TweenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
    }

    public void clickMe(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tweeen_animation);
        view.startAnimation(animation);
    }
}
