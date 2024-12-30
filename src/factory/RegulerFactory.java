package factory;

import model.Reguler;
import model.User;
import proxy.Proxy;

public class RegulerFactory extends UserFactory{


	@Override
	public User createClient(String accNum, String name, String accType, long balance, Proxy bank) {
		Reguler reguler = new Reguler(accNum, name, accType, balance, bank);
		return reguler;
	}

}
