//login(s): eu6 and bv0
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * UnbalancedBSTMap
 * 
 * An Unbalanced Binary Search Tree, which implements the Map interface (i.e.
 * maps between keys and values). The user specifies the type of the keys and
 * the type of the values. The type of the keys must be a type that implements
 * the interface Comparable.
 */
public class UnbalancedBSTMap<KeyType extends Comparable<KeyType>, ValueType> implements Map<KeyType, ValueType> {

	// instance variable of UnbalancedBSTMap
	BSTNode rootNode; // null rootNode indicates an empty tree
	int treeSize = 0; // tracks treesize.

	/**
	 * BSTNode
	 * 
	 * Private inner class BSTNode represents the nodes of the BST, with each
	 * BSTNode storing a key, a value, and references to the left and right
	 * subtrees.
	 */
	private class BSTNode {
		private KeyType key;
		private ValueType value;
		private BSTNode leftTree;
		private BSTNode rightTree;

		private BSTNode(KeyType inputKey, ValueType inputValue) {

			if (inputKey == null || inputValue == null) {
				throw new IllegalArgumentException("Inserted keys and values must be non-null");
			}
			this.key = inputKey;
			this.value = inputValue;

		}

		private BSTNode(KeyType inputKey, ValueType inputValue, BSTNode inputLeftT, BSTNode inputRightT) {

			new BSTNode(inputKey, inputValue);
			this.leftTree = inputLeftT;
			this.rightTree = inputRightT;

		}
	} // End of class BSTNode
		// (NOTE: BSTNode only has instance variables & constructors)

	// //////////////////////////////////////////////////////////////////
	// *** Queries about the tree ***
	// Methods: isEmpty, size, containsKey, containsValue,
	// get, getMinKey, height
	// //////////////////////////////////////////////////////////////////

	/* *************** */
	// isEmpty
	/* *************** */
	@Override
	// Returns true if the rootNode is null (i.e. there are no BSTNodes)
	public boolean isEmpty() {
		
		return this.rootNode == null;
	}

	/* *************** */
	// size
	/* *************** */
	@Override
	public int size() {

		return (this.treeSize);
	}

	// Private helper method to calculate size using recursion

	/* *************** */
	// containsKey
	/* *************** */
	@SuppressWarnings("unchecked")
	@Override
	// Returns true if the key is in the UnbalancedBSTMap.
	public boolean containsKey(Object keyToFind) {
		return containsKey((KeyType) keyToFind, this.rootNode);
	}

	// Private helper method to perform containsKey using recursion
	private boolean containsKey(KeyType keyToFind, BSTNode currentBSTNode) {
		// Key not found if currentBSTNode is null (i.e. in an empty sub-tree)
		if (currentBSTNode == null) {
			return false;
		}
		KeyType currentKey = currentBSTNode.key;

		// Found the key
		if (keyToFind.equals(currentKey)) {
			return true;
		}
		// Look for the key in the right subtree
		else if (keyToFind.compareTo(currentKey) > 0) {
			return containsKey(keyToFind, currentBSTNode.rightTree);
		}
		// Look for the key in the left subtree
		else {
			return containsKey(keyToFind, currentBSTNode.leftTree);
		}
	}

	/* *************** */
	// containsValue
	/* *************** */
	@Override
	// Searches through every key in the Map to see if it is associated with the
	// input value.
	public boolean containsValue(Object value) {
		// get all keys
		ArrayList<KeyType> allKeys = this.getAllKeysInOrder();
		// search through all keys
		for (KeyType oneKey : allKeys) {
			// get the value associated with this key
			ValueType oneValue = get(oneKey);
			if (oneValue.equals(value)) {
				// found it!
				return true;
			}
		}
		// not found
		return false;
	}

	/* *************** */
	// get
	/* *************** */
	@SuppressWarnings("unchecked")
	@Override
	// Returns the value associated with a particular key
	public ValueType get(Object key) {
		return get((KeyType) key, this.rootNode);
	}

	// Private helper method to perform get using recursion
	private ValueType get(KeyType keyToFind, BSTNode tempRoot) {
		if (tempRoot == null) {
			return null;
		}
		KeyType currentKey = tempRoot.key;
		if (keyToFind.equals(currentKey)) {
			return tempRoot.value;
		} else if (inOrderKeys(currentKey, keyToFind)) {
			return get(keyToFind, tempRoot.rightTree);
		} else {
			return get(keyToFind, tempRoot.leftTree);
		}
	}

