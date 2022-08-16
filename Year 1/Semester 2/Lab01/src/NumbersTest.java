
public class NumbersTest {
	
	public static void main(String[] args) {
		// creates a new array and prints out a list of values with an array length of 10. 
		Numbers n1 = new Numbers(10);
		n1.generateNumbers();
		System.out.println("Printing Numbers");
		n1.printNumbers();
		
		Numbers n2 = new Numbers (10, 10);
		System.out.println("\n\nPrinting Positions");
		n2.printIndicies();
		n2.generateSquares();
		System.out.println("\n\n\nPrinting Squares in a pattern");
		n2.printSquares();
		System.out.println("\n\n\nPrinting stars in Patterns");
		n2.StarsPattern1();
		n2.StarsPattern2();
		
	}
}