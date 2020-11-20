package infra;

import java.io.IOException;
import java.util.TreeSet;

import business.model.User;
import util.InfraException;

public class UserPersistence implements IPersistence  {
  public TreeSet<User> loadUsers() throws InfraException {
    TreeSet<User> usersFile = new TreeSet<User>();
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

  public void saveUsers(TreeSet<User> users) throws InfraException {
    TreeSet<User> usersFile = new TreeSet<User>();

    try {
      usersFile = loadUsers();
    } catch (InfraException e) {
      // e.printStackTrace();
    }

    usersFile.addAll(users);

    try {
		  HandlePersistence.writeBinaryFile(usersFile, "database.bin");
  	} catch (IOException e) {
      // System.out.printf("Não foi possível salvar os usuários.");
      throw new InfraException("Não foi possível salvar os usuários.");
		  // e.printStackTrace();
	  }
  }
}
