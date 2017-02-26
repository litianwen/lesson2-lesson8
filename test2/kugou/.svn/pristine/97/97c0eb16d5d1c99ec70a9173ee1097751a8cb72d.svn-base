package com.example.kugou;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter{
	List<String> list;
	Context context;
	public  ListAdapter(Context context, List<String> list) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.list=list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tv=(TextView) convertView.findViewById(R.id.adapter);
			if(convertView==null)
				convertView=View.inflate(context, R.layout.adlist, null);
			
			tv.setText(list.get(position));
			
		return convertView;
	}

}
