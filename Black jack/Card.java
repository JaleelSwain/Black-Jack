public class Card {
    private String suit;
    private String value;
    private int numericValue;

    public Card(String suit, String value, int numericValue) {
        this.suit = suit;
        this.value = value;
        this.numericValue = numericValue;
    }

    public int getValue() {
        return numericValue;
    }

    public String toString() {
        return value + " of " + suit;
    }
}
