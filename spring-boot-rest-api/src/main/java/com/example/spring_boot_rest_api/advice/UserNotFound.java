package com.example.spring_boot_rest_api.advice;



public class UserNotFound extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UserNotFound(String message){
        super(message);
    }
}
