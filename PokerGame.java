package poker;

public class PokerGame {

	public static final String STRAIGHT_MESSAGE = "Straight!";
	
	public static final String THREE_CARDS_MESSAGE = "Three Cards.";
	
	public static final String TWO_PAIRS_MESSAGE = "Two Pairs.";
	
	public static final String ONE_PAIR_MESSAGE = "One Pair.";
	
	public static final String NO_PAIR_MESSAGE = "No Pair...";

	public static final String FLUSH_MESSAGE = "Flush!";

	public static final String FOUR_CARDS_MESSAGE = "FOUR OF A KIND!";

	public static final String STRAIGHT_FLUSH_MESSAGE = "IT'S STRAIGHT FLUSH!!!";

	public static final String ROYAL_STRAIGHT_FLUSH_MESSAGE = "Welp, Royal Straight Flush.";
	
	
	/**
	 * ポーカーの結果を返します
	 * @param card 
	 * @return
	 */
	public static String judge(Card[] card) {
		
		if (card.length != 5) {
			throw new IllegalArgumentException();
		}
		
		if (isRoyalStraightFlush(card)) {
			return ROYAL_STRAIGHT_FLUSH_MESSAGE;
		}
		else if (isStraightFlush(card)) {
			return STRAIGHT_FLUSH_MESSAGE;
		}
		else if (isFourOfAKind(card)) {
			return FOUR_CARDS_MESSAGE;
		}
		else if (isFlush(card)) {
			return FLUSH_MESSAGE;
		}
		else if (isStraight(card)) {
			return STRAIGHT_MESSAGE;
		}
		else if (isThreeCards(card)) {
			return THREE_CARDS_MESSAGE;
		}
		else if (isTwoPairs(card)) {
			return TWO_PAIRS_MESSAGE;
		}
		else if (isOnePair(card)) {
			return ONE_PAIR_MESSAGE;
		}
		else {
			return NO_PAIR_MESSAGE;
		}
	}
	
	private static boolean isRoyalStraightFlush(Card[] card) {
		// hash storing sum
		int[] hash = new int[13];
		for(int i=0; i<card.length; i++) {
			hash[card[i].number-1]++;
		}
		
		if(hash[0]==1 && hash[9]==1 && hash[10]==1 && hash[11]==1 && hash[12]==1) {
			if(isFlush(card)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isStraightFlush(Card[] card) {
		if(isStraight(card) && isFlush(card)) {
			return true;
		}
		return false;
	}
	
	

	private static boolean isFourOfAKind(Card[] card) {
		// hash storing sum
		int[] hash = new int[13]; // NOTE: hash[0] is redundant!
		for(int i=0; i<card.length; i++) {
			hash[card[i].number-1]++;
		}
		
		// find largest sum
		int max = -1;
		for(int i=0; i<hash.length; i++) {
			if(hash[i] > max) {
				max = hash[i];
			}
		}
		
		// if three cards exist
		if(max==4) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	private static boolean isFlush(Card[] card) {
		// hash storing sum
		Card.Mark record = card[0].mark;
		for(int i=1; i<card.length; i++) {
			if (card[i].mark != record) {
				return false;
			}
		}
		return true;
	}


	private static boolean isStraight(Card[] card) {
		// hash storing sum
		int[] hash = new int[13];
		for(int i=0; i<card.length; i++) {
			hash[card[i].number-1]++;
		}
		
		// check straight
		for(int i=0; i<hash.length-4; i++) {
			if (hash[i] == 1) {
				if (hash[i+1] == 1) {
					if (hash[i+2] == 1) {
						if (hash[i+3] == 1) {
							if (hash[(i+4)%13] == 1) {
								return true;
							}
						}
					}
				}
				return false;
			}
		}
		return false;
	}
	

	private static boolean isThreeCards(Card[] card) {
		// hash storing sum
		int[] hash = new int[13]; // NOTE: hash[0] is redundant!
		for(int i=0; i<card.length; i++) {
			hash[card[i].number-1]++;
		}
		
		// find largest sum
		int max = -1;
		for(int i=0; i<hash.length; i++) {
			if(hash[i] > max) {
				max = hash[i];
			}
		}
		
		// if three cards exist
		if(max==3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static boolean isTwoPairs(Card[] card) {
		// hash storing sum
		int[] hash = new int[13]; // NOTE: hash[0] is redundant!
		for(int i=0; i<card.length; i++) {
			hash[card[i].number-1]++;
		}
		
		// search for two pairs
		Boolean flag = false;
		for(int i=0; i<hash.length; i++) {
			if(hash[i] == 2) {
				if(flag) {
					return true;
				}
				else {
					flag = true;
				}
			}
		}
		return false;
	}
	
	private static boolean isOnePair(Card[] card) {
		int[] hash = new int[13]; // NOTE: hash[0] is redundant!
		for(int i=0; i<card.length; i++) {
			hash[card[i].number-1]++;
		}
		// search for one pair
		for(int i=0; i<hash.length; i++) {
			if(hash[i] == 2) {
					return true;
			}
		}
		return false;
	}
}
