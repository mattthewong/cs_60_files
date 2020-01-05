/**
	 * Person.java
	 * 
	 * login(s): eu6
	 */
public class Person implements Juggler{
	
		// instance variables
		private int myAge;
		
		private String myName;
		
		
		
		// constructors
		public Person(String inputName, int inputAge){
			
			this.myName = inputName;
			
			this.myAge = inputAge;
			
		}
		
		public Person(){
			this("Wally", 60);
		}
		
		public String getName(){
			
			return this.myName;
		}
		public int compareTo(Object o) {
//outputs 1 if the reference person precedes the other compared person.
//outputs 2 if the other compared person precedes the reference person.
//the comparison is done lexicographically then by age if the two individuals
//first initial is lexicographically the same.
			if (! (o instanceof Person))
				throw new ClassCastException();
			
			Person newperson = (Person) o;
			
			int thisperson = 1;
			
			int otherperson = 2;
			
			int tie = 3;
			
			if (this.myName.compareTo(newperson.myName) < 0){	
				return thisperson;
			}
			
			if (this.myName.compareTo(newperson.myName) == 0){	
				if (this.myAge < newperson.myAge){	
					return thisperson;	
				}
				if (this.myAge > newperson.myAge){	
					return otherperson;
				}
				return tie;
			}
			return otherperson;
		}



public String juggle(Comparable X, Comparable Y){
//calculates the pair two individuals who produce the greatest age
//by juggling each pair's age total and comparing them with another.
//juggle outputs a string of the two individual's who's ages give the highest
//combination.
	
	
	Person one = (Person)X;
	
	Person two = (Person)Y;
	
	Person three = (Person)this;
	
	int agesum = one.myAge + two.myAge;
	
	int agesum1 = one.myAge + three.myAge;
	
	int agesum2 = two.myAge + three.myAge;
	
	if (agesum > agesum1 && agesum > agesum2){
		
		return one.myName + " and " + two.myName;
	}
	if (agesum1 > agesum && agesum1 > agesum2){
		
		return one.myName + " and " + three.myName;
	}
	if (agesum2 > agesum && agesum2 > agesum1){
		
		return two.myName + " and " + three.myName;
	}
	return null;
	
}
public int juggleRecord(Comparable X,Comparable Y){
//calculates the pair two individuals who produce the greatest age
//by juggling each pair's age total and comparing them with another.
//juggleRecord outputs an int sum of the two ages that contributed two
//producing the highest age. I had to use people inputs in order to generate 
//people with unique characteristics.
	Person one = (Person)X;
	
	Person two = (Person)Y;
	
	Person three = (Person)this;
	
	int agesum = one.myAge + two.myAge;
	
	int agesum1 = one.myAge + three.myAge;
	
	int agesum2 = two.myAge + three.myAge;
	
	if (agesum > agesum1 && agesum > agesum2){
		
		return one.myAge + two.myAge;
	}
	if (agesum1 > agesum && agesum1 > agesum2){
		
		return one.myAge + three.myAge;
	}
	if (agesum2 > agesum && agesum2 > agesum1){
		
		return two.myAge + three.myAge;
	}
	return 0;
}


}


