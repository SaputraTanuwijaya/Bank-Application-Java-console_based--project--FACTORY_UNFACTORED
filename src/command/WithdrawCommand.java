package command;

import model.User;

public class WithdrawCommand extends BankCommand {
	private long withdraw;
	
	public WithdrawCommand(User user, long withdraw) {
		super(user);
		this.withdraw = withdraw;
	}

	@Override
	public void execute() {
		user.deposit(withdraw);
	}

}
