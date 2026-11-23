package com.kodewala.Exception6.CustomExceptions;

public class InsufficientBalanceException extends RuntimeException {

    InsufficientBalanceException(String msg) {
        super(msg);
    }
}
