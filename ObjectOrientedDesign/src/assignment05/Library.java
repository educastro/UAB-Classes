package assignment05;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.io.PrintStream;

/** The main library class. */
public class Library
{
  /**
   * sets up a vaild Library object.
   *
   * Design choices: (1) it is assumed that the student's id is assigned by the
   *                     university, thus we accept that this is unique
   *                 (2) the library introduces a book counter (maxBookId) to
   *                     generate new ids for books
   *                 (3) the library system manages all creations of Book,
   *                     Student, and Loan objects. They do not escape to the client.
   *                 (4) This version handles clients communication through print streams
   *                 (5) Validity of arguments are checked in the public methods
   */
  public Library()
  {
    itemList    = new ArrayList<Item>();
    studentList = new ArrayList<Student>();
    maxBookId   = 0;
  }

  /**
   * Adds a new book to the library systems. unique IDs are automatically
   * generated.
   *
   * @param title book title
   * @param author book author
   * @precondition title != null && author != null
   */
  public void addItem(String title, String author, String category)
  {
    assert title != null && author != null && (category != "dvd" || category != "book")
           : "Precondition violation : invalid null data";

    String itemid = "" + (++maxBookId);  // generates a new unique book id
    assert findItem(itemid) == null : "Precondition failed : BookId in use";

    itemList.add(new Item(itemid, title, author, category));
  }

  /**
   * adds a new student to the library systems.
   *
   * @param uid unique student id
   * @param name student's name
   * @param email student's email
   * @param classification is the student classification(undergraduate or graduate)
   *
   * @precondition uid != null && name != null && email != null
   *               && "student is not yet in the system"
   */
  public void addStudent(String uid, String name, String email, String classification)
  {
    assert uid != null && name != null && email != null
           : "Precondition violation : invalid null data";

    Student student = findStudent(uid);
    assert student == null : "Precondition failed : uid already exists";
    assert classification != "undergraduate" || classification != "graduate" : "Precondition failed : student must be undergraduate or graduate";


    studentList.add(new Student(uid, name, email, classification));
  }

  /**
   * Student checks out a book.
   *
   * @param uid student id
   * @param bookid book id
   *
   * @throws BookLimitReachedException if the student has already checked too many books
   * @throws StudentNotFoundException if the student is not in the library system
   *
   * @precondition uid and bookid are valid IDs && book.getLoanRecord() == null
   */
  public void checkOutItem(String uid, String bookid)
                      throws StudentNotFoundException, BookLimitReachedException
  {
    Item item = findItem(bookid);
    assert item != null : "Precondition failed : book not found";
    assert item.getLoanRecord() == null : "Precondition failed : book checked out";

    Student student = findStudent(uid);
    if (student == null) throw new StudentNotFoundException();
    if (student.onLoanCount() > 1) throw new BookLimitReachedException();

    Loan loan = new Loan(student, item, new Date());

    student.checkOutLoan(loan);
    item.checkOutItem(loan);
  }

  /**
   * a book is returned to the libary.
   *
   * @param bookid id of the book that is returned
   * @precondition bookid is a valid book id
   */
  public void returnItem(String bookid)
  {
    Item    item = findItem(bookid);
    assert item != null : "Precondition failed : book not found";

    Loan    loan = item.getLoanRecord();
    assert loan != null : "No loan record for book " + bookid;

    Student student = loan.getStudent();
    assert student != null && student.getLoans().contains(loan)
           : "Inconsistent state";

    student.returnLoan(loan);
    item.returnItem(loan);
  }

  /**
   * prints a list of students to the printstream.
   *
   * @param stream stream to print the students
   */
  public void listStudents(PrintStream stream)
  {
    for (Student student : studentList)
    {
      stream.println(studentAsString(student));
    }
  }
  
  public Object[] getStudentList(){
	  ArrayList<String> arrayOfIds = new ArrayList<String>();
	  for(Student student : studentList){
		  arrayOfIds.add(student.getId());
	  }
	  return arrayOfIds.toArray();
  }
  
