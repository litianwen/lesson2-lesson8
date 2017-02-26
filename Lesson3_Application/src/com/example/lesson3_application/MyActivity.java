package com.example.lesson3_application;

import android.app.Activity;
import android.os.Bundle;

/**
 * 1.创建类继承Activity 2.重写onCreate 3.在onCreate中setContentView 4.注册
 * 每一个组件必须在manifest中注册
 * 如果不注册会 ActivityNotFound
 * 
 * @author Administrator
 *
 */
public class MyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
	}
}
