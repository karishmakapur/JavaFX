/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/27/19
    Project: Assignment 10
    Description: Exceptions
*/
package java2assignment10;

import javafx.scene.control.*;
import javafx.scene.image.*;

public abstract class Card extends Label
{
    protected Image imgCard;
    protected String imgName;
    
    //default constructor
    public Card() throws CardException
    {
        this("file:img\\155.gif");
    }
    
    //overloaded constructor
    public Card(String path) throws CardException
    {
        super();
        this.setImage(path);
    }
    
    //setting methods
    private void setImage(String name) throws CardException
    {
        this.imgName = name;
        loadCard(this.imgName);
    }
    
    protected abstract boolean loadCard(String path) throws CardException;
    

    
}
