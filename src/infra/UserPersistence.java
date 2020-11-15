package infra;

import java.io.IOException;
import java.util.HashMap;

import business.model.User;

public class UserPersistence {
  public HashMap<String, User> loadUsers() {
    HashMap<String, User> usersFile = new HashMap<String, User>();
    try {
		  usersFile = HandlePersistence.readBinaryFile("teste.bin");
	} catch (IOException e) {
		System.out.printf("Não foi possível carregar os usuários.");
		e.printStackTrace();
	}
    return usersFile;
  }

  public void saveUsers(HashMap<String, User> users) {
    HashMap<String, User> usersFile = loadUsers();
    usersFile.putAll(users);

    try {
		HandlePersistence.writeBinaryFile(usersFile, "teste.bin");
	} catch (IOException e) {
		System.out.printf("Não foi possível salvar os usuários.");
		e.printStackTrace();
	}
  }
}
