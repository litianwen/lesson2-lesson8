package com.example.lesson7_seekbar;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/**
 * 需要用他调节音量大小
 * 
 * @author Administrator
 *
 */

/**
 * 所有操作系统的 都需要Service系统服务
 * 
 * @author Administrator
 *
 */

public class MainActivity extends Activity {
	SeekBar seekBar;
	TextView tv;
	AudioManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		tv = (TextView) findViewById(R.id.tv);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// 拖拽完毕
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// 开始拖拽时 用户刚好点上去
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// 每次进度改变都会调用
				// 是否是用户改变的呢？？？
				// if (fromUser) {
				tv.setText(progress + "/" + seekBar.getMax());
				// }
				// 拖动进度条，我需要改变音量
				// flags用来 需不需要声音 是否需要ui
				manager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,
						AudioManager.FLAG_SHOW_UI
								| AudioManager.FLAG_PLAY_SOUND);

			}
		});
		// seekBar.setMax(200);
		// seekBar.setProgress(50);

		// 获取系统服务
		// 获取音频管理器
		manager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		// 获取他的最大值 0-15
		int max = manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		seekBar.setMax(max);
		// 本来就有一个声量值
		int volumn = manager.getStreamVolume(AudioManager.STREAM_MUSIC);
		Log.e("TAG", volumn + "   ");
		seekBar.setProgress(volumn);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
			// ++
			seekBar.setProgress(seekBar.getProgress() + 1);
		} else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
			seekBar.setProgress(seekBar.getProgress() - 1);
		}
		return super.onKeyUp(keyCode, event);
	}
}
