package business.model;
import java.io.Serializable;

import util.Date;

public class User implements Serializable, Comparable<User> {
  private String login;
  private String password;
  private Date birth_date;

  public User(String login, String password, Date birth_date) {
    this.login = login;
    this.password = password;
    this.birth_date = birth_date;
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

  /**
   * @return Date return the birth_date
   */
  public Date getBirthDate() {
    return birth_date;
  }

  /**
   * @param birth_date the birth_date to set
   */
  public void setBirthDate(Date birth_date) {
      this.birth_date = birth_date;
  }

  public int compareTo(User user) {
    return this.login.compareTo(user.getLogin());
  }

  @Override
  public String toString() {
    return ("Login: " + getLogin() + " Password: " + getPassword()  + " Birth date: " + getBirthDate().showDate());
  }
}