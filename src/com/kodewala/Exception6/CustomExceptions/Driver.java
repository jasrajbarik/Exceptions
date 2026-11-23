package com.kodewala.Exception6.CustomExceptions;

public class Driver {
    public static void main(String[] args) {
        PaymentMgmt mgmt = new PaymentMgmt();
        mgmt.doPayment("SBI250444756",1500 );
    }
}
