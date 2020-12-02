package util;

public class NothingToUndoMementoException extends Exception {
	private static final long serialVersionUID = 1L;

  public NothingToUndoMementoException() {
    super("all possible undoes have been undone");
  }

  public NothingToUndoMementoException(String message) {
    super(message);
  }
}
