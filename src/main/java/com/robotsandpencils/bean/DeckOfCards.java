/**
 * 
 */
package com.robotsandpencils.bean;

import java.util.Arrays;

import com.robotsandpencils.enums.Rank;
import com.robotsandpencils.enums.Suit;

/**
 * The DeckOfCards class defines a deck of cards and operations on the deck.
 * 
 * @author Neeta
 *
 */
public class DeckOfCards {

	private Card[] deckOfCards;
	private int cardOnTop;

	/**
	 * Initializes deckOfCards. Puts all type of cards in the deck. Defines card at index 0 as card on top.
	 */
	public DeckOfCards() {
		deckOfCards = new Card[52];
		int cntr = 0;
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deckOfCards[cntr++] = new Card(suit, rank);
			}
		}
		cardOnTop = 0;
	}

	/**
	 * Shuffles the deck of cards. Defines cardOnTop as card at index 0.
	 */
	public void shuffle() {
		for (int i = deckOfCards.length - 1; i > 0; i--) {
			int randIndex = (int) (Math.random() * (i + 1));
			Card temp = deckOfCards[i];
			deckOfCards[i] = deckOfCards[randIndex];
			deckOfCards[randIndex] = temp;
		}
		// We can also use this Collections utility to shuffle the cards
		// Collections.shuffle(Arrays.asList(deckOfCards)); 
		cardOnTop = 0;
	}

	/**
	 * Deals one card at a time. Returns top card in the deck. Top card can be identified by cardOnTop index.
	 * 
	 * @return card {@link Card}
	 * @throws Exception
	 */
	public Card deal() throws Exception {
		if (cardOnTop < deckOfCards.length) {
			return deckOfCards[cardOnTop++];
		} else {
			throw new Exception("Deck out of cards");
		}
	}

	/**
	 * Deals n noOfCards at a card. Returns top n noOfCards from top. Top card can be identified by cardOnTop index.
	 * 
	 * @param noOfCards
	 * @return card {@link Card}
	 * @throws Exception
	 */
	public Card[] deal(int noOfCards) throws Exception {
		Card[] cards = null;
		if (cardOnTop < deckOfCards.length) {
			cards = Arrays.copyOfRange(deckOfCards, cardOnTop, (cardOnTop + noOfCards));
		} else {
			throw new Exception("Deck out of cards");
		}
		cardOnTop = cardOnTop + noOfCards;
		return cards;
	}
	
	/**
	 * Show remaining cards in deck Of cards. Top card can be identified by cardOnTop index.
	 * 
	 * @return array of Card {@link Card}
	 */
	public Card[] showRemainingDeckOfCards() {
		return Arrays.copyOfRange(deckOfCards, cardOnTop, deckOfCards.length);
	}

	@Override
	public String toString() {
		return "DeckOfCards [deckOfCards.length=" + deckOfCards.length + " deckOfCards=" + Arrays.toString(deckOfCards)
				+ ", cardOnTop=" + cardOnTop + "]";
	}

}
