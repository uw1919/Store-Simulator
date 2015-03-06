package store;

/**
 * This class describes the item, stores and initialises current instance with
 * the item in use
 * 
 * @author Uday Vilas Wadhone
 * 
 *
 */
public class Item {

	// variable to hold price of current item
	private double price;
	// variable to hold name of current item
	private String name;

	/**
	 * Constructor of class Item that initializes class variables
	 * 
	 * @param name
	 *            name of the item
	 * @param price
	 *            price of the item
	 */
	public Item(String name, double price) {
		// instantiate class variables
		this.price = price;
		this.name = name;
	}

	/**
	 * pass price of the item to requesting class
	 * 
	 * @return price price of the item
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Method used by Receipt class to retrieve the name of the item
	 * 
	 * @return name name of the item
	 */
	public String getName() {
		return name;
	}

}
