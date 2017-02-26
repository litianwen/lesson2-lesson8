package com.example.lesson5_layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;
	CheckBox cb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		tv = (TextView) findViewById(R.id.tv);
		cb = (CheckBox) findViewById(R.id.cb);
		cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				tv.setSelected(isChecked);
			}
		});

		// 加载一个布局,将一个layout文件变成一个view树
		// 后面一个参数永远为空
		// View view = LayoutInflater.from(this).inflate(R.layout.activity_main,
		// null);
		// // 在activity里面
		// View view2 = getLayoutInflater().inflate(R.layout.activity_main,
		// null);
		// // 在其他类中，只有context 没有activity
		// View view3 = View.inflate(this, R.layout.activity_main, null);

	}

	// 回调方法，在activity刚好显示在用户面前时
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
	}
}
