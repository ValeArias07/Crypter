package exception;

public class WordKeyInvalidException extends Exception {

	public WordKeyInvalidException(String key, int number) {
		super("The key "+key+" is invalid because it has " +number+ " caracters more than the text");
	}
}
