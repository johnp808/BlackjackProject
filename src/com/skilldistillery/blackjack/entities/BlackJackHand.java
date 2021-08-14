package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {

	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : handOfCards) {
			value += card.getValue();
		}
		return value;
	}
	
	public boolean isBlackjack() {
		if(getHandValue() == 21 && handOfCards.size() == 2) {
			System.out.println("BlackJack, You Win!");
			return true;
		}
		return false;
	}
	
	public boolean isBust() {
		if(getHandValue() > 21) {
			System.out.println("Bust! LOSER!");
			return true;
		}
			return false;
		}
	
	
}
