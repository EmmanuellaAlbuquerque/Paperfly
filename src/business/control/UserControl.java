package business.control;
import java.util.HashMap;
import java.util.Map;

import business.model.User;
import infra.HandlePersistence;
import infra.UserPersistence;

public class UserControl {
  private Map<String, User> users = new HashMap<String, User>();

  public UserControl(HashMap<String, User> users) {
    this.users = users;
  }

  public void add(String[] param) {
    // ----------------------------------------------------------------

    // verify parameters methods
    if (verifyLogin(param[0]) && verifyPassword(param[1])) {
      User user = new User(param[0], param[1]);
      users.put(param[0], user);
      System.out.println("User created.");
    }
    else {
      System.out.println("User not created.");
    }


    // ----------------------------------------------------------------
  }

  private Boolean verifyPassword(String password) {
    Boolean checkPassword = false;

    try {
      checkPassword = password.matches("(?=(.*\\d){2})[a-zA-Z0-9]{8,12}");

      if(!checkPassword){
        throw new UserPasswordException();
      }
      
    } catch (UserPasswordException e) {
      e.printStackTrace();
    }

    return checkPassword;
  }

  private Boolean verifyLogin(String login) {
    Boolean tamanhoMinMax = false;
    Boolean dontContainNumber = false;

    try {

      tamanhoMinMax = login.matches("[a-zA-Z]{1,20}");
      dontContainNumber = !login.matches(".*\\d.*");

      if(!(tamanhoMinMax && dontContainNumber)){
        throw new UserLoginException();
      }
      
    } catch (UserLoginException e) {
      e.printStackTrace();
    }

    return tamanhoMinMax && dontContainNumber;
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

  public static void main(String[] args) {
    // HashMap<String, User> users = new HashMap<String, User>();

    // UserControl userControl = new UserControl(users);

    // String[] param = {"ManuellaF", "1me3afoo"};
    // userControl.add(param);

    // userControl.listAll();

    // UserPersistence userPersistence = new UserPersistence();
    // userPersistence.saveUsers(users);


    //--------------------------------------------------------------

    HashMap<String, User> usersFile = new HashMap<String, User>();
    UserPersistence userPersistence = new UserPersistence();
    usersFile = userPersistence.loadUsers();

    UserControl userControl = new UserControl(usersFile);
    userControl.listAll();

  }
}