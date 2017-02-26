package com.example.lesson8_demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AnswerActivity extends Activity implements OnClickListener {

	TextView tv_quest, tv_finish;

	RadioGroup rg_answer;

	Questions quest;

	List<CompoundButton> mList = new ArrayList<CompoundButton>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answer);
		// 获取数据
		quest = (Questions) getIntent().getSerializableExtra("quest");
		initView();
		tv_quest.setText(quest.getQuest());
		// 答案是单选和是多选 添加组件
		initSelectButton();

	}

	private void initSelectButton() {
		if (quest.getAnswer().contains(",")) {
			// 多选
			多选();
		} else {
			// 单选
			单选();
		}
	}

	private void 单选() {
		创建单选按钮();
		// 修改默认值
		String answer = quest.getUserAnswer();
		// 判断答案为空
		if (!TextUtils.isEmpty(answer)) {
			// 让他默认选择
			for (int i = 0; i < abcd.length; i++) {
				if (answer.equalsIgnoreCase(this.abcd[i])) {
					mList.get(i).setChecked(true);
				}
			}
		}
	}

	private String[] 创建单选按钮() {
		String[] abcd = quest.getAbcd();
		for (int i = 0; i < abcd.length; i++) {
			RadioButton rb = new RadioButton(this);
			rb.setText(abcd[i]);
			mList.add(rb);
			rg_answer.addView(rb);
		}
		return abcd;
	}

	private void 多选() {
		创建多选按钮();
		String answer = quest.getUserAnswer();
		if (!TextUtils.isEmpty(answer)) {
			// 让他默认选择
			String[] anArray = answer.split(",");
			for (int i = 0; i < abcd.length; i++) {
				for (String string : anArray) {
					if (string.equalsIgnoreCase(this.abcd[i])) {
						mList.get(i).setChecked(true);
					}
				}
			}
		}
	}

	private String[] 创建多选按钮() {
		String[] abcd = quest.getAbcd();
		for (int i = 0; i < abcd.length; i++) {
			CheckBox cb = new CheckBox(this);
			cb.setText(abcd[i]);
			mList.add(cb);
			rg_answer.addView(cb);
		}
		return abcd;
	}

	private void initView() {
		tv_quest = (TextView) findViewById(R.id.tv_quest);
		tv_finish = (TextView) findViewById(R.id.tv_finish);
		rg_answer = (RadioGroup) findViewById(R.id.rg_answer);
		tv_finish.setOnClickListener(this);
	}

	String[] abcd = { "A", "B", "C", "D" };

	@Override
	public void onClick(View v) {
		String answer = "";
		for (int i = 0; i < mList.size(); i++) {
			if (mList.get(i).isChecked())
				answer += abcd[i] + ",";
		}
		// 去掉最后一个,号
		if (!answer.equals(""))
			answer = answer.substring(0, answer.length() - 1);
		setResult(RESULT_OK, getIntent().putExtra("answer", answer));
		finish();
	}
}
