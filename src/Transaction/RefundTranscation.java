package Transaction;

import users.User;

public class RefundTranscation implements ITransaction{
	private User user;
	public RefundTranscation(User user) {
		this.user = user;
	}
	
	@Override
	public boolean submit() {
		return false;
	}
	
	@Override
	public User getUser() {
		return user;
	}
}