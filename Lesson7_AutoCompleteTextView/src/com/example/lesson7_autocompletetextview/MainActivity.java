package com.example.lesson7_autocompletetextview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

	// 数据源
	String[] data = { "zhangsan", "lisi", "wangwu", "zhaoliu", "tianqi",
			"wangba", "xiaojiujiu", "李四", "李五", "李六" };

	AutoCompleteTextView actv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 显示
		actv = (AutoCompleteTextView) findViewById(R.id.actv);
		// 适配器
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.item_actv, R.id.tv, data);
		// 所有需要适配器的view
		actv.setAdapter(adapter);
	}

}