	/* *************** */
	// getMinKey
	/* *************** */
	public KeyType getMinKey() {

		return getMinKey(this.rootNode);
	}

	// private helper method for remove necessary in the 2-child case to find
	// the key that should replace the key being deleted.
	private KeyType getMinKey(BSTNode tempRoot) {

		if (tempRoot.leftTree == null) {
			return tempRoot.key;
		}

		return getMinKey(tempRoot.leftTree);
	}

	/* *************** */
	// getHeight
	/* *************** */
	// returns the height of the tree
	public int getHeight() {

		return getHeight(this.rootNode);
	}

	// helper function that returns the height of the tree.
	public int getHeight(BSTNode tempRoot) {
		if (tempRoot == null) {
			return -1;
		}

		if (tempRoot.leftTree == null && tempRoot.rightTree == null) {
			return 0;
		}
		if (tempRoot.leftTree == null) {
			return 1 + getHeight(tempRoot.rightTree);
		}
		if (tempRoot.rightTree == null) {
			return 1 + getHeight(tempRoot.leftTree);
		}
		int height1 = 1 + getHeight(tempRoot.leftTree);
		int height2 = 1 + getHeight(tempRoot.rightTree);
		return Math.max(height1, height2);
	}

	// //////////////////////////////////////////////////////////////////
	// *** Modifications to the tree ***
	// Methods: clear, put, putAll, remove
	// //////////////////////////////////////////////////////////////////

	/* *************** */
	// clear
	/* *************** */
	@Override
	// Removes all keys and values from the UnbalancedBSTMap
	public void clear() {
		this.rootNode = null;
		this.treeSize = 0;

	}

	/* *************** */
	// put
	/* *************** */
	@Override
	// Adds the key and value to the tree.
	public ValueType put(KeyType key, ValueType value) {
		this.treeSize++;
		// Case 1: Tree is empty
		if (this.isEmpty()) {
			this.rootNode = new BSTNode(key, value);
		}
		// Case 2: Tree is not empty
		else {
			// call private helper method to perform operation
			put(key, value, this.rootNode);
		}
		// Always return the value added to the tree

		return value;
	}

	// Private helper method to perform put using recursion
	private void put(KeyType inputKey, ValueType inputValue, BSTNode tempRoot) {
		
		KeyType currentKey = tempRoot.key;
		// Case 1: Found the key, update the value
		if (inputKey.equals(currentKey)) {
			tempRoot.value = inputValue;
		}
		// Case 2: The key is (or would be) in the right subtree
		if (inOrderKeys(currentKey, inputKey)) {
			// Case 2a: empty right subtree, add a new node
			if (tempRoot.rightTree == null) {
				tempRoot.rightTree = new BSTNode(inputKey, inputValue);
			}
			// Case 2b: recursively call put on the right subtree
			else {
				put(inputKey, inputValue, tempRoot.rightTree);
			}
		}
		// Case 3: The key is (or would be) in the left subtree
		else {
			// Case 3a: empty left subtree, a a new node
			if (tempRoot.leftTree == null) {
				tempRoot.leftTree = new BSTNode(inputKey, inputValue);
			}
			// Case 3b: recursively call put on the left subtree
			else {
				put(inputKey, inputValue, tempRoot.leftTree);
			}
		}
	}

	/* *************** */
	// putAll
	/* *************** */
	@Override
	// Provided another map, adds all of the keys and values to the tree
	public void putAll(Map<? extends KeyType, ? extends ValueType> mapOfNewEntries) {
		
		this.treeSize++;
		for (KeyType key : mapOfNewEntries.keySet()) {
			
			ValueType value = mapOfNewEntries.get(key);
			this.put(key, value);

		}

	}

	/* *************** */
	// remove
	/* *************** */
	@Override
	@SuppressWarnings("unchecked")
	public ValueType remove(Object key) {
		this.treeSize--;
		ValueType value = get(key);

		if (value != null) { // Only try to remove keys that are in the tree
			this.rootNode = remove((KeyType) key, this.rootNode);
			
		}
		
		return value;
	}

