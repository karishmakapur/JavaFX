/*  
    Student Name: Karishma Kapur
    Student ID: 0558326
    Date: 3/30/19
    Project: Assignment 6
    Description: Constructors and Composition
*/
package java2assignment6;

import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
    int index = 0;
    final int LAST_CARD = 30;
    
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
    public Card deal()
    {
        if(this.index >= this.LAST_CARD)
        {
            this.shuffle();
            this.index = 0;
        }
        Card card = deck.get(index);
        index++;
        
        return card;
    }
    
    //private methods
    private void loadCards(String path)
    {
        String pathToCard;
        Card card;
        
        for(int i = 101; i <= 152; i++)
        {
                pathToCard = path + i + ".gif";
                card = new Card(pathToCard);
                deck.add(card);
        }
    }
}
