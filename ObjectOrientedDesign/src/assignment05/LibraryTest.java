package assignment05;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class LibraryTest {

	@Test
	public void testStudentConstructorAndAccessorsWithUndergraduateStudent() throws Exception {
		Student student = new Student("1", "testName", "testEmail", "undergraduate");
		assertEquals("1", student.getId());
		assertEquals("testName", student.getName());
		assertEquals("testEmail", student.getEmail());
		assertEquals("undergraduate", student.getClassification());
	}
	
	@Test
	public void testStudentConstructorAndAccessorsWithGraduateStudent() throws Exception {
		Student student = new Student("1", "testName", "testEmail", "graduate");
		assertEquals("1", student.getId());
		assertEquals("testName", student.getName());
		assertEquals("testEmail", student.getEmail());
		assertEquals("graduate", student.getClassification());
	}
	
	
	@Test (expected = Exception.class)
	public void testStudentCreationWithWrongClassification() throws Exception {
		Student student = new Student("1", "testName", "testEmail", "wrongClassification");	
	}
	
	@Test
	public void testBookItemConstructor() throws Exception {
		Item item = new Item("1", "testName", "testAuthor", "book");
		assertEquals("1", item.getId());
		assertEquals("testName", item.getTitle());
		assertEquals("testAuthor", item.getAuthor());
		assertEquals("book", item.getCategory());
	}
	
	@Test
	public void testDvdItemConstructor() throws Exception {
		Item item = new Item("1", "testName", "testAuthor", "dvd");
		assertEquals("1", item.getId());
		assertEquals("testName", item.getTitle());
		assertEquals("testAuthor", item.getAuthor());
		assertEquals("dvd", item.getCategory());
	}
	
	@Test (expected = Exception.class)
	public void testItemConstructorWithUnknownItemCategory() throws Exception {
		Item item = new Item("1", "testName", "testAuthor", "wrongCategory");
	}
	
	@Test
	public void testLoanConstructor() throws Exception {
		Student student = new Student("1", "testName", "testEmail", "undergraduate");
		Item item = new Item("1", "testName", "testAuthor", "book");
		Date date = new Date(2015, 3, 5);
		Loan loan = new Loan(student, item, date);
		assertEquals(student, loan.getStudent());
		assertEquals(item, loan.getItem());
		assertEquals(date, loan.getSince());
	}
	
	@Test
	public void testCheckoutBook() throws Exception {
		Library library = new Library();
		library.addItem("testName", "testAuthor", "book");
		library.addStudent("1", "testName", "testEmail", "undergraduate");
		library.checkOutItem("1", "testName");
		assertEquals("1","1");
	}
	
	

}
