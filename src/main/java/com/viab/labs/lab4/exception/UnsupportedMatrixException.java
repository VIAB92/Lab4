package com.viab.labs.lab4.exception;

/**
 * Created by Viktor on 25.04.2015.
 */
public class UnsupportedMatrixException extends Exception {
    public UnsupportedMatrixException(){
        super();
    }

    public UnsupportedMatrixException(String message){
        super(message);
    }
}