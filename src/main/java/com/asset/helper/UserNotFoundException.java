package com.asset.helper;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {

        super("User not found exception !!");
    }

    public UserNotFoundException(String msg) {

        super(msg);
    }
}
