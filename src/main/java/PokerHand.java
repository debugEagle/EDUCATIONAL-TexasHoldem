/**
 * A class used to construct PokerHand Objects which can be used to compare
 * to other PokerHands
 */
package main.java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static main.java.PokerHandRankings.*;

/**
 * The PokerHand class is created with five cards and can be used to compare
 * PokerHands to other PokerHands following the basic rules of poker such as a
 * royal flush beats a full house which beats a pair which beats a high card and
 * all the other common rules in between.
 * 
 * @author Jonathon Davis
 */
public final class PokerHand implements Comparable<PokerHand> {
	private final long value;      // the stored calculated value of the hand
	private final List<Card> hand; // the cards contained in the hand

	/**
	 * The constructor for the class PokerHand takes in Five cards as it's input
	 * PokerHands can be used to compare to other PokerHands
	 * 
	 * @param C1 The first Card
	 * @param C2 The second Card
	 * @param C3 The third Card
	 * @param C4 The fourth Card
	 * @param C5 The fifth Card
	 */
	public PokerHand(Card C1, Card C2, Card C3, Card C4, Card C5) {
		// all the cards will be stored in a collection of cards,
		hand = new ArrayList<>();
		hand.add(C1);
		hand.add(C2);
		hand.add(C3);
		hand.add(C4);
		hand.add(C5);
		Collections.sort(hand, Collections.reverseOrder());

		// tests if there are duplicate cards in the hand
		for (int i = 0; i < hand.size(); i++)
			for (int j = i + 1; j < hand.size(); j++)
				if (hand.get(i).equals(hand.get(j)))
					throw new DuplicateCardException();

		// find the value of this hand and store it into the value variable
		value = findValue();
	}

	/*
	 * Calculates the value of the hand For Example
	 * 
	 * consider the following hand [2 of spades, 2 of hearts, 3 of spades, 4 of
	 * diamonds, 6 of hearts] is a pair, when the hand is calls 
	 * hasXofAKind(2,1,occurrences) it will receive [2, 6, 4, 3] Since it received 
	 * an array rather then null it knows the value is a pair, so it will multiply 
	 * the first value of the card by the constant for a pair, 1E9, Then it will multiply
	 * each subsequent card by 1 * 10 ^ (the last value - 2) So this hand will
	 * be expressed as having a value of 2 * 1E9 + 6 * 1E7 + 4 * 1E5 + 3 * 1E3
	 * This is expanded as 2,000,000,000 + 60,000,000 + 400,000 + 3000 or
	 * 2,060,403,000
	 * 
	 * if we had another hand, such as the highest possible hand lower than a
	 * pair [A of spades, King of spades, Queen of spades, Jack of spades, 9 of
	 * hearts] since this is not any special, it will calculate the values as
	 * function and it will receive [14, 13, 12, 11, 9] It will then start 
	 * its multiplication with the HIGH constant of 1E8 so the hand will be 
	 * expressed as 14*1E8 + 13*1E6 + 12*1E4 + 11*1E2 + 9*1E0 This is expanded 
	 * as 1,400,000,000 + 13,000,000 + 120,000 + 1,100 + 9 1,413,121,109
	 * 
	 * when the two hands are compared the value of the pair of 2s, will be
	 * higher then the best possible high card combo 2,060,403,000 >
	 * 1,413,121,109
	 * The value accurately represents that a pair of aces is larger than a pair
	 * of twos. each subsequent tier can be represented this way with each tiers
	 * constant increasing by a factor of 10
	 * 
	 */
	private long findValue() {
		List<Integer> output = null;

		// checks for StraightFlush and Straight
		output = isStraight();
		if (output != null)
			if (isFlush() != null)
				return getValue(output, STRAIGHT_FLUSH);
			else
				return getValue(output, STRAIGHT);

		// checks for flush
		output = isFlush();
		if (output != null)
			return getValue(output, FLUSH);

		//get the occurrences of ranks to test for four, three, two of a kind
		Map<Integer, Integer> occurrences = getFrequencies();
		
		// checks for four of a kind
		output = hasXofAKind(4, 1,occurrences);
		if (output != null)
			return getValue(output, FOUR_OF_A_KIND);

		// checks for full house and 3 of a kind
		output = hasXofAKind(3, 1,occurrences);
		if (output != null)
			if (hasXofAKind(2, 1,occurrences) != null)
				return getValue(output, FULL_HOUSE);
			else
				return getValue(output, THREE_OF_A_KIND);

		// checks for two pairs
		output = hasXofAKind(2, 2,occurrences);
		if (output != null)
			return getValue(output, TWO_PAIR);

		// checks for two of a kind
		output = hasXofAKind(2,1,occurrences);
		if (output != null)
			return getValue(output, PAIR);

		// format output for high card
		output = new LinkedList<>();
		for (Card card : hand)
			output.add(card.getRank().getValue());

		return getValue(output, HIGH);
	}

	/*
	 * This function acts as a helper function to the calculateValue()
	 * and performs the arithmetic to convert the hand into a long value
	 * The process is described more in the calculateValue notes
	 */
	private long getValue(List<Integer> cardRanks, PokerHandRankings type) {
		long multiplier = type.getValue();
		long result = 0;
		for (Integer rank : cardRanks) {
			result += rank * multiplier;
			multiplier /= 100;
		}
		return result;
	}

