package com.example.lesson7_listview_simpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

	ListView lv;

	// 数据源
	// String[] data = { "zhangsan", "lisi", "wangwu", "zhaoliu", "tianqi",
	// "wangba", "xiaojiujiu", "李四", "李五", "李六", "zhangsan", "lisi",
	// "wangwu", "zhaoliu", "tianqi", "wangba", "xiaojiujiu", "李四", "李五",
	// "李六", "zhangsan", "lisi", "wangwu", "zhaoliu", "tianqi", "wangba",
	// "xiaojiujiu", "李四", "李五", "李六", "zhangsan", "lisi", "wangwu",
	// "zhaoliu", "tianqi", "wangba", "xiaojiujiu", "李四", "李五", "李六", };

	String[] names = { "范冰冰", "李晨", "王宝强" };
	String[] contents = {
			"简介：范冰冰，1981年9月16日生于山东青岛，华语影视女演员、歌手、制片人。1996年参演电视剧《女强人》。1998年主演电视剧《还珠格格》系列成名，2001年起投身大银幕。",
			"简介：李晨，1978年11月24日出生于北京市，中国内地影视男演员、监制、赛车手，毕业于北京群星艺术学院。",
			"王宝强，1984年5月29日出生于河北省邢台市，中国内地男演员、导演。王宝强6岁开始练习武术，8岁在嵩山少林寺做俗家弟子。2003年，凭借剧情片《盲井》获得第40届台湾电影金马奖最佳新演员奖[1-2]  。2004年，因参演冯小刚执导的剧情片《天下无贼》而获得关注。" };
	int[] ids = { R.drawable.fbb, R.drawable.lichen, R.drawable.wangbaoqiang };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// GridView spinner = new GridView(this);
		// spinner.setNumColumns(2);
		// setContentView(spinner);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.lv);
		// 创建适配器
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, data);
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		// 添加数据
		// list是指你有多少个条目.
		for (int i = 0; i < 3; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("img", ids[i]); // R.id.img
			map.put("name", names[i]);// R.id.name
			map.put("content", contents[i]);// R.id.content
			data.add(map);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, data,
				R.layout.item_lv_star,
				new String[] { "img", "name", "content" }, new int[] {
						R.id.img, R.id.name, R.id.content });
		// spinner.setAdapter(adapter);
		lv.setAdapter(adapter);
	}
}
