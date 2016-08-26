import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author metro
 *
 */
public class RankSuitAndCardTest {

	@Test
	public void testTwoOfHearts(){
		Card KH = new Card(Rank.Duece, Suit.Hearts);
		assertEquals(Suit.Hearts, KH.getSuit());
		assertEquals(Rank.Duece, KH.getRank());
		assertEquals(2, KH.getRank().getValue());
	}
	
	@Test
	public void testThreeOfSpades(){
		Card KH = new Card(Rank.Three, Suit.Spades);
		assertEquals(Suit.Spades, KH.getSuit());
		assertEquals(Rank.Three, KH.getRank());
		assertEquals(3, KH.getRank().getValue());
	}
	
	@Test
	public void testFourOfDiamonds(){
		Card KH = new Card(Rank.Four, Suit.Diamonds);
		assertEquals(Suit.Diamonds, KH.getSuit());
		assertEquals(Rank.Four, KH.getRank());
		assertEquals(4, KH.getRank().getValue());
	}
	
	@Test
	public void testFiveOfClubs(){
		Card KH = new Card(Rank.Five, Suit.Clubs);
		assertEquals(Suit.Clubs, KH.getSuit());
		assertEquals(Rank.Five, KH.getRank());
		assertEquals(4, KH.getRank().getValue());
	}
	
	@Test
	public void testSixOfHearts(){
		Card KH = new Card(Rank.Six, Suit.Hearts);
		assertEquals(Suit.Hearts, KH.getSuit());
		assertEquals(Rank.Six, KH.getRank());
		assertEquals(5, KH.getRank().getValue());
	}
	
	@Test
	public void testSevenOfSpades(){
		Card KH = new Card(Rank.Seven, Suit.Spades);
		assertEquals(Suit.Spades, KH.getSuit());
		assertEquals(Rank.Seven, KH.getRank());
		assertEquals(6, KH.getRank().getValue());
	}
	
	@Test
	public void testEightOfDiamonds(){
		Card KH = new Card(Rank.Eight, Suit.Diamonds);
		assertEquals(Suit.Diamonds, KH.getSuit());
		assertEquals(Rank.Eight, KH.getRank());
		assertEquals(7, KH.getRank().getValue());
	}
	
	@Test
	public void testNineOfClubs(){
		Card KH = new Card(Rank.Nine, Suit.Clubs);
		assertEquals(Suit.Clubs, KH.getSuit());
		assertEquals(Rank.Nine, KH.getRank());
		assertEquals(8, KH.getRank().getValue());
	}
	
	@Test
	public void testTenOfHearts(){
		Card KH = new Card(Rank.Ten, Suit.Hearts);
		assertEquals(Suit.Hearts, KH.getSuit());
		assertEquals(Rank.Ten, KH.getRank());
		assertEquals(9, KH.getRank().getValue());
	}
	
	@Test
	public void testJackOfSpades(){
		Card KH = new Card(Rank.Jack, Suit.Spades);
		assertEquals(Suit.Spades, KH.getSuit());
		assertEquals(Rank.Jack, KH.getRank());
		assertEquals(10, KH.getRank().getValue());
	}
	
	@Test
	public void testQueenOfDiamonds(){
		Card KH = new Card(Rank.Queen, Suit.Diamonds);
		assertEquals(Suit.Diamonds, KH.getSuit());
		assertEquals(Rank.Queen, KH.getRank());
		assertEquals(13, KH.getRank().getValue());
	}
	@Test
	public void testKingOfClubs(){
		Card KH = new Card(Rank.King, Suit.Clubs);
		assertEquals(Suit.Clubs, KH.getSuit());
		assertEquals(Rank.King, KH.getRank());
		assertEquals(13, KH.getRank().getValue());
	}
	
	@Test
	public void testAceOfHearts(){
		Card KH = new Card(Rank.Ace, Suit.Hearts);
		assertEquals(Suit.Hearts, KH.getSuit());
		assertEquals(Rank.Ace, KH.getRank());
		assertEquals(14, KH.getRank().getValue());
	}

	
}
