package com.example.lesson3_activityjump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TwoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		TextView tv = (TextView) findViewById(R.id.tv);
		// 获取前一个界面给我的数据
		Intent intent = getIntent();
		String msg = intent.getStringExtra("msg");
		char sex = intent.getCharExtra("sex", '男');
		int age = intent.getIntExtra("age", 18);
		tv.setText(msg + "  " + sex + "  " + age);
		
		
	}

}
