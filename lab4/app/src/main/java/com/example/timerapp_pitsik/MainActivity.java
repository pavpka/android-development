package com.example.timerapp_pitsik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running = false;
    private String timerText = "00:00:00";
    TextView timerView;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.post(runTimer);
        timerView = findViewById(R.id.time);
    }

    @Override
    public void onResume() {
        super.onResume();
        timerView.setText(timerText);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runTimer);
    }

    final Runnable runTimer = new Runnable() {
        @Override
        public void run() {
            if (running) {
                timerText = String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60));
                timerView.setText(timerText);
                seconds++;
            }
            handler.postDelayed(this, 1000);
        }
    };

    public void onClickStart(View view) {
        running = true;
    }

    public void onClickStop(View view) {
        running = false;
    }

    public void onClickReset(View view) {
        running = false;
        seconds = 0;
        timerText = "00:00:00";
        timerView.setText(timerText);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putString("timerText", timerText);
        Log.i("save", "" + seconds + " " + running + " " + timerText);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        seconds = savedInstanceState.getInt("seconds");
        running = savedInstanceState.getBoolean("running");
        timerText = savedInstanceState.getString("timerText");
    }
}
