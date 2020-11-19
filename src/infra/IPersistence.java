package infra;

import java.util.TreeMap;

import business.model.User;
import util.InfraException;

public interface IPersistence {
  public TreeMap<String, User> loadUsers() throws InfraException;
  public void saveUsers(TreeMap<String, User> users) throws InfraException;
}
