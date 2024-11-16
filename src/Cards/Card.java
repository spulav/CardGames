package Cards;

public abstract class Card {
    public Color color;
    public String name;

    public Color get_color() {
        return this.color;
    }

    public void set_color(Color c) {
        this.color = c;
    }

}
