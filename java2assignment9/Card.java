/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/13/19
    Project: Assignment 9
    Description: Polymorphism
*/
package java2assignment9;

import javafx.scene.control.*;
import javafx.scene.image.*;

public abstract class Card extends Label
{
    protected Image imgCard;
    protected String imgName;
    
    //default constructor
    public Card()
    {
        this("file:img\\155.gif");
    }
    
    //overloaded constructor
    public Card(String path)
    {
        super();
        this.setImage(path);
    }
    
    //setting methods
    private void setImage(String name)
    {
        this.imgName = name;
        loadCard(this.imgName);
    }
    
    protected abstract boolean loadCard(String path);
    

    
}
