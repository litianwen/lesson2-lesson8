package com.example.lesson3_work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button btn_image,zhuce,tuichu;
	ImageView iv;
	EditText username=null;
	EditText password=null;
	EditText email=null;
	int id=0;
	public static final int REQUEST_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// id必须在布局中存在，并且 findViewByid必须在setContentView之后
		btn_image = (Button) findViewById(R.id.btn_image);
		zhuce=(Button) findViewById(R.id.zhuce);
		tuichu=(Button) findViewById(R.id.tuichu);
		iv = (ImageView) findViewById(R.id.iv);
		username=(EditText) findViewById(R.id.username);
		password=(EditText) findViewById(R.id.password);
		email=(EditText) findViewById(R.id.email);
		btn_image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 跳转activity
				Intent intent = new Intent(MainActivity.this,
						SelectorImageActivity.class);
				startActivityForResult(intent, REQUEST_CODE);
			}
		});
		
		zhuce.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent=new Intent(MainActivity.this,SecondActivity.class);
				String nameString=username.getText().toString();
				String pString=password.getText().toString();
				String eString=email.getText().toString();

				intent.putExtra("name", nameString);
				intent.putExtra("password", pString);
				intent.putExtra("email", eString);
				intent.putExtra("id", id);
				startActivity(intent);
				finish();
			}
		});
		
		tuichu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	}

	// 带结果返回
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE && resultCode ==SelectorImageActivity.RESULT_OK) {
			int img = data.getIntExtra("id", -1);
			if (img != -1) {
				// 怎么给一个图片设置前景图片
				iv.setImageResource(img);
			}
		}
	}
}
