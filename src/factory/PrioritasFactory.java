package factory;

import model.Prioritas;
import model.User;
import proxy.Proxy;

public class PrioritasFactory extends UserFactory {

	@Override
	public User createClient(String accNum, String name, long balance, Proxy bank) {
		Prioritas prioritas = new Prioritas(accNum, name, balance, bank);
		return prioritas;
	}

}
