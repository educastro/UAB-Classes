package lab13;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MSTPrim2 {
	public double[] key;
	String[] color;
	public double[] pred;
	
	public MSTPrim2(Graph G, int w, int r){
		key = new double[G.V];
		color = new String[G.V];
		pred = new double[G.V];
		ExtractMin Q = new ExtractMin(G.V);
		
		for(int u = 0; u <= G.V; u++){
			key[u] = Double.MAX_VALUE;
			color[u] = "WHITE";
		}
		
		key[r] = 0;
		pred[r] = (Double) null;
		
		
		
		while(!Q.isEmpty()){
			int u = Q.delMin();
			for(int v = 0; v < G.adj[u].size(); v++){
				if((color[v] == "WHITE") && (G.adj[u].get(v).edgeWeight < key[v])){
					key[v] = G.adj[u].get(v).edgeWeight;
					Q.decreaseKey(v, key[v]);
					pred[v] = u;
				}
				color[u] = "BLACK";
				
			}
			
		}
		
		
	}
	
	
	
}
	


