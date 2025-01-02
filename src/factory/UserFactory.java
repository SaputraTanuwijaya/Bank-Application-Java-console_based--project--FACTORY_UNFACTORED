package factory;

import model.User;
import proxy.Proxy;

public abstract class UserFactory {

	public User newMember(String accNum, String name,long balance, Proxy bank) {
		User user = createClient(accNum, name, balance, bank);
		
		System.out.println("Welcome " + user.getName() + "! Thank you for trusting us as your financial partner.");
		
		return user;
	}
	
	public abstract User createClient(String accNum, String name,long balance, Proxy bank);

}
