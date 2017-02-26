package aaa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button btn = new Button(this);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AActivity.this, BActivity.class);
				User user = new User();
				user.age = 15;
				user.isAdmin = true;
				user.money = 10000000;
				user.password = "123456";
				user.username = "zhangsan";
				intent.putExtra("user", user);
				startActivity(intent);
			}
		});
		setContentView(btn);
	}
}
