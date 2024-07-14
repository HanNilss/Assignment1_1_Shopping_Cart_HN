/**
   Test class for shopping cart instantiated as an ArrayBag implementing shopping cart adt
   @author hNilsson
   @version 1.0
*/
public class ShoppingCartTest {

	public static void main(String[] args) {
		
		ArrayBag<Item> shoppingCart = new ArrayBag<>(5);
		
		System.out.println("Empty cart:\n"+shoppingCart.displayCart());
		System.out.println("\nAdding 3 items");
		Item fish = new Item("Fish","Salmon",9.99);
		Item lego = new Item("Lego","Fire station",24.99);
		Item pastry = new Item("Pastry","Cinnamon bun",0.99);
		shoppingCart.addItem(fish);
		shoppingCart.addItem(lego);
		shoppingCart.addItem(pastry);
		System.out.println(shoppingCart.displayCart());
		System.out.println("\nRemoving unspecified item");
		shoppingCart.removeItem();
		System.out.println(shoppingCart.displayCart());
		System.out.println("\nRemoving salmon");
		shoppingCart.removeItem(fish);
		System.out.println(shoppingCart.displayCart());
		System.out.println("\nCurrentSize: "+shoppingCart.getCurrentSize());
		shoppingCart.addItem(lego);
		System.out.println("\nCurrentSize: "+shoppingCart.getCurrentSize());
		System.out.println("\nChanging frequency of Lego to 4");
		shoppingCart.changeFrequency(lego, 4);
		System.out.println("\nSize: "+shoppingCart.getCurrentSize());
		System.out.println(shoppingCart.displayCart());
		System.out.println("\nClearing Cart");
		shoppingCart.clear();
		System.out.println(shoppingCart.displayCart());
		System.out.println("\nAdding fish");
		shoppingCart.addItem(fish);
		System.out.println(shoppingCart.displayCart());
		System.out.println("\nChecking contains method");
		boolean result = shoppingCart.containsItem(fish);
		System.out.println(result+" Does contain fish");
		result = shoppingCart.containsItem(pastry);
		System.out.println(result+" Does not contain pastry");
		System.out.println("\nChecking getFrequency method");
		System.out.println(shoppingCart.getFrequency(pastry)+" Pastry, "+shoppingCart.getFrequency(fish)+" fish.");
		System.out.println("\nChecking isEmpty method");
		System.out.println(shoppingCart.isEmpty());
		System.out.println("Clearing");
		shoppingCart.clear();
		System.out.println(shoppingCart.isEmpty());
		System.out.println("\nSize: "+shoppingCart.getCurrentSize());
		shoppingCart.addItem(lego);
		System.out.println("Adding 10 lego to check resize");
		shoppingCart.changeFrequency(lego, 10);
		System.out.println("\nSize: "+shoppingCart.getCurrentSize());
		System.out.println(shoppingCart.displayCart());
		System.out.println("\nChecking toArray\nDoes not work, ClassCastException");
		for(int i = 0; i < shoppingCart.toArray().length;i++) {
			System.out.println(shoppingCart.toArray()[i].toString());
		}
	}//end main

}//end class
