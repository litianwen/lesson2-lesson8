package com.example.lesson8_notification;

import android.app.Activity;
import android.app.Activity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OneActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("跳转界面");
		setContentView(tv);
	}
}
