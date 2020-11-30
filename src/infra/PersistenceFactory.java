package infra;

public interface PersistenceFactory<E> {
    IPersistence<E> createPersistence();
}
