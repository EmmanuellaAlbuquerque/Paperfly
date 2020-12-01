package business.control;

import java.util.TreeSet;

import infra.IPersistence;
import util.InfraException;

public class DBConnectionController<E> {
  private IPersistence<E> iPersistence;

  public DBConnectionController(IPersistence<E> iPersistence) {
    this.iPersistence = iPersistence;
  }
  
  public TreeSet<E> loadFromDatabase(String filename) {
    try {
      return iPersistence.loadUsers(filename);
    } catch (InfraException e) {
      System.out.print(e.getMessage());
      // e.printStackTrace();
    }
    return null;
  }

  public void saveInDatabase(TreeSet<E> users, String filename) {
    try {
      iPersistence.saveUsers(users, filename);
    } catch (InfraException e) {
      System.out.print(e.getMessage());
      // e1.printStackTrace();
    }
  }
}
