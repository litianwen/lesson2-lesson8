package com.example.lesson8_demo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class StartDialog extends Dialog {

	public StartDialog(Context context) {
		super(context, R.style.StartDialogTheme);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_start);
	}

	// 打开大概2秒钟
	@Override
	public void show() {
		super.show();
		// 开个定时器
		new Thread() {
			public void run() {
				//启动时间
				if (callback != null)
					callback.loadData();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//结束时间
				if (StartDialog.this.isShowing()) {
					dismiss();
				}
			};
		}.start();
	}

	// 如果外部在show之前给了监听，就执行
	private Callback callback;

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

	public interface Callback {
		void loadData();
	}
}
