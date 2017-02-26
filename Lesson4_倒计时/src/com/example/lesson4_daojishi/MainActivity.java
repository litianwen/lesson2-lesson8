package com.example.lesson4_daojishi;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	EditText et_phonenum;
	Button btn_send;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_phonenum = (EditText) findViewById(R.id.et_phonenum);
		btn_send = (Button) findViewById(R.id.btn_send);
		btn_send.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// 模拟发送短信
		String phone = et_phonenum.getText().toString();
		if (phone.matches("[1][3579][\\d]{9}")) {
			// 不能继续发
			btn_send.setEnabled(false);
			MyCountDownTimer timer = new MyCountDownTimer();
			// 开启
			timer.start();
			// 使用倒计时
			// new Thread() {
			// public void run() {
			// try {
			// sleep(2000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// // 1. 子线程不允许修改UI UI线程就是主线程
			// // 2. 主线程不允许使用网络请求
			// // 3. 在Activity中如果需要访问UI，可以使用
			// runOnUiThread(new Runnable() {
			//
			// @Override
			// public void run() {
			// btn_send.setEnabled(true);
			// }
			// });
			// };
			// }.start();
		}
	}

	class MyCountDownTimer extends CountDownTimer {
		// 必须显示的调用父类的构造方法
		public MyCountDownTimer() {
			// millisInFuture 倒计时的时间 毫秒
			// countDownInterval间隔多少毫秒执行一次事件
			super(10000, 1000);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			// 每countDownInterval触发一次onTick事件
			btn_send.setText("还剩" + millisUntilFinished / 1000 + "秒可以再次发送");
		}

		@Override
		public void onFinish() {
			btn_send.setEnabled(true);
			btn_send.setText("发送");
		}

	}
}
