package org.junit;
//login(s): eu6
	/**
	 * List class
	 * 
	 * This class creates Objects that can represent a List of Strings.
	 * 
	 * Implementation details:
	 * This List class
	 *   - is a singly-linked list (references pointing from front to back)
	 *   - has an *inner* class (ListNode) that works just like Racket lists!
	 *   - each ListNode has data (a String, named myData)
	 *                   and a reference to another ListNode (myNext)
	 *
	 * @author (login):eu6
	 * 
	 * Comments/notes:
	 */
	public class List {

		private ListNode myHead;
		private int mySize;

		/**
		 * zero-input constructor, which creates an empty List
		 */
		public List() {
			this.myHead = null;
			this.mySize = 0;
		}

		
		/** ListNode
		 * 
		 * This inner class represents the internal structure of a List.
		 * Each node has its own data and a pointer to the next node in the list 
		 * Note how this is similar to [first,rest] pairs like Racket lists!
		 * 
		 */
		private class ListNode {
			
			private String myData;
			private ListNode myNext;

			/**
			 * ListNode constructor
			 * @param data, this node's data
			 * @param next, a pointer to the node that will be next after this one
			 */
			private ListNode(String data, ListNode next) {
				this.myData = data;
				this.myNext = next;
			}

			/**
			 * convenience constructor that creates a ListNode
			 * with a null reference to a second ListNode
			 */
			private ListNode(String data) {
				// An additional use of the keyword "this" is to call a constructor
				// with a different set of arguments. Delegating to other
				// constructors like this must be the first line of code
				// within a constructor:
				this(data, null);
			}
		}

		
		/*********************
		 * 
		 * List Methods
		 * 
		 *********************/
		
		
		/**
		 * isEmpty() checks if this List has no elements
		 * @return true if the List contains no ListNodes
		 */
		public boolean isEmpty() {
			return this.myHead == null;
			// also could have checked that mySize == 0;
		}

		/**
		 * toString() produces a string representation for this List
		 * @return a String representation of the contents of the List
		 */
		public String toString() {
			String rtn = "( ";
			for (ListNode node = this.myHead; node != null; node = node.myNext) {
				rtn = rtn + node.myData + " ";
			}
			return rtn + ")";
		}

		/**
		 * size() is a "getter" method for the mySize data member of List
		 * @return the number of ListNodes in the List.
		 */
		public int size() {
			return this.mySize;
		}

		/**
		 * length() computes the number of nodes in this List from scratch - 
		 * without using the mySize instance variable
		 * @return the number of ListNodes in the List.
		 */
		public int length() {
			int count = 0;
			// for loop example
			for (ListNode node = this.myHead; node != null; node = node.myNext) {
				count++;
			}
			return count;
		}

		/**
		 * length2() computes the number of nodes in this List from scratch - 
		 * without using the mySize instance variable (using a while loop)
		 * @return the number of ListNodes in the List.
		 */
		public int length2() {
			int count = 0;
			ListNode node = this.myHead;
			// while loop example
			while (node != null) {
				count++;
				node = node.myNext;
			}
			return count;
		}
		

		/**
		 * contains(String s) computes whether s is in this List
		 * @param s, a string to look for in the List.
		 * @return true if s is in the list, false otherwise
		 */
		public boolean contains(String s) {
			for (ListNode node = this.myHead; node != null; node = node.myNext) {
				if (s.equals(node.myData)) {
					return true;
				}
			}
			return false;
		}

		/**
		 * get(int pos) returns the element at index pos in this List
		 * @param the desired index in the List.
		 * @return the value of the string at element number pos
		 * (zero-indexed) from the List
		 * @throws IllegalArgumentException if there is no element
		 * at that position
		 */
		public String get(int pos) {
			if (pos < 0) {
				throw new IllegalArgumentException(
						  "Argument to get must be at least 0.");
			}
			if (pos >= this.size()) {
				throw new IllegalArgumentException(
						  "Argument to get is too large.");
			}
			int k = 0;
			ListNode node = this.myHead;
			while (node != null) {
				if (k == pos) {
					return node.myData;
				}
				node = node.myNext; // move to the next element
				k++;
			}
			return null;
		}

		/**
		 * addToFront(String str)
		 * @param str is a new String to be inserted at the front of the list
		 * 
		 * Note that addToFront modifies this List; it does *not* return anything.
		 * It's different than the constructor, which does create a new list.
		 */
		public void addToFront(String str) {
			this.mySize++;
			ListNode newNode = new ListNode(str, this.myHead);
			this.myHead = newNode;
		}

		// an example of overloading (same function, different type of inputs):
		// Note how this method is private, as only methods inside List know that ListNode exists
		/**
		 * addToFront(ListNode node)
		 * @param node which is a ListNode to be inserted as the first element in
		 * the current List.
		 * This should modify the List and does not return anything.
		 */
		private void addToFront(ListNode node) {
			this.mySize++;
			node.myNext = this.myHead;
			this.myHead = node;
		}
		/**
		 * addTextToAllNodes(String s)
		 * @param str is a String to add to the data of every ListNode.
		 * 
		 * the method _should_ modify the ListNodes!
		 */
		public void addTextToAllNodes(String str){
			ListNode current = this.myHead;
			while (current != null){
				current.myData = current.myData + str;
				current = current.myNext;
			}
		}
		
		/**
		 * replaceLongestDataWithX()
		 * 
		 * the method _should_ modify the ListNodes!
		 */
		public void replaceLongestDataWithX() {
			if (this.myHead == null) {
				return;
			}
			ListNode longestNode = this.myHead;
			ListNode current = this.myHead.myNext;
			while (current != null) {
				if (current.myData.length() > longestNode.myData.length()) {
					longestNode = current;
				}
				current = current.myNext;
			}
			longestNode.myData = "X";
		}
		
		/**
		 * equals(List list2) 
		 * @param obj is an Object to compare this List to.
		 * @return true if obj is a list with the same elements in the
		 * same order as this; false otherwise
		 */
		public boolean equals(List list2) {
			
			// if the two lists are different sizes, they are not equal
			if (this.mySize != list2.mySize) {
				return false;
			}
			// compare element by element
			ListNode node1 = this.myHead;
			ListNode node2 = list2.myHead;
			for (int i = 0; i < this.mySize; i++) {
				// get the two strings
				String s1 = node1.myData;
				String s2 = node2.myData;
				if (s1.equals(s2) == false) { // equivalent to if(!s1.equals(s2))
					return false;
				}
				node1 = node1.myNext; // "walk" down this list
				node2 = node2.myNext; // "walk" down list2
			}
			// if we haven't returned false by this point, return true
			return true;
		}
		
		/**
		 * equals(Object obj) 
		 * @param obj is an Object to compare this List to.
		 * @return true if obj is a list with the same elements in the
		 * same order as this; false otherwise
		 */
		public boolean equals(Object obj) {
			// if obj is not of type List, they are not equal
			if (!(obj instanceof List)) {
				return false;
			}

			// We know that obj is of type List.
			// So, we can cast it to a reference (list2) of type List
			List list2 = (List) obj;

			// if the two lists are different sizes, they are not equal
			if (this.mySize != list2.mySize) {
				return false;
			}
			// compare element by element
			ListNode node1 = this.myHead;
			ListNode node2 = list2.myHead;
			for (int i = 0; i < this.mySize; i++) {
				// get the two strings
				String s1 = node1.myData;
				String s2 = node2.myData;
				if (s1.equals(s2) == false) {
					return false;
				}
				node1 = node1.myNext; // "walk" down this list
				node2 = node2.myNext; // "walk" down list2
			}
			// if we haven't returned false by this point, return true
			return true;
		}

		/**
		 * add(String s)
		 * 
		 * @param s is a String to add to the end of the List.
		 * 
		 * This should modify the List and does not return anything. If this List is
		 * empty, it should add the String to the back of the List. If the List is
		 * not empty, it should search to find the last ListNode in the List and
		 * then add a new ListNode, containing s, beyond it as the final element.
		 */
		public void add(String s) {
			
			if (this.mySize == 0){
				this.mySize ++;
				ListNode N = new ListNode(s,null);
				this.myHead = N;
			
			}
			else {
				this.mySize++;
				ListNode node1 = this.myHead;
				
				while (node1.myNext != null){
					node1 = node1.myNext;
					}
		
				node1.myNext = new ListNode(s,null);
				return;
				}
				
			}
			
		
	
		
		/**
		 * add(ListNode node)
		 * 
		 * @param node is a ListNode to add to the end of the List.
		 * 
		 * This should modify the List and does not return anything. If this List is
		 * empty, it should add node to the List. If not empty, it should search to
		 * find the last ListNode in the List and the add node beyond it as the
		 * final element.
		 * 
		 * Another example of overloading based on input type (private method):
		 */
		private void add(ListNode node) {
			
			if (this.mySize == 0){
				
				this.myHead = node;
				this.mySize ++;
				return;
			}
			else {
				this.mySize ++;
				ListNode node1 = this.myHead;
				while (node1.myNext != null){
					node1 = node1.myNext;
				}
				node1.myNext = node;
			}
			
			
			
		}
		
		/**
		 * removeFirst()
		 * 
		 * @return the data (as a String) that was previously stored 
		 * in the first ListNode in the List, or null if the list is empty
		 * 
		 * This should modify the List to remove the first element in the List. The
		 * List should be unchanged if this is called on an empty List.
		 */
		public String removeFirst() {
			if (this.mySize == 0){
				return null;
			}
			else {
			ListNode N = this.myHead;
			
			this.myHead = this.myHead.myNext;
			
			this.mySize = this.mySize -1;
			
			return N.myData;
			}
		}
			
			
		


		/**
		 * appendInPlace(List list2)
		 * @param list2 is a List to be appended to the end of this List. 
		 * appendInPlace _should_ copy the data from 
		 * list2 into new ListNodes at then end of this List. However,
		 * appendInPlace should *not* return anything and should *not* modify list2.
		 */
		public void appendInPlace(List list2) {
			
			for (int i = 0; i < list2.mySize; i++){
				
				ListNode N1 = new ListNode(list2.get(i));
				
				this.add(N1);
			}
		}

		
	
			
		/**
		 * makeFromArray(String[] strArr)
		 * 
		 * @param strArr is an array of Strings.
		 * 
		 * @return a List of the same size as the input strArr and with the content
		 * from strArr in the order they appear in strArr.
		 * 
		 * This method is labeled as STATIC. 
		 * 
		 * This means you don't need an object of type List to call this method. 
		 * Because it's static, there is no "this" reference -- since there is no
		 * object calling the method! 
		 * 
		 * So, to call this method you'd use the class name: List.makeFromArray(strArr). 
		 * We also could have made this a constructor that took in an String[].
		 * 
		 * You should use addToFront, **not** add, to create elements in the resulting List. 
		 * addToFront takes constant time, so this will allow you to add all
		 * of the N elements to your List in time proportional strArr.length
		 */
		public static List makeFromArray(String[] strArr){
			
			List X = new List();
			
			for (int i=strArr.length -1; i >= 0 ; i--){
				
				X.addToFront(strArr[i]);
				
			}
			return X;
	
		}

		/**
		 * makeEquivalentArray()
		 *  
		 * @param none.
		 * 
		 * @return an String[] with the contents from the List in the same order in
		 * which they appear in the List.
		 * 
		 * It should not modify the List.
		 */
		public String[] makeEquivalentArray() {
			
			String[] StringX = new String[this.length()];
			
			for (int i = 0; i < this.length(); i++){
				
				StringX[i] = this.get(i);
			}
			return StringX;
			
		}

		/**
		 * reverse()
		 * 
		 * @return none
		 * 
		 * This method should reverse the contents of the List without creating any
		 * new ListNode Objects or any new List Objects and without creating an
		 * Array or other structures. You can create references to Objects, but you
		 * can't call new. This type of restriction is called doing something
		 * "in place" because it does not require any additional Objects to be
		 * created.
		 * 
		 * If you do this recursively, you'll be able to use removeFirst; if you
		 * use loops, you will need a few ListNode references. Specifically, if you
		 * are looping, I'd recommend creating ListNode references to refer to the
		 * previous, current, and next ListNode as your code "walks" the list...
		 */
		public void reverse() {
			
			if (this.length() != 0){
				
				ListNode X = this.myHead;
				
				this.removeFirst();
				
				this.reverse();
				
				this.add(X.myData);
			}
			
		} 

		/**
		 * split()
		 * 
		 * @return a new List that contains the second half of the elements in the
		 * original List.
		 * 
		 * The current list (this) should be modified to now only have a list of
		 * half the length. 
		 * 
		 * If the current list (this) has only 1 element, the List should be
		 * unmodified and should return an empty List.
		 * 
		 * If the current list (this) has an odd number of elements, the current
		 * List should have one more element than the List that is returned.
		 */
		public List split() {
			
			if (this.mySize == 1){
				
				return null;
			}
			List newlist = new List();
			
			int count  = this.mySize/2;
			
			int counter = 0;
			
			ListNode current = this.myHead;
			
			if (this.mySize % 2 ==1){
				
				count = count + 1;
			}
			int newsize = this.mySize - count;
			
				while (current.myNext != null){
					
					if (counter >= count ){
						
						newlist.myHead = current;
						
						this.mySize = count;
						
						current = current.myNext;
							
				}
					else if (counter == count -1){
						
						ListNode temp = current.myNext;
						
						current.myNext = null;
						
						current = temp;
					}
					else {
						current = current.myNext;
					}
					counter++;	
				}
				newlist.mySize = newsize;
				
				return newlist;
				
		}
				


		/**
		 * merge(List list2)
		 * 
		 * @param list2 is an already sorted List to be merged with the current List
		 * (this).
		 * 
		 * The method should modify the current List to contain the merged
		 * combination of the current List (this) and the input List (list2).
		 * 
		 * The method merge should only be called on a List that is already in
		 * sorted order.
		 * 
		 * You will find Java's compareTo method helpful. Find information about
		 * String's compareTo here:
		 * http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#compareTo(java.lang.String)
		 * You can also look at the examples in BSTNode.java
		 * 
		 * It's OK to make an extra List Object (such as the mergedList that will
		 * become the result), but you should not create any new ListNode Objects
		 * You'll find the method removeFirst() and addToFront(ListNode node)
		 * helpful.
		 * 
		 * This method will modify this and list2. When completed, list2 should be
		 * empty and the current List (this) should contain all elements in sorted
		 * order
		 */

		public void merge(List list2){
			List temp = new List();
			this.mySize =temp.mySize;
			this.mySize = this.mySize + list2.mySize;
			
			
			if (this.mySize == 0){
				
				temp.appendInPlace(list2);
			}
			if (list2.mySize==0){
				
				temp.appendInPlace(this);
			}
			int tempsize = 0;
			
			while (tempsize != this.mySize + list2.mySize){
				
				if (this.myHead.myData.compareTo(list2.myHead.myData) < 0 && this.myHead != null){
					
				temp.add(this.myHead.myData);
				
				this.removeFirst();
				
				this.myHead = this.myHead.myNext;
				}
				else if(this.myHead.myData.compareTo(list2.myHead.myData) > 0 && list2.myHead != null){
					
					temp.add(list2.myHead.myData);
					
					list2.removeFirst();
					
					list2.myHead = list2.myHead.myNext;
					
			}
				temp.mySize ++;
			}
			this.myHead = temp.myHead;
			
			this.mySize = temp.mySize;
		}
		
		 
			
		

		/**
		 * mergeSort()
		 * 
		 * The method mergeSort should use split() and merge(List list2) to execute
		 * mergesort on a List.
		 * 
		 * This method will modify the List.
		 */
		public void mergeSort() {
			
			
		}

		/*
		 * The main method may include informal tests and other code...
		 * 
		 * In addition, there is a set of List unit tests available in 
		 * ListTest.java
		 */
		public static void main(String[] args) {
			
			System.out.println("Q: Why is this List class like Zelda?");
			System.out.println("A: They're both 'linked.'");

			/*
			 * This is one I used when debugging... :
			 *
			String[] input1 = { "b", "c" };
			String[] input2 = { "a", "d" };
			String[] correct = { "a", "b", "c", "d" };
			List list1 = List.makeFromArray(input1);
			List list2 = List.makeFromArray(input2);
			List list3 = List.makeFromArray(correct);
			System.out.println("list1 is " + list1);
			System.out.println("list2 is " + list2);
			System.out.println("list3 is " + list3);
			list1.merge(list2); // merge!
			System.out.println("result is " + list1);
			 *
			 */		
		}

	

		


	
	


