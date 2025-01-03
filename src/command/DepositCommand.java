package command;

import model.User;

public class DepositCommand extends BankCommand {
	private long deposit;
	
	public DepositCommand(User user, long deposit) {
		super(user);
		this.deposit = deposit;
	}

	@Override
	public void execute() {
		user.deposit(deposit);
	}

}
