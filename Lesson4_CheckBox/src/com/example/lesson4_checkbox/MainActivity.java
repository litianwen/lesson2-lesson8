package com.example.lesson4_checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnCheckedChangeListener {
	CheckBox music, android, play;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		music = (CheckBox) findViewById(R.id.music);
		android = (CheckBox) findViewById(R.id.android);
		play = (CheckBox) findViewById(R.id.play);

		// 设置勾选的事件
		music.setOnCheckedChangeListener(this);
		android.setOnCheckedChangeListener(this);
		play.setOnCheckedChangeListener(this);
		
		music.setChecked(true);

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.music:
			Toast.makeText(this, "音乐" + (isChecked ? "被选中" : "被取消"),
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.play:
			Toast.makeText(this, "运动" + (isChecked ? "被选中" : "被取消"),
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.android:
			Toast.makeText(this, "敲代码" + (isChecked ? "被选中" : "被取消"),
					Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
