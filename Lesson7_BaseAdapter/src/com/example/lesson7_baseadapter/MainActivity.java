package com.example.lesson7_baseadapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lesson7_gridview_baseadapter.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 耗时必须子线程.
		// SD卡根目录
		File dir = Environment.getExternalStorageDirectory();
		// 遍历文件夹
		// 使用dir.listFiles();进行递归

		ListView lv = (ListView) findViewById(R.id.lv);
		// 适配器
		List<String> list = new ArrayList<String>();
		final List<Article> list2 = new ArrayList<MainActivity.Article>();
		for (int i = 0; i < 100; i++) {
			list.add("条目" + i);
			list2.add(new Article("标题" + i, "内容" + i));
		}

		// MyBaseAdapter adapter = new MyBaseAdapter(this, list);
		final MyBaseAdapter2 adapter = new MyBaseAdapter2(this, list2);
		lv.setAdapter(adapter);

		// ListView的点击事件
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// postion代表点的第几个
				Article a = list2.get(position);
				Toast.makeText(getBaseContext(), a.toString(),
						Toast.LENGTH_SHORT).show();
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		// 一般长按事件用来做 删除和弹出对话框
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				list2.remove(position);
				// 调用adapter.notifyDataSetChanged方法来刷新适配器，保证数据改变之后，view刷新
				// 长度不一致会导致崩溃
				// 类容发生改变不会
				// Article a = list2.get(position);
				// a.content = "哈哈，修改了";
				// 必须在主线程
				adapter.notifyDataSetChanged();
				return true;
			}
		});
	}

	public static class Article {
		String title;
		String content;

		@Override
		public String toString() {
			return "Article [title=" + title + ", content=" + content + "]";
		}

		public Article(String title, String content) {
			super();
			this.title = title;
			this.content = content;
		}

	}
}
