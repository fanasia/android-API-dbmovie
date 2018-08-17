package com.future.anyatasia.myfirstapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // wait for 3 sec before transition
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // pindah activity
                Intent intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}
