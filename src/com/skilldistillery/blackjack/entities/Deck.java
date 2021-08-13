package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;
	
	public Deck() {
		cards = createDeck();
	}
	
	private List<Card> createDeck() {
		// initialize the list with 52 cards
		List<Card> deck = new ArrayList<>(52);
		for (Suit suitName : Suit.values()) {
			for(Rank rankName : Rank.values()) {
				deck.add(new Card(rankName,suitName));
			}
		}
		return deck;
	}
	
	public int checkDeckSize() {
		return cards.size();
	}
	
	public Card dealCard() {
		return cards.remove(0);
	}
	
	public void shuffle( ) {
		Collections.shuffle(cards);
	}
}
