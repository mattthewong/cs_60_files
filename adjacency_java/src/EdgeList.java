import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//login(s): eu6
public class EdgeList<NodeDataType, EdgeDataType> implements
		DirectedWeightedGraph<NodeDataType, EdgeDataType> {
	/*********************************
	 * Inner class to represent an Edge
	 *********************************/
	private class NodePair {
		NodeDataType srcNode;
		NodeDataType dstNode;

		// Note - we don't include the Edge weight so that we can hash NodePairs

		private NodePair(NodeDataType srcNodeInput, NodeDataType dstNodeInput) {
			this.srcNode = srcNodeInput;
			this.dstNode = dstNodeInput;

		}

		// Two edges are equal if their src and dst nodes are the same
		@SuppressWarnings("rawtypes")
		public boolean equals(Object obj) {
			if (obj instanceof EdgeList.NodePair) {
				@SuppressWarnings("unchecked")
				NodePair edge2 = (EdgeList.NodePair) obj;
				return this.srcNode.equals(edge2.srcNode)
						&& this.dstNode.equals(edge2.dstNode);
			} else {
				return false;
			}
		}

		public int hashCode() {
			return this.srcNode.hashCode() + this.dstNode.hashCode();
		}
		public String toString(){
			return "[" + this.srcNode + ", " + this.dstNode + "]";
		}
	}

	/*********************************
	 * Instance Variables
	 *********************************/
	// A mapping between pairs of nodes (i.e. and edge) and their weight
	private Map<NodePair, EdgeDataType> theGraph = new HashMap<NodePair, EdgeDataType>();

	// Store a copy of each node to not lose any nodes that aren't part of an edge
	private Set<NodeDataType> allNodes = new HashSet<NodeDataType>();

	/*********************************
	 * Access Methods
	 *********************************/
	// return the full set of nodes in the graph
	@Override
	public Set<NodeDataType> getNodes() {
		Set<NodeDataType> outputSet = new HashSet<NodeDataType>();
		for (NodeDataType nodeData : this.allNodes) {
			outputSet.add(nodeData);
		}
		return outputSet;
	}

	// return the edge's data or null if there is no edge
	@Override
	public EdgeDataType getEdge(NodeDataType srcNodeData,
			NodeDataType dstNodeData) {
		NodePair pair = new NodePair(srcNodeData, dstNodeData);
		return this.theGraph.get(pair);
	}

	// returns true if the nodeData is within the graph, false otherwise
	@Override
	public boolean containsNode(NodeDataType nodeData) {
		return this.allNodes.contains(nodeData);
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
		Set<NodeDataType> neighbors = new HashSet<NodeDataType>();
		Set<NodePair> nodePairs = this.theGraph.keySet();
		for (NodePair nextPair : nodePairs) {
			if (nextPair.srcNode.equals(srcNodeData)) {
				neighbors.add(nextPair.dstNode);
			}
		}
		return neighbors;
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
		}else{
			this.allNodes.add(nodeData);
			return true;
		}
	}
	

	// return false if the node was not in the graph and true otherwise
	@Override
	public boolean removeNode(NodeDataType nodeData) {
		
		if (! this.containsNode(nodeData)){
			return false;
		}
		this.allNodes.remove(nodeData);
		for (NodeDataType node : this.allNodes){
			NodePair pair = new NodePair(nodeData, node);
			this.theGraph.remove(pair);
			
		}
		return true;
		}
	
	

	// returns false if the edge is in the graph and true otherwise
	// to replace an edge, remove the edge and add it back in
	@Override
	public boolean addEdge(NodeDataType srcNodeData, NodeDataType dstNodeData,
			EdgeDataType edge) {
		NodePair thePair = new NodePair(srcNodeData, dstNodeData);
		if (this.theGraph.containsKey(thePair)) {
			return false;
		} else if (srcNodeData.equals(dstNodeData)){
			return false;
		}
		this.allNodes.add(srcNodeData);
		this.allNodes.add(dstNodeData);
		
		this.theGraph.put(thePair, edge);
		return true;
		
	}

	// returns the edge that is removed or null if the edge did not exist
	@Override
	public EdgeDataType removeEdge(NodeDataType srcNodeData,
			NodeDataType dstNodeData) {
		NodePair thePair = new NodePair(srcNodeData, dstNodeData);
		return this.theGraph.remove(thePair);
	}
}