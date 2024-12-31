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
		bank.deposit(user, balance);
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
