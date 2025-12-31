package com.example.user_management.Exception;

public class InvalidRoleException extends RuntimeException{
    public InvalidRoleException(String message){
        super(message);
    }
}
