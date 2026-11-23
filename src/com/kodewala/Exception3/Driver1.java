package com.kodewala.Exception3;

public class Driver1 {
    public static void main(String[] args) {

        Driver1 driver1 = new Driver1();
        int result =driver1.calDicsout(1500,15);
        System.out.println("Discounted Amount: "+result);

    }

    private int calDicsout(int amount, int disc) {
        int finalAmt =0;
        try {
            finalAmt = amount-(amount * disc/100);
            return finalAmt;
        } catch (Exception e) {
            System.out.println("Some exception occured");
            e.printStackTrace(System.out);
        }

        finally {
            System.out.println("Inside finally block");
            finalAmt = 110;
            //returning from here will give 110
            return finalAmt;
        }
        //  return finalAmt;   --> If we return from here then discounted amount will be returned.
    }
}
