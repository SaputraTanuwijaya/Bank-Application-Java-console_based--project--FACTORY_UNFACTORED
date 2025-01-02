package mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.User;
import proxy.Proxy;
import singleton.Database;

//buat mediator
public class Bank implements Proxy{

	private String name;
	private String address;
	
	public Bank(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void checkBalance(User user) {
		// TODO Auto-generated method stub
		System.out.println("Your name is           : " + user.getName());
        System.out.println("Account no             : " + user.getAccountNumber());  
        System.out.println("Account type           : " + user.getAccountType());  
	    System.out.println("Balance                : " + user.getBalance());  
		System.out.println("THANKS FOR BALANCE CHECKING ");
	}

	@Override
	public void deposit(User user, long balance) {
		user.setBalance(user.getBalance() + balance);
		System.out.println(balance +" is deposited into your Account");
		System.out.println("Current Available Balance is "+ user.getBalance());
	}

	@Override
	public void withdraw(User user, long balance) {
		
		if(balance < user.getBalance())
		{
			user.setBalance(user.getBalance() - balance);
			System.out.println(balance +" is withdrawn from your Account");
			System.out.println("Current Available Balance is "+ user.getBalance());
		}
		else{
			System.out.println("The current balance is insufficient for further transactions");
			System.out.println("Current Available Balance is "+ user.getBalance());
		}
		
	}

	@Override
	public void transfer(User user, long balance, User receiver) {
		if(balance <= user.getBalance())
		{
			user.setBalance(user.getBalance() - balance);
			receiver.setBalance(receiver.getBalance() + balance);
			System.out.println(balance +" is transfer from " + user.getAccountNumber() + " Account to " + receiver.getAccountNumber());
			System.out.println("Current Available Balance in" + user.getAccountNumber() + " is "+ user.getBalance());
		}
		else{
			System.out.println("The current " + user.getAccountNumber() + " balance is insufficient for further transactions");
			System.out.println("Current Available Balance is "+ user.getBalance());
		}
	}

}
