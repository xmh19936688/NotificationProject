package com.xmh.simplenotificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder mBuilder;
    private NotificationManager mNotificationManager;
    int notifyId = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initNotify();
    }

    private void initNotify() {
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        PendingIntent pendingIntent= PendingIntent.getActivity(this, 1, new Intent(), Notification.FLAG_AUTO_CANCEL);
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("title")
                .setContentText("text")
                .setSubText("sub")
                .setContentInfo("info")
                .setContentIntent(pendingIntent)
                .setOnlyAlertOnce(true)//如果该通知正在显示，则再发通知不会触发铃声，震动，ticker
				.setNumber(12)//显示数量//显示在时间下边的数字
                .setTicker("ticker")//通知首次出现在通知栏，带上升动画效果的
                .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示
                .setPriority(Notification.PRIORITY_DEFAULT)//设置该通知优先级
				.setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setDefaults(Notification.DEFAULT_VIBRATE)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合：
                .setSmallIcon(R.drawable.ic_launcher)
                .addAction(R.drawable.ic_launcher,"dsaf",pendingIntent)
                .addAction(R.drawable.ic_launcher,"dsaf",pendingIntent)
                .addAction(R.drawable.ic_launcher,"dsaf",pendingIntent);
    }

    @OnClick(R.id.btn_show)
    void onShowClick(){
        mNotificationManager.notify(notifyId, mBuilder.build());
    }
}
