package business.model;

public interface IUser {
  public String getLogin();
  public String getPassword();
  public Date getBirthDate();

  public void setLogin(String login);
  public void setPassword(String password);
  public void setBirthDate(Date birthDate);
}
