package directed_3;

import edu.princeton.cs.algs4.*;

public class DepthFirstOrder_d3 {
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DepthFirstOrder_d3(Digraph_d3 graph) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[graph.numberOfVertices()];
		
		for(int i = 0; i < graph.numberOfVertices(); i++) {
			if(!marked[i])
				dfs(graph, i);
		}
	}
		
	private void dfs(Digraph_d3 graph, int from) {
		pre.enqueue(from);
		marked[from] = true;
		for(int current : graph.adj(from))
			if(!marked[current])
				dfs(graph, current);
		post.enqueue(from);
		reversePost.push(from);
	}
	
	public Iterable<Integer> pre(){
		return pre;
	}
	
	public Iterable<Integer> post(){
		return post;
	}
	
	public Iterable<Integer> reversePost(){
		return reversePost;
	}

}
