package lab12;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Graph{
    public int V;
    public int E;
    public Vertex[] vortex;

    
    public LinkedList<Integer>[] adj;
    
    public Graph()
    {
        V = 0;
        E = 0;
    }
    
    public Graph(BufferedReader reader) throws IOException
    {
        String line;
        line = reader.readLine();
        V = Integer.parseInt(line);
        line = reader.readLine();
        E = Integer.parseInt(line);
        adj =  new LinkedList[V];
        vortex = new Vertex[V]; 


        
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
        while ((line = reader.readLine()) != null) {
            int tempV1, tempV2;
              StringTokenizer st = new StringTokenizer(line, " ");
              tempV1 = Integer.parseInt(st.nextToken());
              tempV2 = Integer.parseInt(st.nextToken());
              addEdge(tempV1, tempV2);
              if(vortex[tempV1]!=null){
            	  vortex[tempV1].d.add(tempV2);
              }else{
            	  vortex[tempV1] = new Vertex(tempV1,tempV2,"WHITE");
              }
        }
    }
    
    public void addEdge(int v, int w) {
    	adj[v].add(w);
    }
    
    public String tostring()
    {
        String s = new String();
        s = "There are "+V+" vertices and "+E+" edges\n";
        for(int i=0;i<V;i++)
        {
            s = s+i+": ";
            for(int j = 0; j<adj[i].size();j++)
            {
                s = s+adj[i].get(j)+" ";
            }
            s = s+"\n";
            
        }
        return s;
    }

}
