package business.control;

import java.util.TreeSet;

import infra.IPersistence;
import util.InfraException;

public class DBConnectionController<E> {
  
  public TreeSet<E> loadFromDatabase(TreeSet<E> users, IPersistence<E> iPersistence, String filename) {
    try {
      users = iPersistence.loadUsers(filename);
    } catch (InfraException e) {
      System.out.print(e.getMessage());
      // e.printStackTrace();
    }
    return users;
  }

  public void saveInDatabase(TreeSet<E> users, IPersistence<E> iPersistence, String filename) {
    try {
      iPersistence.saveUsers(users, filename);
    } catch (InfraException e) {
      System.out.print(e.getMessage());
      // e1.printStackTrace();
    }
  }
}
