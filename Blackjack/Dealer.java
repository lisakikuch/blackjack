// Inherit the attributes and methods from the Player class
public class Dealer extends Player {
    public Dealer() {
        super();
    }
    // Make addtional methods that do not exist in the player class

    @Override
    // Override to print only the first card
    public void printHand() {
        if (!getHand().getCards().isEmpty()) {
            Card fisrtCard = getHand().getCards().get(0);
            System.out.println("Dealer's first card: " + fisrtCard.printCard());
        } else {
            System.out.println("Dealer's hand is empty.");
        }
    }

    /* Reveal all cards in the hand
    *  It will used at the end of the round.
    */
    public void printFullHand() {
        if (!getHand().getCards().isEmpty()) {
            System.out.println("Dealer's full hand: ");
            for (Card card : getHand().getCards()) {
                System.out.println(card.printCard());
            }
        }
    }

    // Make sure the dealer continues to draw cards until the sum of their card values exceeds 17.
    public void dealerHit(Deck deck) {
    while (getHandValue() < 17) {
        receiveCard(deck.dealCard());
        System.out.println("Dealer hit.");
    }}

}
