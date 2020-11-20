package business.model;
import java.io.Serializable;

public class User implements Serializable, Comparable<User>, IUser {

	private static final long serialVersionUID = 1L;
  private String login;
  private String password;
  private Date birthDate;

  public User(String login, String password, Date birthDate) {
    this.login = login;
    this.password = password;
    this.birthDate = birthDate;
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
   * @return Date return the birthDate
   */
  public Date getBirthDate() {
    return birthDate;
  }

  /**
   * @param birthDate the birthDate to set
   */
  public void setBirthDate(Date birthDate) {
      this.birthDate = birthDate;
  }

  public int compareTo(User user) {
    return this.login.compareToIgnoreCase(user.getLogin());
  }

  @Override
  public String toString() {
    return ("Login: " + getLogin() + " Password: " + getPassword()  + " Birth date: " + getBirthDate().showDate());
  }
}
