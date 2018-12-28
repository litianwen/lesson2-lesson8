package com.example.lesson3_work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SelectorImageActivity extends Activity {
	/**
	 * 反射 用一个字符串去创建一个类 用一个字符串去获取一个静态变量 。。。
	 *
	 */

	static ImageView[] ivs = new ImageView[9];
	static int[] ids = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6,
			R.id.iv7, R.id.iv8, R.id.iv9 };
	static int[] imgId = { R.drawable.img01, R.drawable.img02, R.drawable.img03,
			R.drawable.img04, R.drawable.img05, R.drawable.img06,
			R.drawable.img07, R.drawable.img08, R.drawable.img09 };

	public static final int RESULT_OK = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seletorimg);
		/*try {
			setContentView(R.layout.class.getField("activity_seletorimg")
					.getInt(null));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 图片文件夹下 200张
		for (int i = 0; i < ivs.length; i++) {
			String name = "iv" + (i + 1);
			// 获取他的类
			Class cls = R.id.class;// ;.getField(name)
			// 获取他的静态变量 getXXX获取这个属性所对应的值
			// null 代表的是静态变量,非静态需要传递对象
			try {
				int id = cls.getField(name).getInt(null);
				ivs[i] = (ImageView) findViewById(id);
				final int finali = i + 1;
				Log.e("TAG", id + "------");
				ivs[i].setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent data = getIntent();
						// // 内部类引用外部局部变量，需要final
						int imgid;
						try {
							imgid = R.drawable.class.getField("img0" + finali).getInt(null);
							data.putExtra("id", imgid);
							setResult(RESULT_OK, data);
							finish();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/

		 for (int i = 0; i < ivs.length; i++) {
			 final int imgid = i;
			 ivs[i] = (ImageView) findViewById(ids[i]);
			 ivs[i].setOnClickListener(new OnClickListener() {
		
				 @Override
				 public void onClick(View v) {
					 Intent data = new Intent();
					 // 内部类引用外部局部变量，需要final
					 data.putExtra("id", imgId[imgid]);
					 setResult(RESULT_OK, data);
					 finish();
				 }
			 });
		 }
	}
}
