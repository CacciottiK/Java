package Pack2;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Hashtable;

import Pack1.CustomHash;


/**
 * Starter file for Lab6 for CST8130-Fall2021
 * @author Kyle thomas
 */

public class PostalCodeSearchTest {

	/**
	 * main() which opens and read CSV file of Canadian postal codes	 * 
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		
		CustomHash<String,String> table = new CustomHash<>(25); // 
				

		String filename = "ottawa_postal_codes_prefix_only.csv";
		Path file = Paths.get(filename);
		try (BufferedReader input = Files.newBufferedReader(file)) {
			String line = null;
			while ((line = input.readLine()) != null) {
				table.put(line, "");
				
			}//while
		}
		catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();

		} 
		// no need to close input. Used try-with-resources above
		
		System.out.println("\nChecking for Key Values");
		
		for(int i=0; i<10; i++) {
			
			 String check = getRandomPrefix();		
			 
			// table.put(check, check);	<- Testing purposes. 
			 table.get(check); //Checks for key values inside of the hash table
			 
			
		}
	}// main()

	// create random generator once. To be used for the life of main(). Global
	// visibility
	// provide a seed value to get same random sequence
	// remove seed after testing
//	final static SecureRandom rand = new SecureRandom("abcdefghijklmnop".getBytes());
	
	final static SecureRandom rand = new SecureRandom();
	final static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String number = "0123456789";

	/**
	 * randomly generate a prefix using the correct format for Canadian postal codes
	 * 
	 * @return randomly generated prefix of the postal code
	 */
	public static String getRandomPrefix() {
		int randA = rand.nextInt(alpha.length());
		int randN = rand.nextInt(number.length());

		return "K" + number.charAt(randN) + alpha.charAt(randA);
	}// getRandomPrefix()

}// class