	// Private helper method to perform remove using recursion
	private BSTNode remove(KeyType inputKey, BSTNode tempRoot) {
		
		if (containsKey(inputKey, tempRoot)) {
			
			if (inputKey.compareTo(tempRoot.key) < 0) {
				tempRoot.leftTree = remove(inputKey, tempRoot.leftTree);
				return tempRoot;	
			}
			
			if (inputKey.compareTo(tempRoot.key) > 0) {
				tempRoot.rightTree = remove(inputKey, tempRoot.rightTree);
				return tempRoot;	
			} 
			else {

				if (tempRoot.rightTree == null && tempRoot.leftTree == null) {
					return null;
					
				}

				if (tempRoot.rightTree == null) {
					return tempRoot.leftTree;
				}
				
				if (tempRoot.leftTree == null) {
					return tempRoot.rightTree;
				} 
				else {
					KeyType minkey = this.getMinKey(tempRoot.rightTree);
					ValueType minvalue = this.get(minkey, tempRoot.rightTree);

					tempRoot.key = minkey;
					tempRoot.value = minvalue;
					tempRoot.rightTree = remove(minkey, tempRoot.rightTree);
				}
			}

		}
		return tempRoot;
	}

	// //////////////////////////////////////////////////////////////////
	// *** Debugging Methods ***
	// Methods: printTreeStructure, toString
	// //////////////////////////////////////////////////////////////////

	/* *************** */
	// printTreeStructure
	/* *************** */
	// prints an indented tree structure of the UnbalancedBSTMap
	public void printTreeStructure() {
		printTreeStructure(this.rootNode, 0);
	}

	// private helper method to recursively print the tree structure
	private void printTreeStructure(BSTNode currentNode, int currentDepth) {
		if (currentNode != null) {
			String currentNodeStr = "[" + currentNode.key.toString() + " , " + currentNode.value.toString() + "]";
			for (int count = 1; count <= currentDepth; count++) {
				System.out.print("\t");
			}
			System.out.println(currentNodeStr);
			printTreeStructure(currentNode.leftTree, currentDepth + 1);
			printTreeStructure(currentNode.rightTree, currentDepth + 1);
		}
	}

	/* *************** */
	// toString
	/* *************** */
	@Override
	// returns a String containing an ordered list of keys
	public String toString() {
		ArrayList<KeyType> allKeys = this.getAllKeysInOrder();
		return allKeys.toString();
	}

	// //////////////////////////////////////////////////////////////////
	// *** Helper Methods ***
	// Methods: inOrderKeys, getAllKeysInOrder
	// //////////////////////////////////////////////////////////////////
	/* *************** */
	// inOrderKeys
	/* *************** */
	// returns true if key1 is less than key2
	private boolean inOrderKeys(KeyType key1, KeyType key2) {
		return key1.compareTo(key2) < 0;
	}

	/* *************** */
	// getAllKeysInOrder
	/* *************** */
	// returns an ArrayList of all of the keys in order
	private ArrayList<KeyType> getAllKeysInOrder() {
		
		ArrayList<KeyType> keyList = new ArrayList<KeyType>();
		addKeysToArrayList(keyList, this.rootNode);

		return keyList;
	}

	// helper method to create the ArrayList of keys in order using recursion
	private void addKeysToArrayList(ArrayList<KeyType> keyList, BSTNode currentNode) {
		if (currentNode != null){
			
		if (currentNode.leftTree != null) {
			addKeysToArrayList(keyList, currentNode.leftTree);
		}
		if (currentNode != null) {
			keyList.add(currentNode.key);
		}
		if (currentNode.rightTree != null) {
			addKeysToArrayList(keyList, currentNode.rightTree);
		}
		}
		return;
		
	}

	// //////////////////////////////////////////////////////////////////
	// *** Extra Credit ***
	// Methods: entrySet, keySet, values
	// //////////////////////////////////////////////////////////////////

	/* *************** */
	// Extra - entrySet
	/* *************** */
	@Override
	public Set<java.util.Map.Entry<KeyType, ValueType>> entrySet() {
		throw new UnsupportedOperationException("Sorry - entrySet was too much of a pain to write");
	}

	/* *************** */
	// Extra - keySet
	/* *************** */
	@Override
	public Set<KeyType> keySet() {
		throw new UnsupportedOperationException("Sorry - keySet was too much of a pain to write");
	}

	/* *************** */
	// Extra - values
	/* *************** */
	@Override
	public Collection<ValueType> values() {
		throw new UnsupportedOperationException("Sorry - values was too much of a pain to write");
	}

}