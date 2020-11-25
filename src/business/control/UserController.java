package business.control;

import java.util.TreeSet;

import business.model.Date;
import business.model.User;
import business.templates.HTMLReport;
import business.templates.TXTReport;
import util.DateFormatException;
import util.HandleUserValidation;
import util.UserLoginException;
import util.UserPasswordException;

import infra.UserPersistence;
import util.ComparatorDate;
import util.InfraException;

public class UserController implements IController {
  private TreeSet<User> users = new TreeSet<User>();

  public UserController() {
    loadFromDatabase();
  }

  public UserController(TreeSet<User> users) {
    this.users = users;
  }

  /**
 * @return TreeSet<User> return the users
 */
  public TreeSet<User> getUsers() {
    return users;
  }

  /**
   * @param users the users to set
   */
  public void setUsers(TreeSet<User> users) {
      this.users = users;
  }

  public void add(String[] param) {
    String login = param[0];
    String password = param[1];
    Date birthDate = new Date();
    Boolean canRegister = true;

    try {

      if(containsLogin(login)){
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
      users.add(user);
      System.out.println("User created.");
      
      TXTReport txtReport = new TXTReport();
      HTMLReport htmlReport = new HTMLReport();

      txtReport.generateReport(user);
      htmlReport.generateReport(user);

    } else {
      System.out.println("User not created.");
    }
  
    this.saveInDatabase();
  }

  public void listAll() {
    users.forEach((value) -> {
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

    users.forEach((value) -> {
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

  private Boolean containsLogin(String login){
    Boolean contains = false;

    for(User user : users) {
      if(user.getLogin().equals(login)){
        contains = true;
      }
    }

    return contains;
  }

  public void list(String login) {}

  public void del(String login) {
    // users.remove(login);
  }
}
