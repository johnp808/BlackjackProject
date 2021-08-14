package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
// deal to player by taking top card and putting it in that specific players hand
	
	private Deck dealerDeck = new Deck();
	
	public void getDeck() {
		dealerDeck.shuffle();
	}
	
	public void dealToPlayer() {
		dealerDeck.dealCard();
//	put that card in the specific players hand
	}
}
