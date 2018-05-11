package com.icanstudioz.bootstraper;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    private Handler handler;
    private Runnable runnable;
    private long SPLASH_TIME_OUT=2000;

    public void setClassName(Class<?> className) {
        this.className = className;
    }

    private Class<?> className;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
        runnable = new Runnable()
        {
            @Override
            public void run()
            {
                Intent home_activity=new Intent(SplashActivity.this,getTargetClass());
                startActivity(home_activity);
                finish();
            }
        };
        handler.postDelayed(runnable, SPLASH_TIME_OUT);
    }

    private Class<?> getTargetClass() {
        return className;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler.removeCallbacks(runnable);
    }
}
