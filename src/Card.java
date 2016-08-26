/**
 * @author Jonathon Davis
 */
public class Card {
	
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

}
