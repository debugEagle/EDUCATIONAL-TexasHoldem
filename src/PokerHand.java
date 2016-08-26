/**
 * @author Jonathon Davis
 *
 */
public class PokerHand implements Comparable<PokerHand> {
	
	private final long value;
	private final Card[] hand;
	
	public PokerHand(Card C1, Card C2, Card C3, Card C4, Card C5){
		hand = new Card[] {C1,C2,C3,C4,C5};
		value = getValue(hand);
	}
	
	private static long getValue(Card[] hand){
		return 0;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(PokerHand o) {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

}
