package com.example.lesson4_datepickertimerpicker;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {

	DatePicker datePicker;
	TimePicker timePicker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		datePicker = (DatePicker) findViewById(R.id.datePicker);
		timePicker = (TimePicker) findViewById(R.id.timePicker);
		// 初始化
		// 从0开始
		datePicker.init(1980, 10 - 1, 10, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				Log.e("TAG", year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
			}
		});
		// 设置24小时制
		timePicker.setIs24HourView(true);
		timePicker.setCurrentHour(18);
		timePicker.setCurrentMinute(00);
		// 监听
		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				Log.e("TAG", hourOfDay + "  " + minute);
			}
		});
		// timePicker.setHour(17);
		// timePicker.setMinute(59);

	}

}
