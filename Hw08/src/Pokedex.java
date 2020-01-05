/**
 * Pokedex.java

 * 
 * login(s): eu6 and tl5
 */

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Pokedex {
	// //////////////////////////////////////////
	// Instance variables of Pokedex Objects
	// //////////////////////////////////////////
	private Map<String, Pokemon> dictionary = new TreeMap<String, Pokemon>();

	// //////////////////////////////////////////
	// Pokedex Constructor
	// //////////////////////////////////////////
	public Pokedex() {
		this.populateDictionaryFromFile("pokedex_src.csv");
	}

	// //////////////////////////////////////////
	// public Pokemon method
	// //////////////////////////////////////////
	/**
	 * getInfo
	 * 
	 * @param pokemonName
	 *            the name of a Pokemon to look-up
	 * @return the String representation of that Pokemon if in the Pokedex.
	 *         Otherwise an error message
	 */
	public String getInfo(String pokemonName) {
		if (dictionary.containsKey(pokemonName)) {
			Pokemon p = dictionary.get(pokemonName);
			return p.toString();
		} else {
			return "We don't have any information about " + pokemonName;
		}
	}
	/**
	 * Use this method to test the behavior of HashMap and TreeMap
	 */
	public void generateSummativeStatistics(){
	
		//TreeMap
		//Took 987 milliseconds
		//Took 1838 milliseconds
		//Took 370 milliseconds
		
		//HashMap
		//Took 205 milliseconds
		//Took 350 milliseconds
		//Took 147 milliseconds
		
		//HashMap took significantly less time that TreeMap. Furthermore, iterating over a specific amount of times per one pokemon 
		//took a much shorter time than iterating a certain amount of times over the full pokedex. 
		
		long start = System.currentTimeMillis();
		for (int m=0; m<20000; m++){
			for (String key : dictionary.keySet()){
				Pokemon pokemon = dictionary.get(key);	
			}
			}
		long end = System.currentTimeMillis();
		System.out.println("That took " + (end - start) + " milliseconds");
		}
	// //////////////////////////////////////////
	// private helper methods
	// //////////////////////////////////////////

	/**
	 * addPokemon
	 * 
	 * Creates a new Pokemon Object based upon the description provided and adds
	 * it to the Pokedex.
	 * 
	 * @param oneLine
	 *            a String from a Pokemon description file
	 */
	private void addPokemon(String oneLine) {
		String[] pokemonData = oneLine.split(",");
		Pokemon onePokemon = new Pokemon(pokemonData);
		dictionary.put(onePokemon.pokemon, onePokemon);
	}

	/**
	 * populateDictionaryFromFile
	 * 
	 * Opens the file within the same folder as the current .java file and line
	 * by line calls a helper method to create Pokemons based upon the lines of
	 * the file and adds them to the Pokedex
	 * 
	 * @param csvFile
	 *            that contains a header row and then rows of Pokemon
	 *            descriptions
	 */
	private void populateDictionaryFromFile(String csvFile) {
		// The majority of this code is standard code for reading a file.
		// Pokemon specific code is labeled below.
		BufferedReader br = null;
		try {
			URL path = Pokedex.class.getResource(csvFile);
			File myFile = new File(path.getFile().replaceAll("%20", " "));
			br = new BufferedReader(new FileReader(myFile));
			br.readLine(); // Skip the first line!
			String line = br.readLine();

			// START - Pokemon specific code
			while (line != null) {
				this.addPokemon(line); // Create the Pokemon from a line!
				line = br.readLine();
			}
			// END - Pokemon specific code

		} catch (FileNotFoundException e) { // Error handling
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close(); // Close the file if it was opened
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// //////////////////////////////////////////
	// main method
	// //////////////////////////////////////////
	/**
	 * main
	 * 
	 * Allows the user to query the Pokedex
	 * 
	 * @param args
	 *            (ignored)
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the Pokedex!");
		Pokedex p = new Pokedex();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while (true) {
			System.out.println("Enter a Pokemon to get info or type \"DONE\"");
			System.out.print("  > ");
			try {
				input = br.readLine();
				if (input.equals("DONE")) {
					break;
				}
				System.out.println(p.getInfo(input));
			} catch (IOException e) {
				System.out.println("Error - please restart");
			}
		}
		System.out.println("Thank you for visiting the Pokemon Database!");
	}
}