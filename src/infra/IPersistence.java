package infra;

import java.util.TreeSet;
import util.InfraException;

public interface IPersistence<E> {
  public TreeSet<E> loadUsers(String filename) throws InfraException;
  public void saveUsers(TreeSet<E> users, String filename) throws InfraException;
}
