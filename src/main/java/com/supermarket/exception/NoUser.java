package com.supermarket.exception;

public class NoUser extends RuntimeException {
    private static final long serialVersionUID = 1l;
    public NoUser(String message){
        super(message);
    }

}
