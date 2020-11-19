package util;

public class UserLoginException extends Exception {

	private static final long serialVersionUID = 1L;

  public UserLoginException() {
    super("- login don't match. try 1-20 caracteres without numbers");
  }

  public UserLoginException(String message) {
    super(message);
  }
}
