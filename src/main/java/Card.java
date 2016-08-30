/**
 * A class used to construct Card objects which represents 
 * 1 of 52 playing cards
 */
package main.java;

/**
 * The Card class creates objects that represent cards found in an average
 * playing card deck. Each Card object contains a suit and a rank, where a Suit
 * can be any Suit enumerated object, and the rank can be any Rank enumerated
 * object. If the suit of a card is Clubs and the Rank is 8, then that card
 * represents an 8 of clubs.
 * 
 * @author Jonathon Davis
 */
public class Card implements Comparable<Card> {

	private Rank cardRank; // Stores the rank associated with the card
	private Suit cardSuit; // Stores the suit associated with the card

	/**
	 * @param rank
	 *            The rank associated with the card
	 * @param suit
	 *            The suit associated with the card
	 */
	public Card(Rank rank, Suit suit) {
		cardRank = rank;
		cardSuit = suit;
	}

	/**
	 * @return The rank associated with the card
	 */
	public Rank getRank() {
		return cardRank;
	}

	/**
	 * @return The suit associated with the card
	 */
	public Suit getSuit() {
		return cardSuit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Card o) {
		return this.cardRank.getValue() - o.cardRank.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Card && obj.hashCode() == this.hashCode()){
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int suit = 0;
		switch (cardSuit) {
		case Diamonds:
			suit = 1;
			break;
		case Hearts:
			suit = 2;
			break;
		case Spades:
			suit = 3;
			break;
		case Clubs:
			suit = 4;
			break;
		}
		return suit*100+cardRank.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return cardRank.name() + " of " + cardSuit.name();
	}


}
