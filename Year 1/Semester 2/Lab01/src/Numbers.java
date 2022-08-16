
public class Numbers {

	private int[] numbers;
	private int[][] dualNumbers;
	int num = 1;
	int num1 = 0;
	// Declaration of a default Constructor
	// Numbers() {

	// }

	// A constructor which receives one integer value called name and creates the
	// numbers array with the size of size
	Numbers(int size) {
		numbers = new int[size];
	}

	Numbers(int row, int col) {
		dualNumbers = new int[row][col];
	}

	// generatesNumbers Constructor which populates the array with numbers relative
	// to the int value of numbers.
	public void generateNumbers() {
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = i;
	}

// Prints out the array values. 
	public void printNumbers() {
		for (int i = 0; i < numbers.length; i++)

			System.out.print(numbers[i] + " ");

	}

	public void printIndicies() {
		// Prints out the Row and Column (I,J) values.
		// each time the I value reaches one under the max length of the array it goes a
		// row down until it reaches the end.
		// dualNumbers = new int[dualNumbers.length][dualNumbers.length];
		for (int i = 0; i < dualNumbers.length; i++) {
			for (int j = 0; j < dualNumbers[i].length; j++) {
				System.out.print(i + "," + j + "  ");

			}
			System.out.println();
		}

	}

	public void generateSquares() {
		// Generates the powers using a for loop
		// each time the for loop is satisfied
		// needs j to continuously count. j * 2 for the power calculation.
		// ex - 10^2, 20 ^2, 30 ^2.
		for (int i = 0; i < dualNumbers.length; i++) {
			for (int j = 0; j < dualNumbers[i].length; j++) {
				// math needs to be done here and saved.
				//dualNumbers[i][j] = (int)Math.pow((i + j), 2);
				//dualNumbers[i][j] = (int) Math.pow((i+1)*10+j, 2);
				dualNumbers[i][j] = (int)Math.pow(j+(i*10),2);


			}

		}
	}

	public void printSquares() {
		// prints out the generated values of the array and squares them
		for (int i = 0; i < dualNumbers.length; i++) {
			for (int j = 0; j < i; j++) {
				// System.out.printf("%.0f ", Math.pow(num, 2));
				System.out.print(dualNumbers[i][j] + " ");

			}
			System.out.println();
		}

	}

	public void StarsPattern1() {
		// Uses a for loop to print the first portion of the pyramid.
		// upon reaching the max value of the array length, it exits for the next
		// portion to begin.

		for (int i = 1; i <= dualNumbers.length; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	public void StarsPattern2() {
		// a continue of the top portion of the pyramid.
		// follows the same rules but in reverse.
		for (int i = dualNumbers.length; i >= 1; --i) {
			for (int j = 2; j <= i; ++j) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}