
public class CaffeineBuzz {

//	public static String caffeineBuzz(int n){
//		String returnString;
//		
//		if((n % 3 == 0) && (n % 4 == 0))
//			returnString = "Coffee";
//		else if(n % 3 == 0)
//			returnString = "Java";
//		else
//			returnString = "mocha_missing!";
//		
//		if((n % 3 == 0) && (n % 2 == 0))
//			returnString += "Script";
//		
//		return returnString;
//	}

		  public static String caffeineBuzz(int n){
		  String message = "mocha_missing!";
		    if(n != 0) {
		      if(n % 3 ==0) message = "Java";
		      if(n % 12 ==0) message = "Coffee";
		      if(n % 2 ==0) message += "Script";
		    }
		    return message;
		  }

	public static void main(String[] args) {
		System.out.println(caffeineBuzz(1));
		System.out.println(caffeineBuzz(3));
		System.out.println(caffeineBuzz(12));
		System.out.println(caffeineBuzz(15));
	}

}