	/*
	 * X = number of occurrences needed: example 3 of a kind
	 * Y= number of times X needs to occur: example 2 pair
	 * occurrences = formated map of rank as key occurrences as value
	 * 
	 * when y is 1 and x is 4 then the method looks for a four of a kind when y
	 * is 2 and x is 2 then the method looks for 2 pairs when y is 1 and x is 3
	 * then the method looks for a three of a kind
	 * 
	 * when y = 1 x = 4 [3 of Spades, 3 of Diamonds, 3 of Hearts, 3 of Clubs, 10
	 * of Spades] would return [3, 10]
	 * 
	 * when y = 1 x = 2 [3 of Spades, 3 of Diamonds, 3 of Hearts, 3 of Clubs, 10
	 * of Spades] would return null
	 */
	private List<Integer> hasXofAKind(int x, int y, Map<Integer, Integer> occurrences) {
		LinkedList<Integer> output = new LinkedList<>(); //stores output
		LinkedList<Integer> other = new LinkedList<>(); //stores highcards
		int numOfY = 0;
		//add the elements to the output
		for(Map.Entry<Integer,Integer> entry : occurrences.entrySet())
			if(entry.getValue() == x){
				output.push(entry.getKey());
				numOfY++;
			}
			else {
				other.push(entry.getKey());
			}
		//combine the two lists
		output.addAll(other);
		return (numOfY == y)?output:null;
	}
	
	/*
	 * finds the occurrences of ranks and stores them in a map
	 * used in the hasXofAKind method
	 */
	private Map<Integer,Integer> getFrequencies(){
		Map<Integer, Integer> occurrences = new TreeMap<>();
		for(Card card : hand)
			if (occurrences.containsKey(card.getRank().getValue()))
				occurrences.put(card.getRank().getValue(), occurrences.get(card.getRank().getValue()) + 1);
	        else
	        	occurrences.put(card.getRank().getValue(), 1);
		return occurrences;
	}

	/*
	 * Returns a formatted card array if the hand is a Flush, null otherwise The
	 * format will be from highest to lowest
	 * 
	 * [3 of Spades, 4 of Spades, 7 of Spades, 10 of Spades, 2 of Spades] would
	 * return [3, 4, 7, 10, 2]
	 * 
	 * [3 of Spades, 3 of Diamonds, 3 of Hearts, 3 of Clubs, 10 of Spades] would
	 * return null
	 */
	private List<Integer> isFlush() {
		// linked list to format the output
		LinkedList<Integer> output = new LinkedList<>();
		// boolean represents whether or not a four of a kind was found
		Suit flushSuit = hand.get(0).getSuit();
		// tests if all cards are of the same suit
		for (Card card : hand) {
			if (card.getSuit() != flushSuit)
				return null;
			output.add(card.getRank().getValue());
		}
		// return the output if the hand is a flush
		return output;
	}

	/*
	 * Returns a formatted card array if the hand is a Straight, null otherwise
	 * The format will be from highest to lowest For example
	 * 
	 * [A of Hearts, 5 of Spades, 4 of Spades, 3 of Spades, 2 of Spades] would
	 * return [5, 4, 3, 2, A]
	 * 
	 * [J of Spades, 6 of Spades, A of Spades, 5 of Spades, 2 of Spades] would
	 * return null
	 */
	private List<Integer> isStraight() {
		// linked list to format the output
		LinkedList<Integer> output = new LinkedList<>();
		int[] aceLowStraightExample = new int[] { 14, 5, 4, 3, 2 };
		boolean isAceLow = true;
		boolean isStraight = true;

		for (int i = 0; i < hand.size(); i++) {
			if (i >= 1 && hand.get(i).getRank().getValue() + 1 != hand.get(i - 1).getRank().getValue()) 
				isStraight = false;
			if (hand.get(i).getRank().getValue() != aceLowStraightExample[i]) 
				isAceLow = false;
			output.add(hand.get(i).getRank().getValue());
		}

		if (isStraight) {
			return output;
		} else if (isAceLow) {
			output.add(output.pop());
			return output;
		} else {
			return null;
		}
	}

	/*
	 * This function compares two hands and checks to see if these hands contain any duplicate
	 * cards. If one hand contains an Ace of Spades and another hand contains an Ace of spades
	 * Then calculating, or comparing them will be difficult
	 */
	private static boolean hasDuplicate(final List<Card> handOne, final List<Card> handTwo) {
		// for every card in handOne check everyCard in handTwo, return true if
		// there is a duplicate
		for (Card cardOne : handOne)
			for (Card cardTwo : handTwo)
				if (cardOne.getRank() == cardTwo.getRank() && cardOne.getSuit() == cardTwo.getSuit())
					return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(PokerHand o) {
		if (hasDuplicate(this.hand, o.hand))
			throw new DuplicateCardException();
		long calc = this.value - o.value;
		return (calc >= 0)?(calc > 0)?1:0:-1;
	}
	
	//The below functions are mostly just used in testing
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof PokerHand && obj.hashCode() == this.hashCode())
			return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (int) (value ^ (value >>> 32));
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PokerHand [" + "hand=" + hand + "]";
	}
}
