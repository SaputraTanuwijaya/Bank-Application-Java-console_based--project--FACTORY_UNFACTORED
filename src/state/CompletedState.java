package state;

import model.User;

public class CompletedState extends State {

	public CompletedState(User user) {
		super(user);
		System.out.println("The Process is finished");
		changeState();
	}

	@Override
	public void changeState() {
		user.setState(new IdleState(user));
	}

}
