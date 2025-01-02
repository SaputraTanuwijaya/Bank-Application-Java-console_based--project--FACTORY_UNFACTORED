package model;

import proxy.Proxy;

public class Prioritas extends User{

	public Prioritas(String accountNumber, String name, long balance, Proxy bank) {
		super(accountNumber, name, "Prioritas", balance, bank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void depositToBank(long balance) {
		if(balance > 50000) {			
			bank.deposit(this, (long)(balance * 1.05));
		} else {
			bank.deposit(this, balance);
		}
	}

}
