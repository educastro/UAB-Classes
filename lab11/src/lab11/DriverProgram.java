package lab11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DriverProgram {

	public static void main(String[] args) throws IOException {
		  BufferedReader tinyDG = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab11/src/lab11/tinyDG.txt"));
		  BufferedReader mediumG = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab11/src/lab11/mediumG.txt"));
		  
		  UndirectedGraph undirectedGraph = new UndirectedGraph(mediumG);
		  DirectedGraph directedGraph = new DirectedGraph(tinyDG);
		  
		  System.out.println("-----------------------------------------------------------------------------");
		  System.out.println("Undirected Graph:");
		  System.out.println(undirectedGraph.tostring());
		  System.out.println("-----------------------------------------------------------------------------");
		  System.out.println("Directed Graph:");
		  System.out.println(directedGraph.tostring());
		  System.out.println("-----------------------------------------------------------------------------");
		}

}
