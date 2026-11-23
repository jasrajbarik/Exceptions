package com.kodewala.Exception3;

public class InvoiceService {
    public void generateInvoice() {

        //Get customers and orders details from the Database
        //Connect with database --> create Database Connection
        //get details from database

        try {
            connectDataBase(); //creating connection
            String name = null;
            name.lastIndexOf("a");
            System.out.println("InvoiceService.generateInvoice.......Generating an Invoice");
            //closing
            closeDbConnection();    //This part will be skipped as exception occurred
        } catch (Exception e) {
            System.out.println("Some exception occured ");
            e.printStackTrace(System.out);
        }

        finally {   //mandatory executable block (Exception or no exception)
            System.out.println("I am inside finally block.....");
        }
    }


    private void connectDataBase() {    //connection object
        System.out.println("Connecting to Database ");
    }
    private void closeDbConnection() {
        System.out.println("Closing the connection.......");
    }
}
