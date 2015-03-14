
public class LeetspeakTest {

	public static void main(String[] args) {
		Leetspeak leetspeakTest = new Leetspeak();
		System.out.println(leetspeakTest.encode(""));
		System.out.println("4|3<[)3|=");
	
		if("a" == leetspeakTest.encode("a"))
			System.out.println("true");
		else
			System.out.println("false");
		System.out.println(leetspeakTest.encode("abcdef").charAt(0));
		System.out.println(leetspeakTest.encode("abcdef").charAt(1));
		System.out.println(leetspeakTest.encode("abcdef").charAt(2));
		System.out.println(leetspeakTest.encode("abcdef").charAt(3));
		System.out.println(leetspeakTest.encode("abcdef").charAt(4));
		System.out.println(leetspeakTest.encode("abcdef").charAt(5));
		System.out.println(leetspeakTest.encode("abcdef").charAt(6));
		System.out.println(leetspeakTest.encode("abcdef").charAt(7));
		System.out.println(leetspeakTest.encode("abcdef").charAt(8));
		System.out.println(leetspeakTest.encode("abcdef").charAt(9));
		

	}

}
