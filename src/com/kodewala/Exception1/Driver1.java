package com.kodewala.Exception1;

public class Driver1 {
    public static void main(String[] args) {
        int amount = 1000;
        System.out.println("Driver1.main....START");

        Driver1 driver1 = new Driver1();
        driver1.doSomething();

        try {
            amount=amount/0;
        }
        catch (ArithmeticException x) {
            System.out.println("Cannot be divided by zero ");
            x.printStackTrace();
        }

        System.out.println("Driver1.main....END");
    }

    public void doSomething() {
        System.out.println("Driver1.doSomething().....START");
        String name = "something";
        String name1 = null;

        System.out.println(name+" Length: "+name.length());


        //Risky Code: may throw an Exception  --> try
        try {
            System.out.println(name1 + " Length: " + name1.length()); //NPE -> not handled

            System.out.println("After length()"); //Ignored Statement
        }


        catch (NullPointerException e) {   //This can catch Exception's object and its child object
            System.out.println("Name is null....");
            e.printStackTrace();
        }


        System.out.println("Driver1.doSomething()......END");
    }
}
