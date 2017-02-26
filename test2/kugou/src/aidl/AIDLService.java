package aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AIDLService extends Service {

	IMathAidlInterface.Stub stub = new IMathAidlInterface.Stub() {

		@Override
		public void login(User user) throws RemoteException {
			Log.e("TAG", user == null ? "¿Õ" : "·Ç¿Õ");
			if (user != null) {
				Log.e("TAG", user.toString());
			}
			user = new User();
			user.setAge(100);
			// if (user != null && user.getUsername().equals("zhangsan")
			// && user.getPassword().equals("123456")) {
			// user.setAge(32);
			// user.setMoney(100000);
			// user.setAnim(true);
			// } else
			// user = null;
		}

		@Override
		public int add(int i, int j) throws RemoteException {
			return 0;
		}
	};

	@Override
	public IBinder onBind(Intent intent) {
		return stub;
	}

}
