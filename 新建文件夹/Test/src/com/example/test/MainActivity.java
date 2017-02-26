package com.example.test;

import aidl.IMathAidlInterface;
import aidl.User;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
	IMathAidlInterface in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			in = IMathAidlInterface.Stub.asInterface(service);
		}
	};

	public void start(View v) {
		bindService(new Intent("login"), conn, BIND_AUTO_CREATE);
	}

	public void login(View v) {
		User user = new User();
		user.setPassword("123456");
		user.setUsername("zhangsan");
		try {
			in.login(user);
			Log.e("TAG", user.toString());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
