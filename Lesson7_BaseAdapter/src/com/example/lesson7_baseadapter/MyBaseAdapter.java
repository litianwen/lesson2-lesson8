package com.example.lesson7_baseadapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyBaseAdapter extends BaseAdapter {

	private List<String> list;
	private Context context;

	// 数据源
	public MyBaseAdapter(Context context, List<String> list) {
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// 获取多少条
		Log.e("TAG", list.size() + "--------------getConut");
		return list.size();
	}

	@Override
	public String getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 最重要的方法
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.e("TAG", position + "--------------getView");
		// position 代表当前的第几项
		// convertView布局重用
		// parent父布局
		// 一切与布局相关的初始化都需要上下文
		// 只有一个组件的时候可能看不出卡
		// TextView tv = new TextView(context);
		// // 设置数据
		// tv.setText(getItem(position));
		// Log.e("TAG", "---" + (convertView == null));
		// 布局重用的固定写法
		if (convertView == null) {
			convertView = new TextView(context);
			// 口袋
			convertView.setTag(position);
		}
		TextView tv = (TextView) convertView;
		tv.setText(getItem(position));
		Log.e("TAG", tv.getTag().toString());
		return tv;
	}

}
