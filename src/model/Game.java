package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static model.Rank.*;
import static model.Suit.*;

/**
 * @author Jonathon Davis
 */
public class Game {

	// used to construct all possible cards
	private static final Rank[] ranks = new Rank[] { Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack,
			Queen, King, Ace };
	private static final Suit[] suits = new Suit[] { Hearts, Diamonds, Clubs, Spades };

	// stores the players in an array
	private final ArrayList<Player> players;
	// stores the 52 cards in a deck
	private final ArrayList<Card> deck;

	/**
	 * creates 52 cards and the inputed number of players
	 * 
	 * @param numberOfPlayers
	 *            The number of players in the game
	 */
	public Game(int numberOfPlayers) {
		players = new ArrayList<>();
		for (int i = 0; i < numberOfPlayers; i++)
			players.add(new Player("Player " + (i + 1)));

		deck = new ArrayList<>();
		for (Rank rank : ranks)
			for (Suit suit : suits)
				deck.add(new Card(rank, suit));
	}

	/**
	 * Creates and runs a new game object
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("How many players? ");
			String in = bf.readLine();
			if (in != null) {
				int i = Integer.parseInt(in);
				Game game = new Game(i);
				game.run();
			}
		} catch (IOException e) {
			System.out.println("Invalid input: Only integers are allowed");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input: Only integers are allowed");
		}
	}

	/**
	 * runs the core game loop, runs a single round then checks to see if
	 * another round should be run
	 */
	public void run() {
		boolean running = true;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (running) {
			//run the round
			newRound();
			try {
				//check for another round
				System.out.print("Play another round? y or n: ");
				String in = bf.readLine();
				if (in != null && in.equals("y"))
					continue;
				else
					break;
			} catch (IOException e) {
				running = false;
				break;
			}
		}
	}

	/**
	 * runs all the processes of a round, first shuffles the deck, takes in ante
	 * deals out cards, distributes the pot among winners, and then builds a
	 * string Representation of the round.
	 */
	public void newRound() {
		StringBuilder output = new StringBuilder();
		output.append(System.lineSeparator());
		// shuffle the deck
		Collections.shuffle(deck);
		// the pot that was collected
		double pot = collect();
		// deal the community cards
		ArrayList<Card> communityCards = dealCommunityCards();
		// deal cards to the players
		TreeMap<PokerHand, List<Player>> listOfPlayers = dealPlayersCards(communityCards);
		// add the intermediate results to the output
		output.append(roundAsString(communityCards));
		// pays out the collected pot amongst the winners
		payout(pot, listOfPlayers.get(listOfPlayers.lastKey()));
		// add the winners to the output
		output.append(roundResultAsString(listOfPlayers));

		System.out.println(output.toString());
	}

	/**
	 * Splits the pot amongst the winners
	 * 
	 * @param pot
	 *            The amount of money in the pot
	 * @param winners
	 *            The winners of the round
	 */
	public void payout(double pot, List<Player> winners) {
		for (Player player : winners)
			player.setCash(player.getCash() + pot / winners.size());
	}

	/**
	 * This function will collect the ante from each player before the match
	 * starts
	 */
	public double collect() {
		double pot = 0;
		for (Player player : players) {
			player.setCash(player.getCash() - 2);
			pot += 2;
		}
		return pot;
	}

	/**
	 * This function will take the first five cards off of the deck and use them
	 * as the community cards
	 * 
	 * @return The arrayList that contains the cards
	 */
	public ArrayList<Card> dealCommunityCards() {
		ArrayList<Card> communityCards = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			communityCards.add(deck.get(i));
		return communityCards;
	}

	/**
	 * This function will take in the communityCards and the deal the two cards
	 * to each player It will return a TreeMap of the players ranked by their
	 * best possible hand and a list of all players that contain that hand
	 * 
	 * @param communityCards
	 *            The community cards all players can use
	 * @return A TreeMap that ranks the players for this round
	 */
	public TreeMap<PokerHand, List<Player>> dealPlayersCards(ArrayList<Card> communityCards) {
		TreeMap<PokerHand, List<Player>> listOfPlayers = new TreeMap<>();
		int index = communityCards.size();
		//sort all the players into the map
		for (Player player : players) {
			player.setCommunityCards(communityCards);
			player.setPersonalCards(deck.get(index++), deck.get(index++));
			PokerHand bestHand = player.getBestHand();
			//add the player to the map
			if (listOfPlayers.containsKey(bestHand)) {
				listOfPlayers.get(bestHand).add(player);
			} else {
				ArrayList<Player> collisions = new ArrayList<>();
				collisions.add(player);
				listOfPlayers.put(bestHand, collisions);
			}
		}
		return listOfPlayers;
	}

	/**
	 * displays the round as a string
	 * 
	 * @param communityCards
	 *            The community cards
	 * @return Returns a string representation of the round
	 */
	public String roundAsString(ArrayList<Card> communityCards) {
		StringBuilder output = new StringBuilder();
		String divider = "++++++++++++++++++++++++++++++++++++";

		// output community cards
		output.append("Community Cards: ");
		for (Card card : communityCards)
			output.append(card + " ");
		output.append(System.lineSeparator() + divider + System.lineSeparator());

		// output each player
		for (Player player : players)
			output.append(player.toString() + System.lineSeparator());

		return output.toString();
	}

	/**
	 * Outputs the results of a round as a string
	 * 
	 * @param players
	 *            The winners
	 * @return The string representation of the winners
	 */
	public String roundResultAsString(TreeMap<PokerHand, List<Player>> players) {
		StringBuilder output = new StringBuilder();
		String divider = "++++++++++++++++++++++++++++++++++++";

		// output for the winners, if there is one winner format for 1 winner,
		// otherwise format for multiple winners
		if (players.get(players.lastKey()).size() == 1) {
			Map.Entry<PokerHand, List<Player>> winner = players.lastEntry();
			output.append("Winner: " + winner.getValue().get(0).name + " " + "$"
					+ String.format("%1$,.2f", winner.getValue().get(0).getCash()) + System.lineSeparator() + divider
					+ System.lineSeparator() + "   " + winner.getKey().getRank().name + " " + winner.getKey().toString()
					+ System.lineSeparator());
		} else {
			output.append("Winning hands: (tie)" + System.lineSeparator() + divider + System.lineSeparator());
			for (Player winner : players.get(players.lastKey())) {
				output.append(winner.getBestHand() + " - " + winner.getBestHand().getRank().name + " - " + winner.name
						+ " $" + String.format("%1$,.2f", winner.getCash()) + System.lineSeparator());
			}
		}

		// return the output as string
		return output.toString();
	}
	
	

}
