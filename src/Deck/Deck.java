package Deck;
import java.util.ArrayList;
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
    }

    public void drawAndDiscard() {
    }

    public void drawAndPutAtBottom() {
    }

    public void drawAndReshuffle() {
    }

    // public Deck[] splitDeck(int[] n) { proportions so [0.25,0.25,0.5] would be 3, with the first two a quarter size each and the last 1/2
    //     ;
    // }
}
