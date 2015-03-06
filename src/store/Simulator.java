/*
 * Simulator.java
 * 
 * @version
 * $Id: Simulator.java, Version 1.0 09/26/2014 $
 * 
 * @revision
 * $Log initial version $
 * 
 */

package store;

import java.util.Scanner;

/**
 * This class implements the simulator and takes inputs from users and calls the
 * methods of other classes as required
 * 
 * @author Uday Vilas Wadhone
 * 
 *
 */
public class Simulator {

	// declare Scanner object to scan input from user
	private final Scanner scan = new Scanner(System.in);
	// variable for shopping items
	private int item;

	/**
	 * The main program Calls the shop method for customer to start shopping
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Create an object of class Simulator to call its method
		Simulator simulator = new Simulator();
		// call method shop of Simulator class
		simulator.shop();
	}

	/**
	 * Ask customers for input and call methods from other classes accordingly
	 * for processing
	 * 
	 */
	public void shop() {
		/*
		 * variables to determine whether to continue shopping and if capacity
		 * is full
		 */

		boolean shopping = true, isFull = false;
		// variable for selecting number of items to buy
		int noOfItems;
		// keep a track of total number of items
		int totalItems = 0;
		// variables for number of bags in cart 1 and cart 2
		int noOfBags1, noOfBags2;

		// Output series of questions and accordingly take input of customer
		System.out.println("START SHOPPING");

		System.out
				.print("**********************\nEnter No of Bags for Cart 1:");
		noOfBags1 = scan.nextInt();

		System.out
				.print("**********************\nEnter No of Bags for Cart 2:");
		noOfBags2 = scan.nextInt();

		// store number of bags in each cart
		Bag[] bags1 = new Bag[noOfBags1];
		for (int i = 0; i < noOfBags1; i++) {
			bags1[i] = new Bag();
		}

		Bag[] bags2 = new Bag[noOfBags2];
		for (int i = 0; i < noOfBags2; i++) {
			bags2[i] = new Bag();
		}

		// create new object of class Customer
		Customer customer = new Customer();
		// create arrays for both carts
		Cart[] cart = new Cart[2];
		cart[0] = new Cart(noOfBags1);
		cart[1] = new Cart(noOfBags2);

		// do-while loop for completing or continuing shopping
		do {

			// display choices to the customer and read the input
			System.out.println("Enter the Item: ('apple-1', 'orange-2' ,"
					+ " 'kiwi-3' , 'flour-4' , 'milk-5' ):");
			item = scan.nextInt();

			// Ask to select cart and read input
			System.out.println("Select Cart(1-Cart1 , 2-Cart2) :");
			int cartChoice = scan.nextInt();

			// retrieve number of bags for each cart
			int noOfBags;
			if (cartChoice == 1) {
				noOfBags = noOfBags1;
			} else if (cartChoice == 2) {
				noOfBags = noOfBags2;
			} else {
				System.out.println("Invalid Input");
				continue;
			}

			// give choice for bags and read the input
			System.out.println("Put into Bag(1) or purchase individually(2)?");
			int bagChoice = scan.nextInt();
			int bagNo;

			// check for valid input for bag selection
			if (bagChoice == 1) {
				System.out.println("Enter Bag Number");
				bagNo = scan.nextInt();
				if (bagNo > noOfBags) {
					System.out.println("invalid input,please try again");
					continue;

				}
				bagNo--;

				// take number of products to buy
				System.out.println("Enter the number of items:");
				noOfItems = scan.nextInt();

				// condition to check if total number of items dont exceed 100
				if (totalItems + noOfItems >= 100) {
					System.out.println("Maximum number of items reached. Only "
							+ (100 - totalItems) + " items selected");
					noOfItems = 100 - totalItems;
					isFull = true;
				}

				/*
				 * According to input of user change number of items using
				 * methods of Item class
				 */
				if (item == 1) {
					if (cartChoice == 1)
						bags1[bagNo]
								.addItem(new Item("apple", 0.50), noOfItems);
					if (cartChoice == 2)
						bags2[bagNo]
								.addItem(new Item("apple", 0.50), noOfItems);
					totalItems += noOfItems;
				}
				if (item == 2) {
					if (cartChoice == 1)
						bags1[bagNo].addItem(new Item("orange", 0.70),
								noOfItems);
					if (cartChoice == 2)
						bags1[bagNo].addItem(new Item("orange", 0.70),
								noOfItems);
					totalItems += noOfItems;
				} else if (item == 3) {
					if (cartChoice == 1)
						bags1[bagNo].addItem(new Item("kiwi", 0.70), noOfItems);
					if (cartChoice == 2)
						bags1[bagNo].addItem(new Item("kiwi", 0.70), noOfItems);
					totalItems += noOfItems;
				} else if (item == 4) {
					if (cartChoice == 1)
						bags1[bagNo]
								.addItem(new Item("flour", 0.70), noOfItems);
					if (cartChoice == 2)
						bags1[bagNo]
								.addItem(new Item("flour", 0.70), noOfItems);
					// cart1.addIndividualItem(new Item("flour", 0.70));
					totalItems += noOfItems;
				} else if (item == 5) {
					if (cartChoice == 1)
						bags1[bagNo].addItem(new Item("milk", 0.33), noOfItems);
					if (cartChoice == 2)
						bags1[bagNo].addItem(new Item("milk", 0.33), noOfItems);
					totalItems += noOfItems;
				}

			} else if (bagChoice == 2) {

				if (totalItems + 1 == 100) {
					System.out.println("Maximum number of items reached."
							+ " Last item selected");
					isFull = true;
				} else if (totalItems + 1 > 100) {
					System.out.println("Cart Full");
					break;
				}

				if (item == 1) {
					cart[cartChoice - 1].addIndividualItem(new Item("apple",
							0.50));
					totalItems += 1;
				} else if (item == 2) {
					cart[cartChoice - 1].addIndividualItem(new Item("orange",
							0.70));
					totalItems += 1;
				} else if (item == 3) {
					cart[cartChoice - 1].addIndividualItem(new Item("kiwi",
							0.70));
					totalItems += 1;
				} else if (item == 4) {
					cart[cartChoice - 1].addIndividualItem(new Item("flour",
							0.70));
					totalItems += 1;
				} else if (item == 5) {
					cart[cartChoice - 1].addIndividualItem(new Item("milk",
							0.33));
					totalItems += 1;
				}
			} else {
				System.out.println("Invalid input");
				return;
			}
			if (totalItems >= 100) {
				System.out.println("Cart Full(100 Items). Can't Shop anymore");
				break;
			}

			/*
			 * ask user if he wants to continue shopping. Go back to start if
			 * yes and exit if no
			 */

			System.out.println("Do you wish to continue shopping?(y/n)");
			String reply = scan.next();
			if (reply.equalsIgnoreCase("n")) {
				shopping = false;
			}
		} while (shopping == true && totalItems <= 100 && isFull == false);

		/*
		 * use methods from Bag and Cart class to store the items selected by
		 * the user. Use Receipt class to print out the receipt of the user's
		 * shopping
		 */
		cart[0].addBags(bags1);
		cart[1].addBags(bags2);
		customer.addCart(cart[0]);
		customer.addCart(cart[1]);
		Receipt receipt = new Receipt(customer);
		receipt.process();

	}
}
