package infra;

import java.util.TreeMap;

import business.model.User;

public interface IPersistence {
  public TreeMap<String, User> loadUsers();
  public void saveUsers(TreeMap<String, User> users);
}
