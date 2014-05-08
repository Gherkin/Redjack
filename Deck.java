package pkg21;

import java.util.Random;

public class Deck {
    private Card[] deck;
    private int size = 52;
    private int value;
    
    Deck(boolean fill) {
        int c = 0;
        deck = new Card[52];
        if(fill == true) {
                for(int i = 0; i < 4; ++i) {
                    for(int e = 0; e < 13; ++e) {
                        deck[c] = new Card(e, i); 
                        c++;
                    }
                }
            size = 52;
        }
        if(fill == false)
            size = 0;
    }
    
    Deck() {
        value = 0;
        size = 0;
        deck = new Card[52];
    }
    
    //Does not set value
    Deck(boolean fill, int maxSize) {
        deck = new Card[maxSize];
        if(fill == true) {
                for(int i = 0; i < maxSize; ++i) {
                    deck[i] = new Card(); 
                }
            size = maxSize;
        }
        if(fill == false)
            size = 0;
    }
    
    Deck(int maxSize) {
        value = 0;
        size = 0;
        deck = new Card[maxSize];
    }
    
    public Card returnCard(boolean remove) {
        if(size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        Random random = new Random();
        int cardNumber = random.nextInt(size);
        Card card;
        
        card = deck[cardNumber];
        if(remove == true) {
            deck[cardNumber] = deck[size - 1];
            deck[size - 1] = null;
            size--;
        }
        
        return card;             
    }
    
    @Override
    public String toString() {
        String string = "";
        if(size == 0)           
            throw new ArrayIndexOutOfBoundsException();
        for(int i = 0; i < size; i++) {
            string = string + deck[i].toString();
            if(i != size - 1)
                string = string + ", ";
        }
        return string;
    }
    
    public boolean addCard(Card card) {
        if(size >= deck.length)
            return false;
        ++size;
        deck[size - 1] = card;
        value += card.getValue();
        return true;
    }
    
    public Card getCard(int i) {
        return deck[i];
    }
    
    public int size() {
        return this.size;
    }
    
    public int getValue() {
        return value;
    }
}