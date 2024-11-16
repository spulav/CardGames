package Cards; 

public class RegularCard extends Card {
    public CardNumber number;
    public Suite suite;

    public RegularCard(CardNumber n, Suite s) {
        this.number = n;
        this.suite = s;
        this.name = n.name() + " of " + s.name();

        if (s == Suite.Clubs || s == Suite.Spades) {
            this.color = Color.Black;
        } else if (s == Suite.Diamonds || s == Suite.Hearts) {
            this.color = Color.Red;
        }
    }

    public CardNumber get_number() {
        return this.number;
    }

    public Suite get_suite() {
        return this.suite;
    }

    public void set_number(CardNumber n) {
        this.number = n;
    }

    public void set_suite(Suite s) {
        this.suite = s;
    }
}
