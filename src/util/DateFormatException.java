package util;

public class DateFormatException extends Exception {

	private static final long serialVersionUID = 1L;

public DateFormatException() {
    super("- date not valid");
  }

  public DateFormatException(String message) {
    super(message);
  }
}
