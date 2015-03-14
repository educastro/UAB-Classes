package assignment02;

public class Student extends Person{
	String kindOf; // graduate or undergraduate

	public Student(String name, String contact, String kindOf, int universityID) {
		this.name = name;
		this.contact = contact;
		this.kindOf = kindOf;
		this.universityID = universityID;
	}

	public String getKindOf() {
		return kindOf;
	}

	public void setKindOf(String kindOf) {
		this.kindOf = kindOf;
	}

	public void checkoutBook(Book book){
		book.rented = true;
		book.whoRented = this;
	}
	
	public void returnBook(Book book){
		book.rented = false;
		book.whoRented = null;
	}
	
}
