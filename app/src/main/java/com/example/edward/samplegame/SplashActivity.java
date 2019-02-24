package com.example.edward.samplegame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler= new Handler();

        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //SharedPreferences preferences = getSharedPreferences("account", MODE_PRIVATE);
                        //String tokenEncrypted = preferences.getString(encrypt("token"), "default");
                        //Intent i =new Intent(SplashActivity.this,tokenEncrypted.equals("default") ? LoginActivity.class : HomeActivity.class);
                        Intent i =new Intent(SplashActivity.this,Sesiones.getSessionConfig(getApplicationContext()).isUserLoggedIn() ? LoginActivity.class :  MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
            }
        };

        Timer timer= new Timer();
        timer.schedule(task,3000);
    }
}
