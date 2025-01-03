package command;

import model.User;

public class CheckBalanceCommand extends BankCommand {

	public CheckBalanceCommand(User user) {
		super(user);
	}

	@Override
	public void execute() {
		user.checkBalance();
	}

}
