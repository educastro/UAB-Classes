package assignment03;

import java.util.ArrayList;

/*
 * Class for the Student
 */
public class Student {
	private int uid;
	private String name;
	private String email;
	private int onLoanCount = 0;
	private ArrayList<Loan> loanRecord;
	
	/*
	 * Constructor
	 */
	
	public Student(int uid, String name, String email){
		this.uid = uid;
		this.name = name;
		this.email = email;
		loanRecord = new ArrayList<Loan>();
	}
	
	/*
	 * Getters and Setters
	 */
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public int getUid(){
		return this.uid;
	}
	
	public void setUid(int uid){
		this.uid = uid;
	}
	
	public int getOnLoanCount(){
		return onLoanCount;
	}
	
	public void setOnLoanCount(int onLoanCount){
		this.onLoanCount = onLoanCount;
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
	
	public ArrayList<Loan> getLoanRecord(){
		return this.loanRecord;
	}
	
}
