package com.example.lesson4_edittextdemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {

	Button btn;
	TextView result;
	EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		// 设置基本的状态
		btn.setEnabled(false);// 设置Button不能被点击
		// 给EditText添加一个事件

		// //在这里获取的永远是空的
		// String phone = et.getText().toString();

		et.addTextChangedListener(listener);

		// 点击按钮 去判断手机是否正常
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 获取输入框的字符串
				send();
			}

			
		});
		//按了enter键的监听
		et.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				send();
				return false;
			}
		});

	}
	
	private void send() {
		String phonenum = et.getText().toString();
		if (phonenum.matches("[1][34678][0-9]{9}")) {
			result.setText("发送成功");
		} else {
			result.setText("发送失败");
		}
	}
	
	private void initView() {
		btn = (Button) findViewById(R.id.btn);
		result = (TextView) findViewById(R.id.result);
		et = (EditText) findViewById(R.id.et);
	}

	TextWatcher listener = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// 当文本改变时
			Log.e("TAG", s + "  " + start + "  " + before + "  " + count);
			// 判断是否是11位
			if (s.length() == 11) {
				btn.setEnabled(true);
			} else {
				btn.setEnabled(false);
			}

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// 文本改变之前
		}

		@Override
		public void afterTextChanged(Editable s) {
			// 文本改变之后
		}
	};

}
