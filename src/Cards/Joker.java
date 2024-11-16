package Cards;

public class Joker extends Card {
    public Joker(Color c) {
        this.color = c;
        this.name = color.name() + " Joker";
    }
}
