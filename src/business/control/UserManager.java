package business.control;
import java.util.TreeMap;

import business.model.User;
import util.HandleUserValidation;
import util.UserLoginException;
import util.UserPasswordException;

public class UserManager implements IManager {
  private TreeMap<String, User> users = new TreeMap<String, User>();

  public UserManager(TreeMap<String, User> users) {
    this.users = users;
  }

  public void add(String[] param) {
    String login = param[0];
    String password = param[1];
    Boolean canRegister = true;

    try {
      HandleUserValidation.verifyLogin(login);

	} catch (UserLoginException e) {
    System.out.println(e.getMessage());
    canRegister = false;
		// e.printStackTrace();
  }
  
  try {
    HandleUserValidation.verifyPassword(password);
  } catch (UserPasswordException e) {
    System.out.println(e.getMessage());
    canRegister = false;
  }

  // verify parameters methods
  if (canRegister) {
    User user = new User(login, password);
    users.put(login, user);
    System.out.println("User created.");
  }
  else {
    System.out.println("User not created.");
  }

  }

  // listAllAlphabetical: LISTAR OS USUÁRIOS POR LOGIN EM ORDEM ALFABÉTICA CRESCENTE
  public void listAll() {
    users.forEach((key, value) -> {
      System.out.println("Login: " + key + " | User: " + value);
  });
  }

  public void list(String login) {}

  public void del(String login) {
    users.remove(login);
  }

}
