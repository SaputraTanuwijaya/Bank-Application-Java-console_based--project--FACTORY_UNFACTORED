package state;

import model.User;

public abstract class State {

	protected User user;
	
	public State(User user) {
		this.user = user;
	}
	
	public abstract void changeState();

}
