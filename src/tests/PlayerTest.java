package tests;
/**
 * 
 */


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Card;
import model.Player;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * @author Jonathon Davis
 *
 */
public class PlayerTest {

	@Test
	public void testGetBestCards() {
		Player tester = new Player();
		ArrayList<Card> pCards = new ArrayList<>();
		ArrayList<Card> cCards = new ArrayList<>();
		pCards.add(new Card(Rank.Ace,Suit.Diamonds));
		pCards.add(new Card(Rank.King,Suit.Diamonds));
		cCards.add(new Card(Rank.Ace,Suit.Clubs));
		cCards.add(new Card(Rank.King,Suit.Clubs));
		cCards.add(new Card(Rank.Queen,Suit.Diamonds));
		cCards.add(new Card(Rank.Jack,Suit.Diamonds));
		cCards.add(new Card(Rank.Ten,Suit.Diamonds));
		
		tester.setPersonalCards(pCards);
		tester.setCommunityCards(cCards);
		PokerHand best = tester.getBestHand();
		PokerHand test = new PokerHand(pCards.get(0),pCards.get(1),cCards.get(2),cCards.get(3),cCards.get(4));
		
		assertEquals(true,test.equals(best));
	}
	
	@Test
	public void testGetBestCards2() {
		Player tester = new Player();
		ArrayList<Card> pCards = new ArrayList<>();
		ArrayList<Card> cCards = new ArrayList<>();
		pCards.add(new Card(Rank.Ace,Suit.Diamonds));
		pCards.add(new Card(Rank.King,Suit.Diamonds));
		cCards.add(new Card(Rank.Ace,Suit.Clubs));
		cCards.add(new Card(Rank.Queen,Suit.Clubs));
		cCards.add(new Card(Rank.Queen,Suit.Diamonds));
		cCards.add(new Card(Rank.Jack,Suit.Clubs));
		cCards.add(new Card(Rank.Nine,Suit.Clubs));
		
		tester.setPersonalCards(pCards);
		tester.setCommunityCards(cCards);
		PokerHand best = tester.getBestHand();
		PokerHand test = new PokerHand(pCards.get(0),pCards.get(1),cCards.get(0),cCards.get(1),cCards.get(2));
		
		System.out.println(best);
		assertEquals(true,test.equals(best));
	}

}
