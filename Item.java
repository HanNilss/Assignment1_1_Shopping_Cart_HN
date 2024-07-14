/**
   A class representing an item to be put in a shopping cart
   @author hNilsson
   @version 1.0
*/
public class Item {
	
	private String name;
	private String description;
	private double price;
	
	/**
	 * Creates an item with default values
	 */
	public Item() {
		super();
		setName("Item");
		setDescription("Description");
		setPrice(0.0);
	}//end empty-argument constructor
	
	/**
	 * Creates an item with name, description, and price passed in at instantiation.
	 * @param name of item
	 * @param description of item
	 * @param price as a double in US dollars
	 */
	public Item(String name, String description, double price) {
		super();
		setName(name);
		setDescription(description);
		setPrice(price);
	}//end preferred constructor

	/**
	 * Prints out name of item
	 */
	public void displayName() {
		System.out.println(getName());
	}//end displayName
	
	/**
	 * Prints out description of item
	 */
	public void displayDescription() {
		System.out.println(getDescription());
	}//end displayDescription
	/**
	 * Prints out price of item in US dollars
	 */
	public void displayPrice() {
		System.out.println(getPrice());
	}//end displayPrice
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}//end getName

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}//end setName

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}//end getDescription

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}//end setDescription

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}//end getPrice

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}//end setPrice

	@Override
	public String toString() {
		return getName()+" - "+getDescription()+" - $"+getPrice();
	}//end toString

}//end class
