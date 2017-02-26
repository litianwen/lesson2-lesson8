package com.example.lesson5_resource;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	// Color
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String hello = getResources().getString(R.string.hello);
		Log.e("TAG", hello);
		String[] array = getResources().getStringArray(R.array.array);
		for (String string : array) {
			Log.e("TAG", string);
		}
		final TextView tv = (TextView) findViewById(R.id.tv);
		
		//getResources().getDisplayMetrics().density
		
		final Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// tv.setTextColor(getResources().getColor(R.color.red));
				// # 0x
				tv.setTextColor(Color.argb(0x80, 0x33, 0x66, 0x99));
				btn.setEnabled(false);
			}
		});
		
	}

}
