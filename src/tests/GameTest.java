/**
 * 
 */
package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Card;
import model.Game;
import model.Player;
import model.PokerHand;

/**
 * @author Jonathon Davis
 *
 */
public class GameTest {
	
	@Test
	public void testRound(){
		Game test = new Game(3);
		StringBuilder output = new StringBuilder();
		
		double pot = test.collect();
		// deal the community cards
		ArrayList<Card> communityCards = test.dealCommunityCards();
		// deal cards to the players
		TreeMap<PokerHand, List<Player>> listOfPlayers = test.dealPlayersCards(communityCards);
		// add the intermediate results to the output
		output.append(test.roundAsString(communityCards));
		// pays out the collected pot amongst the winners
		test.payout(pot, listOfPlayers.get(listOfPlayers.lastKey()));
		// add the winners to the output
		output.append(test.roundResultAsString(listOfPlayers));
		
		assertEquals(6.0,pot,0);
		assertEquals("Community Cards: 2♥ 2♦ 2♣ 2♠ 3♥ " + System.lineSeparator()
				+ "++++++++++++++++++++++++++++++++++++" + System.lineSeparator()
				+ "Player 1: $98.00 - 3♦ 3♣" + System.lineSeparator()
				+ "   Best Hand: 3♥ 2♥ 2♦ 2♣ 2♠ - Four of a Kind" + System.lineSeparator() + System.lineSeparator()
				+ "Player 2: $98.00 - 3♠ 4♥" + System.lineSeparator()
				+ "   Best Hand: 4♥ 2♥ 2♦ 2♣ 2♠ - Four of a Kind" + System.lineSeparator() + System.lineSeparator()
				+ "Player 3: $98.00 - 4♦ 4♣" + System.lineSeparator()
				+ "   Best Hand: 4♦ 2♥ 2♦ 2♣ 2♠ - Four of a Kind" + System.lineSeparator() + System.lineSeparator()
				+ "Winning hands: (tie)" + System.lineSeparator()
				+ "++++++++++++++++++++++++++++++++++++"+ System.lineSeparator()
				+ "4♥ 2♥ 2♦ 2♣ 2♠ - Four of a Kind - Player 2 $101.00"+ System.lineSeparator()
				+ "4♦ 2♥ 2♦ 2♣ 2♠ - Four of a Kind - Player 3 $101.00" + System.lineSeparator(),output.toString());
	}

}
