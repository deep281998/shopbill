package com.example.shopbillmanager.exception;

public class AlreadyExist extends RuntimeException{
    public AlreadyExist(String message){
        super(message);
    }
}
