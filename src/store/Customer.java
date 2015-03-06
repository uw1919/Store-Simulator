package store;

/**
 * This class gets the contents of carts from simulator class and stores data 
 * in its own variables
 * 
 * @author Uday Vilas Wadhone
 * 
 *
 */
public class Customer {

	//variables for storing contents of the two carts
	Cart[] carts = new Cart[2];
	//variable to keep track of number of carts
	int noOfCarts = 0;
	String name;

	/**
	 * Constructor of the class Customer to initialise the class variables
	 */
	public Customer() {
	}
    
	/**
	 * used by receipt class to get contents of carts
	 * 
	 * @return returns the carts variables
	 */
	public Cart[] getCarts() {
		return carts;  //returns the variables which contains cart1 and cart2
	}

	/**
	 * Adds new cart,which used by the Simulator cart to send the inputs of the 
	 * user
	 * @param cart
	 */
	public void addCart(Cart cart) {
		//increment number of carts
		noOfCarts++;
		//initialise which cart user is going to use
		if (noOfCarts == 1) {
			carts[0] = cart;
		} else if (noOfCarts == 2) {	
			carts[1] = cart;
		} else {
			//if number of carts exceeds 2
			System.out.println("Maximum Number of Carts Reached."
					+ " Cart Not added");
		}
	}

	//used by receipt to get number of carts used by user
	public int getNoOfCarts() {
		return noOfCarts;
	}

}
