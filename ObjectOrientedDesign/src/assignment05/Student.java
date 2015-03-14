package assignment05;

import java.util.ArrayList;

/**
 * represents a student in the library.
 */
public class Student
{
  /**
   * sets up a valid Student object.
   *
   * @param uid university ID
   * @param studentname student name
   * @param emailaddr email address
 * @throws Exception 
   * @precondition uid != null && studentname != null && emailaddr != null
   */
  public Student(String uid, String studentname, String emailaddr, String studentClassification) 
  {
    assert uid != null && studentname != null && emailaddr != null
           : "Precondition violation : invalid null data";
    
    assert studentClassification != "undergraduate" || studentClassification != "graduate"
    		: "Precondition violation : invalid student classification";

    id    = uid;
    name  = studentname;
    email = emailaddr;
    classification = studentClassification;
    loans = new ArrayList<Loan>();
  }

  /**
   * returns student id.
   *
   * @return student id
   */
  public String getId() { return id; }

  /**
   * returns student name.
   *
   * @return student name
   */
  public String getName()  { return name;  }
  
  /**
   * returns student classification(undergrad or grad.
   *
   * @return student classification
   */
  public String getClassification()  { return classification;  }

  /**
   * returns email address.
   *
   * @return email address
   */
  public String getEmail() { return email; }

  /**
   * student checks out a book from the library.
   *
   * @param loanRecord record of the new transaction
   * @postcondition loanRecord != null && onLoanCount() > 0
   */
  public void checkOutLoan(Loan loanRecord)
  {
    assert loanRecord != null : "Precondition failure: null record";
    assert (classification == "undergraduate" && onLoanCount() >= 2) : "Precondition failure: wrong classification";
    assert (classification == "graduate" && onLoanCount() >= 4) : "Precondition failure: wrong classification";

    loans.add(loanRecord);
  }

  /**
   * student returns a book to the library.
   *
   * @param loanRecord loan record for the book to be returned
   * @precondition loanRecord != null && getLoans.contains(loanRecord)
   */
  public void returnLoan(Loan loanRecord)
  {
    assert loanRecord != null : "Precondition failure: null record";

    boolean found = loans.remove(loanRecord);

    assert found : "Precondition failure: Loan record not found";
  }

  /**
   * returns the number of books a student holds.
   *
   * @return number of books a student currently holds
   */
  public int onLoanCount()
  {
    return loans.size();
  }

  /**
   * returns an arraylist with the active loan records.
   *
   * @return returns a clone of the student's list to prevent clients
   *         from accidentally modifying the student's loan records.
   *         Since Loan is an immutable class we do not need to clone all loans.
   */
  @SuppressWarnings("unchecked")
public ArrayList<Loan> getLoans()
  {
    // note, the following line generates a warning.
    //   The warning is related that we clone a generic collection
    //   and the runtime system has no way to guarantee that the cloned
    //   arraylist also contains loans. :(
    return (ArrayList<Loan>)loans.clone();
  }

  /** the unique id. */
  private String          id;

  /** student name. */
  private String          name;

  /** student's email. */
  private String          email;
  
  /** student's classification(undergrad or grad). */
  private String          classification;

  /** current check outs. */
  private ArrayList<Loan> loans;
}
