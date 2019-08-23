/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/13/19
    Project: Assignment 9
    Description: Polymorphism
*/
package java2assignment9;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayingCard extends Card 
{
    private int value;
    private Suit suit;
    
    //default constructor 
    public PlayingCard()
    {
         this("file:img\\155.gif");
    }
    
    //overloaded constructor
    public PlayingCard(String path)
    {
        super(path);
    }
            
    //getting methods
    public int getValue()
    {
        return this.value;
    }
    public Suit getSuit()
    {
        return this.suit;
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
            this.value = 11;
        }
        else if(value >= 11)
        {
            this.value = 10;
        }
        else if(value > 1 && value < 11)
        {
            this.value = value;
        }
        
        //determining suit
        if(cardNum >= 1 && cardNum < 14)
        {
            this.suit = Suit.Diamonds;
        }
        else if(cardNum >= 14 && cardNum < 127)
        {
            this.suit = Suit.Clubs;
        }
        else if(cardNum >= 127 && cardNum < 140)
        {
            this.suit = Suit.Hearts;
        }
        else if(cardNum >= 140 && cardNum < 152)
        {
            this.suit= Suit.Spades;
        }
    }
    @Override
    protected boolean loadCard(String path) 
    {
        imgCard = new Image(path);
        this.setGraphic(new ImageView(imgCard));
        this.getCardValue(path);
        return true;
    }
    
}