  public Object[] getBookList(){
	  ArrayList<String> arrayOfItem = new ArrayList<String>();
	  for(Item item: itemList){
		  if(item.getCategory() == "book"){
			  arrayOfItem.add(item.getId());
		  }
	  }
	  return arrayOfItem.toArray();
  }
  
  public Object[] getDvdList(){
	  ArrayList<String> arrayOfItem = new ArrayList<String>();
	  for(Item item: itemList){
		  if(item.getCategory() == "dvd"){
			  arrayOfItem.add(item.getId());
		  }
	  }
	  return arrayOfItem.toArray();
  }
  
  public String listAllStudentsAsString() {
	  String returnString = "";
	  for (Student student : studentList) {
		  returnString += studentAsString(student);
		  returnString += "\n----------------------\n";
	  }
	  return returnString;
  }

  /**
   * prints a list of books where the title starts with a given pattern to the printstream.
   *
   * @param titlePattern pattern that a title must contain
   * @param stream the output stream
   */
  public void listBooks(String titlePattern, PrintStream stream)
  {
    for (Item book : itemList)
    {
      if (book.getTitle().startsWith(titlePattern))
      {
        stream.println(bookAsString(book));
      }
    }
  }

  /**
   * prints all loan records of a student to the printstream.
   *
   * @param uid student id
   * @param stream output stream
   * @throws StudentNotFoundException if student does not exist in the library system
   */
  public void listLoans(String uid, PrintStream stream) throws StudentNotFoundException
  {
    Student         student = findStudent(uid);
    if (student == null) throw new StudentNotFoundException();

    stream.println("Loans for " + studentAsString(student));
    stream.println("-----");

    for (Loan loan : student.getLoans())
    {
      stream.println(bookAsString(loan.getItem()) + "  #  " + dateAsString(loan.getSince()));
    }
  }

  /**
   * internal method that converts a book to a string.
   *
   * @param book a book
   * @return a string representation of @book
   */
  private String bookAsString(Item book)
  {
    String res = (book.getLoanRecord() == null) ? "*  " : "   ";

    res = res + book.getId() + "  #  " + book.getTitle() + "  #  " + book.getAuthor();
    return res;
  }

  /**
   * internal method that converts a student to a string.
   *
   * @param student a student
   * @return string representation of @student
   */
  private String studentAsString(Student student)
  {
    String res = "Name:" + student.getName() + "\nEmail:" + student.getEmail();

    res = res + "\nUID: " + student.getId() + "\nNumber of Loans: " + student.onLoanCount();
    return res;
  }

  /**
   * internal method that converts a student to a string.
   *
   * @param day a day
   * @return string representation of @day
   */
  private String dateAsString(Date day)
  {
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    return df.format(day);
  }


  /**
   * internal method that retrieves a book from the library records.
   *
   * @param bookid a book id
   * @return the book found (null if the id does not exist)
   */
  private Item findItem(String bookid)
  {
    Item           res = null;
    Iterator<Item> it = itemList.iterator();

    while (it.hasNext() && (res == null))
    {
      Item cand = it.next();

      if (cand.getId().equals(bookid)) res = cand;
    }

    return res;
  }

  /**
   * internal method that retrieves a student from the library records.
   *
   * @param studentid uid
   * @return the student with given @studentid (null if it does not exist)
   */
  private Student findStudent(String studentid)
  {
    Student           res = null;
    Iterator<Student> it = studentList.iterator();

    while (it.hasNext() && (res == null))
    {
      Student cand = it.next();

      if (cand.getId().equals(studentid)) res = cand;
    }

    return res;
  }

  /** all books. */
  private ArrayList<Item>    itemList;

  /** all students. */
  private ArrayList<Student> studentList;

  /** current max student id. */
  private int                maxBookId;
}
