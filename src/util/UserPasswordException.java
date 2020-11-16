package util;

public class UserPasswordException extends Exception {
  public UserPasswordException() {
    super("password don't match. try 8-12 caracteres with at least two number");
  }

  public UserPasswordException(String message) {
    super(message);
  }
}
