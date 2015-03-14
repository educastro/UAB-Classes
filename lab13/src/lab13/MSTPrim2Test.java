package lab13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MSTPrim2Test {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab13/src/lab13/mediumGraph.txt"));
		Graph graph = new Graph(input);
		MSTPrim2 prim = new MSTPrim2(graph, 1, 1);
		
	}

}
