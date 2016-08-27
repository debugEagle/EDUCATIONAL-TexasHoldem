import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * The PokerHand class is created with five cards and can be used to compare
 * PokerHands to other PokerHands following the basic rules of poker such as
 * a royal flush beats a full house which beats a pair which beats a high card
 * and all the other common rules in between
 * @author Jonathon Davis
 */
public final class PokerHand implements Comparable<PokerHand> {
	//Constant Methods used to calculate the value of a hand
	private static final long STRAIGHT_FLUSH = (long) 1E16, FOUR_OF_A_KIND = (long) 1E15, FULL_HOUSE = (long) 1E14,
			FLUSH = (long) 1E13, STRAIGHT = (long) 1E12, THREE_OF_A_KIND = (long) 1E11, TWO_PAIR = (long) 1E10,
			PAIR = (long) 1E9, HIGH = (long) 1E8;
	//the stored value of a hand, used for compares
	private final long value;
	//the cards contained in the hand
	private final List<Card> hand;

	/**
	 * The constructor for the class PokerHand takes in Five cards as it's input
	 * PokerHands can be used to compare to other PokerHands
	 * @param C1 The first Card
	 * @param C2 The second Card
	 * @param C3 the third Card
	 * @param C4 the fourth Card
	 * @param C5 the fifth Card
	 */
	public PokerHand(Card C1, Card C2, Card C3, Card C4, Card C5) {
		//all the cards will be stored in a collection of cards,
		
		hand = new ArrayList<>();
		hand.add(C1);
		hand.add(C2);
		hand.add(C3);
		hand.add(C4);
		hand.add(C5);
		Collections.sort(hand);
	
		for(int i = 0; i <= hand.size(); i++){          //test every card given
			for(int j = i+1; j < hand.size(); j++){     //except for itself
				if(hand.get(i).equals(hand.get(j))){    //if it is equal to another card
					throw new DuplicateCardException(); //Throw a new exception
				}
			}
		}
		
		//find the value of this hand and store it into the value variable
		value = getValue();
	}
	
	/*
	 * Calculates the value of the hand
	 * For Example
	 * 
	 * Note the follow examples will not take duplicates into consideration, although the compare function
	 * does consider card duplicates, this example will not fo the sake of simplicity
	 * 
	 * consider the following hand
	 * [2 of spades, 2 of hearts, 3 of spades, 4 of diamonds, 6 of hearts]
	 * is a pair, when the hand is passed to the isPair() function it will receive
	 * [2 of null, 6 of null, 4 of null, 3 of null]
	 * Since it received an array rather then null it knows the value is a pair, so it
	 * will multiply the first value of the card by the constant for a pair 1E8, Then it
	 * will multiply each subsequent card by 1 * 10 ^ (the last value - 2)
	 * So this hand will be expressed as having a value of
	 * 2 * 1E9 + 6 * 1E7 + 4 * 1E5 + 3 * 1E3
	 * This is expanded as 
	 * 2,000,000,000 + 60,000,000 + 400,000 + 3000
	 * or
	 * 2,060,403,000
	 * 
	 * if we had another hand, such as the highest possible hand lower than a pair
	 * [A of spades, King of spades, Queen of spades, Jack of spades, 9 of hearts]
	 * since this is not any special hand it is passed to the isHigh() function and it will receive
	 * [A of null, King of null, Queen of null, Jack of null, 9 of null]
	 * It will then start its multiplication with the HIGH constant of 1E8
	 * so the hand will be expressed as
	 * 14*1E8 + 13*1E6 + 12*1E4 + 11*1E2 + 9*1E0
	 * This is expanded as
	 * 1,400,000,000 + 13,000,000 + 120,000 + 1,100 + 9 
	 * 1,413,121,109
	 * 
	 * when the two hands are compared the value of the pair of 2s, will be higher then the best possible high card combo
	 * 2,060,403,000 > 1,413,121,109
	 * 
	 * This continues up to a royal flush
	 * [A of spades, King of spades, Queen of spades, Jack of spades, 10 of spades]
	 * when passed to isRoyalFlush would return
	 * [A of null, King of null, Queen of null, jack of null, 10 of null]
	 * we would use the Straight flush constant of 1E16
	 * 14 * 1E16 + 13 * 1E14 + 12 * 1E12 + 11 * 1E10 + 10 * 1E8
	 * 14000000000000000 + 130000000000000 + 12000000000 + 100000000
	 * 14,131,211,100,000,000
	 * 
	 * 14,131,211,100,000,000 > 2,060,403,000 > 1,413,121,109
	 * so Royal flush beats pair which beats high,
	 * This number is stored in a long since it is less than a long, but large than an int
	 *    Max Int          Max PokerHandValue     Max Long
	 * 2,147,483,647 < 14,131,211,100,000,000 < 9,223,372,036,854,775,807
	 * 
	 * This works for hands of the same type as well for example
	 * [A of spades, A of Diamonds, 2 of hearts, 3 of spades, 4 of hearts]
	 * This hand is a pair and after passed to the isPair function, a Card[] will be returned like this
	 * [A of null, 4 of null, 3 of null, 2 of null]
	 * with the calculation of a pair
	 * 14 * 1E9 + 4 * 1E7 + 3 * 1E5 + 2 * 1E3
	 * This is expanded as 
	 * 14,000,000,000 + 40,000,000 + 300,000 + 2000
	 * or
	 * 14,040,302,000
	 * 
	 * now when we compare out pair of Aces to our pair of Twos we see
	 * 14,040,302,000 > 2,060,403,000
	 * 
	 * The value accurately represents that a pair of aces is larger than a pair of twos
	 * 
	 */
	private long getValue() {
		List<Integer> output = null;
		
		//checks for StraightFlush and Straight
		output = isStraight();
		if(output != null){
			if(isFlush() != null){
				return calculateValue(output,STRAIGHT_FLUSH);
			} else {
				return calculateValue(output,STRAIGHT);
			}
		}
		
		//checks for flush
		output = isFlush();
		if(output != null){
			return calculateValue(output,FLUSH);
		}
		
		//checks for of a kind
		output = hasXOfAKind(4);
		if(output != null){ 
			return calculateValue(output,FOUR_OF_A_KIND);
		
		}
		
		//checks for full house and 3 of a kind 
		output = hasXOfAKind(3);
		if(output != null){
			if(hasXOfAKind(2) != null){
				return calculateValue(output,FULL_HOUSE);
			} else {
				return calculateValue(output,THREE_OF_A_KIND);
			}
		}
		
		//checks for two pairs
		output = isTwoPair();
		if(output != null){
			return calculateValue(output,TWO_PAIR);
		}
		
		//checks for two of a kind
		output = hasXOfAKind(2);
		if(output != null){
			return calculateValue(output,PAIR);
		}
		
		return calculateValue(output,HIGH);
	}
	

