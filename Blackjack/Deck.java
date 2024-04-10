import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

        /* An array list to contain the card suits and values. 
         * It will go through all suits and values and add them to the list.
        */
        public Deck() {
            this.cards = new ArrayList<Card>();
            for (Suit suit : Suit.values()) {
                for (Value value : Value.values()) {
                    cards.add(new Card(suit, value));
                }
            }
        }

        // Use the java utility to shuffle the deck.
        public void shuffle() {
            Collections.shuffle(this.cards);
        }

        /* Check if the deck is empty
         * This method will be used to determine if the game proceeds
         */        
        public boolean isEmpty() {
            return cards.isEmpty();
        }

        // Deal a single card from the deck (the first card will have an index no.0)
        public Card dealCard() {
            if(!isEmpty()) {
                return this.cards.remove(0);
            } else {
                return null;
            }
        }
        
}
