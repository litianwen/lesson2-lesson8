package com.example.lesson8_demo;

import java.util.ArrayList;
import java.util.List;

import android.app.ExpandableListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

//前缀为view后缀是activity fragment等 带有一个view的布局的界面
public class ResultActivity extends ExpandableListActivity {

	List<Questions> right = new ArrayList<Questions>();
	List<Questions> error = new ArrayList<Questions>();
	List<Questions> enno = new ArrayList<Questions>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ExpandableListView lv = getExpandableListView();
		lv.setGroupIndicator(null);
		initData();
		MyAdapter adapter = new MyAdapter();
		lv.setAdapter(adapter);
	}
	
	@Override
	public void onBackPressed() {
		setResult(RESULT_CANCELED);
		super.onBackPressed();
	}

	private void initData() {
		@SuppressWarnings("unchecked")
		ArrayList<Questions> list = (ArrayList<Questions>) getIntent()
				.getSerializableExtra("result");
		Log.e("TAG", list.toString());
		// 分配
		for (Questions questions : list) {
			if (TextUtils.isEmpty(questions.getUserAnswer())) {
				enno.add(questions);
			} else if (questions.getUserAnswer().equalsIgnoreCase(
					questions.getAnswer())) {
				right.add(questions);
			} else
				error.add(questions);
		}

	}

	class MyAdapter extends BaseExpandableListAdapter {
		String[] group = { "正确", "错误", "未答" };

		@Override
		public int getGroupCount() {
			return group.length;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			switch (groupPosition) {
			case 0:
				return right.size();
			case 1:
				return error.size();
			default:
				return enno.size();
			}
		}

		@Override
		public Object getGroup(int groupPosition) {
			return null;
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return null;
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
				convertView = new TextView(getBaseContext());
			TextView tv = (TextView) convertView;
			tv.setText(group[groupPosition]);
			tv.setTextColor(Color.RED);
			return convertView;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			if (convertView == null)
				convertView = new TextView(getBaseContext());
			TextView tv = (TextView) convertView;
			tv.setTextColor(Color.BLACK);
			Questions quest = null;
			switch (groupPosition) {
			case 0:
				quest = right.get(childPosition);
				break;
			case 1:
				quest = error.get(childPosition);
				break;
			default:
				quest = enno.get(childPosition);
				break;
			}
			String msg = quest.getQuest()
					+ "\n"
					+ "正确答案:<font color='#0000ff'>"
					+ quest.getAnswer()
					+ "</font>\n你的答案:<font color='#FF0000'>"
					+ (quest.getUserAnswer() == null ? "未答" : quest
							.getUserAnswer() + "</font>");
			tv.setText(Html.fromHtml(msg));
			return convertView;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}

	}
}
