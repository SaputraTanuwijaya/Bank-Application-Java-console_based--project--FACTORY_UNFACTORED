package factory;

import model.User;
import proxy.Proxy;

public abstract class UserFactory {

	private User newMember(String accNum, String name, String accType, long balance, Proxy bank) {
		User user = createClient(accNum, name, accType, balance, bank);
		
		System.out.println("Welcome " + name + "! Thank you for trusting us as your financial partner.");
		
		return user;
	}
	
	public abstract User createClient(String accNum, String name, String accType, long balance, Proxy bank);

}
