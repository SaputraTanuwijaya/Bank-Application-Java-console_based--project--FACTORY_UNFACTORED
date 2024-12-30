package singleton;

import java.util.ArrayList;
import java.util.Random;

import model.User;
import iterator.Iterable;
import iterator.Iterator;
import iterator.UserIterator;

public class Database implements Iterable<User> {
	private volatile ArrayList<User> users = new ArrayList<>();
	private static Database instance = null;
	
	private Database() {}

	public static Database getInstance() {
		if (instance==null) {
			synchronized (Database.class) {
				if (instance == null) {
					instance = new Database();
				}
			}
		}
		return instance;
	}
	
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public Iterator<User> createIterator() {
		return new UserIterator(users);
	}
}
