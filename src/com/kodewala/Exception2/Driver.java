package com.kodewala.Exception2;

/*Throwable ==> 1. Exception
*               2. Error
* */

public class Driver {
    public static void main(String[] args) {
        System.out.println("Driver.main....STARTS");
        Account account = new Account();
        String accNo = "SBI502228805";
        String[] address = {"BTM Bengaluru","HSR Layout"};
        account.doActivate(accNo,address);
        System.out.println("Driver.main....ENDS");
    }
}

class Account {
    void doActivate(String accNo,String[] address) {
        System.out.println("Account.doActivate....STARTS");
        boolean result = validateAccDetails(accNo,address);
        if(result) {
            System.out.println("Account Successfully Validated");
        } else
        {
            System.err.println("\nValidation Failed!!!");
        }
        System.out.println("Account.doActivate....ENDS");
    }
    private boolean validateAccDetails(String accNo, String[] address) {
        System.out.println("Account.validateAccDetails....STARTS");

        boolean isValid = false;
        try {
            String homeAddress = address[1];
            System.out.println("Home Address: "+homeAddress);
            isValid = accNo.startsWith("SBI"); //NPE if accNo is null --> This is a risky code.
            int amount = 1500/0;
            int intAccNo = Integer.parseInt(accNo);

        }

        catch (NullPointerException e) { //This block will catch any of the exception object
            System.out.println("\nAccount Number is null \n ");
            e.printStackTrace(System.err);
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nyou are trying to get an value from invalid index\n");
            e.printStackTrace(System.out);
        }

        catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero");
            e.printStackTrace(System.out);
        }

        catch (Exception e) {
            System.out.println("\nUnknown Error\n");
            e.printStackTrace(System.out);
        }


        System.out.println("Account.validateAccDetails.....ENDS");
        return isValid;
    }
}
