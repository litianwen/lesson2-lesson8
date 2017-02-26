package com.example.lesson7_progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar4);
		final TextView tv = (TextView) findViewById(R.id.tv);
		pb.setMax(200);
		pb.setProgress(0);
		new Thread() {
			public void run() {
				// 模拟耗时任务
				int index = 0;
				while (index++ < 200) {
					try {
						Thread.sleep((int) (Math.random() * 200));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 修改值
					// 做了UI的处理，所以直接可以再子线程中修改UI
					pb.setProgress(index);
					// 需要使用UI线程
					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							tv.setText(pb.getProgress() + "/" + pb.getMax());
						}
					});
				}

			};
		}.start();
	}

}
