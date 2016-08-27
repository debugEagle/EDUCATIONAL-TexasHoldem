package main.java;
/**
 * This class contains all the different types of valid poker hand combinations
 * as well as stores an associated value with each constant
 * @author Jonathon Davis
 */
public enum PokerHandRankings {
	STRAIGHT_FLUSH(1E16), FOUR_OF_A_KIND(1E15), FULL_HOUSE(1E14), FLUSH(1E13), STRAIGHT(1E12), 
	THREE_OF_A_KIND(1E11), TWO_PAIR(1E10), PAIR(1E9), HIGH(1E8);

	// the value of this poker hand
	private long value;

	//converts the double notation used above into a long
	private PokerHandRankings(double value) {
		this.value = (long) value;
	}

	/**
	 * @return the value
	 */
	public long getValue() {
		return value;
	}

}
