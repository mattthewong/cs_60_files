/** Change-making class!





 * 
 * @author 
 *
 * Other notes/comments:
 */

//login(s): eu6

import java.util.Arrays;

public class Change {
  
  /**
   * the data member holding all of the coin _types_: coinTypeList
   */
  private int[] coinTypeList;

  
  /**
   * printArray, a helper for printing 1d int arrays
   * @param A, the 1d int array to be printed
   */
  public static void printArray( int[] A ) {
    // we use the helper function Arrays.toString:
    System.out.println( Arrays.toString( A ) );
  }
  
  /**
   * constructor for a Change problem!
   * @param coinTypeList_input, the list of denominations
   *        in our tests, the list will always contain a 1!
   */
  public Change(int[] coinTypeList_input) {
    this.coinTypeList = coinTypeList_input;
  }
  
  /**
   * makeChange returns an ascending-SORTED version of the 
   * SHORTEST list of coins that make change for the input amount
   * 
   * To sort?   Use Arrays.sort( L )   It changes L - this is OK.
   * See docs.oracle.com/javase/7/docs/api/java/util/Arrays.html
   * 
   * @param amt, the input amount
   * @return the sorted version of the shortest-length list
   *         of integers that make change for amt
   */
  public int[] makeChange(int amt) {
	  
	  int [] mincoins = new int[amt+1];
	  int[] lastcoin = new int[amt+1];
	    mincoins[0] = 0;
	    lastcoin[0] = 0;
	    
	    int numcoins = this.coinTypeList.length;
	    
	    for (int c = 1; c <= amt; c++){
	    	
	    	int best = c;
	    	int bestcoin = 0;
	    	
	    	for (int i = 0; i < numcoins ; i++ ){
	    		int back  = c- this.coinTypeList[i];
	    		
	    		if (back >=0){
	    			int value = mincoins[back] +1;
	    		
	    		if (value < best){
	    			best = value;
	    			bestcoin = this.coinTypeList[i];	
	    		}
	    	
	    		}
	    		mincoins[c] = best;
	    		lastcoin[c] = bestcoin;
	    	}
	    }
	    
	   int[] change = new int [mincoins[amt]];
	   int count = amt;
	   
	   for (int n = 0; n<mincoins[amt]; n++){
		   change[n] = lastcoin[count];
		   count = count - lastcoin[count];
	   }
	   Arrays.sort(change);
	   return change;
	    
	   
	   
   }

  
  /**
   * minCoins returns the smallest number of coins needed
   * to make change for the input amount
   * 
   * @param amt, the input amount
   * @return an int, the smallest number of coins needed to
   *         make change for amt using the denominations in
   *         this.coinTypeList
   */
  public int minCoins(int amt) {
    int [] table = new int[amt+1];
    table[0] = 0;
    table[1] = 1;
    
    for (int c = 2; c < amt+1 ; c++){
    	
    	int temp = table[c - this.coinTypeList[0]];
    	
    	for (int i = 1; i < this.coinTypeList.length; i++ ){
    		if (c < coinTypeList[i]){
    			break;
    		}
    		//if  (i < this.coinTypeList[m]);
    		if (temp > table[c- this.coinTypeList[i]]){
    			temp = table[c- this.coinTypeList[i]];
    		}
    		
    	}
    	table[c] = temp + 1;
    }
    return table[amt];
    }
  

  /**
   * main, for smaller tests...
   */
  public static void main(String[] args) {
    /*
    int[] denominations = {1,5,10};
    Change C = new Change( denominations ); // US System
    printArray( C.makeChange(29) );
    printArray( C.minCoinsTable );
    printArray( C.prevCoinTable );
    */
  }

}

