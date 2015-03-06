package store;

/**
 * This class is used to provide the amount of bags and its contents to receipt
 * class and also cost of each item is passed to it
 * 
 * @author Uday Vilas Wadhone
 * 
 *
 */
public class Bag {

	//variable of length 100 as defined in the problem
	private Item[] items = new Item[100];
	//variable to store cost of each item
	private int[] amountEach = new int[100];
	//variable to track of count of each item
	private int count = 0;
	//variable to keep track of number of items of specific product
	private int noOfItems;

	/**
	 * Constructor Bad of class Bag initialises the class variables of current
	 * instance
	 * 
	 */
	public Bag() {
		//this keyword used to take current instance of class
		this.noOfItems = 0;
		//amount of each item is stored in the array declared
		for (int i = 0; i < 100; i++) {
			amountEach[i] = 0;
		}
	}

	/**
	 * Method used by Simulator class to pass the item selected and their count
	 * @param item			item selected by user
	 * @param noOfItems		number of items of each product
	 */
	public void addItem(Item item, int noOfItems) {
		//this keyword used to instantiate college variable
		this.items[count] = item;
		amountEach[count] = noOfItems;
		this.noOfItems += noOfItems;
		count++;
	}

	/**
	 * Method used by receipt to get number of items 
	 * @return		variable used to store total number of items
	 */
	public int getNoOfItems() {
		return noOfItems;
	}

	/**
	 * Method used to getItems from each cart or bag
	 * @return		variable to return utems selected by users
	 */
	public Item[] getItems() {
		return items;
	}

	/**
	 * Returns the cost of each item
	 * @return		variable used to store value of each item
	 */
	public int[] getAmountEach() {
		return amountEach;
	}

	/**
	 * Count method is used to keep track of the process
	 * @return		returns variable coun
	 */
	public int getCount() {
		return count;
	}

}
