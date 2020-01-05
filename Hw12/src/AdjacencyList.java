import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//login(s): eu6
public class AdjacencyList<NodeDataType, EdgeDataType> implements
		DirectedWeightedGraph<NodeDataType, EdgeDataType> {

	/*********************************
	 * Instance Variables
	 *********************************/
	// For each node, store a set of connected nodes and the edge weight
	private Map<NodeDataType, HashMap<NodeDataType, EdgeDataType>> theGraph = 
			new HashMap<NodeDataType, HashMap<NodeDataType, EdgeDataType>>();

	/*********************************
	 * Access Methods
	 *********************************/
	// return the full set of nodes in the graph
	@Override
	public Set<NodeDataType> getNodes() {
		return this.theGraph.keySet();
		}
	

	// return the edge's data or null if there is no edge
	@Override
	public EdgeDataType getEdge(NodeDataType srcNodeData,
			NodeDataType dstNodeData) {
		if (!this.theGraph.containsKey(srcNodeData) || ! this.theGraph.containsKey(dstNodeData)){
			return null;
		}
		if (srcNodeData == null || dstNodeData == null){
			return null;
		}
		HashMap<NodeDataType, EdgeDataType> sourcemap = this.theGraph.get(srcNodeData);
		if (sourcemap == null){
			return null;
		}
		return sourcemap.get(dstNodeData);
	}

	// returns true if the nodeData is within the graph, false otherwise
	@Override
	public boolean containsNode(NodeDataType nodeData) {
		
		 if (this.theGraph.containsKey(nodeData)){
			 return true;
		 }
		return false;
	}

	// returns true if an edge exists between the src and dst nodes, false
	// otherwise
	@Override
	public boolean adjacent(NodeDataType srcNodeData, NodeDataType dstNodeData) {
		
		if (theGraph.get(srcNodeData) == null){
			return false;
		}
		
		return (theGraph.get(srcNodeData).containsKey(dstNodeData));
	}
			
	// returns a set of the neighbors of a particular node
	@Override
	public Set<NodeDataType> neighbors(NodeDataType srcNodeData) {
		if (! this.theGraph.containsKey(srcNodeData)){
			return new HashSet<NodeDataType>();
		}
		if (this.theGraph.get(srcNodeData)==null){
			return new HashSet<NodeDataType>();
		}
		HashMap<NodeDataType, EdgeDataType> neighborset = theGraph.get(srcNodeData);
		
		return neighborset.keySet();
	}

	/*********************************
	 * Methods to Modify the Graph
	 *********************************/
	// return false if the graph already contains the node and true if the node
	// is added to the graph
	@Override
	public boolean addNode(NodeDataType nodeData) {
		if (this.theGraph.containsKey(nodeData) == true){
			return false;
		}
		else{
		this.theGraph.put(nodeData,new HashMap<NodeDataType, EdgeDataType>());
		return true;
		}
	}

	// return false if the node was not in the graph and true otherwise
	@Override
	public boolean removeNode(NodeDataType nodeData) {
		if (! this.containsNode(nodeData)){
			return false;
	}
		this.theGraph.remove(nodeData);
		return true;
		
	}
	
	
	// returns false if the edge is in the graph and true otherwise
	// to replace an edge, remove the edge and add it back in
	@Override
	public boolean addEdge(NodeDataType srcNodeData, NodeDataType dstNodeData,
			EdgeDataType edge){
		
		if (srcNodeData.equals(dstNodeData)){
			return false;
		}
		if (this.theGraph.containsKey(srcNodeData)==false){
			this.addNode(srcNodeData);
		}
		if (this.theGraph.containsKey(dstNodeData)==false){
			this.addNode(dstNodeData);
		}
		
		if (this.theGraph.get(srcNodeData)==null){
			
			this.theGraph.put(srcNodeData, new HashMap<NodeDataType, EdgeDataType>());
			
			this.theGraph.get(srcNodeData).put(dstNodeData,edge);
			
			return true;
		}
		if (this.theGraph.get(srcNodeData).containsKey(dstNodeData)==true){
			
			return false;
		}
		
		
		this.theGraph.get(srcNodeData).put(dstNodeData,edge);
		System.out.println(this.theGraph.get(srcNodeData));
		System.out.println("adding destination");
		return true;
	}

	// returns the edge that is removed or null if the edge did not exist
	@Override
	public EdgeDataType removeEdge(NodeDataType srcNodeData,
			NodeDataType dstNodeData) {
		if (! this.theGraph.containsKey(dstNodeData) || ! this.theGraph.containsKey(srcNodeData)){
			return null;
		}
		if (this.theGraph.get(srcNodeData).containsKey(dstNodeData)){
			
			return this.theGraph.get(srcNodeData).remove(dstNodeData);
			
		}
		return null;
	}

}