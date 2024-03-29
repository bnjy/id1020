package directed_3;

import edu.princeton.cs.algs4.*;

public class Digraph_d3 {
	private final int numberOfVertices;
	private int numberOfEdges;
	private Bag<Integer>[] adj;
	
	public Digraph_d3(int V) {
		this.numberOfVertices = V;
		this.numberOfEdges = numberOfEdges;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}
	
	/**
	 * Returns the number of vertices in this graph.
	 * @return the number of vertices in this graph.
	 */
	public int numberOfVertices() {
		return numberOfVertices;
	}
	
	/**
	 * Returns the number of edges in this graph.
	 * @return the number of edges in this graph.
	 */
    public int numberOfEdges() {
    	return numberOfEdges;
    }
    
    public void addEdge(int vertex, int otherVertex) {
    	adj[vertex].add(otherVertex);
    	numberOfEdges++;
    }	
    
	/**
	 * Returns the vertices adjacent to vertex param v.
	 * @param vertex the vertex.
	 * @return the bag connected to the index.
	 */
    public Iterable<Integer> adj(int vertex) {
    	return adj[vertex];
    }  
    
    /**
     * Return the reverse of the graph.
     * @return the reverse of the graph.
     */
    public Digraph_d3 reverse() {
    	Digraph_d3 reverseGraph = new Digraph_d3(numberOfVertices);
    	for (int i = 0; i < numberOfVertices; i++)
    		for (int current : adj(i))
    			reverseGraph.addEdge(current, i);
    	return reverseGraph;
    }
    
    //string representation of the graph.
    public String toString(SymbolGraph_d3 sg) {
		String s = numberOfVertices + " vertices, " + numberOfEdges + " edges\n";
		for (int v = 0; v < numberOfVertices; v++) {
			s += sg.name(v) + ": ";
			for(int w : this.adj(v))
				s += sg.name(w) + " -> "; 
			s += "\n";
		}
		return s;
    }
    
}
