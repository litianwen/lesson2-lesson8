package com.example.lesson5_style;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// // 所有对于窗体的设置都必须在setContentView之前
		// // getActionBar().hide();
		// // getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		// // setTheme(R.style.AppTheme);
		// String str = "";
		// // if (str.matches("[0-9]{1,}")) {
		// //
		// // }
		//
		
		//加载xml
		setContentView(R.layout.activity_main);
		loadXml();
	}

	private void loadXml() {
		//需要打开文件
		try {
			InputStream is=getAssets().open("car.xml");
			XmlPullParser pull =Xml.newPullParser();
			pull.setInput(is, "UTF-8");
			//开始解析
			//产生事件用来循环
			int type = pull.getEventType();
			List<Car> mList = new ArrayList<Car>();
			Car car=null;
			while(type!=XmlPullParser.END_DOCUMENT)
			{
				switch (type) {
				case XmlPullParser.START_TAG:
					if(pull.getName().equals("Car"))
					{
						car  = new Car();
						car.id = Integer.parseInt(pull.getAttributeValue(0));
					}else if(pull.getName().equals("pingpai"))
					{
						//获取后面的文本
						car.pingpai= pull.nextText();
					}else if(pull.getName().equals("color"))
					{
						car.color=pull.nextText();
					}
					break;
				case XmlPullParser.END_TAG:
					if(pull.getName().equals("Car"))
					{
						mList.add(car);
					}
					break;
				}
				pull.next();
				type = pull.getEventType();
			}
			Log.e("TAG", mList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	class Car
	{
		
		
		@Override
		public String toString() {
			return "Car [pingpai=" + pingpai + ", color=" + color + ", id="
					+ id + "]";
		}
		String pingpai;
		String color;
		int id;
	}

}
