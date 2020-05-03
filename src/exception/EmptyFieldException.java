package exception;

@SuppressWarnings("serial")
public class EmptyFieldException extends Exception {
	public EmptyFieldException(String type, String action) {
		super("You try " + action + " with an empty " + type);
	}
}
