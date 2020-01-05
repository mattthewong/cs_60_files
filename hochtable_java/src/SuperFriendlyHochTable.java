
	import java.util.ArrayList;
	//login(s): eu6
	/*
	 * Just like a HochTable, but whenever a person is added, 
	 * they say hello to everyone else at the table!
	 */
	public class SuperFriendlyHochTable extends HochTable {
		
		/*
		 * Constructor for SuperFriendlyHochTable
		 */
		public SuperFriendlyHochTable(){
			// By default, SuperFriendlyHochTable have 10 chairs.
			this(10);
		}
		/*
		 * SuperFriendlyHochTable(int capacity)
		 * 
		 * SuperFriendlyHochTable constructor where the input determines the size of the Table.
		 * Throws an IllegalArgumentException if the argument is less than 0.
		 */
		public SuperFriendlyHochTable(int capacity){
			super(capacity);
		}
		/*
		 * emptySeat()
		 * 
		 * Hoch tables are never full! 
		 * returns true.
		 */
		public boolean emptySeat(){
			// Hoch tables are never full! N+1
			return true;
		}

		/*
		 * addPerson(String name)
		 * 
		 * adds the new person to the table by updating the personCount variable and
		 * the list of names.
		 * returns a String welcoming the person to the table.
		 */
		//fix this;
		public String addPerson(String name){
			if (this.chairCount == this.personCount){
				this.chairCount++;
			}
			// return a greeting to the person!
			if (this.emptySeat()) {
				this.personCount++;
				this.people.add(name);
			} 
			String allNames = this.people.toString();
			return "Hello " + allNames.substring(1, allNames.length() - 1)
					+ "!!!!!";
		}
		/*
		 * removePerson(String name)
		 * 
		 * removes a person from the table.
		 * returns a salutation.
		 */
		public String removePerson(String name) {
			return super.removePerson(name);
			}
		}
	

