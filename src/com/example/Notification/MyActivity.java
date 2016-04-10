package com.example.Notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {
    static final int NOTIFICATION_ID=0x123;
    NotificationManager nm;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
    public void send(View source)
    {
        Intent intent=new Intent(MyActivity.this,OtherActivity.class);
        PendingIntent pi=PendingIntent.getActivity(MyActivity.this,0,intent,0);
        Notification notify=new Notification.Builder(this).setAutoCancel(true)
                .setTicker("有消息")
                .setSmallIcon(R.drawable.notify)
                .setContentText("恭喜你，你加薪了")
                .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_LIGHTS)
                .setSound(Uri.parse("android.resource://org.crazyit.ui/"+R.raw.msg))
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pi)
                .build();
        nm.notify(NOTIFICATION_ID,notify);
    }
    public void del(View v)
    {
        nm.cancel(NOTIFICATION_ID);
    }
}
