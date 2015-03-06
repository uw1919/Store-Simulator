package store;

/**
 * This class demonstrates how items and bags are stored in cart
 * 
 * @author Uday Vilas Wadhone
 * 
 *
 */
public class Cart {

	// array variable to store the items selected by user
	Item[] items = new Item[100];
	int count = 0;
	// array for storing each bag taken by user
	private Bag[] bags;
	// variable for keeping count of items bought individually
	private final int noOfIndividualItems;
	// variable for keeping count of number of bags used by user
	private final int noOfBags;

	/**
	 * Constructor of class Cart used to initialise the class value in
	 * accordance with the current instance
	 * 
	 * @param noOfBags
	 *            number of bags that user is going to use
	 */
	public Cart(int noOfBags) {
		// declare new array of size input by user
		bags = new Bag[noOfBags];
		// also instantiate class variables
		this.noOfBags = noOfBags;
		// instantiate number of individuals items as 0
		this.noOfIndividualItems = 0;
	}

	/**
	 * Method to initialise value of class variables as input by user in each
	 * cart
	 * 
	 * @param bags
	 *            variable to hold value pased by Simulator class
	 */
	public void addBags(Bag[] bags) {
		this.bags = bags;
	}

	/**
	 * Method used by other classes to retrieve the bags and its contents
	 * 
	 * @return bags bags variable having content info
	 */
	public Bag[] getBags() {
		return bags;
	}

	/**
	 * Method used by other classes to retrieve items.
	 * 
	 * @return items items variable having info
	 */
	public Item[] getItems() {
		return items;
	}

	/**
	 * Method used by other classes to retrieve info about individual items
	 * 
	 * @return noOfIndividualItems individual items bought by user
	 */
	public int getNoOfIndividualItems() {
		return noOfIndividualItems;
	}

	/**
	 * Method used by other classes to retrieve the total number of bags
	 * 
	 * @return noOfBags total number of bags at that instance
	 */
	public int getNoOfBags() {
		return noOfBags;
	}

	/**
	 * Method used by Simulator class to add individual item
	 * 
	 * @param item
	 *            the item selected by the user
	 */
	public void addIndividualItem(Item item) {
		// increase count of the item bought individually
		items[count] = item;
		count++;
	}

	/**
	 * Return value of total items bought by the user
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}
}
