package Transaction;

import users.User;

public interface ITransaction {
	public User getUser();
	public boolean submit();
}