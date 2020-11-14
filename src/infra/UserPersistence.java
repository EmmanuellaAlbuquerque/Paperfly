package infra;

import java.util.HashMap;

import business.model.User;

public class UserPersistence {
  public HashMap<String, User> loadUsers() {
    HashMap<String, User> usersFile = new HashMap<String, User>();
    usersFile = HandlePersistence.readBinaryFile("teste.bin");
    return usersFile;
  }

  public void saveUsers(HashMap<String, User> users) {
    HashMap<String, User> usersFile = loadUsers();
    usersFile.putAll(users);

    HandlePersistence.writeBinaryFile(usersFile, "teste.bin");
  }
}
