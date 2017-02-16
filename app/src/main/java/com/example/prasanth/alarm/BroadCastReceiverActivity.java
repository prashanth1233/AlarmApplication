package com.example.prasanth.alarm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

public class BroadCastReceiverActivity extends BroadcastReceiver {

  public void onReceive(Context context,Intent intent)
  {
      Toast.makeText(context, "ALARM STARTED...", Toast.LENGTH_SHORT).show();
      Intent intent1=new Intent(context,NotificationWindowActivity.class);
      PendingIntent pendingIntent=PendingIntent.getActivity(context,10,intent1,0);
      Uri ringtone=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
      NotificationCompat.Builder notification=new NotificationCompat.Builder(context);
      notification.setContentTitle("YOU HAVE ALARM");
      notification.setSmallIcon(R.drawable.alarm);
      notification.setContentText("OPEN PLEASE");
      notification.setSound(ringtone);
      notification.setContentIntent(pendingIntent);
      NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(10,notification.build());
  }
}
