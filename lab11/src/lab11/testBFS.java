package lab11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class testBFS {

	public static void main(String[] args) throws IOException {
		BufferedReader in2 = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab11/src/lab11/tinyDG.txt"));
		UndirectedGraph test2 = new UndirectedGraph(in2);
		
		long startTime = System.nanoTime();

		BFS bfs = new BFS(test2, 0);
		bfs.printPath(test2);
		
		// Stores the current time of the computer system
		long stopTime = System.nanoTime();

		// Calculates the elapsed time using the time stores at the beggining and at the end of this execution
		long elapsedTime = stopTime - startTime;
		
		System.out.println("Time: " + elapsedTime);

	}

}
