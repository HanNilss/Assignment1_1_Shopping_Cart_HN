import java.util.Arrays;
/**
   A class that implements a bag of objects by using an array.
	The bag is never full.
   @author Frank M. Carrano, Timothy M. Henry, hNilsson
   @version 6.0
*/
public final class ArrayBag<T>
{
	private T[] bag; // Cannot be final due to doubling
	private int numberOfEntries;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag() 
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/** Creates an empty bag having a given initial capacity.
	    @param initialCapacity  The integer capacity desired. */
	public ArrayBag(int initialCapacity)
	{
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempBag = (T[])new Object[initialCapacity]; // Unchecked cast
      bag = tempBag;
      numberOfEntries = 0;
      integrityOK = true;
	} // end constructor

	/** Creates a bag containing given entries.
	    @param contents  An array of objects. */
   public ArrayBag(T[] contents) 
   {
      checkCapacity(contents.length);
      bag = Arrays.copyOf(contents, contents.length);
      numberOfEntries = contents.length;
      integrityOK = true;
   } // end constructor
       
	/** Adds a new entry to this bag.
       @param newEntry  The object to be added as a new entry.
       @return  True. */
	public boolean addItem(T newEntry)
	{
		checkintegrity();
      if (isArrayFull())
      {
         doubleCapacity();
      } // end if
      
      bag[numberOfEntries] = newEntry;
      numberOfEntries++;
      
      return true;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray() 
	{
		checkintegrity();
      
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = bag[index];
      } // end for
      
      return result;
	} // end toArray
	/** Sees whether this bag is empty.
       @return  True if this bag is empty, or false if not. */
	public boolean isEmpty()
	{
      return numberOfEntries == 0;
	} // end isEmpty
   
	/** Gets the current number of entries in this bag.
       @return  The integer number of entries currently in this bag. */
	public int getCurrentSize()
	{
      return numberOfEntries;
	} // end getCurrentSize
   
	/** Counts the number of times a given entry appears in this bag.
       @param anEntry  The entry to be counted.
       @return  The number of times anEntry appears in this ba. */
	public int getFrequencyOf(T anEntry)
	{
		checkintegrity();
      int counter = 0;
      
      for (int index = 0; index < numberOfEntries; index++)
      {
         if (anEntry.equals(bag[index]))
         {
            counter++;
         } // end if
      } // end for
      
      return counter;
	} // end getFrequencyOf
   
	/** Tests whether this bag contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if this bag contains anEntry, or false otherwise. */
   public boolean containsItem(T anEntry)
	{
		checkintegrity();
      return getIndexOf(anEntry) > -1; // or >= 0
	} // end contains
   
	/** Removes all entries from this bag. */
	public boolean clear() {
		checkintegrity();
		while (!isEmpty()) {
			removeItem();
		}//end while
		return true;
	}//end clear
	
	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
       was successful, or null. */
	
	public boolean removeItem() {
		checkintegrity();
		boolean result = true;
		if(isEmpty()) {
			result = false;
			System.out.print("Cannot remove item, bag already empty");
		}//end if
		else {
			bag[numberOfEntries-1] = null;
			numberOfEntries--;
		}//end else
		return result;
	}//end removeItem	
	
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
	
	public boolean removeItem(T anItem) {
		checkintegrity();
		boolean result = true;
		if(isEmpty()) {
			result = false;
			System.out.print("Cannot remove item, bag already empty");
		}//end if
		else {
			for(int i = 0; i<numberOfEntries;i++) {
				if(bag[i] == anItem) {
					bag[i] = null;
					bag[i] = bag[numberOfEntries - 1];
					bag[numberOfEntries-1] = null;
					numberOfEntries--;
				}//end if
			}//end for
		}//end else
		return result;
	}//end removeItem
   
	/**
	 * Locates a given entry within the array bag. 
	 * Precondition: checkintegrity has been called.
	 * @return the index of the entry if located, or -1 otherwise. 
	 * @param the object to return index of
	 */
	private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;
		int index = 0;
      
