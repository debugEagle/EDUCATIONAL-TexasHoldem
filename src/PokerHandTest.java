import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jonathon Davis
 *
 */
public class PokerHandTest {

	@Test
	public void testPairBeatsHigh() {
		Card handOneCardOne = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Three,Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.Four,Suit.Diamonds);
		Card handOneCardFive = new Card(Rank.Five,Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen,Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Jack,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Nine,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(1,handOne.compareTo(handTwo));
		assertEquals(-1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testPairLosesToPairHigh() {
		Card handOneCardOne = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Three,Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.Four,Suit.Diamonds);
		Card handOneCardFive = new Card(Rank.Five,Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Queen,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Jack,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(-1,handOne.compareTo(handTwo));
		assertEquals(1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testPairTiesPair() {
		Card handOneCardOne = new Card(Rank.Eight,Suit.Hearts);
		Card handOneCardTwo = new Card(Rank.Eight,Suit.Spades);
		Card handOneCardThree = new Card(Rank.King,Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Six,Suit.Clubs);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Eight,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Eight,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Duece,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Six,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(0,handOne.compareTo(handTwo));
		assertEquals(0,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testTwoPairBeatsPair() {
		Card handOneCardOne = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Three,Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.Three,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Four,Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Queen,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Ten,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(1,handOne.compareTo(handTwo));
		assertEquals(-1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testTwoPairLosesToTwoPairHigh() {
		Card handOneCardOne = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Three,Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.Three,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Four,Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.King,Suit.Clubs);
		Card handTwoCardFive = new Card(Rank.Ten,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(-1,handOne.compareTo(handTwo));
		assertEquals(1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testTwoPairTiesTwoPair() {
		Card handOneCardOne = new Card(Rank.Eight,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Eight,Suit.Hearts);
		Card handOneCardThree = new Card(Rank.King,Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.King,Suit.Spades);
		Card handOneCardFive = new Card(Rank.Four,Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Eight,Suit.Diamonds);
		Card handTwoCardTwo = new Card(Rank.Eight,Suit.Spades);
		Card handTwoCardThree = new Card(Rank.King,Suit.Hearts);
		Card handTwoCardFour = new Card(Rank.King,Suit.Clubs);
		Card handTwoCardFive = new Card(Rank.Four,Suit.Clubs);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(0,handOne.compareTo(handTwo));
		assertEquals(0,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testThreeOfAKindBeatsTwoPair() {
		Card handOneCardOne = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece,Suit.Spades);
		Card handOneCardFour = new Card(Rank.Three,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Four,Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.King,Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Queen,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(1,handOne.compareTo(handTwo));
		assertEquals(-1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testThreeOfAKindLosesToThreeOfAKindHigh() {
		Card handOneCardOne = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece,Suit.Spades);
		Card handOneCardFour = new Card(Rank.Three,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Four,Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Ace,Suit.Spades);
		Card handTwoCardFour = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Queen,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(-1,handOne.compareTo(handTwo));
		assertEquals(1,handTwo.compareTo(handOne));
	}
	
	
	@Test
	public void testStraightBeatsThreeOfAKind() {
		Card handOneCardOne = new Card(Rank.Five,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Four,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Three,Suit.Spades);
		Card handOneCardFour = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Ace,Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace,Suit.Hearts);
		Card handTwoCardThree = new Card(Rank.Ace,Suit.Spades);
		Card handTwoCardFour = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Queen,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(1,handOne.compareTo(handTwo));
		assertEquals(-1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testStraightLosesToStraightHigh() {
		Card handOneCardOne = new Card(Rank.Six,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Five,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Four,Suit.Spades);
		Card handOneCardFour = new Card(Rank.Three,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Duece,Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen,Suit.Spades);
		Card handTwoCardFour = new Card(Rank.Jack,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Ten,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(-1,handOne.compareTo(handTwo));
		assertEquals(1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testStraightTiesStraight() {
		Card handOneCardOne = new Card(Rank.Ace,Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King,Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen,Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.Jack,Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ten,Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardTwo = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen,Suit.Spades);
		Card handTwoCardFour = new Card(Rank.Jack,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Ten,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(0,handOne.compareTo(handTwo));
		assertEquals(0,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testFlushBeatsStraight() {
		Card handOneCardOne = new Card(Rank.Seven,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Five,Suit.Clubs);
		Card handOneCardThree = new Card(Rank.Four,Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Three,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Duece,Suit.Clubs);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen,Suit.Spades);
		Card handTwoCardFour = new Card(Rank.Jack,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Ten,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(1,handOne.compareTo(handTwo));
		assertEquals(-1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testFlushLosesToFlushHigh() {
		Card handOneCardOne = new Card(Rank.Seven,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Five,Suit.Clubs);
		Card handOneCardThree = new Card(Rank.Four,Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Three,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Duece,Suit.Clubs);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardTwo = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen,Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Jack,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Nine,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(-1,handOne.compareTo(handTwo));
		assertEquals(1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testFlushTiesFlush() {
		Card handOneCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.King,Suit.Clubs);
		Card handOneCardThree = new Card(Rank.Queen,Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Jack,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Nine,Suit.Clubs);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardTwo = new Card(Rank.King,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen,Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Jack,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Nine,Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(0,handOne.compareTo(handTwo));
		assertEquals(0,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testFullHouseBeatsFlush(){
		Card handOneCardOne = new Card(Rank.Duece,Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Duece,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Three,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Three,Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.King,Suit.Clubs);
		Card handTwoCardThree = new Card(Rank.Queen,Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.Jack,Suit.Clubs);
		Card handTwoCardFive = new Card(Rank.Nine,Suit.Clubs);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(1,handOne.compareTo(handTwo));
		assertEquals(-1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testFullHouseLosesFullHouseHigh(){
		Card handOneCardOne = new Card(Rank.Duece,Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Duece,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Three,Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Three,Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Ace,Suit.Spades);
		Card handTwoCardFour = new Card(Rank.King,Suit.Clubs);
		Card handTwoCardFive = new Card(Rank.King,Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(-1,handOne.compareTo(handTwo));
		assertEquals(1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testFourOfAKindBeatsFullHouse(){
		Card handOneCardOne = new Card(Rank.Duece,Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Duece,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Duece,Suit.Hearts);
		Card handOneCardFive = new Card(Rank.Three,Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.Ace,Suit.Spades);
		Card handTwoCardThree = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.King,Suit.Clubs);
		Card handTwoCardFive = new Card(Rank.King,Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(1,handOne.compareTo(handTwo));
		assertEquals(-1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testFourOfAKindLosestoFourOfAKindHigh(){
		Card handOneCardOne = new Card(Rank.Duece,Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Duece,Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece,Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Duece,Suit.Hearts);
		Card handOneCardFive = new Card(Rank.Three,Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.Ace,Suit.Spades);
		Card handTwoCardThree = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.King,Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(-1,handOne.compareTo(handTwo));
		assertEquals(1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testStraightFlushBeatsFourOfAKind(){
		Card handOneCardOne = new Card(Rank.Duece,Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Three,Suit.Spades);
		Card handOneCardThree = new Card(Rank.Four,Suit.Spades);
		Card handOneCardFour = new Card(Rank.Five,Suit.Spades);
		Card handOneCardFive = new Card(Rank.Six,Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.Ace,Suit.Spades);
		Card handTwoCardThree = new Card(Rank.Ace,Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.Ace,Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.King,Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(1,handOne.compareTo(handTwo));
		assertEquals(-1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testStraightFlushLosesToStraightFlushHigh(){
		Card handOneCardOne = new Card(Rank.Duece,Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Three,Suit.Spades);
		Card handOneCardThree = new Card(Rank.Four,Suit.Spades);
		Card handOneCardFour = new Card(Rank.Five,Suit.Spades);
		Card handOneCardFive = new Card(Rank.Six,Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.King,Suit.Hearts);
		Card handTwoCardThree = new Card(Rank.Queen,Suit.Hearts);
		Card handTwoCardFour = new Card(Rank.Jack,Suit.Hearts);
		Card handTwoCardFive = new Card(Rank.Ten,Suit.Hearts);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(-1,handOne.compareTo(handTwo));
		assertEquals(1,handTwo.compareTo(handOne));
	}
	
	@Test
	public void testStraightFlushTiesStraightFlush(){
		Card handOneCardOne = new Card(Rank.Ace,Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King,Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen,Suit.Spades);
		Card handOneCardFour = new Card(Rank.Jack,Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ten,Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.King,Suit.Hearts);
		Card handTwoCardThree = new Card(Rank.Queen,Suit.Hearts);
		Card handTwoCardFour = new Card(Rank.Jack,Suit.Hearts);
		Card handTwoCardFive = new Card(Rank.Ten,Suit.Hearts);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		assertEquals(0,handOne.compareTo(handTwo));
		assertEquals(0,handTwo.compareTo(handOne));
	}
	
	@Test(expected = DuplicateCardException.class)
	  public void testDuplicateCardExceptionInCompare() {
		Card handOneCardOne = new Card(Rank.Ace,Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King,Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen,Suit.Spades);
		Card handOneCardFour = new Card(Rank.Jack,Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ten,Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
		
		Card handTwoCardOne = new Card(Rank.Ace,Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.King,Suit.Hearts);
		Card handTwoCardThree = new Card(Rank.Queen,Suit.Hearts);
		Card handTwoCardFour = new Card(Rank.Jack,Suit.Hearts);
		Card handTwoCardFive = new Card(Rank.Ten,Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne,handTwoCardTwo,handTwoCardThree,handTwoCardFour,handTwoCardFive);
		
		handOne.compareTo(handTwo);
	  }
	
	@Test(expected = DuplicateCardException.class)
	  public void testDuplicateCardExceptioninHand() {
		Card handOneCardOne = new Card(Rank.Ace,Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King,Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen,Suit.Spades);
		Card handOneCardFour = new Card(Rank.Jack,Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ace,Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne,handOneCardTwo,handOneCardThree,handOneCardFour,handOneCardFive);
	  }


}
