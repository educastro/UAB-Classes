package assignment03;

import java.util.ArrayList;

/*
 * Class for a Library
 */

public class Library {

	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Loan> loanList = new ArrayList<Loan>();
	
	/*
	 * Adds a book to the ArrayList of Books
	 */
	
	public void addBook(Book book){
		listBooks().add(book);
	}
	
	/*
	 * Adds a student to the ArrayList of students
	 */
	
	public void addStudent(Student student) throws Exception{
		/*
		 * Checks if the student already exist on the ArrayList
		 */
		
		if(listStudents().contains(student))
				throw new Exception("student already exist");
		
		/*
		 * Checks if the UID is already being used
		 */
		
		for(Student studentIterator : listStudents()){
			if(studentIterator.getUid() == student.getUid())
				throw new Exception("UID already exist for another student");
		}
		
		this.studentList.add(student);
	}
	
	/*
	 * Returns an ArrayList with the books
	 */
	
	public ArrayList<Book> listBooks(){
		return this.bookList;
	}
	
	/*
	 * Returns an ArrayList with the students
	 */
	
	public ArrayList<Student> listStudents(){
		return this.studentList;
	}
	
	/*
	 * Returns an ArrayList with the active loans
	 */
	
	public ArrayList<Loan> listLoans(){
		return this.loanList;
	}
	
	/*
	 * Makes the checkout of a book for a student
	 */
	
	public void checkOutBook(Student student, Book book) throws Exception{
		/*
		 * Checks if the book exists and if it is not rented
		 */
		
		if((bookList.contains(book)) && (book.getLoanRecord().size() < 1)){
			/*
			 * Checks if the students exists
			 */
			
			if(studentList.contains(student)){
				/*
				 * Count how many loans the student has
				 */
				
				for(Loan loanIterator : loanList){
					if(loanIterator.getStudent().getUid() == student.getUid())
						student.setOnLoanCount(student.getOnLoanCount() + 1);
				}
				/*
				 * If more than 2 loans then he/she can't take the book
				 */
				
				if(student.getOnLoanCount() < 2) {
					Loan loan = new Loan(student, book);
					/*
					 * Adds to the loanList from book too
					 */
					loanList.add(loan);
					book.checkOutBook(loan);
				}
				else{
					throw new Exception("Student already rented 2 books");
				}
			}
			else{
				throw new Exception("Student doesnt exist");
			}
		}
		else{
			throw new Exception("Book doesnt exist or already rented");
		}
	}
	
	/*
	 * Makes the return of a book
	 */
	
	public void returnBook(Book book) throws Exception{
		/*
		 * Checks if the book exists and if it is rented
		 */
		
		if((bookList.contains(book)) && (book.getLoanRecord().size() > 0)){
			Loan loan = book.getLoanRecord().get(0);
			loanList.remove(loan);
			book.returnBook(loan);
		}
		else{
			throw new Exception("Book doesnt exist or not rented");
		}
	}
}
