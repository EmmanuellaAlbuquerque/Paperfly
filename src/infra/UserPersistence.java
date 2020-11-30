package infra;

import java.util.TreeSet;

import business.model.User;
import util.InfraException;

public class UserPersistence implements IPersistence<User> {
  HandlePersistence<User> handleUserPersistence = new HandlePersistence<User>();

  @Override
  public TreeSet<User> loadUsers(String filename) throws InfraException {
    return handleUserPersistence.load(filename);
  }

  @Override
  public void saveUsers(TreeSet<User> users, String filename) throws InfraException {
    handleUserPersistence.save(users, filename);
  }
}
