package model;

import exception.WordKeyInvalidException;

public abstract class Crypter {

	public abstract String encrypt(String txt) throws WordKeyInvalidException;

	public abstract String decrypt(String txt);
}
