package com.example.lesson8_progressdialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void progress1(View v) {
		final ProgressDialog dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在加载");
		// 设置为水平样式
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.show();
		new Thread() {
			public void run() {
				int index = 0;
				while (index++ < dialog.getMax()) {
					dialog.setProgress(index);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
		// 关闭时一般判断
		//
		// if (dialog != null && dialog.isShowing())
		// dialog.dismiss();
	}

	public void datePicker(View v) {
		DatePickerDialog dialog = new DatePickerDialog(this,
				new OnDateSetListener() {

					@Override
					public void onDateSet(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						// 这里是用户选择完毕后的回调
						Toast.makeText(
								getBaseContext(),
								year + "-" + (monthOfYear + 1) + "-"
										+ dayOfMonth, Toast.LENGTH_SHORT)
								.show();

					}
				}, 2016, 11, 11);
		dialog.show();
	}

	public void timePicker(View v) {
		TimePickerDialog dialog = new TimePickerDialog(this,
				new OnTimeSetListener() {

					@Override
					public void onTimeSet(TimePicker view, int hourOfDay,
							int minute) {
						Toast.makeText(getBaseContext(),
								hourOfDay + ":" + minute, Toast.LENGTH_SHORT)
								.show();
					}
				}, 11, 11, true);
		dialog.show();
	}
}
