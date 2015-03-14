package lab02;

public class FibonacciTree {
	int tabCounter = 0;
		
	public static long recursiveFibonacci(int n) {
		if(n == 1)
			return 1; 
		else if(n == 0)
			return 0;
		else
			return recursiveFibonacci(n-1) + recursiveFibonacci(n-2); // fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
	}
	
	public static void main(String args[]) {		
		printTree(5);
	}
	
	public static void printTree(int n){
		if(n == 0){
			System.out.println("fib(" + n + ")-->0");
			return;
		}
		
		if(n == 1){
			System.out.println("fib(" + n + ")-->1");
			return;
		}
		
		int parentMinusOne = n-1;
		int parentMinusTwo = n-2;
		
		printTree(parentMinusOne);
		
		System.out.println("fib(" + n + ")");
		
		printTree(parentMinusTwo);	
	}
}
