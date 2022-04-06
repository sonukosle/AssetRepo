package com.asset.helper;

public class UserFoundException extends Exception {

    public UserFoundException() {
        super("User already present in database !!");
    }

    public UserFoundException(String msg) {

        super(msg);
    }
}
