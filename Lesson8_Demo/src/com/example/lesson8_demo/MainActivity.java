package com.example.lesson8_demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.lesson8_demo.StartDialog.Callback;

/**
 * 循环遍历退出
 * 
 * @author Administrator
 *
 */
public class MainActivity extends Activity implements Callback,
		OnDismissListener, OnItemClickListener, OnClickListener {

	private static final int REQUERT_CODE = 0;

	private static final int REQUEST_RESULT = 0;

	// M V C
	// MVP MVVM

	StartDialog dialog;

	ArrayList<Questions> mList = new ArrayList<Questions>();

	ListView lv_content;
	TextView tv_finish, tv_progress, tv_time;
	ProgressBar pb_progress;

	QuestionAdapter adapter;

	// Set去重复
	// 无序，无重复，有且只有一个null
	HashSet<Integer> set = new HashSet<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		startDialog();
	}

	private void initView() {
		// 加载视图
		lv_content = (ListView) findViewById(R.id.lv_content);
		tv_finish = (TextView) findViewById(R.id.tv_finish);
		tv_progress = (TextView) findViewById(R.id.tv_progress);
		pb_progress = (ProgressBar) findViewById(R.id.pb_progress);
		tv_time = (TextView) findViewById(R.id.tv_time);
		// 跳转界面
		lv_content.setOnItemClickListener(this);
		tv_finish.setOnClickListener(this);
	}

	private void startDialog() {
		dialog = new StartDialog(this);
		dialog.setCallback(this);
		dialog.show();
		dialog.setOnDismissListener(this);
	}

	@Override
	public void loadData() {
		// 加载数据
		// 10条
		String[] array = getResources().getStringArray(R.array.timu);
		mList.add(new Questions(array[0], "B",
				new String[] { "后手", "先手", "不确定" }));
		mList.add(new Questions(array[1], "D", new String[] { "三红", "三白", "二红",
				"一白" }));
		mList.add(new Questions(array[2], "B", new String[] { "管理	", "金融",
				"外语", "推断不出" }));
		mList.add(new Questions(array[3], "A", new String[] { "4", "1", "2",
				"3" }));
		mList.add(new Questions(array[4], "B", new String[] { "2", "3", "4",
				"5" }));
		mList.add(new Questions(array[5], "A", new String[] { "14", "15", "16",
				"13" }));
		mList.add(new Questions(array[6], "A", new String[] { "900", "1200",
				"1000", "800" }));

		mList.add(new Questions(array[7], "B", new String[] { "1会五笔", "10不会五笔",
				"1不会", "10会" }));
		mList.add(new Questions(array[8], "B", new String[] { "6", "7", "8",
				"9" }));
		mList.add(new Questions(array[9], "C", new String[] { "5", "6", "7",
				"8" }));
		mList.add(new Questions("空运货物的计费重量可按如下计算", "A,B,C", new String[] {
				"按实际毛重", "按体积重量", "按较高重量分界点的重量", "按较低重量分界点的重量" }));
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		// 当启动页关闭后,为他设置适配器
		adapter = new QuestionAdapter(this, mList);
		lv_content.setAdapter(adapter);
		pb_progress.setMax(mList.size());
		tv_progress.setText("0/" + mList.size());

		// 启动定时器
		MyTask task = new MyTask();
		task.start();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Questions quest = mList.get(position);
		Intent intent = new Intent(this, AnswerActivity.class);
		// 带题目过去
		intent.putExtra("quest", quest);
		startActivityForResult(intent, position);
	}

	// String
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// 确定选择了答案
		if (resultCode == RESULT_OK) {
			String answer = data.getStringExtra("answer");
			mList.get(requestCode).setUserAnswer(answer);
			if (TextUtils.isEmpty(answer))
				set.remove(requestCode);
			else
				set.add(requestCode);
			adapter.notifyDataSetChanged();
			// 改变进度条
			tv_progress.setText(set.size() + "/" + mList.size());
			pb_progress.setProgress(set.size());
		} else if (resultCode == RESULT_CANCELED) {
			finish();
		}
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, ResultActivity.class);
		intent.putExtra("result", mList);
		startActivityForResult(intent, REQUEST_RESULT);
	}

	// 倒计时
	class MyTask extends CountDownTimer {

		SimpleDateFormat format;

		public MyTask() {
			super(1000 * 10, 1000);
			format = new SimpleDateFormat("mm:ss");
		}

		@Override
		public void onTick(long millisUntilFinished) {
			// 更新UI
			tv_time.setText(format.format(new Date(millisUntilFinished)));
		}

		@Override
		public void onFinish() {
			// 跳转到未答界面
			Intent intent = new Intent(MainActivity.this, ResultActivity.class);
			intent.putExtra("result", mList);
			startActivityForResult(intent, REQUEST_RESULT);
		}

	}
}
