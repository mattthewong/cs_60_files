// pokedex_src.csv from: http://tinyurl.com/pzm8de5
/**
 * Pokemon.java
 * 
 * login(s):eu6 and tl5
 */
public class Pokemon {
	// //////////////////////////////////////////
	// Instance variables of Pokemon Objects
	// //////////////////////////////////////////
	Double per; // 0
	Double nat; // 1
	String pokemon; // 2
	Integer hp; // 3
	Integer atk; // 4
	Integer def; // 5
	Integer spA; // 6
	Integer spD; // 7
	Integer spe; // 8
	Integer total; // 9
	String type1; // 10
	String type2; // 11
	String tier; // 12
	String ability1; // 13
	String ability2; // 14
	String hiddenAbility;// 15
	Double mass; // 16
	Integer lk_gk; // 17
	String ev_worth; // 18
	Integer expv; // 19
	String color; // 20
	Integer hatch; // 21
	String gender; // 22
	String eggGroup1; // 23
	String eggGroup2; // 24
	Integer catchValue; // 25
	Integer exp; // 26
	String evolve; // 27
	Integer joh; // 28
	Double hoe; // 29
	Double sin; // 30
	Double un; // 31

	// //////////////////////////////////////////
	// Pokemon Constructor
	// //////////////////////////////////////////
	/**
	 * Constructor for a Pokemon given a row from a Pokedex description file:
	 * http://tinyurl.com/pzm8de5
	 * 
	 * @param pokemonDataRaw
	 */
	public Pokemon(String[] pokemonDataRaw) {
		String[] pokemonData = extendDataLengthIfNec(pokemonDataRaw);
		this.setIntegerInstVariables(pokemonData);
		this.setStringInstVariables(pokemonData);
		this.setDoubleInstVariables(pokemonData);
	}

	// //////////////////////////////////////////
	// public Pokemon method
	// //////////////////////////////////////////

	/**
	 * toString()
	 * 
	 * @return a String representing information about the Pokemon
	 */
	
	public String toString() {
		// It is more efficient to use a StringBuffer to create a String to
		// return!
		// http://docs.oracle.com/javase/7/docs/api/java/lang/StringBuffer.html
		StringBuffer output = new StringBuffer();
		output.append("Name: ");
		output.append(this.pokemon);
		output.append("\n");// Adds a new line!
		output.append("Ability 1: ");
		output.append(this.ability1);
		output.append("\n");
		output.append("Ability 2: ");
		output.append(this.ability2);
		output.append("\n");
		output.append("EXP: ");
		output.append(this.exp);
		

		// return the string version of the StringBuffer
		return output.toString();
	}
	


	// //////////////////////////////////////////
	// private helper methods
	// //////////////////////////////////////////

	/**
	 * extendDataLengthIfNec
	 * 
	 * @param pokemonDataRaw
	 *            the String[] from the input file
	 * @return a String[] that has a length of exactly 32.
	 */
	private String[] extendDataLengthIfNec(String[] pokemonDataRaw) {
		String[] output = new String[32];
		int maxIndex = Math.min(32, pokemonDataRaw.length);
		for (int i = 0; i < maxIndex; i++) {
			output[i] = pokemonDataRaw[i];
		}
		return output;
	}

	/**
	 * setStringInstVariables
	 * 
	 * @param pokemonData
	 *            Processes the elements from pokemonData that are Strings
	 */
	private void setStringInstVariables(String[] pokemonData) {
		this.ability1 = pokemonData[13];
		this.ability2 = pokemonData[14];
		this.color = pokemonData[20];
		this.eggGroup1 = pokemonData[23];
		this.eggGroup2 = pokemonData[24];
		this.ev_worth = pokemonData[18];
		this.evolve = pokemonData[27];
		this.gender = pokemonData[22];
		this.hiddenAbility = pokemonData[15];
		this.pokemon = pokemonData[2];
		this.tier = pokemonData[12];
		this.type1 = pokemonData[10];
		this.type2 = pokemonData[11];
	}

	/**
	 * setDoubleInstVariables
	 * 
	 * @param pokemonData
	 *            Processes the elements from pokemonData that are Doubles
	 */
	private void setDoubleInstVariables(String[] pokemonData) {
		this.mass = Pokemon.getDouble(pokemonData[16]);
		this.nat = Pokemon.getDouble(pokemonData[1]);
		this.per = Pokemon.getDouble(pokemonData[0]);
		this.hoe = Pokemon.getDouble(pokemonData[29]);
		this.sin = Pokemon.getDouble(pokemonData[30]);
		this.un = Pokemon.getDouble(pokemonData[31]);
	}

	/**
	 * setIntegerInstVariables
	 * 
	 * @param pokemonData
	 *            Processes the elements from pokemonData that are Integers
	 */
	private void setIntegerInstVariables(String[] pokemonData) {
		this.atk = Pokemon.getInteger(pokemonData[4]);
		this.catchValue = Pokemon.getInteger(pokemonData[25]);
		this.def = Pokemon.getInteger(pokemonData[5]);
		this.exp = Pokemon.getInteger(pokemonData[26]);
		this.expv = Pokemon.getInteger(pokemonData[19]);
		this.hatch = Pokemon.getInteger(pokemonData[21]);
		this.hp = Pokemon.getInteger(pokemonData[3]);
		this.joh = Pokemon.getInteger(pokemonData[28]);
		this.lk_gk = Pokemon.getInteger(pokemonData[17]);
		this.spA = Pokemon.getInteger(pokemonData[6]);
		this.spD = Pokemon.getInteger(pokemonData[7]);
		this.spe = Pokemon.getInteger(pokemonData[8]);
		this.total = Pokemon.getInteger(pokemonData[9]);
	}

	/**
	 * getInteger
	 * 
	 * @param strInput
	 * @return the Integer representation of strInput or null if invalid Integer
	 */
	private static Integer getInteger(String strInput) {
		// return null if strInput is null, "", or "NONE"
		if (Pokemon.shouldNotParse(strInput)) {
			return null;
		}
		try {
			return new Integer(strInput);
		} catch (NumberFormatException e) {
			// return null for any formatting errors!
			return null;
		}
	}

	/**
	 * getDouble
	 * 
	 * @param strInput
	 * @return the Double representation of strInput or null if invalid Double
	 */
	private static Double getDouble(String strInput) {
		// return null if strInput is null, "", or "NONE"
		if (Pokemon.shouldNotParse(strInput)) {
			return null;
		}
		try {
			return new Double(strInput.trim());
		} catch (NumberFormatException e) {
			// return null for any formatting errors!
			return null;
		}
	}

	/**
	 * shouldNotParse
	 * 
	 * @param strInput
	 * @return true if the input is null, "", or "NONE"
	 */
	private static boolean shouldNotParse(String strInput) {
		return (strInput == null || strInput.trim().equals("") || strInput
				.trim().equals("NONE"));
	}

	

}
