package assignment03;

import java.util.Date;

/* 
 * Class for a Loan
 */

public class Loan {

	private Student student;
	private Book book;
	private Date date;

	/*
	 * Empty Constructor
	 */
	
	public Loan(){
		setDate(new Date());
	}
	
	/*
	 * Constructor
	 */
	
	public Loan(Student student, Book book){
		this.student = student;
		this.book = book;
		/*
		 * Creates a new date with the actual time of the computer
		 */
		setDate(new Date());
	}
	
	/*
	 * Getters and Setters
	 */
	
	public void setStudent(Student student){
		this.student = student;
	}
	
	public Student getStudent(){
		return this.student;
	}
	
	public void setBook(Book book){
		this.book = book;
	}
	
	public Book getBook(){
		return this.book;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
