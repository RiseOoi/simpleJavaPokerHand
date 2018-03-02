package poker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class PokerGameTest {

	Card H1 = new Card(1, Card.Mark.HEART);
	Card H2 = new Card(2, Card.Mark.HEART);
	Card H3 = new Card(3, Card.Mark.HEART);
	Card H4 = new Card(4, Card.Mark.HEART);
	Card H5 = new Card(5, Card.Mark.HEART);
	Card H6 = new Card(6, Card.Mark.HEART);
	Card H7 = new Card(7, Card.Mark.HEART);
	Card H8 = new Card(8, Card.Mark.HEART);
	Card H9 = new Card(9, Card.Mark.HEART);
	Card H10 = new Card(10, Card.Mark.HEART);
	Card H11 = new Card(11, Card.Mark.HEART);
	Card H12 = new Card(12, Card.Mark.HEART);
	Card H13 = new Card(13, Card.Mark.HEART);
	
	Card S1 = new Card(1, Card.Mark.SPADE);
	Card S2 = new Card(2, Card.Mark.SPADE);
	Card S3 = new Card(3, Card.Mark.SPADE);
	Card S4 = new Card(4, Card.Mark.SPADE);
	Card S5 = new Card(5, Card.Mark.SPADE);
	Card S6 = new Card(6, Card.Mark.SPADE);
	Card S7 = new Card(7, Card.Mark.SPADE);
	Card S8 = new Card(8, Card.Mark.SPADE);
	Card S9 = new Card(9, Card.Mark.SPADE);
	
	Card C1 = new Card(1, Card.Mark.CLUB);
	Card D1 = new Card(1, Card.Mark.DIAMOND);
	
	//test boundaries of numbers
	
	@Test
	public void testOnePair() {
		Card[] onePair = {H1, H2, H3, H4, S1};
		assertThat(PokerGame.judge(onePair), is(PokerGame.ONE_PAIR_MESSAGE));
	}
	
	@Test
	public void testTwoPairs() {
		Card[] onePair = {H1, S1, H2, S2, H5};
		assertThat(PokerGame.judge(onePair), is(PokerGame.TWO_PAIRS_MESSAGE));
	}
	
	@Test
	public void testThreeCards() {
		Card[] onePair = {H1, S1, C1, H2, H3};
		assertThat(PokerGame.judge(onePair), is(PokerGame.THREE_CARDS_MESSAGE));
	}
	
	@Test
	public void testEndStraight() {
		Card[] straight = {H1, H13, H12, H11, H10};
		assertThat(PokerGame.judge(straight), is(PokerGame.STRAIGHT_MESSAGE));
	}
	
	@Test
	public void testStartStraight() {
		Card[] straight = {S1, H2, H3, H4, H5};
		assertThat(PokerGame.judge(straight), is(PokerGame.STRAIGHT_MESSAGE));
	}
	
	@Test
	public void testMiddleStraight() {
		Card[] straight = {S5, H6, H7, H8, H9};
		assertThat(PokerGame.judge(straight), is(PokerGame.STRAIGHT_MESSAGE));
	}
	
	@Test
	public void noWraparoundStraight() {
		// No wraparound for Straights!!
		// EXTRA TESTING
		Card[] noWrap = {H12, H13, S1, H2, H3};
		assertThat(PokerGame.judge(noWrap), is(PokerGame.NO_PAIR_MESSAGE));
	}
	
	@Test
	public void testFourOfAKind() {
		// EXTRA TESTING
		Card[] four = {S1, H1, C1, D1, H5};
		assertThat(PokerGame.judge(four), is(PokerGame.FOUR_CARDS_MESSAGE));
	}
	
	@Test
	public void testFlush() {
		// EXTRA TESTING
		Card[] flush = {H1, H2, H5, H7, H9};
		assertThat(PokerGame.judge(flush), is(PokerGame.FLUSH_MESSAGE));
	}
	
	@Test
	public void testStraightFlush() {
		// EXTRA TESTING
		Card[] straightflush = {H5, H6, H7, H8, H9};
		assertThat(PokerGame.judge(straightflush), is(PokerGame.STRAIGHT_FLUSH_MESSAGE));
	}
	
	@Test
	public void testRoyalStraightFlush() {
		// EXTRA TESTING
		Card[] royalstraightflush = {H1, H13, H12, H11, H10};
		assertThat(PokerGame.judge(royalstraightflush), is(PokerGame.ROYAL_STRAIGHT_FLUSH_MESSAGE));
	}
	
	@Test
	public void noPair() {
		Card[] onePair = {S1, H2, H3, H4, H7};
		assertThat(PokerGame.judge(onePair), is(PokerGame.NO_PAIR_MESSAGE));
	}

	
	
	
	
}
