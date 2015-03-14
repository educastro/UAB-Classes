package lab14;

import java.util.Stack;

public class Dijkstra {

	ExtractMin Q;
	public double[] distanceTo;
	Edge[] edgeTo;

	public Dijkstra(Graph G, int s){
		distanceTo = new double[G.V];
		edgeTo = new Edge[G.V];
		Q = new ExtractMin(G.V);

		for(int iterator = 0; iterator < G.V; iterator++){
			distanceTo[iterator] = Double.MAX_VALUE;
		}

		distanceTo[s] = 0.0;
		Q.insert(s, distanceTo[s]);

		while(!Q.isEmpty()){
			int u = Q.delMin();
			for(Edge v : G.adj[u]){
				relax(v);
			}
		}
	}

	private void relax(Edge e){
		int v1 = e.v1;
		int v2 = e.v2;

		if (distanceTo[v2] > distanceTo[v1] + e.edgeWeight) {
			distanceTo[v2] = distanceTo[v1] + e.edgeWeight;
			edgeTo[v2] = e;
			if (Q.contains(v2)) 
				Q.decreaseKey(v2, distanceTo[v2]);
			else                
				Q.insert(v2, distanceTo[v2]);
		}			
	}
	
	public Iterable<Edge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Edge> path = new Stack<Edge>();
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.v1]) {
            path.push(e);
        }
        return path;
    }
	
	public boolean hasPathTo(int v) {
        return distanceTo[v] < Double.POSITIVE_INFINITY;
    }
	
}
