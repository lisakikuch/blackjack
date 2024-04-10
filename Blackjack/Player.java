import java.util.ArrayList;

public class Player {
    private Hand hand;

    public Player() {
        this.hand = new Hand();
    }
    // Clear out old cards to begin a new round.
    public void clearHand() {
        this.hand.clearHand();
    }

    public Hand getHand() {
        return this.hand;
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public void printHand() {
        hand.printCards();
    }

    public int getHandValue() {
        return hand.calculateTotal();
    }
    
    // Check if the player has busted
    public boolean isBust() {
        return getHandValue() > 21;
    }

    public void hit(Deck deck) {
        Card drawnCard = deck.dealCard();// Draw a card from the deck
        this.hand.addCard(drawnCard);// Add the drawn card to the player's hand
    }

    // Inner Hand class
    public class Hand {
        private ArrayList<Card> cards;

        public void clearHand() {
            cards.clear();
        }

        public Hand() {
            this.cards = new ArrayList<>();
        }

        public void addCard(Card card) {
            cards.add(card);
        }

        public void printCards() {
            for (Card card: cards) {
                System.out.println(card.printCard());
            }
        }

        public ArrayList<Card> getCards() {
            return cards;
        }

        // Get the total value
        public int calculateTotal() {
            // Initilize the total and the number of ACE
            int total = 0;
            int acesCount = 0;

            // Iterete over the cards in hand
       for (Card card : cards) {
                // Get values of the cards and add to the total
                int value = card.getNumericValue();
                total += value;
                // Count the number of ACEs, if it is in hand
                if (card.getValue() == Value.ACE) {
                    acesCount++;
                }
            }     
            /* If there are ACEs in hand, which is worth 11 and the total is going to be over 21,
            substract 10 for each ACE to prevent the player from busting */
            while (total > 21 && acesCount > 0) {
                // Adjusting an Ace from 11 to 1
                total -= 10;
                acesCount--; 
            }
            return total;
        }

    }
    
}
