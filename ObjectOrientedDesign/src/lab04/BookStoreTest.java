package lab04;



import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookStoreTest {

	private BookStore store;
	private Book b1 = new Book(1, "Harper Lee", "To Kill a Mockingbird");
	private Book b2 = new Book(2, "Harper Lee", "To Kill a Mockingbird");
	private Book b3 = new Book(3, "Frances Hodgson", "The Secret Garden");
	private Book b4 = new Book(4, "Douglas Adams",
			"The Hitchhiker's Guide to the Galaxy");
	private Book b5 = new Book(5, "Antoine de Saint-Exupery",
			"The Little prince");

	/**
	 * setup the store
	 * 
	 */
	@Before
	public void setUpBookStore() {
		store = new BookStore();
		store.addBook(b1);
		store.addBook(b2);
		store.addBook(b3);
		store.addBook(b4);
	}

	/**
	 * tests the addition of book
	 * 
	 */

	@Test
	public void testAddBook() {
		store.addBook(b5);
		assertTrue(store.getBooks().contains(b5));
	}

	/**
	 * tests the deletion of book
	 * 
	 */

	@Test
	public void testDeleteBook() {
		assertTrue(store.getBooks().contains(b4));
		store.deleteBook(b4);
		assertFalse(store.getBooks().contains(b4));
	}

	/**
	 * tests sorting of books by author name
	 * 
	 */

	@Test
	public void testGetBooksSortedByAuthor() {
		//System.out.println(store.getBooksSortedByAuthor());
		
		assertEquals("The Hitchhiker's Guide to the Galaxy", store.getBooksSortedByAuthor().get(0).getTitle());
		assertEquals("Douglas Adams", store.getBooksSortedByAuthor().get(0).getAuthorName());
		assertEquals(4, store.getBooksSortedByAuthor().get(0).getId());
		
		assertEquals("The Secret Garden", store.getBooksSortedByAuthor().get(1).getTitle());
		assertEquals("Frances Hodgson", store.getBooksSortedByAuthor().get(1).getAuthorName());
		assertEquals(3, store.getBooksSortedByAuthor().get(1).getId());
		
		assertEquals("To Kill a Mockingbird", store.getBooksSortedByAuthor().get(2).getTitle());
		assertEquals("Harper Lee", store.getBooksSortedByAuthor().get(2).getAuthorName());
		assertEquals(1, store.getBooksSortedByAuthor().get(2).getId());
		
		assertEquals("To Kill a Mockingbird", store.getBooksSortedByAuthor().get(3).getTitle());
		assertEquals("Harper Lee", store.getBooksSortedByAuthor().get(3).getAuthorName());
		assertEquals(2, store.getBooksSortedByAuthor().get(3).getId());		
	}

	/**
	 * tests sorting of books by title
	 * 
	 */

	@Test
	public void testGetBooksSortedByTitle() {
		//System.out.println(store.getBooksSortedByTitle());
		
		assertEquals("The Hitchhiker's Guide to the Galaxy", store.getBooksSortedByAuthor().get(0).getTitle());
		assertEquals("Douglas Adams", store.getBooksSortedByAuthor().get(0).getAuthorName());
		assertEquals(4, store.getBooksSortedByAuthor().get(0).getId());
		
		assertEquals("The Secret Garden", store.getBooksSortedByAuthor().get(1).getTitle());
		assertEquals("Frances Hodgson", store.getBooksSortedByAuthor().get(1).getAuthorName());
		assertEquals(3, store.getBooksSortedByAuthor().get(1).getId());
		
		assertEquals("To Kill a Mockingbird", store.getBooksSortedByAuthor().get(2).getTitle());
		assertEquals("Harper Lee", store.getBooksSortedByAuthor().get(2).getAuthorName());
		assertEquals(1, store.getBooksSortedByAuthor().get(2).getId());
		
		assertEquals("To Kill a Mockingbird", store.getBooksSortedByAuthor().get(3).getTitle());
		assertEquals("Harper Lee", store.getBooksSortedByAuthor().get(3).getAuthorName());
		assertEquals(2, store.getBooksSortedByAuthor().get(3).getId());	
	}

	/**
	 * tests the number of copies of book in store
	 * 
	 */

	@Test
	public void testCountBookWithTitle() {
		assertEquals(2, store.countBookWithTitle("To Kill a Mockingbird"));
		assertEquals(1, store.countBookWithTitle("The Secret Garden"));
		assertEquals(1, store.countBookWithTitle("The Hitchhiker's Guide to the Galaxy"));
		assertEquals(0, store.countBookWithTitle("Whatever name that doesnt exists"));
	}

}
