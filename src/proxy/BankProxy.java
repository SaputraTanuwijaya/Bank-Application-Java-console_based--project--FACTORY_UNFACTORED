package proxy;

import mediator.Bank;
import model.User;

public class BankProxy implements Proxy{
	
	private Bank bank;
	private boolean isValid;
	
	public BankProxy(Bank bank) {
		this.bank = bank;
		this.isValid = true;
	}

	@Override
	public void checkBalance(User user) {
		if(isValid)
			bank.checkBalance(user);
	}

	@Override
	public void deposit(User user, long balance) {
		if(isValid)
			bank.deposit(user, balance);
	}

	@Override
	public void withdraw(User user, long balance) {
		if(isValid) {
			user.getState().changeState();
			bank.withdraw(user, balance);
		}
	}

	@Override
	public void transfer(User user, long balance, User receiver) {
		if(isValid) {
			user.getState().changeState();
			receiver.getState().changeState();
			bank.transfer(user, balance, receiver);
		}
		
	}

	public boolean checkCredentials(User user, String pass) {
		if(user.getPassword().equals(pass)) {
			this.isValid = true;
			return true;
		}
		else {
			System.out.println("Invalid password");
			this.isValid = false;
			return false;
		}
	}

}
