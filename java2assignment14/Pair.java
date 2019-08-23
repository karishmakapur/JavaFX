/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 5/11/19
    Project: Assignment 14
    Description: Generics
 */
package java2assignment14;

public class Pair<F, S> 
{
    F x;
    S y;
    
    //overloaded constructor
    public Pair(F xVal, S yVal)
    {
        this.x = xVal;
        this.y = yVal;
    }
    //accessor method. Returns first pair value
    public F getFirst()
    {
        F xCoord = this.x;
        return xCoord;
    }
    //accessor method. Returns second pair value
    public S getSecond()
    {
        S yCoord = this.y;
        return yCoord;
    }
    //mutator method. Set the first pair value
    public void setFirst(F xVal)
    {
        this.x = xVal;
    }
    //mutator method. Set the second pair value
    public void setSecond(S yVal)
    {
        this.y = yVal;
    }
}
