/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Each Player object represents a player in the Texas Holdem game
 * Each player has access to the community pot, two cards of their own
 * and an amount of money that represents their personal cash. The player
 * also has a name to identify the player by
 * @author Jonathon Davis
 */
public class Player {

	// cards to be only used by this player
	private Card first;
	private Card second;
	// All community cards that can be used
	private List<Card> cCard;
	// The amount of cash this player has
	private double cash;
	// last best hand
	private PokerHand lastBest;
	// name
	public final String name;

	/**
	 * creates a new player object with a defualt of $100 and a name
	 * @param name The name of the player
	 */
	public Player(String name) {
		cash = 100;
		this.name = name;
	}

	/**
	 * runs through all possible hands which is 5 choose 3 or 10, then
	 * returns the best possible hand
	 * @return
	 */
	public PokerHand getBestHand() {
		if (first != null && second != null && cCard != null) {
			ArrayList<PokerHand> allPossibleHands = new ArrayList<>();
			//add all possible hands to the list all possible hands
			for (int i = 0; i < cCard.size() - 2; i++)
				for (int j = i + 1; j < cCard.size() - 1; j++)
					for (int k = j + 1; k < cCard.size(); k++)
						allPossibleHands.add(new PokerHand(first, second, cCard.get(i), cCard.get(j), cCard.get(k)));
			//sorts the collection
			Collections.sort(allPossibleHands, Collections.reverseOrder());
			lastBest = allPossibleHands.get(0);
		}
		return lastBest;
	}

	/**
	 * @param personalCards
	 *            the personalCards to set
	 */
	public void setPersonalCards(Card first, Card second) {
		this.first = first;
		this.second = second;
	}

	/**
	 * @param communityCards
	 *            the communityCards to set
	 */
	public void setCommunityCards(List<Card> communityCards) {
		this.cCard = communityCards;
	}

	/**
	 * @return the lastBest
	 */
	public PokerHand getLastBest() {
		return lastBest;
	}

	/**
	 * @return the cash
	 */
	public double getCash() {
		return cash;
	}

	/**
	 * @param d
	 *            the cash to set
	 */
	public void setCash(double d) {
		this.cash = d;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		if (first != null && second != null && lastBest != null) {
			output.append(name + ": $" + String.format("%1$,.2f", cash) + " - " + first + " " + second + System.lineSeparator());
			output.append("   Best Hand: " + lastBest + " - " + lastBest.getRank().name + System.lineSeparator());
		}
		return output.toString();
	}

}
