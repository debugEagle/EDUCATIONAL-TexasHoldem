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
		Player tester = new Player("Player 1");
		ArrayList<Card> pCards = new ArrayList<>();
		ArrayList<Card> cCards = new ArrayList<>();
		pCards.add(new Card(Rank.Ace,Suit.Diamonds));
		pCards.add(new Card(Rank.King,Suit.Diamonds));
		cCards.add(new Card(Rank.Ace,Suit.Clubs));
		cCards.add(new Card(Rank.King,Suit.Clubs));
		cCards.add(new Card(Rank.Queen,Suit.Diamonds));
		cCards.add(new Card(Rank.Jack,Suit.Diamonds));
		cCards.add(new Card(Rank.Ten,Suit.Diamonds));
		
		tester.setPersonalCards(pCards.get(0),pCards.get(1));
		tester.setCommunityCards(cCards);
		PokerHand best = tester.getBestHand();
		PokerHand test = new PokerHand(pCards.get(0),pCards.get(1),cCards.get(2),cCards.get(3),cCards.get(4));
		
		assertEquals(true,test.equals(best));
	}
	
	@Test
	public void testGetBestCardsToString() {
		Player tester = new Player("Player 1");
		ArrayList<Card> pCards = new ArrayList<>();
		ArrayList<Card> cCards = new ArrayList<>();
		pCards.add(new Card(Rank.Ace,Suit.Diamonds));
		pCards.add(new Card(Rank.King,Suit.Diamonds));
		cCards.add(new Card(Rank.Ace,Suit.Clubs));
		cCards.add(new Card(Rank.King,Suit.Clubs));
		cCards.add(new Card(Rank.Queen,Suit.Diamonds));
		cCards.add(new Card(Rank.Jack,Suit.Diamonds));
		cCards.add(new Card(Rank.Ten,Suit.Diamonds));
		
		tester.setPersonalCards(pCards.get(0),pCards.get(1));
		tester.setCommunityCards(cCards);
		PokerHand best = tester.getBestHand();
		
		assertEquals(100,tester.getCash(),0);
		tester.setCash(101);
		assertEquals(101,tester.getCash(),0);
		assertEquals(true, tester.getLastBest().equals(best));
		assertEquals("Player 1: $101.00 - A♦ K♦"+System.lineSeparator()+"   Best Hand: A♦ K♦ Q♦ J♦ 10♦ - Straight Flush" + System.lineSeparator(),tester.toString());
	}
	
	@Test
	public void testGetBestCards2() {
		Player tester = new Player("Player 1");
		ArrayList<Card> pCards = new ArrayList<>();
		ArrayList<Card> cCards = new ArrayList<>();
		pCards.add(new Card(Rank.Ace,Suit.Diamonds));
		pCards.add(new Card(Rank.King,Suit.Diamonds));
		cCards.add(new Card(Rank.Ace,Suit.Clubs));
		cCards.add(new Card(Rank.Queen,Suit.Clubs));
		cCards.add(new Card(Rank.Queen,Suit.Diamonds));
		cCards.add(new Card(Rank.Jack,Suit.Clubs));
		cCards.add(new Card(Rank.Nine,Suit.Clubs));
		
		tester.setPersonalCards(pCards.get(0),pCards.get(1));
		tester.setCommunityCards(cCards);
		PokerHand best = tester.getBestHand();
		PokerHand test = new PokerHand(pCards.get(0),pCards.get(1),cCards.get(0),cCards.get(1),cCards.get(2));
		
		assertEquals(true,test.equals(best));
	}

}
