package directed_3;

import edu.princeton.cs.algs4.Stack;

public class DirectedCycle_d3 {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	private boolean[] onStack;
	
    /**
     * Determines whether the graph has a directed cycle and then
     * finds such a cycle.
     * @param graph the graph
     */
	public DirectedCycle_d3(Digraph_d3 graph) {
		onStack = new boolean[graph.numberOfVertices()];
		edgeTo = new int[graph.numberOfVertices()];
		marked = new boolean[graph.numberOfVertices()];
		for(int i = 0; i < graph.numberOfVertices(); i++) {
			if(!marked[i])
				dfs(graph, i);
		}
	}
	
	//check that algorithm computes either the topological order or finds a directed cycle
	private void dfs(Digraph_d3 graph, int v) {
		onStack[v] = true;
		marked[v] = true;
		for(int w : graph.adj(v))
			if(this.hasCycle())
				return;
			else if(!marked[w]) {
				edgeTo[w] = v;
				dfs(graph, w);
			} else if(onStack[w]) {
				cycle = new Stack<Integer>();
				for(int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		onStack[v] = false;
	}
	
    /**
     * Does the digraph have a directed cycle?
     * @return true if the graph has a directed cycle, false if not.
     */
	public boolean hasCycle() {
		return cycle != null;
	}
	
    /**
     * Returns a directed cycle if the graph has a directed cycle.
     * @return a directed cycle
     */
	public Iterable<Integer> cycle(){
		return cycle;
	}

}
