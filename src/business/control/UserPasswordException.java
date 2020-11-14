package business.control;

public class UserPasswordException extends Exception {
  @Override
  public String toString() {
    return "password don't match with regex";
  }
}
