/**
 * defines several constants which will be used by the PokerHand class to calculate
 * the value of a PokerHand
 */
package model;

/**
 * This class contains all the different types of valid poker hand combinations
 * as well as stores an associated value with each constant
 * 
 * @author Jonathon Davis
 */
public enum PokerHandRankings {
	STRAIGHT_FLUSH("Straight Flush", 1E16), FOUR_OF_A_KIND("Four of a Kind", 1E15), FULL_HOUSE("Full House",
			1E14), FLUSH("Flush", 1E13), STRAIGHT("Straight", 1E12), THREE_OF_A_KIND("Three of a Kind",
					1E11), TWO_PAIR("Two Pair", 1E10), PAIR("Pair", 1E9), HIGH("High", 1E8);

	// the value of this poker hand
	public final long value;
	public final String name;

	// converts the double notation used above into a long
	private PokerHandRankings(String name, double value) {
		this.name = name;
		this.value = (long) value;
	}

}
