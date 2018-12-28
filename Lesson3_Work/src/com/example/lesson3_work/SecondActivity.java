package com.example.lesson3_work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity{

	TextView username,password,email;
	ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		imageView=(ImageView) findViewById(R.id.iv1);
		username=(TextView) findViewById(R.id.username1);
		password=(TextView) findViewById(R.id.password1);
		email=(TextView) findViewById(R.id.email1);
		
		Intent intent = getIntent();
		String username1 = intent.getStringExtra("name");
		String userpass1 = intent.getStringExtra("password");
		String useremail = intent.getStringExtra("email");
		int headNum = intent.getIntExtra("id",0);
	
		// 对文本的内容进行写入
		username.setText(username1);
		password.setText(userpass1);
		email.setText(useremail);
		imageView.setImageResource(SelectorImageActivity.imgId[headNum]);

		
	}

}
