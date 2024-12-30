package iterator;

import java.util.ArrayList;

import model.User;

public class UserIterator implements Iterator<User>{

	private ArrayList<User> userList;
	private int currIdx;
	
	public UserIterator(ArrayList<User> userList) {
		super();
		this.userList = userList;
		currIdx = 0;
	}

	@Override
	public User getNext() {
		if(hasNext())
			return userList.get(currIdx++);
		return null;
	}

	@Override
	public boolean hasNext() {
		return currIdx < userList.size();
	}
}
