import java.util.*;
import java.util.Scanner;
public class ArrayBasedSortedList<AnyType extends Comparable<AnyType>> {

	private AnyType[] items;
	private static int MAX_LIST = 10;
	private int numItems;
	private static final int NOT_FOUND = -1;


	public ArrayBasedSortedList( ) {
		items = (AnyType[]) new Comparable[MAX_LIST];
		numItems = 0;
	}
	
    public String toString() {
		String result = "[ ";
		for (int i=0; i < this.numItems; i++)
			result += this.items[i] + " ";
		result += "]";
		return result;
	}
    
	public int size() {
		return numItems;
	}
	
	/**
	 * An internal method to expand the size of array items
	 * Allocates a new array, twice as long.
	 * Updates the MAX_LIST
	 */
	private void expand() {
		AnyType[] newArray = (AnyType []) new Object[2 * MAX_LIST];  // Allocate a new array, twice as long.
	    for (int i = 0; i < numItems; i++)       // Copy items to the bigger array.
	        newArray[i] = this.items[i];
	    this.items = newArray;                   // Replace the too-small array with the new one.
	    MAX_LIST *=2;  
	}
	
	public void insert(AnyType x) {
		int index = 0; // we dont know where to start so we start 0
		
		while(items[index] != null && x.compareTo(items[index]) > 0) // if x is larger than the items in the list compareTo will result in 1 
			index++;
		insert(index, x); //opens up the specific index to enter the number
	}
	
	public void insert(int index, AnyType x) {
		for (int i = size()-1; i >= index; i-- ) {
			items[i+1] = items[i];
		}
		items[index] = x;
		numItems++;
	}
	
	public int findIndex (AnyType t) {
		
		int low = 0;
		int high = numItems - 1;
		int mid;
		
		while ( low <= high) {
			
			mid = (low + high ) / 2;
			
			if ( items[mid].compareTo(t) < 0)
				low = mid + 1;
			else if(items[mid].compareTo(t) > 0)
				high = mid + 1;
			else 
				return mid;
		}
		
	return NOT_FOUND;
	}
	
	public boolean remove(AnyType x) {
		return remove(findIndex(x)) != null;
		
	}
	
	public Object remove(int index) throws NoSuchElementException{
		if (index < 0 || index >= numItems)
			throw new NoSuchElementException("index: "+index);
	
		Object item = items[index];
		for (int i = index+1; i < numItems; i++)       // Shift items to the left.
			items[i - 1] = items[i];
		
		numItems--;
		return item;
	}
	
	
	public Object find(AnyType x) {
		int index = findIndex(x);
		if(index >= 0)
			return get(index);
		return null;
	}
	
	public  Comparable<AnyType> get(int i) throws ArrayIndexOutOfBoundsException {
		if (i < 0 || i > size() - 1)
			throw new ArrayIndexOutOfBoundsException ();
		return items[i];
	}
	
}