      while (!found && (index < numberOfEntries))
		{
			if (anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			} // end if
         index++;
		} // end while
      
      // Assertion: If where > -1, anEntry is in the array bag, and it
      // equals bag[where]; otherwise, anEntry is not in the array.
      
		return where;
	} // end getIndexOf

   /**
    * @return true if the array bag is full, or false if not.
    */
	private boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	} // end isArrayFull
   
   /**
    * Doubles the size of the array bag.
    * Precondition: checkInitialization has been called.
    */
	private void doubleCapacity()
	{
      int newLength = 2 * bag.length;
      checkCapacity(newLength);
      bag = Arrays.copyOf(bag, newLength);
	} // end doubleCapacity
   
   /**
    * Checks the capacity of the bag
    * @throws an exception if the client requests a capacity that is too large.
    * @param capacity
    */
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                                         "allowed maximum of " + MAX_CAPACITY);
   } // end checkCapacity
   
   /**
    * Checks if the array bag object is corrupt
    *  @throws an exception if receiving object is not initialized.
    */
   private void checkintegrity()
   {
      if (!integrityOK)
         throw new SecurityException ("ArrayBag object is corrupt.");
   } // end checkintegrity
	
   /**Changes the frequency of a specified item. If user wants to change item instances from 1 to 4 for example
	 * 
	 * @param anItem Item to change frequency of
	 * @param i Desired instances of item
	 * @return true if frequency was successfully changed, false if not
	 */
   
   public boolean changeFrequency(T anItem, int i) {
		checkintegrity();
		boolean result;
			for(int j = 1; j<i;j++) {
				addItem(anItem);
			}//end for
		result = true;
		return result;
	}//end changeFrequency
   
   /**Displays shopping cart as a string, all items and price
	 * 
	 * @return formatted information about the cart as a string
	 */
   
	public String displayCart() {
		StringBuilder sb = new StringBuilder("Bag");
		for (int i = 0; i < numberOfEntries; i++) {
			sb.append("\n"+bag[i].toString());
		}//end for
		return sb.toString();
	}//end displayCart
   
   /**
     * Gets the frequency of a specified item in cart
	 * 
	 * @param anItem to get frequency of
	 * @return integer representing number of instances of specified item
	 */
	
	public int getFrequency(T anItem) {
		int c = 0;
		for(int i = 0; i<numberOfEntries;i++) {
			if(bag[i].equals(anItem)) {
				c++;
			}//end if
		}//end for
		return c;
	}//end getFrequency

	/**
	 * @return the bag
	 */
	public T[] getBag() {
		return bag;
	}//end getBag

	/**
	 * @param bag the bag to set
	 */
	public void setBag(T[] bag) {
		this.bag = bag;
	}//end setBag

	/**
	 * @return the numberOfEntries
	 */
	public int getNumberOfEntries() {
		return numberOfEntries;
	}//end getNumberOfEntries

	/**
	 * @param numberOfEntries the numberOfEntries to set
	 */
	public void setNumberOfEntries(int numberOfEntries) {
		this.numberOfEntries = numberOfEntries;
	}//end setNumberOfEntries

	/**
	 * @return the integrityOK
	 */
	public boolean isIntegrityOK() {
		return integrityOK;
	}//end isIntegrityOK

	/**
	 * @param integrityOK the integrityOK to set
	 */
	public void setIntegrityOK(boolean integrityOK) {
		this.integrityOK = integrityOK;
	}//end setIntegrityOK

	/**
	 * @return the defaultCapacity
	 */
	public static int getDefaultCapacity() {
		return DEFAULT_CAPACITY;
	}//end getDefaultCapacity

	/**
	 * @return the maxCapacity
	 */
	public static int getMaxCapacity() {
		return MAX_CAPACITY;
	}//end getMaxCapacity
	
} // end ArrayBag
