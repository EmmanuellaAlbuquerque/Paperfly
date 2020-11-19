package business.control;

import java.util.TreeMap;

import business.model.Date;
import business.model.User;
import util.DateFormatException;
import util.HandleUserValidation;
import util.UserLoginException;
import util.UserPasswordException;

public class UserController implements IController {
  private TreeMap<String, User> users = new TreeMap<String, User>();

  public UserController() {}

  public UserController(TreeMap<String, User> users) {
    this.users = users;
  }

  public void add(String[] param) {
    String login = param[0];
    String password = param[1];
    Date birthDate = new Date(Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4]));
    Boolean canRegister = true;

    try {

      if(users.containsKey(login)){
        throw new UserLoginException("- login already registered.");
      }

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

  try {
    HandleUserValidation.verifyDate(birthDate);
  } catch (DateFormatException e) {
    System.out.println(e.getMessage());
    canRegister = false;
  }

  // verify parameters methods
  if (canRegister) {
    User user = new User(login, password, birthDate);
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
      System.out.println(value.toString());
    });
  }

  public void list(String login) {}

  public void del(String login) {
    users.remove(login);
  }

  /**
   * @return TreeMap<String, User> return the users
   */
  public TreeMap<String, User> getUsers() {
      return users;
  }

  /**
   * @param users the users to set
   */
  public void setUsers(TreeMap<String, User> users) {
      this.users = users;
  }
}
