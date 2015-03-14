package lab13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;


public class GraphTest {
	
	public static void main(String[] args) throws Throwable {
//		BufferedReader input = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab13/src/lab13/mediumGraph.txt"));
//		Graph graph = new Graph(input);
//		System.out.println(graph.tostring());
		
		System.out.println("------------");
		
//		BufferedReader input2 = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab13/src/lab13/LargeGraph.txt"));
//		Graph graph2 = new Graph(input2);
//		System.out.println(graph2.tostring());
		
		System.out.println("------------");
		
		BufferedReader input3 = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab13/src/lab13/XtraLargeGraph.txt"));
		Graph graph3 = new Graph(input3);
		System.out.println(graph3.tostring());
				
	}
}
