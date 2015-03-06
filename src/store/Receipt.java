package store;

/**
 * This class is used to retrieve info from Item, Cart, Customer classes to
 * calculate the total cost of customers shopping
 * 
 * @author Uday Vilas Wadhone
 * 
 *
 */
public class Receipt {

	// variable to hold total amount to be paid by customer
	private float total;
	// variable to store number of carts used
	private int noOfCarts;
	// create object of class Customer
	private final Customer customer;
	// initialise variables for each item to hold their cumulative cost
	private int apple = 0, orange = 0, kiwi = 0, flour = 0, milk = 0;

	/**
	 * Constructor for class Receipt to initialise class variables
	 * 
	 * @param customer
	 *            object of class Constructor
	 */
	public Receipt(Customer customer) {
		this.total = 0;
		this.customer = customer;
	}

	/**
	 * Method to calculate the total amount that is to be paid by the customer
	 * 
	 * @return total total cost of shopping
	 */
	public float getTotal() {
		// calculate total amount to be paid
		total = (float) (apple * 0.5 + orange * 0.7 + kiwi * 0.7 + 
				flour * 0.7 + milk * 0.33);
		return total;
	}

	/**
	 * Return current instance values of the Customer class
	 * 
	 * @return customer object of Customer class
	 * 
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Retrieve the number of carts and according to number of carts,retrieve
	 * info about the two carts
	 * 
	 */
	public void process() {
		// get number of carts by using method of class Customer
		noOfCarts = customer.getNoOfCarts();
		// switch case to consider instance of 1 or 2 carts
		switch (noOfCarts) {
		case 1:
			// call method to process cart 1
			processCart(customer.getCarts()[0]);
			break;
		case 2:
			// call method to process cart 1
			processCart(customer.getCarts()[0]);
			// call method to process cart 2
			processCart(customer.getCarts()[1]);
			break;
		default:
			System.out.println("Program Error");
			break;
		}

	}

	/**
	 * Method to process individual items and items in bags in each cart
	 * 
	 * @param cart 	object of class Cart
	 * 
	 */
	private void processCart(Cart cart) {
		// get info about individual items using cart object
		Item[] individualItems = cart.getItems();
		// get total count of items in cart
		int itemCount = cart.getCount();
		// get info about each individual item and process each item
		for (int i = 0; i < itemCount; i++) {
			String name = individualItems[i].getName();
			processItem(name, 1);
		}
		// Retrieve info about bags in each cart using cart object
		Bag[] bags = cart.getBags();
		// store number of bags in each cart
		int noOfBags = cart.getNoOfBags();
		// get item bought and the amount of items bought in each bag
		for (int i = 0; i < noOfBags; i++) {
			Item[] items = bags[i].getItems();
			int[] amountEach = bags[i].getAmountEach();
			int count = bags[i].getCount();
			for (int j = 0; j < count; j++) {
				String name = items[j].getName();
				processItem(name, amountEach[j]);
			}
		}
		print();
	}

	/**
	 * Calculates the individual count of each product
	 * 
	 * @param 	name		name of each item
	 * @param 	amount		number of each item bought
	 */
	private void processItem(String name, int amount) {
		// switch case to increment value of each item variable
		switch (name) {
		case "apple":
			apple += amount;
			break;
		case "orange":
			orange += amount;
			break;
		case "kiwi":
			kiwi += amount;
			break;
		case "flour":
			flour += amount;
			break;
		case "milk":
			milk += amount;
			break;
		default:
			System.out.println("Program Error");
			break;
		}
	}

	/**
	 * Print the output of the program that is the receipt at the end of
	 * shopping
	 * 
	 */
	private void print() {
		System.out.println("\n%Java Store");
		System.out.println("--------");
		// Print out count of individual items,their name and individual price
		if (apple != 0) {
			System.out.println("apple:" + apple + "(0.50)");
		}
		if (kiwi != 0) {
			System.out.println("kiwi:" + kiwi + "(0.70)");
		}
		if (orange != 0) {
			System.out.println("orange:" + orange + "(0.70)");
		}
		if (flour != 0) {
			System.out.println("flour:" + flour + "(0.70)");
		}
		if (milk != 0) {
			System.out.println("milk:" + milk + "(0.33)");
		}
		System.out.println("--------");
		// Print out the total cost of shopping instance
		System.out.println("cost:" + getTotal());
		System.exit(0);
	}
}
