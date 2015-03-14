package lab13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MSTPrimTest {

	public static void main(String[] args) throws IOException {

//		BufferedReader input = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab13/src/lab13/mediumGraph.txt"));
//		Graph graph = new Graph(input);
//		MSTPrim prim = new MSTPrim(graph);
//		for (Edge e : prim.edges()) {
//            System.out.println(e.v1 + " - " + e.v2 + " -> Weight: " + e.edgeWeight);
//        }
//        System.out.printf("Final Weight: %.5f\n", prim.weight());
        
//		BufferedReader input2 = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab13/src/lab13/largeGraph.txt"));
//		Graph graph2 = new Graph(input2);
//		MSTPrim prim2 = new MSTPrim(graph2);
//		for (Edge e : prim2.edges()) {
//            System.out.println(e.v1 + " - " + e.v2 + " -> Weight: " + e.edgeWeight);
//        }
//        System.out.printf("Final Weight: %.5f\n", prim2.weight());
        
		BufferedReader input3 = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab13/src/lab13/XtraLargeGraph.txt"));
		Graph graph3 = new Graph(input3);
		MSTPrim prim3 = new MSTPrim(graph3);
		for (Edge e : prim3.edges()) {
            System.out.println(e.v1 + " - " + e.v2 + " -> Weight: " + e.edgeWeight);
        }
        System.out.printf("Final Weight: %.5f\n", prim3.weight());
	}

}
