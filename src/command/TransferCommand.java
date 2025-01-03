package command;

import model.User;

public class TransferCommand extends BankCommand {
	private long balance;
	private User receiver;
	
	public TransferCommand(User user, long balance, User receiver) {
		super(user);
		this.balance = balance;
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		user.transfer(balance, receiver);
	}
	
}
