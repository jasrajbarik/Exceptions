package com.kodewala.Exception1;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Driver.main......START");

        String name = "Jasraj";
        String name1 = null;
        System.out.println(name.length());
        // System.out.println(name1.length());  //NullPointerException

        //ArithmeticException //ArrayIndexOutOfBoundException //NumberFormatException

        System.out.println("Driver.main......END");
    }
}
