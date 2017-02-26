package com.example.lesson3_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	public static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Log.v(TAG, "v");
		// Log.d(TAG, "v");
		// Log.i(TAG, "v");
		// System.out.println("syso");
		// Log.w(TAG, "v");
		// Log.e(TAG, "v");
		//
		// MyApplication myapp = (MyApplication) getApplication();
		// if (myapp.user == null) {
		// Log.e(TAG, "用户还没有登录");
		// }
		// systS
		System.out.println("MainActivity.onCreate()");
		
		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 表达的一个意图
				Intent intent = new Intent(MainActivity.this, MyActivity.class);
				// 跳转Activity
				// startActivity(intent);
				finish();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println("MainActivity.onStart()");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("MainActivity.onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		System.out.println("MainActivity.onPause()");
	}

	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("MainActivity.onStop()");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("MainActivity.onDestroy()");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		System.out.println("MainActivity.onRestart()");
	}
}
