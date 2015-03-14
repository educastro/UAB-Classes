import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class test {

	public static void main(String[] args) throws IOException {

		BufferedReader in2 = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab11/src/lab11/mediumG.txt"));
		Graph graph = new Graph(in2);
		System.out.println("oi");
		
		//Create a reference to our BreadthFirstSearch implementation with source 0
		int source = 0;
		BreadthFirstSearch search = new BreadthFirstSearch(graph, source);
		
		//We declare a stack that we will use to get a path from source to vertex rather
		//than from vertex to source
		Stack pathStack = new Stack();

		//Now we check all paths from the source to all other CONNECTED vertices in the graph 
		for (int vertex = source + 1; vertex < ((Object) graph).verticesInGraph(); vertex++)
		{	
			System.out.print("Path from " + source + " to " + vertex + " : ");	
				
			//Make sure that there is path to the vertex
			if (search.hasPathTo(vertex))
			{	
			      List path = new ArrayList<List>();
	                      //Put the path in a list (this will be a backwards path)	
			      path = search.pathTo(vertex);
				
	                      //Put the path in a Stack so we can reverse it   	
			      for(int connection : path)	
			      pathStack.push(connection);
				
			      //Go over the stack to print a path
			      while (!pathStack.isEmpty())
			      {
	                         //Remove an item form the stack and put it in theVertex variable
				 int theVertex = (int) pathStack.pop();

				 if (theVertex == source)
					System.out.print(theVertex);
				  else
					System.out.print("-" + theVertex);
			      }
			      System.out.println();
			}
		 }
	    }
		

	}

