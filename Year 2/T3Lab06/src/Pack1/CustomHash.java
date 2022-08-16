package Pack1;
import java.util.ArrayList;
/**
 * 
 * @author Kyle Thomas
 *
 *
 * @param <K> Key Generic Value
 * @param <V> Value Generic
 * 
 * A custom Made hash Algorithm
 * 
 */
public class CustomHash<K, V> {
/**
 * Creation of Custom hashtable
 */
	ArrayList<ArrayList<HashEntry<K, V>>> customTable;
	/**
	 * The size of the Custom Hash Table
	 */	
	int size;
/**
 * 
 * Creates a base for a Entry into the hash table
 * 
 * @author Kyle Thomas
 *
 * @param <K> Generic Key value
 * @param <V> Generic Value
 */
	class HashEntry<K, V> {
		/**
		 * Generic Key
		 */
		K key;
		/**
		 * Generic Value
		 */
		V value;
/**Defines what makes the hashed entry, has it's value and a key. 
 * 
 * @param key The key of the table node
 * @param value	Value of the hashed key
 */
	public HashEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	/**
	 * Prints out the Table. Purpose to show if the buckets were working
	 */
	public String toString() {
		return key.toString() + "=" + value.toString();
	}
	} // end class HASHENTRY

	/**
	 * Sets length of the hast table.
	 */
	public CustomHash() {
		this(25); // initializes length
	}
	
	/**
	 * Initializes the Hash table. Gets it prepared with buckets which will hold every hash code.
	 * 
	 * @param size size of table
	 */

	public CustomHash(int size) {
		this.size = size;
		customTable = new ArrayList<>(size);
		for (int i = 0; i < size; i++)
			customTable.add(i, new ArrayList<HashEntry<K, V>>());
	}
	
	/**
	 * Determines and returns the hash code for a key value using a math equation and built in function.
	 * 
	 * @param key Value being hashed or looked at. 
	 * @return Returns the key value in hash
	 */

	public int getHashIndex(K key) {
		int h = key.hashCode(); // Hashes the Key value
		h = h % size; // size of the hash table
		if (h < 0) {
			h = -h;
		}
		return h;
	}
	
	/**
	 * Gets the Key value from the hash table at its index.
	 * Essentially a search function. 
	 * If the key being searched for is not in the hash index, it is printed as not available.
	 * 
	 * @param key Key value Being searched for.
	 * @return A Null value.
	 */

	public V get(K key) {
		int hashIndex = getHashIndex(key); //using the hashed version of our searched key
		ArrayList<HashEntry<K, V>> bucketSearch = customTable.get(hashIndex); // Getting the index of the hashed key value to search through
		
		int counter = 0; 
		
		if(bucketSearch == null) {
			System.out.println("Retrieving : " + key + " NOT FOUND");
		}else {
			
			for (int i = 0; i < bucketSearch.size(); i++) { // iterate through the bucket
				
				HashEntry<K,V> bucketValue = bucketSearch.get(i);
				if(bucketValue.key.equals(key)) {
					//System.out.println("Retrieving : " + key + " FOUND");					
				}
				else 
					counter++;  // Each time the check is NOT the searched for key value, counter goes up by 1
			}
			
			if (counter == bucketSearch.size()) { // If the counter == the Searched through bucket then we KNOW the value we're looking for is not present
				System.out.println("Retrieving : " + key + " NOT FOUND");
			}else {	// If the count is not equal to the bucket size then we found the key value in the bucket. 			
				System.out.println("Retrieving : " + key + " FOUND");				
			}
			
			}
		
		return null;
		

	}
	
	/** Places the Key value inside of the hash table. 
	 * 	Placement of the Key value is determined by the Hashed value which is returned by the 
	 * getHashIndex(); 
	 * @param key Value being hashed
	 * @param value Value held at the hashed value. 
	 */

	public void put(K key, V value) {
		
		int hashIndex = getHashIndex(key); //using the hashed version of our searched key
		
		ArrayList<HashEntry<K, V>> bucketSearch = customTable.get(hashIndex); // Getting the index of the hashed key value to search through
		
		HashEntry<K, V> newValue = new HashEntry<K, V>(key, value); // Created a new entry inside of the hash table
		boolean isFound = false; // a control
		
		for (HashEntry<K, V> entry : bucketSearch) {
			
			if (entry.key.equals(newValue.key)) { // prevents duplicated key values. 
				
				isFound = true;
				entry.value = newValue.value; // overwrites Key values which already exist in bucket. 
				
			}
			
		}
		if (!isFound) { // If the value does not already exist make it. 
			bucketSearch.add(newValue);
		}
		//System.out.println(customTable); // Enable to show the hashtable as it grows with entries added. 

	}
}
