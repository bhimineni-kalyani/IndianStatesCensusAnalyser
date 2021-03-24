package com.bridgelabz;

public class CustomException extends Exception {
    public enum ExceptionType {
        Wrongfile,
        Wrongfiletype;
    }
    public CustomException() {
    }
    public CustomException(String s,ExceptionType type) {
        super(s);
        this.type = type;
    }
}