package com.example.lesson3_activityjump;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThreeActivity extends Activity implements OnClickListener {

	public static final int MANCODE = 1;
	public static final int WOMENCODE = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 获取返回类型
		setContentView(R.layout.activity_three);
		Button man = (Button) findViewById(R.id.man);
		Button women = (Button) findViewById(R.id.woman);

		man.setOnClickListener(this);
		women.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// 怎么确定到底是那个按钮被点击呢？
		switch (v.getId()) {
		case R.id.woman:
			// 告诉MainActivity，到底选择的是哪一个
			setResult(WOMENCODE);
			finish();
			break;
		case R.id.man:
			setResult(MANCODE);
			finish();
			break;
		}
	}

}
