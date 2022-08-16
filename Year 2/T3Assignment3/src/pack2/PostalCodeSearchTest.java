package pack2;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import pack1.PostalCodeEntry;


/**
 * Starter file for Assigment3 for CST8130-Fall2021
 * @author Kyle Thomas
 * S/N 040733617
 * Date: November 20th 2021
 * 
 * Description: Loads File data into a hash map and then prints out relevant data if matching random area codes. 
 */

public class PostalCodeSearchTest {

	/**
	 * main() which opens and read CSV file of Canadian postal codes
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		
		HashMap<String,PostalCodeEntry> hashAdventure = new HashMap<>();

		String filename = "ottawa_postal_codes.csv";
		Path file = Paths.get(filename);
		try (BufferedReader input = Files.newBufferedReader(file)) {
			String line = null;
			while ((line = input.readLine()) != null) {
				
				String[] parts = line.split(","); // splits up the line by the , Also removes it. 
	
				String postal = parts[0]; // first part of the line string, contains the Prefix only to use as the key of the hashmap.		
				
				hashAdventure.put(postal,new PostalCodeEntry(parts[0], parts[1], parts[2], parts[3], parts[4]));	// prefix as the key and the "rest" as the hashmap data	
				
				
				
			}//while
		}
		catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();

		} 		
		
		
		for(int i = 0; i<10;i++) { //creates a loop 10 times. prints out the pretty data we have 
			
			String randomPrefix = PostalCodeEntry.getRandomPrefix();
			
			if(hashAdventure.containsKey(randomPrefix)){ // if the randomly generated prefix exists in the hashmap print out the values.
				
				System.out.printf("Retrieving: %s\n            %s\n", randomPrefix,hashAdventure.get(randomPrefix));				
				
			}else {
				System.out.printf("Retrieving: %s\n            NOT FOUND\n", randomPrefix);
				
				
			}
		}
		// no need to close input. Used try-with-resources above
	}// main()

}// class