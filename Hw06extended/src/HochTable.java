
	import java.util.ArrayList;

	public class HochTable extends Desk {
		
		/*
		 * Constructor for HochTable
		 */
		public HochTable(){
			// By default, HochTables have 6 chairs.
			this(6);
		}
		/*
		 * HochTable(int capacity)
		 * 
		 * HochTable constructor where the input determines the size of the Table.
		 * Throws an IllegalArgumentException if the argument is less than 0.
		 */
		public HochTable(int capacity){
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
		//login(s): eu6
		/*
		 * addPerson(String name)
		 * 
		 * adds the new person to the table by updating the personCount variable and
		 * the list of names.
		 * returns a String welcoming the person to the table.
		 */
		public String addPerson(String name){
			if (this.chairCount == this.personCount){
				this.chairCount++;
			}
			// return a greeting to the person!
			return super.addPerson(name) + "!";
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

		/*
		 * classStartingSoon()
		 * 
		 * removes everyone from the table.
		 */
		public void classStartingSoon(){
			this.personCount = 0;
			this.people = new ArrayList<String>();
		}
	}

