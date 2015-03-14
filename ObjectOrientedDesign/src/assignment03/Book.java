package assignment03;

import java.util.ArrayList;

/*
 * Class for a Book
 */

public class Book {
	
	private String author;
	private String title;
	private ArrayList<Loan> loanRecord;
	
	/*
	 * Constructor. Receives author and title variables and initialize the loanRecord ArrayList
	 */
	
	public Book(String author, String title){
		this.author = author;
		this.title = title;
		this.loanRecord = new ArrayList<Loan>();
	}
	
	/*
	 * Empty constructor
	 */
	
	public Book(){
		this.loanRecord = new ArrayList<Loan>();
	}
	
	/*
	 * Getters and Setters
	 */
	
	public String getAuthor(){
		return this.author;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}

	public ArrayList<Loan> getLoanRecord(){
		return this.loanRecord;
	}
	
	/*
	 * Makes a checkout or return to a loan
	 */
	
	public void checkOutBook(Loan loan){
		this.getLoanRecord().add(loan);
	}
	
	public void returnBook(Loan loan){
		this.getLoanRecord().remove(loan);
	}
}
