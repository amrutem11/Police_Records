package com.Exceptions;

@SuppressWarnings("serial")
public class CriminalException extends Exception {
	
	public CriminalException () {
		
	}
	
	public CriminalException (String message) {
		super(message);
	}
}
