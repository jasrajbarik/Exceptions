package com.kodewala.Exception6.CustomExceptions;

public class FundTransferException extends RuntimeException {

    public FundTransferException(String msg) {
        super(msg);
    }
}
