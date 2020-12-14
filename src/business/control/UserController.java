package business.control;

import java.util.TreeSet;

import business.model.Date;
import business.model.User;
import business.model.Vacation;
import business.templates.HTMLReport;
import business.templates.TXTReport;
import util.DateFormatException;
import util.HandleUserValidation;
import util.UserLoginException;
import util.UserPasswordException;
import infra.IPersistence;
import infra.PersistenceFactory;
import infra.UserPersistenceFactory;
import util.ComparatorDate;

public class UserController {
  private TreeSet<User> users = new TreeSet<User>();
  private PersistenceFactory<User> persistenceFactory = new UserPersistenceFactory();
  private IPersistence<User> iPersistence = persistenceFactory.createPersistence();
  private DBConnectionController<User> dbConnection = new DBConnectionController<User>(iPersistence);

  public UserController() {
    setUsers(dbConnection.loadFromDatabase("database-users.bin"));
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
    Vacation vac= new Vacation();
    Boolean canRegister = true;

    try {
      User userExists = containsLogin(login);

      if(userExists != null) {
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
      User user = new User(vac, password, login, birthDate);
      users.add(user);
      System.out.println("User created.");
      
      TXTReport txtReport = new TXTReport();
      HTMLReport htmlReport = new HTMLReport();

      txtReport.generateReport(user);
      htmlReport.generateReport(user);

    } else {
      System.out.println("User not created.");
    }
  
    dbConnection.saveInDatabase(users, "database-users.bin");
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

  public User containsLogin(String login){
    for(User user : users) {
      if(user.getLogin().equals(login)){
        return user;
      }
    }
    return null;
  }

  public void del(String login) {
    User user = containsLogin(login);
    if (user != null) {
      users.remove(user);
      System.out.println("Usuário removido com sucesso!");
    }
    else {
      System.out.println("Usuário não existe!");
    }

    listAll();
    dbConnection.saveInDatabase(users, "database-users.bin");
  }

  /**
   * @return PersistenceFactory<User> return the persistenceFactory
   */
  public PersistenceFactory<User> getPersistenceFactory() {
      return persistenceFactory;
  }

  /**
   * @param persistenceFactory the persistenceFactory to set
   */
  public void setPersistenceFactory(PersistenceFactory<User> persistenceFactory) {
      this.persistenceFactory = persistenceFactory;
  }

  /**
   * @return IPersistence<User> return the iPersistence
   */
  public IPersistence<User> getIPersistence() {
      return iPersistence;
  }

  /**
   * @param iPersistence the iPersistence to set
   */
  public void setIPersistence(IPersistence<User> iPersistence) {
      this.iPersistence = iPersistence;
  }

  /**
   * @return DBConnectionController<User> return the dbConnection
   */
  public DBConnectionController<User> getDbConnection() {
      return dbConnection;
  }

  /**
   * @param dbConnection the dbConnection to set
   */
  public void setDbConnection(DBConnectionController<User> dbConnection) {
      this.dbConnection = dbConnection;
  }
}
