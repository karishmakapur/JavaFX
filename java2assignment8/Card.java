/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/6/19
    Project: Assignment 8
    Description: Inheritance
*/
package java2assignment8;

import javafx.scene.control.*;
import javafx.scene.image.*;

public class Card extends Label
{
    Image refImage;
    int valueCard;
    String path;
    private Suit suitCard;
    
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
    public void setImage(String path)
    {
        this.path = path;
        loadCard(this.path);
    }
   
    //getting methods
    public int getValue()
    {
        return this.valueCard;
    }
    public Suit getSuit()
    {
        return this.suitCard;
    }
    
    //private methods
    private boolean loadCard(String path)
    {
        refImage = new Image(path);
        this.setGraphic(new ImageView(refImage));
        this.getCardValue(path);
        return true;
    }
    private void getCardValue(String path)
    {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < path.length(); i++)
        {
            if(Character.isDigit(path.charAt(i)))
            {
                builder.append(path.charAt(i));
            }
        }
       
        int cardNum = Integer.parseInt(builder.toString());
        cardNum -= 100;
        
        int value = cardNum % 13;
        
        //determing value for King, Queen, Jack, and Ace
        if(value == 1)
        {
            this.valueCard = 11;
        }
        else if(value >= 11)
        {
            this.valueCard = 10;
        }
        else if(value > 1 && value < 11)
        {
            this.valueCard = value;
        }
        
        //determining suit
        if(cardNum >= 1 && cardNum < 14)
        {
            this.suitCard = Suit.Diamonds;
        }
        else if(cardNum >= 14 && cardNum < 127)
        {
            this.suitCard = Suit.Clubs;
        }
        else if(cardNum >= 127 && cardNum < 140)
        {
            this.suitCard = Suit.Hearts;
        }
        else if(cardNum >= 140 && cardNum < 152)
        {
            this.suitCard = Suit.Spades;
        }
    }
    
}
