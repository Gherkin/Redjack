package pkg21;

import java.util.Random;

public class Card {
    private int value;
    private int rank, suit = 0;
    private String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    
    Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
        if(rank > 0 && rank < 10)
            value = rank + 1;
        if(rank > 9)
            value = 10;
        if(rank == 0)
            value = 1;
            
    }
    
    Card() {
        Random random = new Random();
        rank = random.nextInt(13);
        suit = random.nextInt(4);
        if(rank > 0 && rank < 10)
            value = rank + 1;
        if(rank > 9)
            value = 10;
        if(rank == 0)
            value = 1;
    }
    
    @Override
    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }
    public int getRank() {
        return rank;
    }
    public int getSuit() {
        return suit;
    }
    public int getValue() {
        return value;
    }
}
