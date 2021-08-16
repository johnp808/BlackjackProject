package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.*;

public class BlackJackApp {
	Player newPlayer = new Player();
	Dealer newDealer = new Dealer();
	Scanner kb = new Scanner(System.in);
	boolean result = true;
	Deck playingDeck = new Deck();

	public static void main(String[] args) {

		BlackJackApp bja = new BlackJackApp();
		bja.run();
	}

	public void run() {
		System.out.println("Welcome to Casino De Losemoni's Elustrious Blackjack Table \n");
//		while loop for playing again
		while (result) {

			newDealer.getDeck();
			playingDeck.shuffle();
			newPlayer.getHand().addToHand(playingDeck.dealCard());
			newDealer.getHand().addToHand(playingDeck.dealCard());
			newPlayer.getHand().addToHand(playingDeck.dealCard());
			newDealer.getHand().addToHand(playingDeck.dealCard());
			playersTurn();
			if (!newPlayer.getHand().isBust()) {
				newPlayer.getHand().isBust();
			}
			else if (!newDealer.getHand().isBust()) {
				newDealer.getHand().isBust();
				} 
			 else { 
				 dealerTurn();
			 }
			System.out.println("------------------------------------- \n");
					results();
		}
	}

	public void playersTurn() {
		System.out.println("Player has:" + newPlayer.getHand());
		System.out.println("Players total: " + newPlayer.getHand().getHandValue() + "\n");
		System.out.println(newDealer.displaySecondCard() + "\n");
		System.out.println("------------------------------------- \n");

		if (newPlayer.getHand().getHandValue() == 21 && newDealer.getHand().getHandValue() == 21) {
			System.out.println("Holy Kamoley It's A Tie!");
		} else if (newPlayer.getHand().getHandValue() == 21) {
			System.out.println("Player has:" + newPlayer.getHand());
			System.out.println("Players total: " + newPlayer.getHand().getHandValue() + "\n");
			System.out.print("Player has ");
			newPlayer.getHand().isBlackjack();
		} else if (newPlayer.getHand().getHandValue() < 21) {
			// while loop choice 1 if the player has a value of < 21 or selects choice 2
			// then also display if bust if that happens
			System.out.println("Players Turn... ");
			while (newPlayer.getHand().getHandValue() < 21) {
//				if (newPlayer.getHand().getHandValue() == 21) {
//				}
				System.out.println("Would you like to: 1) Hit or 2) Stand \n");
				int choice = kb.nextInt();
				kb.nextLine();
				if (choice == 1) {
					newPlayer.getHand().addToHand(playingDeck.dealCard());
					System.out.println("Player has:" + newPlayer.getHand());
					System.out.println("Players total: " + newPlayer.getHand().getHandValue() + "\n");
				} else if (choice == 2) {
					System.out.println("Player has:" + newPlayer.getHand());
					System.out.println("Players total: " + newPlayer.getHand().getHandValue());
					break;
				}
			}
			if(newPlayer.getHand().getHandValue() == 21) {
				System.out.println("Player has:" + newPlayer.getHand());
				System.out.println("Players total: " + newPlayer.getHand().getHandValue() + "\n");
				System.out.print("Player wins ");						
			}
//			Would you like to play again here if bust, clear cards after choice then move on

			if (newPlayer.getHand().getHandValue() > 21) {
				System.out.println("Player bust... ");
//				newPlayer.getHand().isBust();
				System.out.println("Dealer Wins...");
			}
		}
	}

	public void dealerTurn() {
		System.out.println("------------------------------------- \n");
		System.out.println("Dealers Turn... \n");
		System.out.println("Dealer has:" + newDealer.getHand());
		System.out.println("Dealer total:" + newDealer.getHand().getHandValue() + "\n");
//				if dealer has less than 17 he must hit
		while (newDealer.getHand().getHandValue() < 21) {
			if (newDealer.getHand().getHandValue() < 17) {
				newDealer.getHand().addToHand(playingDeck.dealCard());
				System.out.println("Dealer Hits.. \n");
				System.out.println("Dealer has:" + newDealer.getHand());
				System.out.println("Dealer total:" + newDealer.getHand().getHandValue() + "\n");
			} else if (newDealer.getHand().getHandValue() >= 17) {
				break;
			}
		}
		if (newDealer.getHand().getHandValue() > 21) {
			System.out.print("Dealer bust... ");
//			newDealer.getHand().isBust();
			System.out.println("You've Won!");
		}
	}

	public void results() {
//			if dealer has more than 17 check each players hand and announce the winner.
		if (newDealer.getHand().getHandValue() > 21 || (newPlayer.getHand().getHandValue() > newDealer.getHand().getHandValue() && newPlayer.getHand().getHandValue() < 22)) {
			System.out.println("Player has:" + newPlayer.getHand());
			System.out.println("Players total: " + newPlayer.getHand().getHandValue() + "\n");
			System.out.println("Dealer has:" + newDealer.getHand());
			System.out.println("Dealer total:" + newDealer.getHand().getHandValue() + "\n");
			System.out.println("Your Ultimate Poker Skills Got You The Win!");
		} else if (newPlayer.getHand().getHandValue() < newDealer.getHand().getHandValue()
				&& newDealer.getHand().getHandValue() < 22) {
			System.out.println("Player has:" + newPlayer.getHand());
			System.out.println("Players total: " + newPlayer.getHand().getHandValue() + "\n");
			System.out.println("Dealer has:" + newDealer.getHand());
			System.out.println("Dealer total:" + newDealer.getHand().getHandValue() + "\n");
			System.out.println("House Always Wins, Better Luck Next Time... ");
		} else if (newPlayer.getHand().getHandValue() == newDealer.getHand().getHandValue()) {
			System.out.println("Player has:" + newPlayer.getHand());
			System.out.println("Players total: " + newPlayer.getHand().getHandValue() + "\n");
			System.out.println("Dealer has:" + newDealer.getHand());
			System.out.println("Dealer total:" + newDealer.getHand().getHandValue() + "\n");
			System.out.println("Nobody Wins, It's A Tie!");
//			check to see if they would like to play again, clear cards after decision
		}

		result = playAgain();
	}

	public boolean playAgain() {
		System.out.println("Would you like to play again? 1) Yes 2) No ");
		int choice = kb.nextInt();
		kb.nextLine();
		if (choice == 1) {
			newPlayer.getHand().clear();
			newDealer.getHand().clear();
			return true;
		}
		if (choice == 2) {
			System.out.println("Comeback Anytime...");
			kb.close();
			System.exit(1);
		}
		return false;

	}
}
