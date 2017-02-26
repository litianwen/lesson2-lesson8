package com.example.lesson2_viewgroup;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends Activity {
	Button bbb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// super不能去掉，并且再第一行
		super.onCreate(savedInstanceState);
		// 切换视图
		setContentView(R.layout.activity_main);
		// 通过findViewByID将组件和xml的控件对应
		// 如果访问了一个 setContentView的布局中没有的id号，那么返回为空
		// bbb = (Button) findViewById(R.id.center);
		// /System.out.println(bbb == null);
		// bbb.setText("aaa");
	}

}
