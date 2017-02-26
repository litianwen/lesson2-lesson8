package com.example.kugou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class landing extends Activity{
	
	Button bt1;
	Button bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.landing);
		bt1=(Button) findViewById(R.id.x);
		bt2=(Button) findViewById(R.id.like);
		
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.x){
					finish();
				}
			}
		});
		bt2.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(landing.this,play.class);
				startActivity(intent);
			}
		});
	}
}
