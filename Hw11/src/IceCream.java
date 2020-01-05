//logins(s): eu6
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class IceCream {
	// Public enumeration to keep track of flavors :)
	// Look in the test file to see how these are used!
	//the first test did not pass because the two objects (according to the built-in equals function) were different.
	//I needed to specify in a new equals function that if the flavor AND mixed ingredients were the same, then the two objects were equal.
	
	//the testAddingtoHashTable did not pass because the newly created hashset was not a specified size.
	//a helper function that defined the hashcode for tables was necessary to set created hashset sizes by their hashcode.
	public enum BaseFlavor {
		VANILLA, CHOCOLATE;
	}
	
	

	private ArrayList<String> mixins = new ArrayList<String>();
	private BaseFlavor flavor;

	public IceCream(BaseFlavor inputFlavor) {
		this.flavor = inputFlavor;
		
		
	}

	public void addMixIn(String topping) {
		
		this.mixins.add(topping);
		}
	

	

	public static void main(String[]args){
		
		IceCream myicecream = new IceCream(BaseFlavor.VANILLA);
		myicecream.addMixIn("chocolate chips");
	}
	public int hashCode(){
		
		int hash = 5;

		return hash;
		
	}
	
	
	@Override
	public boolean equals(Object obj){
		IceCream myicecream = (IceCream) obj;
		if (this.flavor.equals(myicecream.flavor) && this.mixins.equals(myicecream.mixins)){
			return true;
		}
		return false;
		}
	}
