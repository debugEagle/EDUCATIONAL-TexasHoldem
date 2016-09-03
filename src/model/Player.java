/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jonathon Davis
 *
 */
public class Player {

	// cards to be only used by this player
	private List<Card> pCards;
	// All community cards that can be used
	private List<Card> cCard;
	// The amount of cash this player has
	private int cash;
	//last best hand
	private PokerHand lastBest;
	//name
	private final String name;

	public Player(String name) {
		cash = 100;
		this.name = name;
	}

	public PokerHand getBestHand() {
		ArrayList<PokerHand> allPossibleHands = new ArrayList<>();

		for (int i = 0; i < cCard.size() - 2; i++)
			for (int j = i + 1; j < cCard.size() - 1; j++)
				for (int k = j + 1; k < cCard.size(); k++)
					allPossibleHands.add(new PokerHand(pCards.get(0), pCards.get(1), cCard.get(i), cCard.get(j), cCard.get(k)));

		Collections.sort(allPossibleHands, Collections.reverseOrder());
		lastBest = allPossibleHands.get(0);
		return lastBest;
	}

	/**
	 * @param personalCards
	 *            the personalCards to set
	 */
	public void setPersonalCards(List<Card> personalCards) {
		this.pCards = personalCards;
	}


	/**
	 * @param communityCards
	 *            the communityCards to set
	 */
	public void setCommunityCards(List communityCards) {
		this.cCard = communityCards;
	}

	/**
	 * @return the cash
	 */
	public int getCash() {
		return cash;
	}

	/**
	 * @param cash
	 *            the cash to set
	 */
	public void setCash(int cash) {
		this.cash = cash;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Player " + name + ": $" + cash + ".0 - " + pCards.get(0) + " " + pCards.get(1) + System.lineSeparator());
		output.append("\t Best Hand: " + lastBest + " - " + lastBest.getRank().name + System.lineSeparator());
		return output.toString();
	}
	
	

}
