import java.util.Scanner;

public class Game {

    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scanner;

    // Variables to store the game score
    private int wins;
    private int losses;
    private int pushes;

    public Game() {
        // Create a new deck, player, dealer, scanner instance.
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();
        scanner = new Scanner(System.in);

        deck.shuffle();
        System.out.println("Deck shuffled.");

        // Initialize the scores with 0
        wins = 0;
        losses = 0;
        pushes = 0;
    }

    public void playRound() {
        // Make sure not to have old cards in the hand
        player.clearHand();
        dealer.clearHand();

        // Deal the first 2 cards both player and dealer
        for (int i = 0; i < 2; i++) {

            if (deck.isEmpty()) {
                System.out.println("The deck is out of cards. Ending game.");
                printFinalScore();
                return;
            }
            player.receiveCard(deck.dealCard());
            dealer.receiveCard(deck.dealCard());
        }

        boolean playerTurn = true;
        while (playerTurn) {
            System.out.println("Your hand: ");
            player.printHand();
            System.out.println("Your hand total: " + player.getHandValue());

            dealer.printHand();

            System.out.println("Do you want to hit or stand? Enter 'h' or 's': ");
            String input = scanner.nextLine().trim().toLowerCase();

            if ("h".equals(input)) {
                player.hit(deck);
                if (player.isBust()) {
                    System.out.println("Bust!");
                    losses++;
                    dealer.printFullHand();
                    playerTurn = false;
                }
            } else if ("s".equals(input)) {
                System.out.println("You chose to stand.");
                playerTurn = false;
            } else {
                System.out.println("Your input is invalid. Please enter 'h' to hit or 's' to stand.");
            }
        }

        if (!player.isBust()) {
            System.out.println("Dealer's turn.");
            dealer.dealerHit(deck);
            dealer.printFullHand();
            checkForBlackjack();
            checkFinalOutcomes();

            if (dealer.isBust()) {
                System.out.println("Dealer busts. You win!");
                wins++;
            } else {
                checkFinalOutcomes();
            }
        } else {
            losses++;
        }
    }

    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    private void checkForBlackjack() {
        boolean playerBlackjack = player.getHandValue() == 21;
        boolean dealerBlackjack = dealer.getHandValue() == 21;

        if (playerBlackjack && dealerBlackjack) {
            System.out.println("Push. Both player and dealer got Blackjack.");
            pushes++;
        } else if (playerBlackjack) {
            System.out.println("Blackjack! You won.");
            wins++;
        } else if (dealerBlackjack) {
            System.out.println("Dealer got Blackjack. Dealer won.");
            losses++;
        }
    }

    private void checkFinalOutcomes() {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        if (playerValue == dealerValue) {
            System.out.println("Push.");
            pushes++;
        } else if (playerValue > dealerValue) {
            System.out.println("You win!");
            wins++;
        } else {
            System.out.println("Dealer win.");
            losses++;
        }
    }

    public void printFinalScore() {
        System.out.println("Final Scores:");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Pushes: " + pushes);
    }

}
