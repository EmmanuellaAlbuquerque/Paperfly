package business.control;
import java.util.HashMap;
import java.util.Map;

import business.model.User;
import util.HandleUserValidation;
import util.UserLoginException;
import util.UserPasswordException;

public class UserManager implements IManager {
  private Map<String, User> users = new HashMap<String, User>();

  public UserManager(HashMap<String, User> users) {
    this.users = users;
  }

  public void add(String[] param) {
    String login = param[0];
    String password = param[1];
    Boolean canRegister = false;

    try {
      HandleUserValidation.verifyLogin(login);
    canRegister = true;

	} catch (UserLoginException e) {
    System.out.println(e.getMessage());
		// e.printStackTrace();
  }
  
  try {
    HandleUserValidation.verifyPassword(password);
    canRegister = true;
  } catch (UserPasswordException e) {
    System.out.println(e.getMessage());
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
