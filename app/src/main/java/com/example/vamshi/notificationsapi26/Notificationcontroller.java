package com.example.vamshi.notificationsapi26;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

/**
 * Created by vamshi on 2/7/18.
 */

public class Notificationcontroller extends ContextWrapper {

    private static final String channelId1 = "c1";
    private static final String channelId2 = "c2";
    private static final String channelName1 = "cn1";
    private static final String channelName2 = "cn2";
    NotificationManager manager;


    public Notificationcontroller(Context base) {
        super(base);
        // setting channels to work for Api level 26 as channels work in only Api 26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannels();

        }
    }

    @TargetApi(Build.VERSION_CODES.O) // setting method to only work for target api 26
    public void createChannels() {



        //initializing notification channel 1
        NotificationChannel channel1 = new NotificationChannel(channelId1, channelName1, NotificationManager.IMPORTANCE_DEFAULT);
        channel1.enableLights(true);
        channel1.enableVibration(true);
        channel1.setLightColor(R.color.colorPrimary);
        channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        //creating notification channel 1 in notification manager
        getManager().createNotificationChannel(channel1);

        //intializing notification channel 2
        NotificationChannel channel2 = new NotificationChannel(channelId2, channelName2, NotificationManager.IMPORTANCE_DEFAULT);
        channel2.enableLights(true);
        channel2.enableVibration(true);
        channel2.setLightColor(R.color.colorPrimary);
        channel2.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        //creating notification channel 2 in notification manager
        getManager().createNotificationChannel(channel2);


    }

    public NotificationManager getManager(){
        if (manager == null) {
            // initializing notification manager
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

      return manager;
    }

    public NotificationCompat.Builder getchannel1Notification(String name, String message) {
        Intent resultIntent =new Intent(this,MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,1,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        // setting builder to work on channel1
        return new NotificationCompat.Builder(getApplicationContext(), channelId1)
                .setContentTitle(name)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_one)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent);

    }


    public NotificationCompat.Builder getchannel2Notification(String name, String message) {

        // setting builder to work on channel2
        return new NotificationCompat.Builder(getApplicationContext(), channelId2)
                .setContentTitle(name)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_two);

    }
}
