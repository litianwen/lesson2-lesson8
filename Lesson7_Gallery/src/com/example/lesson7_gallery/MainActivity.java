package com.example.lesson7_gallery;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends Activity {
	//RecyleView
	Gallery gl;

	int[] resId = { R.drawable.img01, R.drawable.img02, R.drawable.img03,
			R.drawable.img04, R.drawable.img05, R.drawable.img06 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gl = (Gallery) findViewById(R.id.gl);
		gl.setAdapter(adapter);
		gl.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Log.e("TAG", "--" + position + "被选中");
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
	}

	private BaseAdapter adapter = new BaseAdapter() {

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null)
				convertView = new ImageView(MainActivity.this);
			ImageView iv = (ImageView) convertView;
			iv.setPadding(20, 20, 20, 20);
			iv.setImageResource(resId[position]);
			return convertView;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public int getCount() {
			return resId.length;
		}
	};
}
