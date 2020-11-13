package business.control;
import java.util.HashMap;

import business.model.User;

public class UserControl {
  private HashMap<String, User> users = new HashMap<String, User>();

  public UserControl(HashMap<String, User> users) {
    this.users = users;
  }

  public void add(String[] param) {
    // ----------------------------------------------------------------

    // verify parameters methods





    // ----------------------------------------------------------------
    User user = new User(param[0], param[1]);
    users.put(param[0], user);
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
    HashMap<String, User> users = new HashMap<String, User>();

    UserControl userControl = new UserControl(users);

    String[] param = {"Marta", "123"};
    userControl.add(param);

    // userControl.del("0");

    userControl.listAll();
  }
}