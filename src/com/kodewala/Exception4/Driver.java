package com.kodewala.Exception4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Driver {
    public static void main(String[] args) {
        String name = null;
        try {
            System.out.println(name.length()); //NPE
        }
        catch (NullPointerException x) {
            System.out.println("Length of Null String cannot be calculated");
            x.printStackTrace(System.out);
        }
        String className = "com.kodewala.Exception3.Driver";
        try {
            Class.forName(className); //loading the class into memory
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found exception");
            e.printStackTrace(System.out);
        }
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(""));
        }
        catch (IOException e) {
            System.out.println("oos IOException");
            e.printStackTrace(System.out);
        }
        System.out.println("Class loaded.....");
    }
}
