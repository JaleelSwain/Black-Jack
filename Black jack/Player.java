import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int totalValue = 0;
        int aceCount = 0;

        for (Card card : hand) {
            totalValue += card.getValue();
            if (card.getValue() == 11) {
                aceCount++;
            }
        }

        while (totalValue > 21 && aceCount > 0) {
            totalValue -= 10;
            aceCount--;
        }

        return totalValue;
    }

    public void showHand(boolean showAll) {
        if (showAll) {
            for (Card card : hand) {
                System.out.println(card);
            }
        } else {
            System.out.println(hand.get(0));  // Show only the first card
            System.out.println("Hidden");
        }
    }

    public boolean isBusted() {
        return getHandValue() > 21;
    }
}

public class Dealer extends Player {

    public void playTurn(Deck deck) {
        while (getHandValue() < 17) {
            addCard(deck.deal());
        }
    }
}


