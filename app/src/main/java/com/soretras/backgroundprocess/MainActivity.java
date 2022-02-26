package com.soretras.backgroundprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button start ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start_background_process);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,BackgroundProcess.class);
                intent.setAction("background process");
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0 ,intent,0) ;
                AlarmManager alarmManager =(AlarmManager) getSystemService(Context.ALARM_SERVICE) ;
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,0,30,pendingIntent);

                finish();
            }
        });
    }
}