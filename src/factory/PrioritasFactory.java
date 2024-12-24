package factory;

import model.Prioritas;
import model.User;

public class PrioritasFactory extends UserFactory {

	@Override
	public User createClient(String accNum, String name, String accType, long balance) {
		Prioritas prioritas = new Prioritas(accNum, name, accType, balance);
		return prioritas;
	}

}
