package command;

import model.User;
import proxy.BankProxy;

public abstract class BankCommand {
	protected User user;
	
	public BankCommand(User user) {
		this.user = user;
	}
	
	public abstract void execute();
}
