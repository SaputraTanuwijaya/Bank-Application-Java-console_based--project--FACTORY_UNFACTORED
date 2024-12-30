package factory;

import model.Prioritas;
import model.User;
import proxy.Proxy;

public class PrioritasFactory extends UserFactory {

	@Override
	public User createClient(String accNum, String name, String accType, long balance, Proxy bank) {
		Prioritas prioritas = new Prioritas(accNum, name, accType, balance, bank);
		return prioritas;
	}

}
