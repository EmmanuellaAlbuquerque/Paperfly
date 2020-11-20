package infra;

import java.util.TreeSet;

import business.model.User;
import util.InfraException;

public interface IPersistence {
  public TreeSet<User> loadUsers() throws InfraException;
  public void saveUsers(TreeSet<User> users) throws InfraException;
}
