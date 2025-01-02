package factory;

import model.Reguler;
import model.User;
import proxy.Proxy;

public class RegulerFactory extends UserFactory{


	@Override
	public User createClient(String accNum, String name, long balance, Proxy bank) {
		Reguler reguler = new Reguler(accNum, name, balance, bank);
		return reguler;
	}

}
