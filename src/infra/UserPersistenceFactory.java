package infra;

public class UserPersistenceFactory implements PersistenceFactory {

	@Override
	public IPersistence createPersistence() {
    return new UserPersistence();
	}
}
