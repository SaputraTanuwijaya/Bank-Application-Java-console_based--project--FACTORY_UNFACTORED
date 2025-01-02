package model;

import proxy.BankProxy;
import proxy.Proxy;
import state.IdleState;
import state.State;

//bingung pake abstract apa engga
public abstract class User {

	private String accountNumber;
	private String name;
	private String password;
	private String accountType;
	private long balance; 
	private State state;
	protected Proxy bank;
	
	public User(String accountNumber, String name, String password, String accountType, Proxy bank) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.accountType = accountType;
		this.balance = 0;
		
		this.state = new IdleState(this);
		this.bank = bank;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void changeState() {
		state.changeState();
	}
	
	public void depositToBank(long balance) {
		bank.deposit(this, balance);
	}
	
	// deposit = template method
	public void deposit(long balance) {
		changeState();
		depositToBank(balance);
	}
	
	public void checkBalance() {
		bank.checkBalance(this);
	}
	
	public void withdraw(long balance) {
		bank.withdraw(this, balance);
	}
	
	public void transfer(long balance, User receiver) {
		bank.transfer(this, balance, receiver);
	}
	
	public boolean checkCredentials(String pass) {
		return ((BankProxy) bank).checkCredentials(this, pass);
	}
}
