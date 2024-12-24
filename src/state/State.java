package state;

import model.User;

public abstract class State {

	private User user;
	
	public State(User user) {
		this.user = user;
	}
	
	public abstract void changeState();

}
