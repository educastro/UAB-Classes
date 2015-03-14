package lab13;

import java.util.LinkedList;
import java.util.Queue;

public class MSTPrim {

	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private ExtractMin pq;

	public MSTPrim(Graph G){

		edgeTo = new Edge[G.V];
		distTo = new double[G.V];
		marked = new boolean[G.V];
		pq = new ExtractMin(G.V);
		for (int v = 0; v < G.V; v++) distTo[v] = Double.POSITIVE_INFINITY;

		for (int v = 0; v < G.V; v++)      // run from each vertex to find
			if (!marked[v]) prim(G, v);      // minimum spanning forest

	}

	private void prim(Graph G, int s) {
		distTo[s] = 0.0;
		pq.insert(s, distTo[s]);
		while (!pq.isEmpty()) {
			int v = pq.delMin();
			prim2(G, v);
		}
	}

	private void prim2(Graph G, int v) {
		marked[v] = true;
		for (Edge e : G.adj[v]) {
			int w = e.other(v);
			//if (marked[w]) continue; 
			if (e.edgeWeight < distTo[w]) {
				distTo[w] = e.edgeWeight;
				edgeTo[w] = e;
				if (pq.contains(w)) 
					pq.decreaseKey(w, distTo[w]);
				else                
					pq.insert(w, distTo[w]);
			}
		}
	}

	public Iterable<Edge> edges() {
		Queue<Edge> mst = new LinkedList<Edge>();
		for (int v = 0; v < edgeTo.length; v++) {
			Edge e = edgeTo[v];
			if (e != null) {
				mst.add(e);
			}
		}
		return mst;
	}	

	public double weight() {
		double weight = 0.0;
		for (Edge e : edges())
			weight += e.edgeWeight;
		return weight;
	}
}

