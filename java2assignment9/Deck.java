/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 4/13/19
    Project: Assignment 9
    Description: Polymorphism
*/
package java2assignment9;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList
{
    int index = 0;
    final int LAST_CARD = 45;
    
    ArrayList<Card> deck = new ArrayList<Card>();
    
    //constructors
    public Deck()
    {
        this("file:img\\");
    }
    public Deck(String path)
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
    private void loadCards(String path)
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
