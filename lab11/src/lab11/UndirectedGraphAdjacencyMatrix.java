package lab11;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class UndirectedGraphAdjacencyMatrix extends Graph{
    public int V;
    public int E;
    public Vertex[] v;

    
    public boolean[][] adj;
    
    public UndirectedGraphAdjacencyMatrix()
    {
        V = 0;
        E = 0;
    }
    
    public UndirectedGraphAdjacencyMatrix(BufferedReader reader) throws IOException
    {
        String line;
        line = reader.readLine();
        V = Integer.parseInt(line);
        line = reader.readLine();
        E = Integer.parseInt(line);
        adj =  new boolean[V][V];
        v = new Vertex[E];

        
        while ((line = reader.readLine()) != null) {
            int tempV1, tempV2;
              StringTokenizer st = new StringTokenizer(line, " ");
              tempV1 = Integer.parseInt(st.nextToken());
              tempV2 = Integer.parseInt(st.nextToken());
              addEdge(tempV1, tempV2);
        }
    }
    
    public void addEdge(int v, int w) {
    	adj[v][w] = true;
    	adj[w][v] = true;
    }
    
    public String tostring()
    {
        String s = new String();
        String v = new String();

        //s = "There are "+V+" vertices and "+E+" edges\n";
        for(int i = 0; i < V; i++)
        	v += i + " ";
        
        System.out.println("   " + v);
        
        for(int i=0;i<V;i++)
        {
            s = s+i+": ";
            for(int j = 0; j<adj.length;j++)
            {
                if (adj[i][j])
                	s += "1 ";
                else s += "0 ";
            	//s = s+adj[i][j]+" ";
            }
            s = s+"\n";
            
        }
        return s;
    }

}
