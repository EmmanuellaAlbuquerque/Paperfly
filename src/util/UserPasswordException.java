package util;

public class UserPasswordException extends Exception {
  public UserPasswordException() {
    super("password don't match with regex");
  }

  public UserPasswordException(String message) {
    super(message);
  }
}
