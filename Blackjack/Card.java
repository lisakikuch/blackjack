// Define the Suit enum
enum Suit {
    SPADES, CLUBS, DIAMONDS, HEARTS
}

// Define the Value enum
enum Value {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

public class Card {

    private Value value;
    private Suit suit;

    //Constructor
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    // Return the card as a string
    public String printCard(){
        return this.value + " of " + this.suit;
    }

    // Return the card value instance
    public Value getValue() {
        return this.value;
    }

    // Return the card suit instance
    public Suit getSuit() {
        return suit;
    }

    // Swith the value to a numeric value 
    public int getNumericValue() {
        switch (this.value) {
            case ACE:
                return 11;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            default:
                throw new IllegalAccessError(null);
        }
    }

}
