//login(s): eu6
	// ArrayLists are common and helpful!
	// Read more about how to use ArrayLists:
	// http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
	import java.util.ArrayList;
	/*
	 * Table class models a table with chairs and people.
	 */
	public class Table extends Desk {
		/*
		 * Table()
		 * 
		 * Table constructor makes a Table object that has 5 seats.
		 */
		public Table() {
			// set the chairCount to 5 by default
			this(5);
		}
		/*
		 * Table(int capacity)
		 * 
		 * Table constructor where the input determines the size of the Table.
		 * Throws an IllegalArgumentException if the argument is less than 0.
		 */
		public Table(int capacity) {
			super(capacity);
		}
		/*
		 * emptySeat()
		 * 
		 * returns true if there are fewer people than seats.
		 */
		public boolean emptySeat() {
			return super.emptySeat();
		}
		/*
		 * addPerson(String name)
		 * 
		 * adds the new person to the table by updating the personCount variable and
		 * the list of names.
		 * returns a String welcoming the person to the table.
		 */
		public String addPerson(String name) {
			return super.addPerson(name);
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


