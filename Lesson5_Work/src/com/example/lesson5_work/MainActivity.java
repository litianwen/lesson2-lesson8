package com.example.lesson5_work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btn_register).setOnClickListener(this);
		findViewById(R.id.btn_login).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_register:
			startActivity(new Intent(this, RegisterActivity.class));
			break;
		case R.id.btn_login:
			startActivity(new Intent(this, HomeActivity.class));
			break;
		}
	}
}
