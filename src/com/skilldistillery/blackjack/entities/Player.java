package com.skilldistillery.blackjack.entities;

public class Player {
	protected BlackJackHand hand = new BlackJackHand();
// needs to be able to be dealt cards into their own hand, face up
// as well as the dealer being dealt one card face down and then face up
// needs to hit or stand
// dealer extends player
// player can show cards

	public void playerDisplayHand() {
		hand.toString();
		System.out.println(hand.toString() + " Value: " + hand.getHandValue() + "\n");
	}

	public BlackJackHand getHand() {
		return hand;
	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}

}