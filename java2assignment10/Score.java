/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/27/19
    Project: Assignment 10
    Description: Exceptions
*/
package java2assignment10;

public class Score
{
    private static int right = 0;
    private static int left = 0;
    
    public static void setRightScore(int rScore)
    {
        right += rScore; //incrementing static variable of class
    }
    public static void setRightScore(String rScore) throws CardException 
    {
        try
        {
            //incrementing static variable of class
            right += Integer.parseInt(rScore);
        }
        catch(Exception e)
        {
            throw new CardException(e.getMessage() + "Card Conversion Error");
        }
        
    }
    public static void setLeftScore(int lScore)
    {
        left += lScore; //incrementing static variable of class
    }
    public static void setLeftScore(String lScore) throws CardException
    {
        try
        {
        //incrementing static variable of class
        left += Integer.parseInt(lScore);
        }
        catch(Exception e)
        {
            throw new CardException(e.getMessage() + "Card Conversion Error");
           
        }   
    }
    public static int getRightScore()
    {
        //returning the right score
        return right;
    }
    public static int getLeftScore()
    {
        //returning the left score
        return left;
    }
    public static void resetScore()
    {
        //setting field variables to 0
        right = 0;
        left = 0;
    }
}
