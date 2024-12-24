package factory;

import model.Reguler;
import model.User;

public class RegulerFactory extends UserFactory{


	@Override
	public User createClient(String accNum, String name, String accType, long balance) {
		Reguler reguler = new Reguler(accNum, name, accType, balance);
		return reguler;
	}

}
