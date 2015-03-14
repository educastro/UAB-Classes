package lab11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DirectedGraphTest {

	public static void main(String[] args) throws IOException {
//	  BufferedReader in = new BufferedReader(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab11/src/lab11/tinyDG.txt"));
//	  DirectedGraph test = new DirectedGraph(in);
//	  System.out.println(test.tostring());
		System.out.println(sumOfFirstNPositiveIntegers(2));
	}
	
	public static int sumOfFirstNPositiveIntegers(int n){
		if(n == 1)
			return 1;
		else
			return n + sumOfFirstNPositiveIntegers(n-1);
	}

}
