package com.supermarket.exception;


public class EmptyDb extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EmptyDb(String message) {
		super(message); 

	}
}
