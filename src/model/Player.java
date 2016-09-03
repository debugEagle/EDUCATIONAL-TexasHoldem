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

	public Player() {
		cash = 100;
	}

	public PokerHand getBestHand() {
		ArrayList<PokerHand> allPossibleHands = new ArrayList<>();

		for (int i = 0; i < cCard.size() - 2; i++)
			for (int j = i + 1; j < cCard.size() - 1; j++)
				for (int k = j + 1; k < cCard.size(); k++)
					allPossibleHands.add(new PokerHand(pCards.get(0), pCards.get(1), cCard.get(i), cCard.get(j), cCard.get(k)));

		Collections.sort(allPossibleHands, Collections.reverseOrder());

		return allPossibleHands.get(0);
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

}
