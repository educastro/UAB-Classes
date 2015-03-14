package assignment02;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {

	String name;
	ArrayList<Student> students;
	ArrayList books;
	ArrayList librarians;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList getStudents() {
		return students;
	}
	public void addStudent(Student student) {
		this.students.add(student);
	}
	public void addBook(Book book) {
		this.books.add(book);
	}
	public ArrayList getBooks() {
		return books;
	}
	public void setBooks(ArrayList books) {
		this.books = books;
	}
	public ArrayList getLibrarians() {
		return librarians;
	}
	public void setLibrarians(ArrayList librarians) {
		this.librarians = librarians;
	}
	
	public Student searchStudentByName(String name){
		Student iterator = (Student) students.iterator();
		
		while(((Iterator<Student>) iterator).hasNext()){
			if(iterator.getName() == name){
				return iterator;
			}
		}
		
		return null;
	}
	
}