	private long calculateValue(List<Integer> output, long multiplier){
		return -1;
	}
	
	/*
	 * Returns a formatted card array if the hand is has an X of a kind, null otherwise
	 * The format will be from highest to lowest, starting with the X of a kind
	 * For example 
	 * 
	 * when x = 4
	 * [3 of Spades, 3 of Diamonds, 3 of Hearts, 3 of Clubs, 10 of Spades] 
	 * would return 
	 * [3, 10] 
	 * 
	 * when x = 2
	 * [3 of Spades, 3 of Diamonds, 3 of Hearts, 3 of Clubs, 10 of Spades] 
	 * would return 
	 * null
	 * 
	 * when x = 2
	 * [3 of Spades, 3 of Diamonds, 6 of Hearts, 7 of Clubs, 10 of Spades] 
	 * would return 
	 * [3, 10, 7, 6]
	 * 
	 * [J of Spades, 6 of Spades, A of Spades, 5 of Spades, 2 of Spades]
	 * would return
	 * null
	 */
	private List<Integer> hasXOfAKind(int x){
		//creates a new array where each index represents a cards rank, value stores the occurrences
		int[] frequency = new int[13]; 
		//creates a new Linked list to format the
		LinkedList<Integer> output = new LinkedList<>();
		//boolean represents whether or not a four of a kind was found
		boolean foundXOfAKind = false;
		
		//loops through all of the cards in the hand and counts their 
		//Occurrences by storing the number of times the occur in the frequencies
		for(Card card : hand){
			if(frequency[card.getRank().getValue()-1] == 0){
				output.add(card.getRank().getValue());
			}
			frequency[card.getRank().getValue()-1]++;
		}
		
		//loops through all of the possible frequencies
		//then checks if any are equal to x
		for(int i = 0; i < frequency.length; i++){
			if(frequency[i] == x){
				output.remove(new Integer(i));
				output.addFirst(i);
				foundXOfAKind = true;
			}
		}
		//return the output if a X of a kind was found, null otherwise
		return (foundXOfAKind)?output:null;
	}
	
	/*
	 * Returns a formatted card array if the hand is a Flush, null otherwise
	 * The format will be from highest to lowest
	 * 
	 * [3 of Spades, 4 of Spades, 7 of Spades, 10 of Spades, 2 of Spades] 
	 * would return 
	 * [3, 4, 7, 10, 2]
	 * 
	 * [3 of Spades, 3 of Diamonds, 3 of Hearts, 3 of Clubs, 10 of Spades] 
	 * would return
	 * null
	 */
	private List<Integer> isFlush(){
		return null;
	}
	
	/*
	 * Returns a formatted card array if the hand is a Straight, null otherwise
	 * The format will be from highest to lowest
	 * For example 
	 * 
	 * [A of Hearts, 5 of Spades, 4 of Spades, 3 of Spades, 2 of Spades] 
	 * would return 
	 * [5, 4, 3, 2, A] 
	 * 
	 * [J of Spades, 6 of Spades, A of Spades, 5 of Spades, 2 of Spades]
	 * would return
	 * null
	 */
	private List<Integer> isStraight(){
		return null;
	}
	
	
	/*
	 * Returns a formatted card array if the hand is a Two Pairs, null otherwise
	 * The format will be from highest to lowest, starting with the 2 pairs
	 * For example 
	 * 
	 * [3 of Spades, 3 of Diamonds, 7 of Hearts, 7 of Clubs, 10 of Spades] 
	 * would return 
	 * [7, 3, 10] 
	 * 
	 * [J of Spades, 6 of Spades, A of Spades, 5 of Spades, 2 of Spades]
	 * would return
	 * null
	 */
	private List<Integer> isTwoPair(){
		return null;
	}
	
	
	//Tests whether there are any duplicate cards in the two hands
	private static boolean hasDuplicate(final List<Card> handOne, final List<Card> handTwo){
		//for every card in handOne check everyCard in handTwo, return true if there is a duplicate
		for(Card cardOne : handOne){
			for(Card cardTwo : handTwo){
				if(cardOne.getRank() == cardTwo.getRank() && cardOne.getSuit() == cardTwo.getSuit()){
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(PokerHand o) {
		if (hasDuplicate(this.hand,o.hand)) throw new DuplicateCardException();
		long calc = this.value - o.value;
		
		if(calc > 0){
			return 1;
		} else if (calc < 0){
			return -1;
		} else {
			return 0;
		}
	}

}
