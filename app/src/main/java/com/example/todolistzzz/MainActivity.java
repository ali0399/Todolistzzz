package com.example.todolistzzz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tittle = findViewById(R.id.title);
        Animation spash_anim = AnimationUtils.loadAnimation(this,R.anim.splashanim);
        tittle.startAnimation(spash_anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,ContentActivity.class);
                startActivity(intent);
                finish();
            }
        },1100);
    }
}