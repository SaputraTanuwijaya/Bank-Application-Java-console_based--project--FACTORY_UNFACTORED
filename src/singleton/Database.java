package singleton;

import java.util.ArrayList;
import java.util.Random;

import model.User;

public class Database {
	private static volatile ArrayList<User> instance = null;

	public static ArrayList<User> getInstance() {
		if (instance==null) {
			synchronized (Database.class) {
				if (instance == null) {
					instance = new ArrayList<User>();
				}
			}
		}
		
		return instance;
	}
}
