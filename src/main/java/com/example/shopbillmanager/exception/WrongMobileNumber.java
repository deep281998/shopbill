package com.example.shopbillmanager.exception;

public class WrongMobileNumber extends RuntimeException{

    public WrongMobileNumber(String message){
        super(message);
    }
}
