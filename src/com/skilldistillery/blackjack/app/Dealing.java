package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class Dealing {

	public static void main(String[] args) {
		Dealing dealing = new Dealing();
		dealing.run();
	}

	public void run() {
		Deck deck = new Deck();
		Scanner kb = new Scanner(System.in);
		
		deck.shuffle();
		try {
		System.out.println("Number of cards");
		int numCards = kb.nextInt();
		kb.nextLine();
		//deal the number of cards requested from user
		//get the number of cards requested from the deck
		// shove the dealt cards into your hand
		List<Card> hand = new ArrayList<>();
			for(int numReq = 0; numReq < numCards; numReq++) {
		//		get a Card from the Deck
				hand.add(deck.dealCard());
			}
			
			for (Card card : hand) {
				System.out.println(card);
			}
		} 
		catch(Exception e) {
			System.err.println("Read The Instructions...");
		}
		kb.close();
		
	}
}
