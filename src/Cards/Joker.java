package Cards;

public class Joker extends Card {
    public Joker(Color c) {
        this.color = c;
        this.name = color.name() + " Joker";
    }

    public static Joker JokerFromString(String someName) {
        String[] parts = someName.split(" ");
        Color c = Color.valueOf(parts[0]);
        return new Joker(c);
    }
}
