package infra;

import java.io.IOException;
import java.util.TreeMap;

import business.model.User;

public class UserPersistence implements IPersistence {
  public TreeMap<String, User> loadUsers() {
    TreeMap<String, User> usersFile = new TreeMap<String, User>();
    try {
		  usersFile = HandlePersistence.readBinaryFile("teste.bin");
	} catch (IOException e) {
		System.out.printf("Não foi possível carregar os usuários.");
		e.printStackTrace();
	}
    return usersFile;
  }

  public void saveUsers(TreeMap<String, User> users) {
    TreeMap<String, User> usersFile = loadUsers();
    usersFile.putAll(users);

    try {
		HandlePersistence.writeBinaryFile(usersFile, "teste.bin");
	} catch (IOException e) {
		System.out.printf("Não foi possível salvar os usuários.");
		e.printStackTrace();
	}
  }
}
