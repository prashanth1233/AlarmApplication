package com.example.prasanth.alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Calendar;

public class SampleAlarmActivity extends Activity implements View.OnClickListener {

    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button start,stop,startAt,stopNotification;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        start=(Button)findViewById(R.id.setAlarm);
        stop=(Button)findViewById(R.id.stopAlarm);
        startAt=(Button)findViewById(R.id.startAt);
        stopNotification=(Button)findViewById(R.id.stpnotification);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        startAt.setOnClickListener(this);
        stopNotification.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.setAlarm:
             setAlarm();
                break;
            case R.id.stopAlarm:
                stopAlarm();
                break;
                case R.id.startAt:
                startAt();
                    break;
            case R.id.stpnotification:
                stopNotifications();
                break;
                default:
                    Toast.makeText(this,"no button is selected",Toast.LENGTH_LONG).show();
        }
    }

    public void setAlarm()
    {
        Intent intent=new Intent(this,BroadCastReceiverActivity.class);
        pendingIntent=PendingIntent.getBroadcast(this,100,intent,0);
         alarmManager=(AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pendingIntent);
        Toast.makeText(this,"STARTING ALARM,SEE NOTIFICATION BAR",Toast.LENGTH_LONG).show();
    }

    public void stopAlarm()
    {
        alarmManager=(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(this,"STOPPING ALARM",Toast.LENGTH_LONG).show();

    }

    public void startAt()
    {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,12);
        calendar.set(Calendar.MINUTE,10);
        Intent intent=new Intent(this,BroadCastReceiverActivity.class);
        pendingIntent=PendingIntent.getBroadcast(this,100,intent,0);
        AlarmManager alarmManager=(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),1000*60*20,pendingIntent);
        Toast.makeText(this,"ALARM WILL REPEAT AFTER 20 MINUTES",Toast.LENGTH_LONG).show();
    }

    public void stopNotifications()
    {
       if(NOTIFICATION_SERVICE!=null)
       {
           NotificationManager notificationManager=(NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
           notificationManager.cancel(10);
           Toast.makeText(this, "NOTIFICATION STOPPED", Toast.LENGTH_SHORT).show();
       }

    }
}
