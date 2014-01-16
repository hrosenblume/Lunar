package com.example.android.animationsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;

public class Splash extends Activity {
    private CountDownTimer lTimer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splashscreen); // Contains only an LinearLayout with backround as image drawable

        lTimer = new CountDownTimer(5000, 1000) {
            public void onFinish() {
                closeScreen();
            }
            @Override
            public void onTick(long millisUntilFinished) {
                // TODO Auto-generated method stub
            }
        }.start();
    }

    private void closeScreen() {
        Intent lIntent = new Intent();
        lIntent.setClass(this, MainActivity.class);
        startActivity(lIntent);
        finish();
    }
}