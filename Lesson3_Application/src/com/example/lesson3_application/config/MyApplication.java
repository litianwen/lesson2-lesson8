package com.example.lesson3_application.config;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

	// 用户
	class User {

	}

	public User user = new User();
	

	// 当应用程序被系统启动后，会调用
	@Override
	public void onCreate() {
		super.onCreate();
		Log.e("MainActivity", "系统调用了我的MyApp");
	}

}
