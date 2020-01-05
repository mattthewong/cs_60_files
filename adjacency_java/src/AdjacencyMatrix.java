// Authors: eu6
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AdjacencyMatrix<NodeDataType, EdgeDataType> implements
		DirectedWeightedGraph<NodeDataType, EdgeDataType> {

	/*********************************
	 * Instance Variables
	 *********************************/
	/*
	 * A HashMap allowing us to convert a node's data to an index.
	 */
	/*
	 * The Graph represented as a 2D array where each element represents an
	 * edge. For example, theGraph[3][4] contains the edge from node 3 to node
	 * 4.The type of theGraph is a 2D Object array, but we'll only store
	 * EdgeDataType objects in the array. We can't create an EdgeDataType array
	 * because you can create arrays of types specified by generics. That is,
	 * when you create an array you have to know exactly what type it will be,
	 * which isn't the case if someone specifies the type when constructing the
	 * object like we do for NodeDataType and EdgeDataType.
	 */
	private HashMap<NodeDataType, Integer> nodeIndexLookup = 
			new HashMap<NodeDataType, Integer>();

	private Object[][] theGraph = new Object[0][0];

	/*********************************
	 * Private Helper Methods
	 *********************************/
	// return the number of nodes in the graph (never negative)
	private int getNumNodes() {
		// Each node has one element in the nodeToIndexMap
		return this.nodeIndexLookup.size();
	}

	// returns an edge given the src and dst indices
	@SuppressWarnings("unchecked")
	private EdgeDataType getEdge(int srcIndex, int dstIndex) {
		// We store theGraph as and Object[][] so must cast to an EdgeDataType
		return (EdgeDataType) this.theGraph[srcIndex][dstIndex];
	}

	// sets the edge within theGraph given the srce and dst indices
	private void setEdge(int srcIndex, int dstIndex, EdgeDataType edge) {
		this.theGraph[srcIndex][dstIndex] = edge;
	}
	
	/*********************************
	 * Access Methods
	 *********************************/
	// return the full set of nodes in the graph
	@Override
	public Set<NodeDataType> getNodes() {
		return this.nodeIndexLookup.keySet();
	}

	// return the edge's data or null if there is no edge
	@Override
	public EdgeDataType getEdge(NodeDataType srcNodeData,
			NodeDataType dstNodeData) {
		Integer srcNodeIndex = this.nodeIndexLookup.get(srcNodeData);
		Integer dstNodeIndex = this.nodeIndexLookup.get(dstNodeData);
		if (srcNodeIndex == null || dstNodeIndex == null){
			// srcNodeData or dstNodeData not found! 
			return null;
		}
		return this.getEdge(srcNodeIndex.intValue(), dstNodeIndex.intValue());
	}

	// returns true if the nodeData is within the graph, false otherwise
	@Override
	public boolean containsNode(NodeDataType nodeData) {
		return this.nodeIndexLookup.containsKey(nodeData);
	}

	// returns true if an edge exists between the src and dst nodes, false
	// otherwise
	@Override
	public boolean adjacent(NodeDataType srcNodeData, NodeDataType dstNodeData) {
		return this.getEdge(srcNodeData, dstNodeData) != null;
	}

	// returns a set of the neighbors of a particular node
	@Override
	public Set<NodeDataType> neighbors(NodeDataType srcNodeData) {
		Integer currentNodeIndex = this.nodeIndexLookup.get(srcNodeData);
		if (currentNodeIndex == null){
			// The node is not in the graph
			return new HashSet<NodeDataType>(); 
		}
		int numNodes = this.getNumNodes();
		// figure out what edges exist
		boolean[] nodesConnected = new boolean[numNodes];
		for (int dstIndex = 0; dstIndex < numNodes; dstIndex++) {
			EdgeDataType edge = this.getEdge(currentNodeIndex, dstIndex);
			if (edge != null) {
				nodesConnected[dstIndex] = true;
			}
		}
		// add nodes with edges to the output
		Set<NodeDataType> connectedNodes = new HashSet<NodeDataType>();
		Set<NodeDataType> allNodes = this.nodeIndexLookup.keySet();
		for (NodeDataType node : allNodes) {
			int dstIndex = this.nodeIndexLookup.get(node).intValue();
			if (nodesConnected[dstIndex]) {
				connectedNodes.add(node);
			}
		}
		return connectedNodes;
	}

	/*********************************
	 * Methods to Modify the Graph
	 *********************************/
	// return false if the graph already contains the node and true if the node
	// is added to the graph
	@Override
	public boolean addNode(NodeDataType nodeData) {
		
		if (this.containsNode(nodeData)) {
			return false;
		}
		int numNodes = this.getNumNodes();
		Integer nodeIndex = numNodes; 
		this.nodeIndexLookup.put(nodeData,nodeIndex);
		// Grow the graph to include one more node!
		Object[][] graphTemp = new Object[numNodes + 1][numNodes + 1];
		for (int row = 0; row < numNodes ; row++) {
			for (int column = 0; column < numNodes ; column++) {
				
				graphTemp[row][column] = this.theGraph[row][column];
				
			}
			
		}

		// update the graph
		this.theGraph = graphTemp;
		return true;
	}

	// return false if the node was not in the graph and true otherwise
	@Override
	public boolean removeNode(NodeDataType nodeData) {
		if (!this.containsNode(nodeData)) {
			return false;
		}
		int numNodes = this.getNumNodes();
		int nodeIndex = this.nodeIndexLookup.get(nodeData).intValue();
		this.nodeIndexLookup.remove(nodeData);
		// Shrink the graph to include one fewer node!
		Object[][] graphTemp = new Object[numNodes - 1][numNodes - 1];
		for (int row = 0; row < numNodes - 1; row++) {
			for (int column = 0; column < numNodes - 1; column++) {
				// calculate the src row and columns
				// uses the Java ternary operator
				// read about it here:
				// https://www.google.com/search?q=ternary+operator+java
				int srcRow = (row >= nodeIndex) ? row : row + 1;
				int srcColumn = (column >= nodeIndex) ? column : column + 1;
				// copy all of the elements over to graphTemp
				graphTemp[row][column] = this.theGraph[srcRow][srcColumn];
			}
		}
		// update the graph
		this.theGraph = graphTemp;
		return true;

	}

	// returns false if the edge is in the graph and true otherwise
	// to replace an edge, remove the edge and add it back in
	@Override
	public boolean addEdge(NodeDataType srcNodeData, NodeDataType dstNodeData,
			EdgeDataType edge) {
		if (srcNodeData.equals(dstNodeData)){
			return false;
		}
		this.addNode(srcNodeData);
		this.addNode(dstNodeData);
		Integer srcNodeIndex = this.nodeIndexLookup.get(srcNodeData);
		Integer dstNodeIndex = this.nodeIndexLookup.get(dstNodeData);
		if (srcNodeIndex == null || dstNodeIndex == null){
			// srcNodeData or dstNodeData not found! 
			return false;
		}
		this.setEdge(srcNodeIndex.intValue(), dstNodeIndex.intValue(), edge);
		return true;
	}

	// returns the edge that is removed or null if the edge did not exist
	@Override
	public EdgeDataType removeEdge(NodeDataType srcNodeData,
			NodeDataType dstNodeData) {
		Integer srcNodeIndex = this.nodeIndexLookup.get(srcNodeData);
		Integer dstNodeIndex = this.nodeIndexLookup.get(dstNodeData);
		if (srcNodeIndex == null || dstNodeIndex == null){
			// srcNodeData or dstNodeData not found! 
			return null;
		}
		EdgeDataType edge = this.getEdge(srcNodeIndex, dstNodeIndex);
		this.setEdge(srcNodeIndex.intValue(), dstNodeIndex.intValue(), null);
		return edge;
	}
}