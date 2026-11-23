package com.kodewala.Exception6.CustomExceptions;

public class Driver {
    public static void main(String[] args) {
        PaymentMgmt mgmt = new PaymentMgmt();
        System.out.println("Driver.main.....STARTS");

        try {
            mgmt.doPayment("SBI250444756",1500 );
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        System.out.println("Driver.main.....ENDS");
    }
}
