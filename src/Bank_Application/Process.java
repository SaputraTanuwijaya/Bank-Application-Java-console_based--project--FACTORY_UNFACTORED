package Bank_Application;

import java.util.ArrayList;
import java.util.Scanner;

import factory.PrioritasFactory;
import factory.RegulerFactory;
import iterator.Iterator;
import iterator.UserIterator;
import mediator.Bank;
import model.User;
import proxy.BankProxy;
import singleton.Database;

public class Process {
	private Scanner scan = new Scanner(System.in);
	private Database database = Database.getInstance();
	private PrioritasFactory prioritasFactory = new PrioritasFactory();
	private RegulerFactory regulerFactory = new RegulerFactory();
	private Bank bank = new Bank("acb", "bumi");
	public User currentUser = null;

	private int count = 0;
	
	public void checkbalance() {
		if(currentUser.checkCredentials(inputPassword()))
			currentUser.checkBalance();
	}
	
	public void deposit() {
		int deposit = 0;
		
		if(currentUser.checkCredentials(inputPassword())) {
			System.out.print("Enter the amount you want to deposit:: ");
			boolean success = false;
			try {
				deposit = scan.nextInt();
				success = true;
			} catch (Exception e) {
				success = false;
			} finally {
				scan.nextLine();
			}
			
			if(success && deposit > 0) {			
				currentUser.deposit(deposit);
			} else {
				System.out.println("Deposit failed");
			}
		}
	}

	public void withdraw() {
		int withdraw = 0;
		
		if(currentUser.checkCredentials(inputPassword())) {
			System.out.print("Enter the amount you want to withdraw:: ");
			boolean success = false;
			try {
				withdraw = scan.nextInt();
				success = true;
			} catch (Exception e) {
				success = false;
			} finally {
				scan.nextLine();
			}
			
			if(success && withdraw > 0) {			
				currentUser.withdraw(withdraw);
			} else {
				System.out.println("Withdraw failed");
			}
		}
	}

	public void transfer() {
		User receiver = null;
		long amount = 0;
		String receiverAccountNumber = "";
		
		if(currentUser.checkCredentials(inputPassword())) {
			System.out.print("Enter the receiver account number:: ");
			receiverAccountNumber = scan.nextLine();
			receiver = findUsersByAccountNumber(receiverAccountNumber);
			
			if(receiver == null) {
				System.out.println("Receiver account not found");
				return;
			}
			
			System.out.print("Enter the amount you want to transfer:: ");
			boolean success = false;
			try {
				amount = scan.nextLong();
				success = true;
			} catch (Exception e) {
				success = false;
			} finally {
				scan.nextLine();
			}
			
			if(success && amount > 0) {
				currentUser.transfer(amount, receiver);
			} else {
				System.out.println("Transfer failed");
			}
		}
		
		
	}

	public void register() {
		System.out.println(
				" ----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" ***Banking System Application***");
		System.out.println(
				" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		String username = "";
		String type = "";
		String pass;

		do {
			System.out.print("Input your username: ");
			username = scan.nextLine();
		} while (username.length() == 0);

		do {
			System.out.print("Input your password: ");
			pass = scan.nextLine();
		} while (pass.length() == 0);
		
		do {
			System.out.print("Input your account type [Prioritas | Reguler]: ");
			type = scan.nextLine();
		} while (!type.equals("Prioritas") && !type.equals("Reguler"));

		String code = "AC" + String.format("%03d", count++);

		if (type.equals("Prioritas")) {
			database.addUser(prioritasFactory.newMember(code, username, pass, new BankProxy(bank)));
		} else {
			database.addUser(regulerFactory.newMember(code, username, pass, new BankProxy(bank)));
		}

		System.out.println();
		System.out.println("Register Successfull!");
	}

	public void login() {
		System.out.println(
				" ----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" ***Banking System Application***");
		System.out.println(
				" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter your username: ");
		String username = scan.nextLine();
		
		System.out.print("Enter your password: ");
		String pass = scan.nextLine();

		User user = null;
		Iterator<User> iterator = database.createIterator();
		while(iterator.hasNext()) {
			User it = iterator.getNext();
			if (it.getName().equals(username) && it.getPassword().equals(pass)) {
				user = it;
				break;
			}
		}
//		for (int i = 0; i < users.size(); i++) {
//			if (users.get(i).getName().equals(username)) {
//				user = users.get(i);
//				break;
//			}
//		}

		System.out.println();

		if (user != null) {
			System.out.println("Login Successfull!");
			System.out.println();
			currentUser = user;
			Operation.bankinfo();
			return;
		}

		System.out.println("Login Failed!");
		scan.nextLine();
		return;
	}
	
	public User findUsersByAccountNumber(String number) {
		Iterator<User> iterator = database.createIterator();
		
		while(iterator.hasNext()) {
			User user = iterator.getNext();
			
			if(user.getAccountNumber().equals(number)) {
				return user;
			}
		}
		return null;
	}

	public String inputPassword() {
		String pass;
		System.out.print("Enter your password:: ");
		pass = scan.nextLine();
		
		return pass;
	}
}
