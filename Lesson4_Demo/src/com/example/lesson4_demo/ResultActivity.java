package com.example.lesson4_demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		setContentView(tv);
		UserBean user = (UserBean) getIntent().getSerializableExtra("user");
		tv.setText(user.toString());
	}
}
