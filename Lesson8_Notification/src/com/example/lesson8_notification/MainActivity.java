package com.example.lesson8_notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void clearNotification(View v) {
		// 通过代码来清除 NO_CLEAR
		// 清除也需要manager
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// 只能清除由本应用程序发出去的通知
		manager.cancelAll();
	}

	public void sendNotification(View v) {
		// 他是 在v4包中的通知，用于16以下版本发送通知
		// NotificationCompat
		// 通知的创建
		Notification.Builder builder = new Notification.Builder(this);
		// NotificationCompat.Builder builder2 = new NotificationCompat.Builder(
		// this);
		// 显示在通知条上的图标 必须的
		builder.setSmallIcon(R.drawable.ic_launcher);
		// 显示通知条上的文字 不是必须的
		builder.setTicker("您有一条新的消息!!");

		// 状态栏中的
		builder.setContentTitle("大标题");
		builder.setContentText("文本");
		builder.setWhen(System.currentTimeMillis());
		builder.setContentInfo("Info");
		builder.setDefaults(Notification.DEFAULT_ALL);
		// 点击事件使用Pending
		Intent intent = new Intent(this, MainActivity.class);
		PendingIntent pi = PendingIntent.getActivity(this, 1, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);
		builder.setContentIntent(pi);
		// 生成对象 16API以上，支持低版本需要使用v4包中的notificationCompat
		Notification notify = builder.build();
		// 设置不能清除
		notify.flags = Notification.FLAG_NO_CLEAR;

		// 如何将通知发送出去
		NotificationManager mananger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// 通知的唯一值，如果id重复，表明是更新一条通知，而不是新建
		mananger.notify((int) (Math.random() * 1000), notify);
	}

	public void diyNotification(View v) {
		// 展示在通知上面的视图
		RemoteViews views = new RemoteViews(getPackageName(), R.layout.layout);
		Notification notification = new Notification.Builder(this)
				.setSmallIcon(R.drawable.ic_launcher).setTicker("自定义通知 ")
				// 布局
				.setContent(views).build();
		// 使用RemoteViews来设置点击事件
		views.setTextColor(R.id.tv, Color.RED);
		Intent intent = new Intent(this, OneActivity.class);
		// 音乐播放是放在Service
		PendingIntent pi = PendingIntent.getActivity(this, 2, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);
		views.setOnClickPendingIntent(R.id.tv, pi);

		Intent intent2 = new Intent(this, MainActivity.class);

		PendingIntent pi2 = PendingIntent.getActivity(this, 1, intent2,
				PendingIntent.FLAG_UPDATE_CURRENT);
		views.setOnClickPendingIntent(R.id.iv, pi2);
		// 发送
		NotificationManager notify = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notify.notify(1, notification);

	}

}