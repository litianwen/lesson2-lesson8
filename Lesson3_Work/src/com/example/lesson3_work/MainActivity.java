package com.example.lesson3_work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	Button btn_image;
	ImageView iv;

	public static final int REQUEST_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// id必须在布局中存在，并且 findViewByid必须在setContentView之后
		btn_image = (Button) findViewById(R.id.btn_image);
		iv = (ImageView) findViewById(R.id.iv);
		btn_image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 跳转activity
				Intent intent = new Intent(MainActivity.this,
						SelectorImageActivity.class);
				startActivityForResult(intent, REQUEST_CODE);
			}
		});
	}

	// 带结果返回
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
			int img = data.getIntExtra("id", -1);
			if (img != -1) {
				// 怎么给一个图片设置前景图片
				iv.setImageResource(img);
			}
		}
	}
}
