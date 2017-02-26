package com.example.lessondemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	/**
	 * 事件驱动编程模式 你不点我不动
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TextView tv = (TextView) findViewById(R.id.tv);
		// 不能直接设置int类型。必须转String
		// tv.setText(30+"");
		// Context context = this;
		// 获取屏幕的宽度
		/* context. */
		int width = getResources().getDisplayMetrics().widthPixels;
		int height = getResources().getDisplayMetrics().heightPixels;

		// 不推荐
		getWindowManager().getDefaultDisplay().getWidth();
		getWindowManager().getDefaultDisplay().getHeight();

		// 还有最后一种
		DisplayMetrics outMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		Log.e("TAG", outMetrics.widthPixels + "");
		Log.e("TAG", outMetrics.heightPixels + "");

		Log.e("TAG", width + "   " + height);

		// 动态代码创建的好处
		// GridLayout gl = (GridLayout) findViewById(R.id.gl);
		// for (int i = 0; i < 100; i++) {
		// Button btn = new Button(this);
		// btn.setText(i+"");
		// gl.addView(btn);
		// }
		LinearLayout ll = (LinearLayout) findViewById(R.id.gl);
		for (int i = 0; i < 4; i++) {
			//创建垂直LinearLayout中的4个水平的LinearLayout
			LinearLayout layout = new LinearLayout(this);
			layout.setOrientation(LinearLayout.HORIZONTAL);
			for (int j = 0; j < 4; j++) {
				//创建水平LinearLayout中的4个Button
				Button btn = new Button(this);
				btn.setText(i + "  " + j);
				btn.setPadding(5, 5, 5, 5);
				// weight = 1
				// 创建我们在xml中设置的带Layout的属性
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
						0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
				// 设置这个属性
				params.setMargins(5, 5, 5, 5);
				btn.setLayoutParams(params);
				layout.addView(btn);
			}
			ll.addView(layout);
		}

	}
}
