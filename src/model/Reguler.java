package model;

import proxy.Proxy;

public class Reguler extends User{

	public Reguler(String accountNumber, String name, String password, Proxy bank) {
		super(accountNumber, name, password, "Reguler", bank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void depositToBank(long balance) {
		if(balance > 50000) {			
			bank.deposit(this, (long)(balance * 1.01));
		} else {
			bank.deposit(this, balance);
		}
	}
}
