package lab14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Graph {
    public int V;
    public int E;
    
    public Vertex[] v;
    
    public LinkedList<Edge>[] adj;
    
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
        v = new Vertex[V];
        
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Edge>();
        }
        
        while ((line = reader.readLine()) != null) {
            int v, w; 
            double weight;
              StringTokenizer st = new StringTokenizer(line, " ");
              v = Integer.parseInt(st.nextToken());
              w = Integer.parseInt(st.nextToken());
              weight = Double.parseDouble(st.nextToken());
              Edge e = new Edge(v, w, weight);
              adj[v].add(e);
        }
    }
    
    public double getWeight(int v1, int v2){
    	return adj[v1].get(v2).edgeWeight;	
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
                s = s + "(" + adj[i].get(j).getV1() + ", " + adj[i].get(j).getV2() + ", " + adj[i].get(j).edgeWeight+"), ";
            }
            s = s+"\n";
            
        }
        return s;
    }
    
}