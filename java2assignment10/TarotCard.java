/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/27/19
    Project: Assignment 10
    Description: Exceptions
*/
package java2assignment10;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TarotCard extends Card
{
    int value;
    String name;
    
    public TarotCard() throws CardException
    {
        this("file:img\\maj_00.jpg");
    }
    public TarotCard(String path) throws CardException
    {
        super(path);
    }
    
    //getting methods
    public int getValue()
    {
        return this.value;
    }
    public String getName()
    {
        return this.name;
    }
    
    private void getCardValue(String path)
    {
       StringBuilder numberBuilder = new StringBuilder();
        
        for(int i = 0; i < path.length(); i++)
        {
            if(Character.isDigit(path.charAt(i)))
            {
                numberBuilder.append(path.charAt(i));
            }
        }
       
        StringBuilder cardNameBuilder = new StringBuilder();
        cardNameBuilder.append("maj_" + numberBuilder);
        
        int cardNum = Integer.parseInt(numberBuilder.toString());
        
        int valueOfCard = cardNum % 10;
        
        this.name = cardNameBuilder.toString();
        this.value = valueOfCard;
        
    }
    
    @Override
    protected boolean loadCard(String path) throws CardException
    {
        try
        {
            imgCard = new Image(path);
            this.setGraphic(new ImageView(imgCard));
            this.getCardValue(path);
            return true; 
        }
        catch(Exception e)
        {
            throw new CardException("Unable to Load Card");
        }
        
    }
}
