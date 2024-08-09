import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] valuesNumeric = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};  // Ace can be 11

        for (String suit : suits) {
            for (int i = 0; i < values.length; i++) {
                deck.add(new Card(suit, values[i], valuesNumeric[i]));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card deal() {
        return deck.remove(deck.size() - 1);
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }
}
