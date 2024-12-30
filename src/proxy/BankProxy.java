package proxy;

import mediator.Bank;
import model.User;

public class BankProxy implements Proxy{
	
	private Bank bank;
	
	public BankProxy(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void checkBalance(User user) {
		bank.checkBalance(user);
	}

	@Override
	public void deposit(User user, long balance) {
		if(user.getAccountType().equalsIgnoreCase("Prioritas") && balance > 50000) {
			user.getState().changeState();
			bank.deposit(user, ((long)(balance * 1.05)));
		}
		else if(user.getAccountType().equalsIgnoreCase("Reguler") && balance > 50000) {
			user.getState().changeState();			
			bank.deposit(user, ((long)(balance * 1.01)));
		}
		else {
			user.getState().changeState();
			bank.deposit(user, balance);
		}
	}

	@Override
	public void withdraw(User user, long balance) {
		user.getState().changeState();
		bank.withdraw(user, balance);
	}

	@Override
	public void transfer(User user, long balance, User receiver) {
		user.getState().changeState();
		receiver.getState().changeState();
		bank.transfer(user, balance, receiver);
	}

}
