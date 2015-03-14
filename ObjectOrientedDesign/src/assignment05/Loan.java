package assignment05;

import java.util.Date;

/**
 * represents an active loan record.
 */
public class Loan
{
  /**
   * sets up a valid Loan object.
   *
   * @param aStudent student checking out
   * @param aItem book checked out
   * @param day current day
   *
   * @precondition aStudent != null && aBook != null && day != null
   */
  public Loan(Student aStudent, Item aItem, Date day)
  {
    assert aStudent != null && aItem != null && day != null
           : "Precondition violation : invalid null data";

    student    = aStudent;
    item       = aItem;
    dateLoaned = day;
  }
  

  /**
   * returns the student who loaned the book.
   *
   * @return the student holding the book
   */
  public Student getStudent() { return student; }

  /**
   * returns the book associated with this loan.
   *
   * @return the book being held
   */
  public Item getItem() { return item; }

  /**
   * returns the date when the check out took place.
   *
   * @return date of transaction
   */
  public Date getSince() { return dateLoaned; }

  /** the student. */
  private Student student;

  /** the book. */
  private Item    item;

  /** date checked out. */
  private Date    dateLoaned;
}
