package business.model;
import java.io.Serializable;

public class User implements Serializable, Comparable<User> {
  private String login;
  private String password;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  /**
   * @return String return the login
   */
  public String getLogin() {
      return login;
  }

  /**
   * @param login the login to set
   */
  public void setLogin(String login) {
      this.login = login;
  }

  /**
   * @return String return the password
   */
  public String getPassword() {
      return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
      this.password = password;
  }

  public int compareTo(User user) {
    return this.login.compareTo(user.getLogin());
  }
}