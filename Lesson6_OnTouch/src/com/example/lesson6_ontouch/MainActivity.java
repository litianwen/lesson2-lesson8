package com.example.lesson6_ontouch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyRelativeLayout rl = (MyRelativeLayout) findViewById(R.id.rl);
		rl.onClickListener = new MyRelativeLayout.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 自己的回调监听
			}
		};
		// rl.setOnTouchListener(this);
		// rl.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// Log.e("TAG", "点击事件");
		// }
		// });
	}

	// // 消耗事件
	// @Override
	// public boolean onTouch(View v, MotionEvent event) {
	// // 命令
	// // Log.e("TAG", event.getAction() + "  ");
	// // Log.e("TAG", event.getX() + " " + event.getY() + " ");
	// // if (event.getPointerCount() > 1) {
	// // Log.e("TAG", "第二个手指头" + event.getX(1));
	// // Log.e("TAG", "第二个手指头" + event.getY(1));
	// // }
	//
	// switch (event.getAction()) {
	// case MotionEvent.ACTION_DOWN:
	//
	// break;
	// case MotionEvent.ACTION_MOVE:
	// break;
	// case MotionEvent.ACTION_UP:
	// Log.e("TAG", "点击事件");
	// onClickListener.onClick(this);
	// break;
	// }
	// // 事件分发，
	// return true;// false true super
	// }

}
