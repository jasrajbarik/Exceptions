package com.kodewala.Exception5;

public class AccountMgmt {

    void openAccount(String name, String address) {
        System.out.println("AccountMgmt.openAccount.....STARTS");
        activateAccount("2544018987");
        System.out.println("AccountMgmt.openAccount.....ENDS");
    }

    void activateAccount(String accNo) {
        System.out.println("AccountMgmt.activateAccount.....STARTS");
        try {
            checkAccountStatus(null);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println("AccountMgmt.activateAccount.....ENDS");
    }

    private boolean checkAccountStatus(String accNo) throws Exception {
    // throws--> someone whoever is calling this method be ready to handle an exception.
        try {
            accNo.startsWith("SBI");
        }
        catch (Exception e) {
            //handle the exception or throw
            e.printStackTrace(System.out);
            //throw--> create new exception object and throw it to the caller.
            throw new Exception("Not an SBI Account");

        }
        return false;
    }
}
