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

    public static RegularCard RegularCardFromString(String someName) {
        String[] parts = someName.split(" of ");
        CardNumber n = CardNumber.valueOf(parts[0]);
        Suite s = Suite.valueOf(parts[1]);
        return new RegularCard(n, s);
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
