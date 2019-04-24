package com.wilson.elston.babycare;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class AlarmReceiver  extends BroadcastReceiver{
    private String CHANNEL_ID="123";


    @Override

    public void onReceive(Context context, Intent intent) {


        Intent intent1=new Intent(context,MainActivity.class);
         intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
          PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
          String nm=intent.getExtras().getString("Name");

          createNotificationChannel(context);
          NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(R.drawable.main_icon)
                        .setContentTitle("Vaccination Reminder")
                        .setAutoCancel(true)
                        .setContentText("Vaccination of "+nm.toString()+" is due")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent); //customising the notification

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
                Random ran=new Random();
        int notificationId= ran.nextInt(100);
        notificationManager.notify(notificationId,mBuilder.build()); //function to generate notifications

            }


    private void createNotificationChannel(Context context) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = context.getString(R.string.channel_name);
            String description = context.getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    } //This is to generate notifications on Android 8+

}

