package com.example.lesson8_dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

public class MyDialog extends Dialog {

	// 必须要给构造方法
	public MyDialog(Context context) {
		// 使用主题来修改Dialog的样式
		super(context, R.style.DialogTheme);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_progress);
	}

	/**
	 * 一个Activity或者一个Dialog刚刚出现在用户面前
	 */
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
	}
}
