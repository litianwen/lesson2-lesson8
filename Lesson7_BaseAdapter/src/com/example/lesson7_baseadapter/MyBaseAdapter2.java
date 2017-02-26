package com.example.lesson7_baseadapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lesson7_baseadapter.MainActivity.Article;
import com.example.lesson7_gridview_baseadapter.R;

public class MyBaseAdapter2 extends BaseAdapter {

	private Context context;
	private List<Article> list;

	public MyBaseAdapter2(Context context, List<Article> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list == null ? 0 : list.size();
	}

	@Override
	public Article getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item_layout, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		holder.setData(list.get(position));
		return convertView;
	}

	// 对于一个较复杂的布局，组件比较多
	class ViewHolder// 保存的是所有的布局上的组件
	{
		TextView title;
		TextView content;

		public ViewHolder(View convertView) {
			title = (TextView) convertView.findViewById(R.id.tv1);
			content = (TextView) convertView.findViewById(R.id.tv2);
			// convertView.setTag(this);
		}

		public void setData(Article a) {
			title.setText(a.title);
			content.setText(a.content);
		}
	}

	// @Override
	// public View getView(int position, View convertView, ViewGroup parent) {
	// // 加载布局,考虑布局重用
	// if (convertView == null) {
	// // View的静态方法 加载视图
	// convertView = View.inflate(context, R.layout.item_layout, null);
	// }
	// // 从一个View中获取他里面的子控件
	// TextView title = (TextView) convertView.findViewById(R.id.tv1);
	// TextView content = (TextView) convertView.findViewById(R.id.tv2);
	// title.setText(list.get(position).title);
	// content.setText(list.get(position).content);
	// // 一定要注意
	// return convertView;
	// }

}
