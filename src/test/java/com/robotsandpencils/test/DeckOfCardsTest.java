/**
 * 
 */
package com.robotsandpencils.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import com.robotsandpencils.bean.Card;
import com.robotsandpencils.bean.DeckOfCards;
import com.robotsandpencils.enums.Rank;
import com.robotsandpencils.enums.Suit;

import junit.framework.Assert;

/**
 * Test class for DeckOfCards.
 * 
 * @author Neeta
 *
 */
public class DeckOfCardsTest {
	
	private DeckOfCards deckOfCards;
		
	/**
	 * Initialize deckOfCards.
	 */
	@Before
	public void setUp() {
		deckOfCards = new DeckOfCards();
	}

	/**
	 * Test showRemainingDeckOfCards
	 */
	@Test
	public void testShowRemainingDeckOfCards() {
		Card[] cardDeck = deckOfCards.showRemainingDeckOfCards();
		Assert.assertEquals(new Card(Suit.HEARTS, Rank.ACE), cardDeck[0]);
	}
	
	/**
	 * Test deal method
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeal() throws Exception {
		deckOfCards.deal();
		Card[] cardDeck = deckOfCards.showRemainingDeckOfCards();
		Assert.assertEquals(new Card(Suit.HEARTS, Rank.TWO), cardDeck[0]);
		Assert.assertTrue(cardDeck.length == 51);
	}
	
	/**
	 * Test dealNoOfCards
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDealNoOfCards() throws Exception {
		deckOfCards.deal(5);
		Card[] cardDeck = deckOfCards.showRemainingDeckOfCards();
		Assert.assertEquals(new Card(Suit.HEARTS, Rank.SIX), cardDeck[0]);
		Assert.assertTrue(cardDeck.length == 47);
	}
	
	/**
	 * Test deal for exception once all cards are dealt from the deck.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testDealNoOfCardsWhenNoCardsLeft() throws Exception {
		deckOfCards.deal(52);
		deckOfCards.deal();
	}
	
	/**
	 * Test shuffle
	 */
	@Test
	public void testShuffle() {
		Card[] cardDeckBeforeShuffle = deckOfCards.showRemainingDeckOfCards();
		deckOfCards.shuffle();
		Card[] cardDeckAfterShuffle = deckOfCards.showRemainingDeckOfCards();
		Assert.assertFalse(Arrays.equals(cardDeckBeforeShuffle, cardDeckAfterShuffle));
	}
	
	/**
	 * Test shuffle - check there is single occurrence of each card after shuffle.
	 */
	@Test
	public void testShuffleForSingleOccurence() {
		deckOfCards.shuffle();
		Card[] cardDeckAfterShuffle = deckOfCards.showRemainingDeckOfCards();
		
		Map<Card, Integer> occurences = new HashMap<Card, Integer>();
		for (Card card : cardDeckAfterShuffle) {
			Integer count = occurences.get(card);
			if (count == null) {
				occurences.put(card, 1);
			} else {
				occurences.put(card, ++count);
			}
		}
		for(Entry<Card, Integer> entry : occurences.entrySet()) {
			Assert.assertTrue(entry.getValue() == 1);
		}
	}
}
