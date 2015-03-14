package lab02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci {
	static int count = 0; // counter to get how many times the recursiveFibonacci call itself
	
	public static long recursiveFibonacci(int n) {
		if(n == 1)
			return 1; 
		else if(n == 0)
			return 0;
		else
			count = count + 2; // everytime that the function gets here the recursiveFibonacci call itself 2 times
			return recursiveFibonacci(n-1) + recursiveFibonacci(n-2); // fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
	}
	
	// given function
	public static long fibonacci(int n) {
		long fib[] = new long[((n + 1) > 3) ? (n + 1) : 3];

		fib[1] = 1;
		fib[2] = 1;

		for (int i = 3; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		return fib[n];
	}

	public static void main(String args[]) {
		for (int i = 1; i <= 20; i++) {
			count = 0;
			System.out.println("recursive fibonacci (" + i + ") = " + recursiveFibonacci(i));
			// From here until the end it is the function that will print the counter total at the f20.txt file
			File log = new File("f20.txt");

			try{
			    if(!log.exists()){
			        System.out.println("We had to make a new file.");
			        log.createNewFile();
			    }

			    FileWriter fileWriter = new FileWriter(log, true);

			    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			    bufferedWriter.write("For fibonacci(" + i + ") the number of self-calls is: " + count + "\n");
			    bufferedWriter.close();
			} catch(IOException e) {
			    System.out.println("COULD NOT LOG!!");
			}
		}
	}
}

