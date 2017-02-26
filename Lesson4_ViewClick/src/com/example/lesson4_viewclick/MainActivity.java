package com.example.lesson4_viewclick;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;
	RelativeLayout rl;

	public void s3end(View v) {
		Log.e("TAG", "点击xml中设置的监听器");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 多态
		tv = (TextView) findViewById(R.id.tv);
		rl = (RelativeLayout) findViewById(R.id.rl);
		tv.setOnClickListener(listener);
		rl.setOnClickListener(listener);

		// tv.setOnLongClickListener(new OnLongClickListener() {
		//
		// @Override
		// public boolean onLongClick(View v) {
		// Log.e("TAG", "长按了TextView");
		// // return 是否消化该事件
		// // 是否向下传递
		// // 击鼓传话
		// return true;
		// }
		// });
		//
		// tv.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// Log.e("TAG", "点击了TextView");
		// }
		// });
		// rl.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// Log.e("TAG", "点击了相对布局");
		// }
		// });
	}

	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// 通过V来判断是谁点击
			if (v.getId() == R.id.tv) {
				Log.e("TAG", "TextView的点击事件");
			} else {
				Log.e("TAG", "RelativeLayout的点击事件");
			}
		}
	};
}
