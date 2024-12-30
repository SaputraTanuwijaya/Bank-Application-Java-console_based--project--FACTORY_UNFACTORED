package iterator;

import java.util.ArrayList;

import model.User;

public class UserIterator<T> implements Iterator<T>{

	private ArrayList<T> userList;
	private int currIdx;
	
	public UserIterator(ArrayList<T> userList) {
		super();
		this.userList = userList;
		currIdx = 0;
	}

	@Override
	public T getNext() {
		if(hasNext())
			return userList.get(currIdx++);
		return null;
	}

	@Override
	public boolean hasNext() {
		return currIdx < userList.size();
	}
}
