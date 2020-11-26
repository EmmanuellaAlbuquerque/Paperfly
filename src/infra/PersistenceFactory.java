package infra;

public abstract class PersistenceFactory {
    public static UserPersistence createPersistence(){
        return new UserPersistence();
    }

    public PersistenceFactory() {
    }
}

