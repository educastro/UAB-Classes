package assignment03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
	
	private Library library;
	
	private Book book1 = new Book("Harper Lee", "To Kill a Mockingbird");
	private Book book2 = new Book("Harper Lee", "To Kill a Mockingbird");
	private Book book3 = new Book("Frances Hodgson", "The Secret Garden");
	private Book book4 = new Book("Douglas Adams",
			"The Hitchhiker's Guide to the Galaxy");
	private Book book5 = new Book("Antoine de Saint-Exupery",
			"The Little prince");
	private Book book6 = new Book("Tolkien",
			"The Lord of the Rings");
	private Book book7 = new Book("Tolkien",
			"The Lord of the Rings");
	
	private Student student1 = new Student(1, "Student 1", "student1@gmail.com");
	private Student student2 = new Student(2, "Student 2", "student2@gmail.com");
	private Student student3 = new Student(3, "Student 3", "student3@gmail.com");
	private Student student4 = new Student(4, "Student 4", "student4@gmail.com");
	private Student student5 = new Student(2, "Student 5", "student5@gmail.com");
	
	/**
	 * setup the Library
	 * @throws Exception 
	 * 
	 */
	@Before
	public void setUpBookStore() throws Exception {
		library = new Library();
		
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book6);
		library.addBook(book7);

		
		library.addStudent(student1);
		library.addStudent(student2);
		library.addStudent(student3);
		library.addStudent(student4);
		
		library.checkOutBook(student1, book1);
		library.checkOutBook(student2, book2);
		library.checkOutBook(student3, book3);
		library.checkOutBook(student4, book4);
		
		
	}
	

	@Test
	public void testAddBook() {
		assertTrue(library.listBooks().contains(book1));
		assertTrue(library.listBooks().contains(book2));
		assertTrue(library.listBooks().contains(book3));
		assertTrue(library.listBooks().contains(book4));
		assertFalse(library.listBooks().contains(book5));
		assertTrue(library.listBooks().contains(book6));
	}
	
	@Test
	public void testAddStudent() {
		assertTrue(library.listStudents().contains(student1));
		assertTrue(library.listStudents().contains(student2));
		assertTrue(library.listStudents().contains(student3));
		assertTrue(library.listStudents().contains(student4));
		assertFalse(library.listStudents().contains(student5));
	}
	
	@Test (expected = Exception.class)
	public void testAddStudentWithUsedUID() throws Exception {
		library.addStudent(student5);
	}
	
	@Test
	public void testListBooks() {
		assertEquals("Harper Lee", library.listBooks().get(0).getAuthor());
		assertEquals("Harper Lee", library.listBooks().get(1).getAuthor());
		assertEquals("Frances Hodgson", library.listBooks().get(2).getAuthor());
		assertEquals("Douglas Adams", library.listBooks().get(3).getAuthor());
		assertEquals("Tolkien", library.listBooks().get(4).getAuthor());
	}
	
	@Test
	public void testListStudents() {
		assertEquals("Student 1", library.listStudents().get(0).getName());
		assertEquals("Student 2", library.listStudents().get(1).getName());
		assertEquals("Student 3", library.listStudents().get(2).getName());
		assertEquals("Student 4", library.listStudents().get(3).getName());
		assertEquals(4, library.listStudents().size());
	}
	
	@Test
	public void testListLoans() {
		assertEquals("Student 1", library.listLoans().get(0).getStudent().getName());
		assertEquals("Student 2", library.listLoans().get(1).getStudent().getName());
		assertEquals("Student 3", library.listLoans().get(2).getStudent().getName());
		assertEquals("Student 4", library.listLoans().get(3).getStudent().getName());
		assertEquals(4, library.listLoans().size());	
	}
	
	@Test 
	public void testCheckOutBook() throws Exception {
		library.checkOutBook(student4, book6);
		assertEquals(student4, library.listLoans().get(4).getStudent());
		assertEquals(book6, library.listLoans().get(4).getBook());
	}

	@Test (expected = Exception.class)
	public void testCheckOutBookWithMoreThanAllowed() throws Exception {
		library.checkOutBook(student4, book6);
		library.checkOutBook(student4, book7);
	}
	
	@Test (expected = Exception.class)
	public void testCheckOutBookWithStudentThatDoesntExist() throws Exception {
		library.checkOutBook(new Student(10,"New Student", "newStudent@gmail.com"), book6);
	}
	
	@Test (expected = Exception.class)
	public void testCheckOutBookWithAlreadyRentedBook() throws Exception {
		library.checkOutBook(student4, book1);
	}
	
	@Test (expected = Exception.class)
	public void testCheckOutBookWithBookThatDoesntExist() throws Exception {
		library.checkOutBook(student4, new Book());
	}
	
	@Test
	public void testReturnBook() throws Exception {
		Loan loan = book1.getLoanRecord().get(0);
		library.returnBook(book1);
		assertFalse(library.listLoans().contains(loan));
	}
	
	@Test (expected = Exception.class)
	public void testReturnBookThatWasNotRented() throws Exception{
		library.returnBook(book6);
	}
	
	@Test (expected = Exception.class)
	public void testReturnBookThatDoesntExist() throws Exception{
		library.returnBook((new Book()));
	}
}
