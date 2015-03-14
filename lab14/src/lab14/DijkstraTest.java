package lab14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DijkstraTest {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab14/src/lab14/largeDG.txt"));
		// Stores the current time of the computer system
		long startTime = System.nanoTime();

		Graph graph = new Graph(input);
		System.out.println(graph.tostring());

		System.out.println("-------------");

		Dijkstra sp = new Dijkstra(graph, 0);

		// Stores the current time of the computer system
		long stopTime = System.nanoTime();
		
		// Calculates the elapsed time using the time stores at the beggining and at the end of this execution
		long elapsedTime = stopTime - startTime;

		for (int t = 0; t < graph.V; t++) {
			if (sp.hasPathTo(t)) {    
				System.out.print("0 to " + t + ":");
				System.out.println();
				if (sp.hasPathTo(t)) {
					String answerString = "";
					for (Edge e : sp.pathTo(t)) {
						//System.out.println(e.v1 + " -> " + e.v2 + ": Weight: " + e.edgeWeight);
						answerString = "(" + e.v1 + "," + e.v2 + ")" + ": " + e.edgeWeight + " | " + answerString;
					}
					answerString = answerString + "Total distance: " + sp.distanceTo[t];
					System.out.println(answerString);

				}
				System.out.println();
			}
			else {
				System.out.print("no path between 0 and " + t);
			}
		}
		
		System.out.println("Total time elapsed: " + elapsedTime + " ns.");

	}

}
