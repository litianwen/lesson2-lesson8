package com.example.lesson7_file_adapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FileAdapter extends BaseAdapter {

	private Context mContext;
	private List<File> mList;

	public FileAdapter(Context context, List<File> list) {
		mContext = context;
		mList = list;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public File getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 1.创建
		ViewHolder holder;
		// 2 判断非空
		if (convertView == null) {
			convertView = View
					.inflate(mContext, R.layout.item_filelayout, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.bindView(getItem(position));
		return convertView;
	}

	class ViewHolder {
		ImageView img;
		TextView name, time;

		public ViewHolder(View convertView) {
			img = (ImageView) convertView.findViewById(R.id.img);
			name = (TextView) convertView.findViewById(R.id.name);
			time = (TextView) convertView.findViewById(R.id.time);
		}

		public void bindView(File item) {
			String name = item.getName();
			this.name.setText(name);
			if (item.isDirectory()) {
				img.setImageResource(R.drawable.folder);
			} else {
				if (name.endsWith(".png") || name.endsWith(".jpg")
						|| name.endsWith("gif"))
					img.setImageResource(R.drawable.image);
				else if (name.endsWith(".txt") || name.endsWith(".log"))
					img.setImageResource(R.drawable.text);
				else {
					img.setImageResource(R.drawable.no);
				}
			}
			// 设置时间
			String date = new SimpleDateFormat("yy-M-d HH:mm").format(new Date(
					item.lastModified()));
			this.time.setText(date);
		}
	}

}
