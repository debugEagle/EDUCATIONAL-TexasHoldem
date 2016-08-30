/**
 * The Rank enum is used to define several constants which represent
 * The ranks in a normal set of playing cards
 */
package main.java;
/**
 * The Rank enumerated class represents the value of cards in an average playing card deck.
 * The class contains 13 ranks from Deuce to Ace in which it assigns values from 2 to 14 for each rank.
 * @author Jonathon Davis
 */
public enum Rank {
	Duece(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13), Ace(14);
	
	//this field stores the value associated with the rank
	private final int value;
	
	
	/**
	 * @param value The value associated with the rank
	 */
	Rank(final int value){
		this.value = value;
	}

	/**
	 * @return The value associated with the Rank
	 */
	public int getValue() {
		return value;
	}

}
