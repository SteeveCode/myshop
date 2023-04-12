package com.myshop.admin.user;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message); // this is one of the constructors from the super class that takes a string parameter
    }

}