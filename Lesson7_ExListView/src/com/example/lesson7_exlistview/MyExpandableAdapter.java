package com.example.lesson7_exlistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MyExpandableAdapter extends BaseExpandableListAdapter {

	private Context context;

	public MyExpandableAdapter(Context context) {
		this.context = context;
	}

	String[] group = { "大学", "中学", "小学" };

	String[][] child = { { "张三", "李四" }, { "王五", "赵六", "田七" }, { "马云" } };

	// 最外层有多少个
	@Override
	public int getGroupCount() {
		return group.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return child[groupPosition].length;
	}

	@Override
	public String getGroup(int groupPosition) {
		return group[groupPosition];
	}

	@Override
	public String getChild(int groupPosition, int childPosition) {
		return child[groupPosition][childPosition];
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		if (convertView == null)
			convertView = new TextView(context);
		TextView tv = (TextView) convertView;
		tv.setText(group[groupPosition]);
		tv.setPadding(30, 10, 10, 10);
		return tv;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		if (convertView == null)
			convertView = new TextView(context);
		TextView tv = (TextView) convertView;
		tv.setText(child[groupPosition][childPosition]);
		tv.setPadding(10, 10, 10, 10);
		return tv;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
