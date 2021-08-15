package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.*;

public class BlackJackApp {
	Player newPlayer = new Player();
	Dealer newDealer = new Dealer();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		BlackJackApp bja = new BlackJackApp();
		bja.run();
	}

	public void run() {
		Deck playingDeck = new Deck();
		System.out.println("Welcome, To the Casino Blackjack Table \n");
		newDealer.getDeck();
		playingDeck.shuffle();
		newPlayer.addToHand(playingDeck.dealCard());
		newDealer.addToHand(playingDeck.dealCard());
		newPlayer.addToHand(playingDeck.dealCard());
		newDealer.addToHand(playingDeck.dealCard());

		System.out.println(newPlayer);
		System.out.println("Players hand: " + newPlayer.getHandValue() + "\n");
		System.out.println("Dealers hand: " + newDealer.displaySecondCard() + "\n");
//		System.out.println("Dealers full hand: " + newDealer.getHandValue() + "\n");
		System.out.println("------------------------------------- \n");
		if (newPlayer.getHandValue() == 21) {
			newPlayer.isBlackjack();
		} else if (newPlayer.getHandValue() > 21) {
			newPlayer.isBust();
		} else if (newPlayer.getHandValue() < 21) {
		
			while(newPlayer.getHandValue() < 21) {
			System.out.println("Would you like to: 1) Hit or 2) Stand \n");
			int choice = kb.nextInt();
			kb.nextLine();
			// while loop choice 1 if the player has a value of < 21 or selects choice 2
			if (choice == 1) {
				newPlayer.addToHand(playingDeck.dealCard());
				System.out.println("Players hand: " + newPlayer.getHandValue() + "\n");
			} else {
				System.out.println("Players hand: " + newPlayer.getHandValue() + "\n");
				break;
			}
			}
			
		}
	}

}
