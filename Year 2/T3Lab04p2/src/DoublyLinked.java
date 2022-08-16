/**
 * Processing data using Doubly Linked List CST8130 Data Structures, Computer
 * Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * 
 * Student Name:Kyle Thomas Student ID:040733617
 * 
 */

//===================== class starts here=============================
class Node<T> {
	/**
	 * Holds the data item
	 */
	public T mData; // data item
	/**
	 * indicates next node
	 */
	public Node<T> next; // next node in list
	/**
	 * indicates the previous node
	 */
	public Node<T> previous; // previous node in list
// -------------------------------------------------------------
	/**
	 * Basic build of a constructor
	 * @param num Holds the Value of the node
	 */
	public Node(T num) // constructor
	{
		this.mData = num;
		this.next = null;
	}
	
	public Node() {
		
	}

// -------------------------------------------------------------
	// display this node data
	/**
	 * Displays the data held at the node
	 */
	public void displayNode() {
		System.out.print(mData + " ");
	}
	
	/**
	 * Gets the next node in a linked list
	 * @return returns the next node
	 */
	
	public Node<T> getNext() {
		return this.next;
	}
	/**
	 * updates the next node location
	 * @param nextOne Updates the node selection
	 */
	public void updateNode(Node<T> nextOne) {
		this.next = nextOne;
	}
	
	
// -------------------------------------------------------------
} // end class Node
/**
 * Next class
 * Builds the double linked list and begins to work with the nodes built in the previous class Node
 */
//===================== class design starts here =============================
class DoublyLinkedList<T> {
	/**
	 * Indicates the left side of a node (head)
	 */
	private Node<T> first;
	/**
	 * Indicates the right side of a node (tail)
	 */
	private Node<T> last;

// -------------------------------------------------------------
	/**
	 * skeleton of a double linked list
	 * includes a head and a tail
	 */
	public DoublyLinkedList() {
		first = null;
		last = null;
	}

// -------------------------------------------------------------
	/**
	 * Checks if the first node is empty
	 * as I don't believe a linked list can have a null value first, if the first value is null then the array is empty
	 * @return If the first value (head) is null
	 */
	public boolean isEmpty() {
		return first == null;
	}

// -------------------------------------------------------------
	/**
	 * Inserts a number into the linked list in the FRONT of the list.
	 * Number inserted will push other nodes further down the chain
	 * @param num NUmber being inserted into the list
	 */
	public void insertFirst(T num) {
		
		Node<T> newNode = new Node<T>(num);

		if (isEmpty())
			last = newNode;
		else
			first.previous = newNode;
		newNode.next = first;
		first = newNode;
	}

// -------------------------------------------------------------
	/**
	 * Inserts a number at the end of the linked list.
	 * @param num Accepts the number being entered into the end of the list
	 */
	public void insertLast(T num) {
		Node<T> newNode = new Node<T>(num);
		if (isEmpty())
			first = newNode;
		else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
	}

	// insert newNumber just after numToFind
	/**
	 * Inserts a new number into the linked list AFTER a specific number.
	 * If a person wanted to enter the number 9 AFTER the number 20 in the linked list, this method would achieve that. 
	 * 
	 * @return true If the number exists in the list, a true is returned. If not then false
	 * @param numToFind The number being used as an identifier to which the next value is added.
	 * @param newNumber The number being added into the list after the numToFind
	 */
	public boolean insertAfter(T numToFind, T newNumber) { // (assumes non-empty list)
		Node<T> current = first;
		while (current.mData != numToFind) {
			current = current.next;
			if (current == null)
				return false;
		}
		Node<T> newNode = new Node<T>(newNumber);

		if (current == last) {
			newNode.next = null;
			last = newNode;
		} else {
			newNode.next = current.next;

			current.next.previous = newNode;
		}
		newNode.previous = current;
		current.next = newNode;
		return true;
	}

//------------------------------------------------// delete first node
	
	/**
	 * Deletes the first node value inside of the list.
	 * this causes the next value in the list to become the first value
	 * @return The value of the node being deleted 
	 */

	public Node<T> deleteFirstNode() {

		Node<T> temp = first;
		if (first == last) {
			last = null;
		}else {
			first.next.previous = null;
		}
		first = first.next;
		temp.next = null;
		return temp;
		

	}

// -----------------------------------------------// delete last node
	/**
	 * Deletes the last node value inside of the linked list.
	 * as it is the last value, the previous value tail just needs to be set as null. 
	 * @return Returns the number being deleted off the back of the list
	 */
	public Node<T> deleteLastNode() {
		
		Node<T> toRemove = last;

		if(first == last) {
			last = null;
		}else {
			last.previous.next = null;
		}
		
		last = last.previous;
		toRemove.previous = null;
		return toRemove;
		

	}

// -------------------------------------------------------------

// -----------------------------------------finds, deletes and returns the node that contains the given int value
	/**
	 * searches for and deletes a specific number inside of the linked list. 
	 *  
	 * @param number the number which is being searched for by the user is entered into the method.
	 * @return returns the number that was removed from the list. Also returns the number if it was not present inside of the list. 
	 */
	public Node<T> searchAndDelete(T number) {
		Node<T> toRemove = null;
		Node<T> temp = first;
		Node<T> prev = first;

		while (temp != null) {
			if(temp.mData == number) {
				toRemove = temp;
				if(temp == first)
					first = temp.next;
				else
					prev.updateNode(temp.getNext());
				break;
			}
			else {
				prev = temp;
				temp = temp.next;
			}
		}
		
		return toRemove;

	}

// -------------------------------------------display data from first node to last node
	/**
	 * Prints out the contents of the node values inside of the list. First node to the last node.
	 */
	public void printForwards() {		

		Node<T> temp = first;
		while(temp != null) {
			System.out.print(temp.mData + " ");
			temp = temp.next;
		}
		System.out.println();

	}

// -------------------------------------------display data from last node to first node
	/**
	 * Prints out the node values inside of the list.
	 * however, this one prints the list in reverse order
	 */
	public void printBackwards() {

		Node<T> temp = last;
		while(temp != null) {
			System.out.print(temp.mData + " ");
			temp = temp.previous;
		}
		System.out.println();

	}
// -------------------------------------------------------------
} // end class DoublyLinkedList

// ==========================================================