package com.example.lesson4_javacreate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		// 创建View
//		Button btn = new Button(this);
//		btn.setText("我是java代码创建的Button对象");
		LinearLayout layout = new LinearLayout(this);
		Button btn = new Button(this);
		btn.setText("第一个Button");
		Button btn2 = new Button(this);
		btn2.setText("第二个Button");
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(btn);
		layout.addView(btn2);
//		// 重载方法 方法名相同，方法参数不一致
		setContentView(layout);
	}

}
