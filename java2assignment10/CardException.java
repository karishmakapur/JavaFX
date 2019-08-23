/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/27/19
    Project: Assignment 10
    Description: Exceptions
*/
package java2assignment10;

public class CardException extends Exception
{
    //overloaded constructor calling base class constructor
    public CardException(String errorMsg)
    {
        super(errorMsg);
    }
    
    //default constructor calling overloaded constructor
    public CardException()
    {
        this("Unknown Error");
    }
}
