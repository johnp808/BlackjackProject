package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	List<Card> handOfCards;

	public Hand() {
		super();
		handOfCards = new ArrayList<>();
	}

	public void addToHand(Card cardInHand) {
		handOfCards.add(cardInHand);
	}

	public void showCards() {
		for (Card card : handOfCards) {
			System.out.println(card.toString());
		}
	}

	public void clear() {
		handOfCards.removeAll(handOfCards);
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		return " " + handOfCards;
	}
	public List<Card> getHandOfCards() {
		return handOfCards;
	}
	public void setHandOfCards(List<Card> handOfCards) {
		this.handOfCards = handOfCards;
	}
}