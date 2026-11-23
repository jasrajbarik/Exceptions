# Exception:
--> Exceptions are always raised at the run time only i.e. while execution.

## Types of Exceptions:
1. Checked Exception / Compile time Exception
--> When our compiler know about the exception i.e. we must handle before executing
--> ClassNotFoundException, FileNotFoundException, IOException, SQLException, 

2. Unchecked Exception


### Note:
--> If any custom exception extends Exception other than RuntimeException will be Checked.
    Hence the user must handle it before executing the program.


##How to create custom exceptions/user-defined exception:
--> Create a class which extends either Exception or RuntimeException class
--> Add one constructor and pass the message.

Eg.
1. UserAlreadyExistException
2. EmailAlreadyExistException
3. DuplicateProductException
4. DeliveryAreaNotInServiceException
5. MaxQuantityFaultException
6. DuplicateUserException
7. InternalServerException
8. MinQtyFaultException

