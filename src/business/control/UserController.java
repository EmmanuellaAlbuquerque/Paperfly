package business.control;

import java.util.TreeMap;
import java.util.TreeSet;

import business.model.Date;
import business.model.User;
import util.DateFormatException;
import util.HandleUserValidation;
import util.UserLoginException;
import util.UserPasswordException;

import infra.UserPersistence;
import util.ComparatorDate;
import util.InfraException;

public class UserController implements IController {
  private TreeMap<String, User> users = new TreeMap<String, User>();

  public UserController() {
    loadFromDatabase();
  }

  public UserController(TreeMap<String, User> users) {
    this.users = users;
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

  public void add(String[] param) {
    String login = param[0];
    String password = param[1];
    Date birthDate = new Date();
    Boolean canRegister = true;

    try {

      if(users.containsKey(login)){
        throw new UserLoginException("- login already registered.");
      }

      birthDate = new Date(Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4]));

      HandleUserValidation.verifyLogin(login);
      HandleUserValidation.verifyPassword(password);
      HandleUserValidation.verifyDate(birthDate);

  	} catch (UserLoginException | UserPasswordException | DateFormatException | NumberFormatException e) {
    canRegister = false;
    System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
    }

    if (canRegister) {
      User user = new User(login, password, birthDate);
      users.put(login, user);
      System.out.println("User created.");
    } else {
      System.out.println("User not created.");
    }
  
    this.saveInDatabase();
  }

  public void listAll() {
    users.forEach((key, value) -> {
      System.out.println(value.toString());
    });
  }

  // LISTAR OS USUÁRIOS POR LOGIN EM ORDEM ALFABÉTICA CRESCENTE
  public void listAllAlphabetical() {
    listAll();
  }

  // EXIBIR USUÁRIOS ORDENADOS POR DATA DE NASCIMENTO DESCRESCENTE.
  public void listAllByBirthDate() {
    TreeSet<User> usersSet = new TreeSet<User>(new ComparatorDate());

    users.forEach((key, value) -> {
      usersSet.add(value);
    });

    usersSet.forEach((value) -> {
      System.out.println(value.toString());
    });
  }

  private void loadFromDatabase() {
    UserPersistence userPersistence = new UserPersistence();

    try {
      users = userPersistence.loadUsers();
    } catch (InfraException e) {
      System.out.print(e.getMessage());
      // e.printStackTrace();
    }
  }

  private void saveInDatabase() {
    UserPersistence userPersistence = new UserPersistence();

    try {
      userPersistence.saveUsers(getUsers());
    } catch (InfraException e) {
      System.out.print(e.getMessage());
      // e1.printStackTrace();
    }

  }

  public void list(String login) {}

  public void del(String login) {
    users.remove(login);
  }
}
