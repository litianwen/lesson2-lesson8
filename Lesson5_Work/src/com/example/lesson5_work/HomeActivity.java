package com.example.lesson5_work;

import net.qiujuer.imageblurring.jni.ImageBlur;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;

public class HomeActivity extends Activity {
	LinearLayout ll_background;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ll_background = (LinearLayout) findViewById(R.id.ll_background);
		// 高斯模糊调用
		// Bitmap是安卓对于图像的类
		Bitmap bmp = BitmapFactory.decodeResource(getResources(),
				R.drawable.back);
		ImageBlur.blurBitMap(bmp, 80);
		// 调用过后 bmp已经改变了
		ll_background.setBackground(new BitmapDrawable(getResources(), bmp));
	}

}
