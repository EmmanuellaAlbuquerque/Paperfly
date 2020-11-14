package business.control;

public class UserLoginException extends Exception {
  @Override
  public String toString() {
    return "login don't match with regex";
  }
}
