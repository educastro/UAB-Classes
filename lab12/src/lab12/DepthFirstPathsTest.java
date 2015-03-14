package lab12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class DepthFirstPathsTest {

	public static void main(String[] args) throws Throwable {
		BufferedReader input = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab12/src/lab12/tinyDG.txt"));
		Graph graph = new Graph(input);
		
		DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, 0);
		LinkedList returnedLinkedList = depthFirstPaths.topologicalSort(graph);
		System.out.println(returnedLinkedList);
		
	}

}
