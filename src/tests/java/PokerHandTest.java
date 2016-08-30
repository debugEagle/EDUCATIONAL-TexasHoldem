/**
 * Tests the PokerHand class for a variety of cases
 */
package tests.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import main.java.Card;
import main.java.DuplicateCardException;
import main.java.PokerHand;
import main.java.Rank;
import main.java.Suit;

/**
 * @author Jonathon Davis
 *
 */
public class PokerHandTest {
	
	@Test
	public void testToString(){
		Card handOneCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handOneCardTwo = new Card(Rank.King, Suit.Hearts);
		Card handOneCardThree = new Card(Rank.Queen, Suit.Hearts);
		Card handOneCardFour = new Card(Rank.Eight, Suit.Hearts);
		Card handOneCardFive = new Card(Rank.Six, Suit.Hearts);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);
		
		assertEquals("PokerHand [hand=[Ace of Hearts, King of Hearts, Queen of Hearts, Eight of Hearts, Six of Hearts]]",handOne.toString());
	}
	
	@Test
	public void sortVerySimilarPokerHands() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handOneCardTwo = new Card(Rank.King, Suit.Hearts);
		Card handOneCardThree = new Card(Rank.Queen, Suit.Hearts);
		Card handOneCardFour = new Card(Rank.Eight, Suit.Hearts);
		Card handOneCardFive = new Card(Rank.Six, Suit.Hearts);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Spades);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handTwoCardFour = new Card(Rank.Eight, Suit.Spades);
		Card handTwoCardFive = new Card(Rank.Five, Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		Card handThreeCardOne = new Card(Rank.Ace, Suit.Diamonds);
		Card handThreeCardTwo = new Card(Rank.King, Suit.Diamonds);
		Card handThreeCardThree = new Card(Rank.Queen, Suit.Diamonds);
		Card handThreeCardFour = new Card(Rank.Eight, Suit.Diamonds);
		Card handThreeCardFive = new Card(Rank.Four, Suit.Diamonds);
		PokerHand handThree = new PokerHand(handThreeCardOne, handThreeCardTwo, handThreeCardThree, handThreeCardFour,
				handThreeCardFive);

		Card handFourCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handFourCardTwo = new Card(Rank.King, Suit.Clubs);
		Card handFourCardThree = new Card(Rank.Queen, Suit.Clubs);
		Card handFourCardFour = new Card(Rank.Eight, Suit.Clubs);
		Card handFourCardFive = new Card(Rank.Three, Suit.Clubs);
		PokerHand handFour = new PokerHand(handFourCardOne, handFourCardTwo, handFourCardThree, handFourCardFour,
				handFourCardFive);


		ArrayList<PokerHand> allHands = new ArrayList<>();
		allHands.add(handThree);
		allHands.add(handFour);
		allHands.add(handTwo);
		allHands.add(handOne);

		Collections.sort(allHands);

		assertEquals(true, allHands.get(0).equals(handFour));
		assertEquals(true, allHands.get(1).equals(handThree));
		assertEquals(true, allHands.get(2).equals(handTwo));
		assertEquals(true, allHands.get(3).equals(handOne));
	}
	
	@Test
	public void sortPokerHands() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handOneCardTwo = new Card(Rank.King, Suit.Hearts);
		Card handOneCardThree = new Card(Rank.Queen, Suit.Hearts);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Hearts);
		Card handOneCardFive = new Card(Rank.Nine, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Spades);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handTwoCardFive = new Card(Rank.Ten, Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		Card handThreeCardOne = new Card(Rank.Duece, Suit.Diamonds);
		Card handThreeCardTwo = new Card(Rank.Duece, Suit.Hearts);
		Card handThreeCardThree = new Card(Rank.Three, Suit.Spades);
		Card handThreeCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handThreeCardFive = new Card(Rank.Three, Suit.Hearts);
		PokerHand handThree = new PokerHand(handThreeCardOne, handThreeCardTwo, handThreeCardThree, handThreeCardFour,
				handThreeCardFive);

		Card handFourCardOne = new Card(Rank.Four, Suit.Clubs);
		Card handFourCardTwo = new Card(Rank.Four, Suit.Hearts);
		Card handFourCardThree = new Card(Rank.Four, Suit.Diamonds);
		Card handFourCardFour = new Card(Rank.Six, Suit.Clubs);
		Card handFourCardFive = new Card(Rank.Seven, Suit.Clubs);
		PokerHand handFour = new PokerHand(handFourCardOne, handFourCardTwo, handFourCardThree, handFourCardFour,
				handFourCardFive);


		ArrayList<PokerHand> allHands = new ArrayList<>();
		allHands.add(handThree);
		allHands.add(handFour);
		allHands.add(handTwo);
		allHands.add(handOne);

		Collections.sort(allHands);

		assertEquals(true, allHands.get(0).equals(handOne));
		assertEquals(true, allHands.get(1).equals(handFour));
		assertEquals(true, allHands.get(2).equals(handThree));
		assertEquals(true, allHands.get(3).equals(handTwo));
	}

	@Test
	public void sortPokerHandsTest() {
		// straight flush
		Card handOneCardOne = new Card(Rank.Duece, Suit.Hearts);
		Card handOneCardTwo = new Card(Rank.Three, Suit.Hearts);
		Card handOneCardThree = new Card(Rank.Four, Suit.Hearts);
		Card handOneCardFour = new Card(Rank.Five, Suit.Hearts);
		Card handOneCardFive = new Card(Rank.Six, Suit.Hearts);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		// four of a kind
		Card handTwoCardOne = new Card(Rank.Eight, Suit.Spades);
		Card handTwoCardTwo = new Card(Rank.Eight, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Eight, Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.Eight, Suit.Hearts);
		Card handTwoCardFive = new Card(Rank.Three, Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		// full house
		Card handThreeCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handThreeCardTwo = new Card(Rank.Ace, Suit.Spades);
		Card handThreeCardThree = new Card(Rank.Ace, Suit.Diamonds);
		Card handThreeCardFour = new Card(Rank.King, Suit.Clubs);
		Card handThreeCardFive = new Card(Rank.King, Suit.Spades);
		PokerHand handThree = new PokerHand(handThreeCardOne, handThreeCardTwo, handThreeCardThree, handThreeCardFour,
				handThreeCardFive);

		// flush
		Card handFourCardOne = new Card(Rank.Seven, Suit.Clubs);
		Card handFourCardTwo = new Card(Rank.Five, Suit.Clubs);
		Card handFourCardThree = new Card(Rank.Four, Suit.Clubs);
		Card handFourCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handFourCardFive = new Card(Rank.Duece, Suit.Clubs);
		PokerHand handFour = new PokerHand(handFourCardOne, handFourCardTwo, handFourCardThree, handFourCardFour,
				handFourCardFive);

		// straight
		Card handFiveCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handFiveCardTwo = new Card(Rank.King, Suit.Diamonds);
		Card handFiveCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handFiveCardFour = new Card(Rank.Jack, Suit.Diamonds);
		Card handFiveCardFive = new Card(Rank.Ten, Suit.Diamonds);
		PokerHand handFive = new PokerHand(handFiveCardOne, handFiveCardTwo, handFiveCardThree, handFiveCardFour,
				handFiveCardFive);

		ArrayList<PokerHand> allHands = new ArrayList<>();
		allHands.add(handThree);
		allHands.add(handFive);
		allHands.add(handTwo);
		allHands.add(handOne);
		allHands.add(handFour);

		Collections.sort(allHands);

		assertEquals(true, allHands.get(0).equals(handFive));
		assertEquals(true, allHands.get(1).equals(handFour));
		assertEquals(true, allHands.get(2).equals(handThree));
		assertEquals(true, allHands.get(3).equals(handTwo));
		assertEquals(true, allHands.get(4).equals(handOne));
	}

	@Test
	public void sortPokerHandsTestTwo() {
		Card handSixCardOne = new Card(Rank.Eight, Suit.Clubs);
		Card handSixCardTwo = new Card(Rank.Eight, Suit.Diamonds);
		Card handSixCardThree = new Card(Rank.Eight, Suit.Spades);
		Card handSixCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handSixCardFive = new Card(Rank.Four, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handSixCardOne, handSixCardTwo, handSixCardThree, handSixCardFour,
				handSixCardFive);

		Card handSevenCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handSevenCardTwo = new Card(Rank.Ace, Suit.Diamonds);
		Card handSevenCardThree = new Card(Rank.King, Suit.Clubs);
		Card handSevenCardFour = new Card(Rank.King, Suit.Diamonds);
		Card handSevenCardFive = new Card(Rank.Queen, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handSevenCardOne, handSevenCardTwo, handSevenCardThree, handSevenCardFour,
				handSevenCardFive);

		Card handEightCardOne = new Card(Rank.Duece, Suit.Clubs);
		Card handEightCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handEightCardThree = new Card(Rank.Three, Suit.Diamonds);
		Card handEightCardFour = new Card(Rank.Four, Suit.Diamonds);
		Card handEightCardFive = new Card(Rank.Five, Suit.Diamonds);
		PokerHand handThree = new PokerHand(handEightCardOne, handEightCardTwo, handEightCardThree, handEightCardFour,
				handEightCardFive);

		Card handNineCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handNineCardTwo = new Card(Rank.King, Suit.Spades);
		Card handNineCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handNineCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handNineCardFive = new Card(Rank.Nine, Suit.Diamonds);
		PokerHand handFour = new PokerHand(handNineCardOne, handNineCardTwo, handNineCardThree, handNineCardFour,
				handNineCardFive);

		ArrayList<PokerHand> allHands = new ArrayList<>();
		allHands.add(handThree);
		allHands.add(handTwo);
		allHands.add(handOne);
		allHands.add(handFour);

		Collections.sort(allHands);

		assertEquals(true, allHands.get(0).equals(handFour));
		assertEquals(true, allHands.get(1).equals(handThree));
		assertEquals(true, allHands.get(2).equals(handTwo));
		assertEquals(true, allHands.get(3).equals(handOne));
	}

	@Test
	public void testPairBeatsHigh() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Three, Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.Four, Suit.Diamonds);
		Card handOneCardFive = new Card(Rank.Five, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Nine, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(1, handOne.compareTo(handTwo));
		assertEquals(-1, handTwo.compareTo(handOne));
	}

	@Test
	public void testPairLosesToPairHigh() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Three, Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.Four, Suit.Diamonds);
		Card handOneCardFive = new Card(Rank.Five, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Queen, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Jack, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(-1, handOne.compareTo(handTwo));
		assertEquals(1, handTwo.compareTo(handOne));
	}

	@Test
	public void testPairTiesPair() {
		Card handOneCardOne = new Card(Rank.Eight, Suit.Hearts);
		Card handOneCardTwo = new Card(Rank.Eight, Suit.Spades);
		Card handOneCardThree = new Card(Rank.King, Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Six, Suit.Clubs);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Eight, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Eight, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Duece, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Six, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(0, handOne.compareTo(handTwo));
		assertEquals(0, handTwo.compareTo(handOne));
	}

	@Test
	public void testTwoPairBeatsPair() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Three, Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Four, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Queen, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Ten, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(1, handOne.compareTo(handTwo));
		assertEquals(-1, handTwo.compareTo(handOne));
	}

	@Test
	public void testTwoPairLosesToTwoPairHigh() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Three, Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Four, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.King, Suit.Clubs);
		Card handTwoCardFive = new Card(Rank.Ten, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(-1, handOne.compareTo(handTwo));
		assertEquals(1, handTwo.compareTo(handOne));
	}

	@Test
	public void testTwoPairTiesTwoPair() {
		Card handOneCardOne = new Card(Rank.Eight, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Eight, Suit.Hearts);
		Card handOneCardThree = new Card(Rank.King, Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.King, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Four, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Eight, Suit.Diamonds);
		Card handTwoCardTwo = new Card(Rank.Eight, Suit.Spades);
		Card handTwoCardThree = new Card(Rank.King, Suit.Hearts);
		Card handTwoCardFour = new Card(Rank.King, Suit.Clubs);
		Card handTwoCardFive = new Card(Rank.Four, Suit.Clubs);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(0, handOne.compareTo(handTwo));
		assertEquals(0, handTwo.compareTo(handOne));
	}

	@Test
	public void testThreeOfAKindBeatsTwoPair() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Four, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.King, Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Queen, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(1, handOne.compareTo(handTwo));
		assertEquals(-1, handTwo.compareTo(handOne));
	}

	@Test
	public void testThreeOfAKindLosesToThreeOfAKindHigh() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Four, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Ace, Suit.Spades);
		Card handTwoCardFour = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Queen, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(-1, handOne.compareTo(handTwo));
		assertEquals(1, handTwo.compareTo(handOne));
	}

	@Test
	public void testStraightBeatsThreeOfAKind() {
		Card handOneCardOne = new Card(Rank.Five, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Four, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Three, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Ace, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace, Suit.Hearts);
		Card handTwoCardThree = new Card(Rank.Ace, Suit.Spades);
		Card handTwoCardFour = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Queen, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(1, handOne.compareTo(handTwo));
		assertEquals(-1, handTwo.compareTo(handOne));
	}

	@Test
	public void testStraightLosesToStraightHigh() {
		Card handOneCardOne = new Card(Rank.Six, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Five, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Four, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Duece, Suit.Diamonds);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Ten, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(-1, handOne.compareTo(handTwo));
		assertEquals(1, handTwo.compareTo(handOne));
	}

	@Test
	public void testStraightTiesStraight() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King, Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen, Suit.Diamonds);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ten, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Ten, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(0, handOne.compareTo(handTwo));
		assertEquals(0, handTwo.compareTo(handOne));
	}

	@Test
	public void testFlushBeatsStraight() {
		Card handOneCardOne = new Card(Rank.Seven, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Five, Suit.Clubs);
		Card handOneCardThree = new Card(Rank.Four, Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Duece, Suit.Clubs);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Ten, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(1, handOne.compareTo(handTwo));
		assertEquals(-1, handTwo.compareTo(handOne));
	}

	@Test
	public void testFlushLosesToFlushHigh() {
		Card handOneCardOne = new Card(Rank.Seven, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.Five, Suit.Clubs);
		Card handOneCardThree = new Card(Rank.Four, Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Duece, Suit.Clubs);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Nine, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(-1, handOne.compareTo(handTwo));
		assertEquals(1, handTwo.compareTo(handOne));
	}

	@Test
	public void testFlushTiesFlush() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handOneCardTwo = new Card(Rank.King, Suit.Clubs);
		Card handOneCardThree = new Card(Rank.Queen, Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Nine, Suit.Clubs);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Diamonds);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.Nine, Suit.Diamonds);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(0, handOne.compareTo(handTwo));
		assertEquals(0, handTwo.compareTo(handOne));
	}

	@Test
	public void testFullHouseBeatsFlush() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Three, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Clubs);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Clubs);
		Card handTwoCardFive = new Card(Rank.Nine, Suit.Clubs);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(1, handOne.compareTo(handTwo));
		assertEquals(-1, handTwo.compareTo(handOne));
	}

	@Test
	public void testFullHouseLosesFullHouseHigh() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Three, Suit.Clubs);
		Card handOneCardFive = new Card(Rank.Three, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardTwo = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardThree = new Card(Rank.Ace, Suit.Spades);
		Card handTwoCardFour = new Card(Rank.King, Suit.Clubs);
		Card handTwoCardFive = new Card(Rank.King, Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(-1, handOne.compareTo(handTwo));
		assertEquals(1, handTwo.compareTo(handOne));
	}

	@Test
	public void testFourOfAKindBeatsFullHouse() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Duece, Suit.Hearts);
		Card handOneCardFive = new Card(Rank.Three, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.Ace, Suit.Spades);
		Card handTwoCardThree = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.King, Suit.Clubs);
		Card handTwoCardFive = new Card(Rank.King, Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(1, handOne.compareTo(handTwo));
		assertEquals(-1, handTwo.compareTo(handOne));
	}

	@Test
	public void testFourOfAKindLosestoFourOfAKindHigh() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Duece, Suit.Diamonds);
		Card handOneCardThree = new Card(Rank.Duece, Suit.Clubs);
		Card handOneCardFour = new Card(Rank.Duece, Suit.Hearts);
		Card handOneCardFive = new Card(Rank.Three, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.Ace, Suit.Spades);
		Card handTwoCardThree = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.King, Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(-1, handOne.compareTo(handTwo));
		assertEquals(1, handTwo.compareTo(handOne));
	}

	@Test
	public void testStraightFlushBeatsFourOfAKind() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Three, Suit.Spades);
		Card handOneCardThree = new Card(Rank.Four, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Five, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Six, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.Ace, Suit.Spades);
		Card handTwoCardThree = new Card(Rank.Ace, Suit.Clubs);
		Card handTwoCardFour = new Card(Rank.Ace, Suit.Diamonds);
		Card handTwoCardFive = new Card(Rank.King, Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(1, handOne.compareTo(handTwo));
		assertEquals(-1, handTwo.compareTo(handOne));
	}

	@Test
	public void testStraightFlushLosesToStraightFlushHigh() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Three, Suit.Spades);
		Card handOneCardThree = new Card(Rank.Four, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Five, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Six, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Hearts);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Hearts);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Hearts);
		Card handTwoCardFive = new Card(Rank.Ten, Suit.Hearts);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(-1, handOne.compareTo(handTwo));
		assertEquals(1, handTwo.compareTo(handOne));
	}

	@Test
	public void testAceLowStraightFlushLosesToStraightFlushHigh() {
		Card handOneCardOne = new Card(Rank.Duece, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.Three, Suit.Spades);
		Card handOneCardThree = new Card(Rank.Four, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Five, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ace, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.King, Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.Queen, Suit.Hearts);
		Card handTwoCardThree = new Card(Rank.Jack, Suit.Hearts);
		Card handTwoCardFour = new Card(Rank.Ten, Suit.Hearts);
		Card handTwoCardFive = new Card(Rank.Nine, Suit.Hearts);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(-1, handOne.compareTo(handTwo));
		assertEquals(1, handTwo.compareTo(handOne));
	}

	@Test
	public void testStraightFlushTiesStraightFlush() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King, Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ten, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Hearts);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Hearts);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Hearts);
		Card handTwoCardFive = new Card(Rank.Ten, Suit.Hearts);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		assertEquals(0, handOne.compareTo(handTwo));
		assertEquals(0, handTwo.compareTo(handOne));
	}

	@Test
	public void testIsEquals() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King, Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Nine, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Hearts);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Hearts);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Hearts);
		Card handTwoCardFive = new Card(Rank.Ten, Suit.Hearts);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour,
				handTwoCardFive);

		Card handThreeCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handThreeCardTwo = new Card(Rank.King, Suit.Hearts);
		Card handThreeCardThree = new Card(Rank.Queen, Suit.Hearts);
		Card handThreeCardFour = new Card(Rank.Jack, Suit.Hearts);
		Card handThreeCardFive = new Card(Rank.Ten, Suit.Hearts);
		PokerHand handThree = new PokerHand(handThreeCardOne, handThreeCardTwo, handThreeCardThree, handThreeCardFour,
				handThreeCardFive);

		assertEquals(false, handOne.equals(handTwo));
		assertEquals(false, handOne.equals(handThree));
		assertEquals(true, handTwo.equals(handThree));
		assertEquals(true, handThree.equals(handTwo));
		assertEquals(false, handThree.equals(handOne));
		assertEquals(false, handThree.equals(null));
		assertEquals(false, handThree.equals(Integer.valueOf(4)));
	}

	@Test(expected = DuplicateCardException.class)
	public void testDuplicateCardExceptionInCompare() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King, Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ten, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour, handOneCardFive);

		Card handTwoCardOne = new Card(Rank.Ace, Suit.Hearts);
		Card handTwoCardTwo = new Card(Rank.King, Suit.Hearts);
		Card handTwoCardThree = new Card(Rank.Queen, Suit.Hearts);
		Card handTwoCardFour = new Card(Rank.Jack, Suit.Hearts);
		Card handTwoCardFive = new Card(Rank.Ten, Suit.Spades);
		PokerHand handTwo = new PokerHand(handTwoCardOne, handTwoCardTwo, handTwoCardThree, handTwoCardFour, handTwoCardFive);

		handOne.compareTo(handTwo);
	}

	@Test(expected = DuplicateCardException.class)
	public void testDuplicateCardExceptioninHand() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King, Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ace, Suit.Spades);
		new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour, handOneCardFive);
		fail();
	}

	@Test(expected = NullPointerException.class)
	public void testInvalidCardSuit() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King, Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen, null);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ace, Suit.Diamonds);
		new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour, handOneCardFive);
		fail();
	}

	@Test(expected = NullPointerException.class)
	public void testInvalidCardRank() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King, Suit.Spades);
		Card handOneCardThree = new Card(null, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ace, Suit.Diamonds);
		new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour, handOneCardFive);
		fail();
	}

	@Test(expected = NullPointerException.class)
	public void testInvalidCard() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Ace, Suit.Diamonds);
		new PokerHand(handOneCardOne, handOneCardTwo, null, handOneCardFour, handOneCardFive);
		fail();
	}
	
	@Test(expected = NullPointerException.class)
	public void testInvalidCompare() {
		Card handOneCardOne = new Card(Rank.Ace, Suit.Spades);
		Card handOneCardTwo = new Card(Rank.King, Suit.Spades);
		Card handOneCardThree = new Card(Rank.Queen, Suit.Spades);
		Card handOneCardFour = new Card(Rank.Jack, Suit.Spades);
		Card handOneCardFive = new Card(Rank.Nine, Suit.Spades);
		PokerHand handOne = new PokerHand(handOneCardOne, handOneCardTwo, handOneCardThree, handOneCardFour,
				handOneCardFive);

		handOne.compareTo(null);
	}

}
