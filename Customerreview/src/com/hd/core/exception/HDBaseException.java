package com.hd.core.exception;
/**
 * 
 * @author jagnya.datta
 *
 */
public class HDBaseException extends RuntimeException{
	public HDBaseException(String message) {
		super(message);
	}

	public HDBaseException(Throwable cause) {
		super(cause);
	}

	public HDBaseException(String message, Throwable cause) {
		super(message, cause);
	}

}
