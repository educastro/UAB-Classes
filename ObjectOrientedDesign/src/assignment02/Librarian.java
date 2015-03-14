package assignment02;

public class Librarian extends Person{
	
	Library library = new Library();
	
	public void addStudent(String name, String contact, String kindOf, int universityID){
		Student student = new Student(name, contact, kindOf, universityID);
		library.addStudent(student);
	}
	
	public void addBook(int bookID, String title, String author){
		Book book = new Book(bookID, title, author);
		library.addBook(book);
	}
	
	public Student whoRentedABook(Book book){
		return book.whoRented;
	}
	
	public Student searchStudentByName(String name){
		return library.searchStudentByName(name);
	}
	
	

}
