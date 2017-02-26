package com.example.lesson3_activityjump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	String msg = "给twoActivity的礼物";

	public static final int SEXCODE = 1;
	public static final int HEIGHTCODE = 2;
	Button selectSex, selectheight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button next = (Button) findViewById(R.id.next);
		Button back = (Button) findViewById(R.id.back);
		// 监听
		// 下一页
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, TwoActivity.class);
				// 支持所有基础数据类型
				// 传递数据
				intent.putExtra("msg", msg);
				startActivity(intent);
			}
		});
		// 推出
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		selectSex = (Button) findViewById(R.id.selectSex);
		// 选择性别
		selectSex.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						ThreeActivity.class);
				startActivityForResult(intent, SEXCODE);
			}
		});

		selectheight = (Button) findViewById(R.id.selectheight);
		selectheight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						FourActivity.class);
				// 跳转到four并且带结果返回
				startActivityForResult(intent, HEIGHTCODE);
			}
		});

	}

	// 重写
	// 请求吗，返回码，返回数据
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// 这里面 获取返回的结果
		if (requestCode == SEXCODE) {
			if (resultCode == ThreeActivity.WOMENCODE) {
				selectSex.setText("选择的女");
			} else {
				selectSex.setText("选择的是男");
			}
		} else if (requestCode == HEIGHTCODE) {
			if (resultCode == FourActivity.CANCEL_CODE) {
				selectheight.setText("取消了选择的身高");
			} else {
				int length = data.getIntExtra("height", 0);
				selectheight.setText("输入的身高为" + length + "cm");
			}
		}
	}

}
