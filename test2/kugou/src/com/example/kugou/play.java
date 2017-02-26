package com.example.kugou;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class play extends Activity implements OnClickListener{
	CheckBox c;
	TextView t,tsb,list;
	Button be;
	Button bn;
	Button bs;
	Button bc;
	RelativeLayout rl;
	MediaPlayer mp;
	SeekBar sb;
	AudioManager manager;
	ListDialog ld;
	 int i=0;
	 int j=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play);
		c=(CheckBox) findViewById(R.id.play);
		t=(TextView) findViewById(R.id.tv);
		tsb=(TextView) findViewById(R.id.tsb);
		list=(TextView) findViewById(R.id.list);
		be=(Button) findViewById(R.id.befor);
		bn=(Button) findViewById(R.id.next);
		bs=(Button) findViewById(R.id.stop);
		bc=(Button) findViewById(R.id.back3);
		sb=(SeekBar) findViewById(R.id.sb);
		tsb.setText("1/100");
		String [] arr=getResources().getStringArray(R.array.list);
		list.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			ld= new ListDialog(play.this);
			ld.show();
				
			}
		});
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				manager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, manager.FLAG_PLAY_SOUND);
				tsb.setText(sb.getProgress()+"/"+sb.getMax());
			}
		});
		manager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
		bc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.back3){
					finish();
				}
			}
		});
		rl=(RelativeLayout) findViewById(R.id.bakc);
		mp	=MediaPlayer.create(play.this, R.raw.tara_just_now);
		try {
			mp.prepare();
			mp.prepareAsync();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					if(t.getText().toString().equals("Ailee - 一天一天.mp3")){
						mp	=MediaPlayer.create(play.this, R.raw.ailee_day_by_day);
						t.setText("Ailee - 一天一天.mp3");
						mp.start();
						mp.prepareAsync();
						rl.setBackgroundResource(R.drawable.ailee1);
					}else if(t.getText().toString().equals("Ailee - 你也一样.mp3")){
						mp	=MediaPlayer.create(play.this, R.raw.ailee_the_same_to_you);
						t.setText("Ailee - 你也一样.mp3");
						mp.start();
						rl.setBackgroundResource(R.drawable.ailee2);
						
					}else if(t.getText().toString().equals("田馥甄 - 小幸运 - 2015如果巡回演唱会.mp3")){
						
						mp	=MediaPlayer.create(play.this, R.raw.lucky);
						t.setText("田馥甄 - 小幸运 - 2015如果巡回演唱会.mp3");
						mp.start();
						rl.setBackgroundResource(R.drawable.hebe);
					}else if(t.getText().toString().equals("T-ara - Just Now.mp3")){
						mp	=MediaPlayer.create(play.this, R.raw.tara_just_now);
						t.setText("T-ara - Just Now.mp3");
						mp.start();
						rl.setBackgroundResource(R.drawable.tara);
					}
				}else{
					mp.pause();
				}
			}
		});
		be.setOnClickListener(this);
		bn.setOnClickListener(this);
		bs.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.befor:
			if(i==0){
				
				mp.stop();
				try {
					Thread.sleep(1001);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp	=MediaPlayer.create(play.this, R.raw.ailee_day_by_day);
				t.setText("Ailee - 一天一天.mp3");
				mp.start();
				rl.setBackgroundResource(R.drawable.ailee1);
				i++;
				break;
			}
			if(i==1){
				
				mp.stop();
				try {
					Thread.sleep(1001);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp	=MediaPlayer.create(play.this, R.raw.ailee_the_same_to_you);
				t.setText("Ailee - 你也一样.mp3");
				mp.start();
				rl.setBackgroundResource(R.drawable.ailee2);
				i++;
				break;
			}
			if(i==2){
				
				mp.stop();
				try {
					Thread.sleep(1001);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp	=MediaPlayer.create(play.this, R.raw.lucky);
				t.setText("田馥甄 - 小幸运 - 2015如果巡回演唱会.mp3");
				mp.start();
				rl.setBackgroundResource(R.drawable.hebe);
				i++;
				break;
			}
			if(i==3){
				
				mp.stop();
				try {
					Thread.sleep(1001);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp	=MediaPlayer.create(play.this, R.raw.tara_just_now);
				t.setText("T-ara - Just Now.mp3");
				mp.start();
				rl.setBackgroundResource(R.drawable.tara);
				i=0;
				break;
			}
		case R.id.next:
			if(j==0){
				
				mp.stop();
				try {
					Thread.sleep(1001);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp	=MediaPlayer.create(play.this, R.raw.ailee_the_same_to_you);
				t.setText("Ailee - 你也一样.mp3");
				mp.start();
				rl.setBackgroundResource(R.drawable.ailee2);
				j++;
				break;
			}
			if(j==1){
				
				mp.stop();
				try {
					Thread.sleep(1001);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp	=MediaPlayer.create(play.this, R.raw.lucky);
				t.setText("田馥甄 - 小幸运 - 2015如果巡回演唱会.mp3");
				mp.start();
				rl.setBackgroundResource(R.drawable.hebe);
				j++;
				break;
			}
			if(j==2){
				
				mp.stop();
				try {
					Thread.sleep(1001);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp	=MediaPlayer.create(play.this, R.raw.ailee_day_by_day);
				t.setText("Ailee - 一天一天.mp3");
				mp.start();
				rl.setBackgroundResource(R.drawable.ailee1);
				j++;
				break;
			}
			if(j==3){
				
				mp.stop();
				try {
					Thread.sleep(1001);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp	=MediaPlayer.create(play.this, R.raw.tara_just_now);
				t.setText("T-ara - Just Now.mp3");
				mp.start();
				rl.setBackgroundResource(R.drawable.tara2);
				j=0;
				break;
			}
		case R.id.stop:
			mp.stop();
			c.setChecked(false);
			rl.setBackgroundResource(R.drawable.bg0_fine_day);
			break;
		}
	}
}
