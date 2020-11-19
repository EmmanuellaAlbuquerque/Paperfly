package infra;

import java.io.IOException;
import java.util.TreeMap;

import business.model.User;
import util.InfraException;

public class UserPersistence implements IPersistence  {
  public TreeMap<String, User> loadUsers() throws InfraException {
    TreeMap<String, User> usersFile = new TreeMap<String, User>();
    try {
      usersFile = HandlePersistence.readBinaryFile("database.bin");

	  } catch (IOException e) {
    // System.out.printf("Não foi possível carregar os usuários.");
      throw new InfraException("Não foi possível carregar os usuários.");
    // e.printStackTrace();
      // throw e;
	  }
    return usersFile;
  }

  public void saveUsers(TreeMap<String, User> users) throws InfraException {
    TreeMap<String, User> usersFile = new TreeMap<String, User>();

    try {
      usersFile = loadUsers();
    } catch (InfraException e) {
      // e.printStackTrace();
    }

    usersFile.putAll(users);

    try {
		  HandlePersistence.writeBinaryFile(usersFile, "database.bin");
  	} catch (IOException e) {
      // System.out.printf("Não foi possível salvar os usuários.");
      throw new InfraException("Não foi possível salvar os usuários.");
		  // e.printStackTrace();
	  }
  }
}
