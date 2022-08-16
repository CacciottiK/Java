/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * 
 * Student Name:Kyle Thomas Student ID:040733617
 * 
 */

public class TestDLLApp {
	/**
	 * The main method of the program
	 * @param args Method Main
	 */
	
	public static void main(String[] args) {

		DoublyLinkedList<Integer> newLL = new DoublyLinkedList<Integer>();		
		
		newLL.insertFirst(20);
		newLL.insertFirst(42);
		newLL.insertFirst(63);
		newLL.insertFirst(93);		
		newLL.insertLast(9);
		newLL.insertLast(34);
		newLL.insertLast(51);
		System.out.print("Linked List<T>: From First To Last: ");
		newLL.printForwards();		
		System.out.print("Linked List<T>: From Last To First: ");
		newLL.printBackwards();	
		newLL.deleteFirstNode();		
		newLL.deleteLastNode();
		newLL.searchAndDelete(9);
		System.out.print("Linked List<T>: From First To Last: ");
		newLL.printForwards();		
		newLL.insertAfter(20, 69);		
		newLL.insertAfter(34, 77);
		System.out.print("Linked List<T>: From First To Last: ");
		newLL.printForwards();
		
		
		
		

	} // end of main() method
} // end class TestDLLApp
