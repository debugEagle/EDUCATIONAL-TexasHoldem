package main.java;
/**
 * The Card class creates objects that represent cards found in an average playing card deck.
 * Each Card object contains a suit and a rank, where a Suit can be any Suit enumerated object,
 * and the rank can be any Rank enumerated object. If the suit of a card is Clubs and the Rank
 * is 8, then that card represents an 8 of clubs.
 * @author Jonathon Davis
 */
public class Card implements Comparable<Card> {
	
	private Rank cardRank; // Stores the rank associated with the card
	private Suit cardSuit; // Stores the suit associated with the card

	/**
	 * @param rank The rank associated with the card
	 * @param suit The suit associated with the card
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Card o) {
		return this.cardRank.getValue() - o.cardRank.getValue();
	}
	
	/**
	 * returns true if both the rank and suit are the same for both cards
	 * @param o the other object to compare to
	 * @return true if both rank and suit are the same, false otherwise
	 */
	public boolean equals(Card o) {
		if(this.getRank() == o.getRank() && this.getSuit() == o.getSuit()){
			return true;
		}
		return false;
	}


}