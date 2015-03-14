package lab11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UndirectedGraphTest {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab11/src/lab11/tinyDG.txt"));
		UndirectedGraph test = new UndirectedGraph(in);
		System.out.println(test.tostring());
	}

}
