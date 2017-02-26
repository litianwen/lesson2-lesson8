package com.example.lesson6_twofinish;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// keyCode == 当前按下的哪个键
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Log.e("TAG", "这是监听键盘操作的");
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		return super.onKeyUp(keyCode, event);
	}
	
	

	/**
	 * 回退键按下的时候
	 */
	/**
	 * 两次返回
	 * 第一次按下的时候记录时间
	 * 第二次按下的时候-第一次的事件<2000 退出，否则 第一次的时间等于现在的时间
	 */
	
	long startTime;
	@Override
	public void onBackPressed() {
		Log.e("TAG", "这是监听onBack的");
		// super.onBackPressed();
		if(System.currentTimeMillis()-startTime<2000)
			super.onBackPressed();//释放资源
		else
		{
			//记录时间
			startTime=System.currentTimeMillis();
			Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
		}
	}

}
