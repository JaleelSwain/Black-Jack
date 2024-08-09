import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scanner;

    public Game() {
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();
        scanner = new Scanner(System.in);
    }

    public void start() {
        // Initial dealing
        dealInitialCards();

        // Player's turn
        playerTurn();

        // Dealer's turn
        dealerTurn();

        // Determine winner
        determineWinner();
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.deal());
            dealer.addCard(deck.deal());
        }

        System.out.println("Dealer's hand:");
        dealer.showHand(false);
        System.out.println("\nYour hand:");
        player.showHand(true);
    }

    private void playerTurn() {
        while (!player.isBusted()) {
            System.out.println("\nDo you want to hit or stand? (h/s)");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("h")) {
                player.addCard(deck.deal());
                System.out.println("\nYour hand:");
                player.showHand(true);
                if (player.isBusted()) {
                    System.out.println("Busted! Your hand value exceeds 21.");
                }
            } else if (action.equalsIgnoreCase("s")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'h' to hit or 's' to stand.");
            }
        }
    }

    private void dealerTurn() {
        System.out.println("\nDealer's turn:");
        dealer.showHand(true);
        dealer.playTurn(deck);
        if (dealer.isBusted()) {
            System.out.println("Dealer busted!");
        } else {
            System.out.println("Dealer's hand value: " + dealer.getHandValue());
        }
    }

    private void determineWinner() {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        System.out.println("\nYour final hand value: " + playerValue);
        System.out.println("Dealer's final hand value: " + dealerValue);

        if (player.isBusted()) {
            System.out.println("Dealer wins!");
        } else if (dealer.isBusted()) {
            System.out.println("You win!");
        } else if (playerValue > dealerValue) {
            System.out.println("You win!");
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
