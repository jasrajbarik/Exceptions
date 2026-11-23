package com.kodewala.Exception6.CustomExceptions;

public class PaymentMgmt {
    public void doPayment(String account, int amount) {
        //check the balance
        checkBalance(account,amount);
    }

    private boolean checkBalance(String account, int amount) {
        boolean checkBalanceStatus = false;
        int balance = 1000; //from database
        if(amount > balance) {
            //balance is not enough
            throw new InsufficientBalanceException(account+" does not have enough balance!! The Balance is: "+balance );
        }
        else {
            //allow the transaction
            System.out.println("Transaction successful !!");
            checkBalanceStatus=true;
        }
        return checkBalanceStatus;
    }

}
