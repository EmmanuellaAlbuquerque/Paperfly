package infra;

import business.model.User;

public class UserPersistenceFactory implements PersistenceFactory<User> {

	@Override
	public IPersistence<User> createPersistence() {
    return new UserPersistence();
	}
}
