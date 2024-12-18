package Deck;
import java.util.ArrayList;
import java.util.Collections;
import Cards.*;

public class Deck {

    public ArrayList<Card> deck;

    public Deck() {
        this.deck = createStandardDeck();
    }

    public Deck(int joker_number) {
        this.deck = createStandardDeck();

        Color c = Color.Black;

        int i = 0;
        while (i < joker_number) {
            Joker j = new Joker(c);
            if (c == Color.Black) {
                c = Color.Red;
            } else if (c == Color.Red) {
                c = Color.Black;
            }
            this.deck.add(j);
            i += 1;
        }
        
    }

    public Deck(ArrayList<Card> d) {
        this.deck = d;
    }

    private ArrayList<Card> createStandardDeck() {
        ArrayList<Card> standard_deck = new ArrayList<Card>();
        for (CardNumber cn : CardNumber.values()) {
            for (Suite s : Suite.values()){
                RegularCard rc = new RegularCard(cn, s);
                standard_deck.add(rc);
            }
        }
        return standard_deck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card pop() {
        Card card = deck.remove(0);
        return card;
    }

    public Card remove(int index) {
        Card card = deck.remove(index);
        return card;
    }

    public Card peek() {
        Card card = deck.get(0);
        return card;
    }

    public void add(Card card) {
        deck.add(card);
    }

    public void insert(Card card, int index) {
        deck.add(index, card);
    }

    public Card get(int index) {
        Card card = deck.get(index);
        return card;
    }

    public Deck[] splitDeck(double[] proportions) { //proportions so [0.25,0.25,0.5] would be 3, with the first two a quarter size each and the last 1/2
        int howManyDecks = proportions.length;
        Deck[] decks = new Deck[howManyDecks];
        int ogSize = deck.size();
        double[] newSizes = new double[howManyDecks];
        int cardsAllocated = 0;
        for (int i = 0; i < proportions.length; i++) { 
            newSizes[i] = Math.floor(ogSize * proportions[i]);
            cardsAllocated += (int)newSizes[i];
        }

        int leftOver = ogSize - cardsAllocated;
        int j = 0;
        while (leftOver > 0) {
            newSizes[j]++;
            leftOver--;
            j++;
        }

        int k = 0;
        int index = 0;
        while (k < ogSize) {
            int incr = (int)newSizes[index];
            Deck deck_n = new Deck(new ArrayList<Card>(deck.subList(k, k+incr)));
            decks[index] = deck_n;
            k = k+incr;
            index += 1;
        }

        return decks;
    }

    public int size() {
        return deck.size();
    }

    public int search(String cardName) {
        int i = 0;
        while (i < deck.size()) {
            String current = deck.get(i).toString();
            if (current == cardName) {
                return i;
            }
        }
        return -1;
    }
}
