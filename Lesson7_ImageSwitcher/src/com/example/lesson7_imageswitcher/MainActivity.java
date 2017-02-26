package com.example.lesson7_imageswitcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	int[] resId = { R.drawable.img01, R.drawable.img02, R.drawable.img03,
			R.drawable.img04, R.drawable.img05, R.drawable.img06 };
	int index = 0;
	ImageSwitcher is;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		is = (ImageSwitcher) findViewById(R.id.is);
		is.setFactory(new ViewFactory() {
			// 用什么View来展示
			@Override
			public View makeView() {
				ImageView iv = new ImageView(getBaseContext());
				return iv;
			}
		});
		is.setImageResource(resId[index]);
	}

	public void up(View v) {
		index--;
		if (index < 0)
			index = resId.length - 1;
		is.setImageResource(resId[index]);
	}

	public void down(View v) {
		index++;
		if (index == resId.length)
			index = 0;
		is.setImageResource(resId[index]);
	}

}
