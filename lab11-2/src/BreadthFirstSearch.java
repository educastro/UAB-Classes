import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch 
{
	//To keep track of the nodes we check so we know if it connects to the source.
        //If a node was checked, then there is a path to the node from a source
        private boolean[] checked;
        //To keep track of the parents that each child is connected to 
	private int[] connectedTo;
        //Where we start our search from in the graph 
	private final int SOURCE;  
	
	public BreadthFirstSearch(Graph g, int rootVertex)
	{
		//Initialize arrays with the size of the graph
		checked = new boolean[g.V];
		connectedTo = new int[g.V];
		
		SOURCE = rootVertex;
		
		bfs(g, rootVertex);		
	}
	
	//Go over the graph selecting the best parent-child connections
	private void bfs(Graph g, int source)
	{
		Queue parentsQueue = new ArrayDeque();     //Create a queue
		//We check the source passed in as a parameter and mark it as checked
                checked[source] = true;         
		parentsQueue.add(source);	//We add our parent to the queue
		
		while(!parentsQueue.isEmpty())		
		{
			// We hold the parentVertex or source in this variable 
			int parentVertex = (int) parentsQueue.remove();   

			//For every child connected to the parent								 			           
			for(int child : g.adj[parentVertex])	  
			{
				if(!checked[child])
				{
					// child is connected to the parent vertex
                                        connectedTo[child] = parentVertex;
                                        //So we don't check this node again
					checked[child] = true; 	
                                         //We add the next parent to the queue	   
					parentsQueue.add(child);
				}
			}
		}
	}
	
	//This method just allows us to check if a vertex is connected to the source.
	//If a vertex has been checked then it is connected
	public boolean hasPathTo(int vertex)
	{
		return checked[vertex];
	}
	
	//This method returns the path from the SOURCE to a given vertex
	public List pathTo(int vertex)
	{
		if (!hasPathTo(vertex)) 
			return null;
		
		List path = new ArrayList();
		
		//First add the vertex passed in to the method
                path.add(vertex);	
                
                //Since we are iterating through a queue, 
                //we check form vertex(goal) to source	       
		while (connectedTo[vertex] != SOURCE)                                     
		{
			vertex = connectedTo[vertex];
			path.add(vertex);
		}
		path.add(SOURCE);	//Now we add the source at the very end

		return path;	    //We return a path from the vertex to the source
	}

}