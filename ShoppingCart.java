/**
   A class representing a shopping cart using the ArrayBag adt.
   @author hNilsson
   @version 1.0
*/
public class ShoppingCart {

	private ArrayBag<Item> shoppingCart;
	
	public ShoppingCart() {
		shoppingCart = new ArrayBag<>();
	}//end empty-argument constructor
	
	public ShoppingCart(int desiredLength) {
		shoppingCart = new ArrayBag<>(desiredLength);
	}//end preferred constructor
	
	public ShoppingCart(Item[] i) {
		shoppingCart = new ArrayBag<>(i);
	}
	//end preferred constructor

	/**Adds a specified item to the cart
	 * 
	 * @param anItem item to be added
	 * @return true if item was successfully added, false if not
	 */
	public boolean addItem(Item anItem) {
		return shoppingCart.addItem(anItem);
	}//end addItem
	
	/**Removes an arbitrary item from the cart
	 * 
	 * @return true if item was successfully removed, false if not
	 */
	public boolean removeItem() {
		return shoppingCart.removeItem();
	}//end removeItem

	/**Removes specified item from the cart
	 * 
	 * @param anItem to be removed from cart
	 * @return true if item was successfully removed, false if not
	 */
	public boolean removeItem(Item anItem) {
		return shoppingCart.removeItem(anItem);
	}//end removeItem
	
	/**Gets number of items in the cart
	 * 
	 * @return integer representing every instance of every item in the cart
	 */
	public int getCurrentSize() {
		return shoppingCart.getCurrentSize();
	}//end getCurrentSize
	
	/**Changes the frequency of a specified item. If user wants to change item instances from 1 to 4 for example
	 * 
	 * @return true if frequency was successfully changed, false if not
	 */
	public boolean changeFrequency(Item anItem, int i) {
		return shoppingCart.changeFrequency(anItem, i);
	}//end changeFrequency
	
	/**Clears cart of all items
	 * 
	 * @return true if cart was successfully cleared, false if not
	 */
	public boolean clear() {
		return shoppingCart.clear();
	}//end clear
	
	/**Checks if specified item is in cart
	 * 
	 * @param anItem Item to be checked for containment
	 * @return true if cart contains item, false if not
	 */
	public boolean containsItem(Item anItem) {
		return shoppingCart.containsItem(anItem);
	}//end containsItem
	
	/**Displays shopping cart as a string, all items and price
	 * 
	 * @return formatted information about the cart as a string
	 */
	public String displayCart() {
		return shoppingCart.displayCart();
	}//end displayCart
	
	/**Gets the frequency of a specified item in cart
	 * 
	 * @param anItem
	 * @return integer representing number of instances of specified item
	 */
	public int getFrequency(Item anItem) {
		return shoppingCart.getFrequency(anItem);
	}//end getFrequency
	
	/**Checks if the cart is empty or not
	 * 
	 * @return true of cart is empty, false if not
	 */
	public boolean isEmpty() {
		return shoppingCart.isEmpty();
	}//end isEmpty
	
	/**Turns the shopping cart into an array of items 
	 * 
	 * @return an array of items
	 */
	public Object[] toArray() {
		return shoppingCart.toArray();
	}//end toArray
}//end class
