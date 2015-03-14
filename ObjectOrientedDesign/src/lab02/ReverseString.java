package lab02;

public class ReverseString {
	static String returnString = "";
	
	// Receives a String and concatenates its last character with another String that will be used for the return recursively.
	public static String reverse(String str){
		if(str.length() == 0){
			return returnString;
		}
		else{
			returnString += str.charAt(str.length() - 1);
			return reverse(str.substring(0, str.length() - 1));
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Input: recursion");
		System.out.println("Output: " + reverse("recursion"));
	}

}
