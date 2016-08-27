package main.java;
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
		Collections.sort(hand, Collections.reverseOrder());
	
		//tests if there are no duplicate cards in the hand
		//also test for invalid cards, such as ranks and suits of null
		for(int i = 0; i < hand.size(); i++){
			//test for invalid cards
			if(hand.get(i) == null || hand.get(i).getRank() == null || hand.get(i).getSuit() == null){
				throw new NullPointerException();
			}
			//test for copies
			for(int j = i+1; j < hand.size(); j++){
				if(hand.get(i).equals(hand.get(j))){
					throw new DuplicateCardException(); 
				}
			}
		}
		
		//find the value of this hand and store it into the value variable
		value = calculateValue();
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
	 * [2, 6, 4, 3]
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
	 * when passed to is RoyalFlush would return
	 * [A, King, Queen, jack, 10]
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
	 * [A, 4, 3, 2]
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
	private long calculateValue() {
		List<Integer> output = null;
		
		//checks for StraightFlush and Straight
		output = isStraight();
		if(output != null){
			if(isFlush() != null){
				return calculateHandValue(output,PokerHandRankings.STRAIGHT_FLUSH);
			} else {
				return calculateHandValue(output,PokerHandRankings.STRAIGHT);
			}
		}
		
		//checks for flush
		output = isFlush();
		if(output != null){
			return calculateHandValue(output,PokerHandRankings.FLUSH);
		}
		
		//checks for four of a kind
		output = hasYNumberOfXofaKind(1,4);
		if(output != null){ 
			return calculateHandValue(output,PokerHandRankings.FOUR_OF_A_KIND);
		}
		
		//checks for full house and 3 of a kind 
		output = hasYNumberOfXofaKind(1,3);
		if(output != null){
			if(hasYNumberOfXofaKind(1,2) != null){
				return calculateHandValue(output,PokerHandRankings.FULL_HOUSE);
			} else {
				return calculateHandValue(output,PokerHandRankings.THREE_OF_A_KIND);
			}
		}
		
		//checks for two pairs
		output = hasYNumberOfXofaKind(2,2);
		if(output != null){
			return calculateHandValue(output,PokerHandRankings.TWO_PAIR);
		}
		
		//checks for two of a kind
		output = hasYNumberOfXofaKind(1,2);
		if(output != null){
			return calculateHandValue(output,PokerHandRankings.PAIR);
		}
		
		//format output for high card
		output = new LinkedList<>();
		for(Card card : hand)
			output.add(card.getRank().getValue());
		
		return calculateHandValue(output,PokerHandRankings.HIGH);
	}
	
	/*
	 * This function takes the value of the cards as well as the type of hand
	 * into consideration when it calculates the value.
	 * It iterates through the list and multiplies it by the value of the type
	 * through each iteration the value is decreased by a factor of 100
	 * This would encode a value like 
	 * 14,13,12,11,9 with a type of HighCard into a number
	 * 1413121109 or 1,413,121,109
	 * this number would be easily comparable to a hand such as
	 * 13,12,11,10,8
	 * which would be encode with the type of HighCard into
	 * 1312111008 or 1,312,111,008 where
	 * A,K,Q,J,9 = 1,413,121,109,
	 * K,Q,J,10,8 = 1,312,111,008 and
	 * A,K,Q,J,9 > K,Q,J,10,8,
	 * 1,413,121,109 > 1,312,111,008
	 */
	private long calculateHandValue(List<Integer> cardRanks, PokerHandRankings type){
		long multiplier = type.getValue();
		long result = 0;
		//for each rank add the number * the multiplier
		//the divide the multiplier by 100
		for(Integer rank : cardRanks){
			result += rank * multiplier;
			multiplier /= 100;
		}
		
		return result;
	}
	
	/*
	 * Returns a formatted card array if the hand is has an X of a kind, null otherwise
	 * The format will be from highest to lowest, starting with the X of a kind
	 * For example 
	 * 
	 * when y is 1 and x is 4 then the method looks for a four of a kind
	 * when y is 2 and x is 2 then the method looks for 2 pairs
	 * when y is 1 and x is 3 then the method looks for a three of a kind
	 * 
	 * when y = 1 x = 4
	 * [3 of Spades, 3 of Diamonds, 3 of Hearts, 3 of Clubs, 10 of Spades] 
	 * would return 
	 * [3, 10] 
	 * 
	 * when y = 1 x = 2
	 * [3 of Spades, 3 of Diamonds, 3 of Hearts, 3 of Clubs, 10 of Spades] 
	 * would return 
	 * null
	 * 
	 * when y= 1 x = 2
	 * [3 of Spades, 3 of Diamonds, 6 of Hearts, 7 of Clubs, 10 of Spades] 
	 * would return 
	 * [3, 10, 7, 6]
	 * 
	 * [J of Spades, 6 of Spades, A of Spades, 5 of Spades, 2 of Spades]
	 * would return
	 * null
	 */
	private List<Integer> hasYNumberOfXofaKind(int y, int x){
		//creates a new array where each index represents a cards rank, value stores the occurrences
		int[] frequency = new int[13]; 
		//creates a new Linked list to format the output
		LinkedList<Integer> output = new LinkedList<>();
		//this represents a list of all the other outputs that are not an x of a kind
		LinkedList<Integer> other = new LinkedList<>();
		int maxFrequency = 0;
				
		//loops through all of the cards in the hand and counts their 
		//Occurrences by storing the number of times the occur in the frequencies
		for(Card card : hand){
			if(frequency[card.getRank().getValue()-2] == 0){
				output.add(card.getRank().getValue());
			}
			int temp = ++frequency[card.getRank().getValue()-2];
			maxFrequency = (maxFrequency < temp)?temp:maxFrequency;
		}
		
		//loops through all of the possible frequencies
		//then checks if any are equal to 2
		if(maxFrequency >= x){
			for(int i = 0; i < frequency.length; i++){
				if(frequency[i] == x){
					output.remove(new Integer(i+2));
					output.addFirst(i+2);
				} else if (frequency[i] >= 1){
					other.add(i+2);
					output.remove(new Integer(i+2));
				}
			}
					
			if(output.size() == y){
				Collections.sort(output, Collections.reverseOrder());
				output.addAll(other);
				return output;
			}
		}
		return null;
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
		//linked list to format the output
		LinkedList<Integer> output = new LinkedList<>();
		//boolean represents whether or not a four of a kind was found
		Suit flushSuit = hand.get(0).getSuit();
		//tests if all cards are of the same suit
		for(Card card : hand){
			if(card.getSuit() != flushSuit){
				return null;
			}
			output.add(card.getRank().getValue());
		}
		//return the output if the hand is a flush
		return output;
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
		//linked list to format the output
		LinkedList<Integer> output = new LinkedList<>();
		//check if every card is 1 less then the previous card
		int[] aceLowStraightExample = new int[] {14,5,4,3,2};
		boolean isAceLow = true;
		boolean isStraight = true;
		
		for(int i = 0; i < hand.size(); i++){
			if(i >= 1 && hand.get(i).getRank().getValue() + 1 != hand.get(i-1).getRank().getValue()){
				isStraight = false;
			} 
			if(hand.get(i).getRank().getValue() !=  aceLowStraightExample[i]){
				isAceLow = false;
			}
			output.add(hand.get(i).getRank().getValue());
		}

		if(isStraight){
			return output;
		} else if (isAceLow){
			output.add(output.pop());
			return output;
		} else {
			return null;
		}
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
	
	//equals method used in testing
	public boolean equals(PokerHand o){
		for(int i = 0; i < hand.size(); i++){
			if(!hand.get(i).equals(o.hand.get(i))){
				return false;
			}
		}
		return true;
	}

}
