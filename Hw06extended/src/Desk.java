//login(s): eu6

import java.util.ArrayList;


	public class Desk {
		int chairCount;
		int personCount;
		ArrayList<String> people;
		int laptopCount;
		int powerOutletCount;

		public Desk(){
			this(3);
		}
		/*
		 * Desk(int capacity)
		 * 
		 * Desk constructor where the input determines the size of the Table.
		 * Throws an IllegalArgumentException if the argument is less than 0.
		 */
		public Desk(int capacity){
			if (capacity < 0) {
				throw new IllegalArgumentException(
						"Tables must start with a capacity of 0 or more");
			}
			this.chairCount = capacity;
			this.personCount = 0;
			this.people = new ArrayList<String>();
		}
		/*
		 * emptySeat()
		 * 
		 * returns true if there are fewer people than seats.
		 */
		public boolean emptySeat() {
			return this.personCount < this.chairCount;
		}
		/*
		 * addPerson(String name)
		 * 
		 * adds the new person to the table by updating the personCount variable and
		 * the list of names.
		 * returns a String welcoming the person to the table.
		 */
		public String addPerson(String name) {
			if (this.emptySeat()) {
				this.personCount++;
				this.people.add(name);
				return "Welcome " + name;
			} else {
				return "Sorry - there is no space for you " + name;
			}
		}
		/*
		 * removePerson(String name)
		 * 
		 * removes a person from the table.
		 * returns a salutation.
		 */
		public String removePerson(String name) {
			boolean wasRemoved = this.people.remove(name);
			if (!wasRemoved) {
				return "Weird! " + name + " was never here!";
			}
			this.personCount--;
			if (this.personCount == 0) {
				return "(Silence - no one is here to say goodbye)";
			} else {
				return "Bye " + name;
			}
		}
		/*
		 * addPowerSupply()
		 * 
		 * add (always needed) power outlets to the table!
		 */
		public void addPowerSupply(){
			this.powerOutletCount += 6;
		}
		/*
		 * addPersonAndLaptop(String name)
		 * 
		 * adds both a person and a laptop to the Desk.
		 * Note - you can never remove a laptop!
		 * returns a saluation.
		 */
		public String addPersonAndLaptop(String name){
			laptopCount++;
			powerOutletCount--;
			return this.addPerson(name);
		}
	}
	

