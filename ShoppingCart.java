/**Interface defining ADT for shopping cart operating on items
 * @author Hannes Nilsson
 * @version 1.0
 */
public interface ShoppingCart<T> {
	/**Adds a specified item to the cart
	 * 
	 * @param anItem item to be added
	 * @return true if item was successfully added, false if not
	 */
	public boolean addItem(T anItem);
	
	/**Removes an arbitrary item from the cart
	 * 
	 * @return true if item was successfully removed, false if not
	 */
	public boolean removeItem();

	/**Removes specified item from the cart
	 * 
	 * @param anItem to be removed from cart
	 * @return true if item was successfully removed, false if not
	 */
	public boolean removeItem(T anItem);
	
	/**Gets number of items in the cart
	 * 
	 * @return integer representing every instance of every item in the cart
	 */
	public int getCurrentSize();
	
	/**Changes the frequency of a specified item. If user wants to change item instances from 1 to 4 for example
	 * 
	 * @return true if frequency was successfully changed, false if not
	 */
	public boolean changeFrequency(T anItem, int i);
	
	/**Clears cart of all items
	 * 
	 * @return true if cart was successfully cleared, false if not
	 */
	public boolean clear();
	
	/**Checks if specified item is in cart
	 * 
	 * @param anItem Item to be checked for containment
	 * @return true if cart contains item, false if not
	 */
	public boolean containsItem(T anItem);
	
	/**Displays shopping cart as a string, all items, frequencies and price
	 * 
	 * @return formatted information about the cart as a string
	 */
	public String displayCart();
	
	/**Gets the frequency of a specified item in cart
	 * 
	 * @param anItem
	 * @return integer representing number of instances of specified item
	 */
	public int getFrequency(T anItem);
	
	/**Checks if the cart is empty or not
	 * 
	 * @return true of cart is empty, false if not
	 */
	public boolean isEmpty();
	
	/**Turns the shopping cart into an array of items 
	 * 
	 * @return an array of items
	 */
	public T[] toArray();
}//end interface
