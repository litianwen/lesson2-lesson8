package com.example.lesson3_activityjump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FourActivity extends Activity implements OnClickListener {

	Button submit, cancel;
	EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_length);
		submit = (Button) findViewById(R.id.submit);
		cancel = (Button) findViewById(R.id.cancel);
		et = (EditText) findViewById(R.id.et);
		submit.setOnClickListener(this);
		cancel.setOnClickListener(this);
	}

	public static final int SUBMIT_CODE = 1;
	public static final int CANCEL_CODE = 2;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.submit:
			// Intent data = new Intent();
			Intent data = getIntent();
			int length = Integer.parseInt(et.getText().toString());
			data.putExtra("height", length);
			// 用户返回，那么必须带身高回去
			setResult(SUBMIT_CODE, data);
			finish();
			break;
		case R.id.cancel:
			// 用户取消，那么不需要带参数
			setResult(CANCEL_CODE);
			finish();
			break;
		}
	}

}
