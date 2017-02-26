package aaa;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
	String c;
	String username;
	String password;
	int age;
	boolean isAdmin;
	double money;

	@Override
	public int describeContents() {
		// 没有用
		return 0;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", age=" + age + ", isAdmin=" + isAdmin + ", money=" + money
				+ "]";
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// 序列化写入
		// 写和读必须一致
		dest.writeString(username);
		dest.writeString(password);
		dest.writeInt(age);
		dest.writeInt(isAdmin ? 1 : 0);
		dest.writeDouble(money);
	}

	// 创建一个静态的
	public static Creator<User> CREATOR = new Creator<User>() {

		@Override
		public User createFromParcel(Parcel source) {
			// 读 顺序一致
			User user = new User();
			user.username = source.readString();
			user.password = source.readString();
			user.age = source.readInt();
			user.isAdmin = source.readInt() == 1 ? true : false;
			user.money = source.readDouble();
			return user;
		}

		@Override
		public User[] newArray(int size) {
			return new User[size];
		}
	};

}
