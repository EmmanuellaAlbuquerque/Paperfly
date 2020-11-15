package util;

public class UserLoginException extends Exception {
  public UserLoginException() {
    super("login don't match with regex");
  }

  public UserLoginException(String message) {
    super(message);
  }
}
