package lab11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UndirectedGraphAdjacencyMatrixTest {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab11/src/lab11/mediumG.txt"));
		UndirectedGraphAdjacencyMatrix test = new UndirectedGraphAdjacencyMatrix(in);
		System.out.println(test.tostring());
		
		System.out.println("-");
		BFSAdjacencyMatrix bfs = new BFSAdjacencyMatrix(test, 0);
		bfs.printPath(test);
	}

}
