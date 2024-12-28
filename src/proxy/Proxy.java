package proxy;

import model.User;

public interface Proxy {
	void checkBalance(User user);
	void deposit(User user, long balance);
	void withdraw(User user, long balance);
	void transfer(User user, long balance, User receiver);
}
