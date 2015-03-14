
public class Person {
  String name;

    public Person(String personName) {
            // TODO: Program Constructor
            this.name = personName;
    }

    public String greet(String yourName) {
            // TODO: Write a greeting string
            String message = "Konbanwa! My name is " + this.name + ". It is nice to meet you, " + yourName + "!";
            return message;
    }
}