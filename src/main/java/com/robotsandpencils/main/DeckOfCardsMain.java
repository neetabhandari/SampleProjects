/**
 * 
 */
package com.robotsandpencils.main;

import java.util.Arrays;
import java.util.logging.Logger;

import com.robotsandpencils.bean.DeckOfCards;

/**
 * Main class to perform operations on deck of cards.
 * 
 * @author Neeta
 *
 */
public class DeckOfCardsMain {
	
	private static Logger logger = Logger.getLogger("DeckOfCardsMain");
	
	public static void main(String args[]) throws Exception {
		logger.info("Inside DecksOfCardsMain - main()method");
		
		DeckOfCards deckOfCards = new DeckOfCards();
		logger.info(String.format("Deck of cards initialized : %s", deckOfCards.toString()));
		
		deckOfCards.shuffle();
		logger.info(String.format("Deck of cards after shuffling : %s", deckOfCards.toString()));
		
		logger.info(String.format("Deal card : %s", deckOfCards.deal()));
		logger.info(String.format("Remaining deck of cards : %s", Arrays.toString(deckOfCards.showRemainingDeckOfCards())));
		logger.info(String.format("Deal card : %s", Arrays.toString(deckOfCards.deal(3))));
		logger.info(String.format("Remaining deck of cards : %s", Arrays.toString(deckOfCards.showRemainingDeckOfCards())));

		logger.info("Completed DecksOfCardsMain - main() method");
	}

}
