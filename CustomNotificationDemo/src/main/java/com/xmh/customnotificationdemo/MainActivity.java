package com.xmh.customnotificationdemo;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RemoteViews;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    int notifyId = 1001;

    int count =0;
    private NotificationCompat.Builder builder;
    private RemoteViews view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initNotification();
    }

    private void initNotification() {
        view = new RemoteViews(getPackageName(), R.layout.layout_notification);
    }

    @OnClick(R.id.btn_show)
    void onShowClick() {
        count++;
        view.setTextViewText(R.id.tv_count,count+"");
        view.setTextViewText(R.id.tv_from,"6:6:6");
        view.setTextViewText(R.id.tv_to,"8:8:8");
        builder = new NotificationCompat.Builder(this);
        builder.setContent(view)
                .setSmallIcon(R.drawable.ic_launcher)
                .setOngoing(true)
                .setTicker("count:"+count);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notifyId, builder.build());
    }
}
