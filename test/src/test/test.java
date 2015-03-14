package test;

public class test {

	String name;

	public test(String personName) {
		// TODO: Program Constructor
		this.name = personName;
	}

	public String greet(String yourName) {
		// TODO: Write a greeting string
		String message = "Konbanwa! My name is " + name + (". It is nice to meet you, " + yourName + "!";
		return message;
	}
}

