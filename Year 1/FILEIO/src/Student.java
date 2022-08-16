import java.io.FilePermission;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Student {

	private static Scanner input;
	
	
	
	Student() {
				
	}

	public static void openFile() {

		input = new Scanner("students2.txt"); 

	}

	public static void readFile() {

		try {
			
			File studentFile = new File("students2.txt"); 		

			input = new Scanner(studentFile); 
			
			
			while (input.hasNextLine()) {

				System.out.println(input.nextInt() + "  " + input.next() + " " + input.next() + " " + input.next() + " "
						+ input.nextLong() + " " + input.next() + " " + input.nextDouble() + " " + input.nextDouble());

			}

		} catch (InputMismatchException e) {
			System.out.println("asd");

		} catch (IllegalStateException ioe) {
			System.out.println("gdfg");

		} catch (FileNotFoundException e) {
			
			
		} 
		

	}

	public static void closeFile() {

		input.close();
	}

}
