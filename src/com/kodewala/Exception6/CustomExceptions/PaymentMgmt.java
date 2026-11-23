package com.kodewala.Exception6.CustomExceptions;

public class PaymentMgmt {
    public void doPayment(String account, int amount) {
        boolean result;
        //check the balance
        try {
        result = checkBalance(account, amount);
        }
        catch (InsufficientBalanceException e) {
            throw new FundTransferException("You do not have enough balance OR \n A new account : wait for 24 hours ");
        }
            System.out.println("Transaction Successful");
    }

    private boolean checkBalance(String account, int amount) throws InsufficientBalanceException {
        boolean checkBalanceStatus = false;
        int balance = 1000; //from database
        if(amount > balance) {
            //balance is not enough
            throw new InsufficientBalanceException(account+" does not have enough balance!! The Balance is: "+balance );
        }
        else {
            //allow the transaction
            checkBalanceStatus=true;
        }
        return checkBalanceStatus;
    }

}
