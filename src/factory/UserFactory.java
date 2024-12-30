package factory;

import model.User;

public abstract class UserFactory {

	private User newMember(String accNum, String name, String accType, long balance) {
		User user = createClient(accNum, name, accType, balance);
		
		System.out.println("Welcome " + user.getName() + "! Thank you for trusting us as your financial partner.");
		
		return user;
	}
	
	public abstract User createClient(String accNum, String name, String accType, long balance);

}
