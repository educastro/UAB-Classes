package assignment02;

import java.util.ArrayList;

public class Book {

	int bookID;
	String title;
	String author;
	Student whoRented;
	public Student getWhoRented() {
		return whoRented;
	}

	public void setWhoRented(Student whoRented) {
		this.whoRented = whoRented;
	}

	boolean rented = false;;
	ArrayList reserves;
	
	public Book(int bookID, String title, String author) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
	}
	
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isRented() {
		return rented;
	}
	public void setRented(boolean rented) {
		this.rented = rented;
	}
	public ArrayList getReserves() {
		return reserves;
	}
	public void addReserve(Student student) {
		this.reserves.add(student);
	}
	
}
