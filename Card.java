package poker;

public class Card {

	/**
	 * 1~13
	 */
	public int number;
	
	/**
	 * Mark
	 */
	public Mark mark;
	
	public Card(int number, Mark mark) {
		if(number >=1 && number <= 13) {
			this.number = number;
		}
		else {
			throw new IllegalArgumentException();
		}
		this.mark = mark;
		// No need to test non mark
	}
	
	public static enum Mark {
		HEART, DIAMOND, CLUB, SPADE;
	}
}

