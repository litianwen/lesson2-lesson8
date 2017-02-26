package com.example.lesson4_radiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {
	RadioGroup rg;
	RadioButton man, woman;
	RadioGroup rg2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rg = (RadioGroup) findViewById(R.id.rg);
		rg2 = (RadioGroup) findViewById(R.id.rg2);
		man = (RadioButton) findViewById(R.id.man);
		woman = (RadioButton) findViewById(R.id.woman);
		rg.check(R.id.woman);
		// 监听方法相同，但是监听接口不一致
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Log.e("TAG", checkedId + "");
				switch (checkedId) {
				case R.id.man:
					break;
				case R.id.woman:
					break;
				}
			}
		});
		man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				Log.e("TAG", "男" + isChecked);
			}
		});
		woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				Log.e("TAG", "女" + isChecked);
			}
		});
		rg2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Log.e("TAG", checkedId + "");
				// 没有分配ID的时候，默认是从1开始计算当前界面上所有的RadioButton的序列。
				// 当界面跳转后，在此回来，可能id继续增加
			}
		});
		rg2.check(1);
		//获取某一个button
		//他是ViewGroup的属性，在布局中获取某一个元素
		//rg2.getChildAt(1);
	}
}
