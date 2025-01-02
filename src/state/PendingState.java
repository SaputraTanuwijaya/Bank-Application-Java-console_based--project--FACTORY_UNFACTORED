package state;

import model.User;

public class PendingState extends State{

	public PendingState(User user) {
		super(user);
		changeState();
	}

	@Override
	public void changeState() {
		System.out.print("Wait, the transaction is in process");
		
		for (int i = 0; i< 3; i++) {
			try {
				Thread.sleep(1000);
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		user.setState(new CompletedState(user));
	}

}
