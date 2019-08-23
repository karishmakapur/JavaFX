/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/27/19
    Project: Assignment 10
    Description: Exceptions
*/
package java2assignment10;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList
{
    int index = 0;
    final int LAST_CARD = 45;
    
    ArrayList<Card> deck = new ArrayList<Card>();
    
    //constructors
    public Deck() throws CardException
    {
        this("file:img\\");
    }
    public Deck(String path) throws CardException
    {
        this.loadCards(path);
    }
    
    //public methods
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    public PlayingCard deal()
    {
        if(this.index >= this.LAST_CARD)
        {
            this.shuffle();
            this.index = 0;
        }
        Card card = deck.get(index);
        index++;
        
        return (PlayingCard)card;
    }
    
    //private methods
    private void loadCards(String path) throws CardException
    {
        String pathToCard;
        PlayingCard card;
        
        for(int i = 101; i <= 152; i++)
        {
                pathToCard = path + i + ".gif";
                card = new PlayingCard(pathToCard);
                deck.add(card);
        }
    }
}
