package assignment05;

/**
 * Represents a book in the library.
 */
public class Item
{
  /**
   * Sets up a valid Book object .
   *
   * @param itemid unique library id for books
   * @param itemtitle title of the book
   * @param itemauthor author of the book
 * @throws Exception 
   *
   * @precondition bookid != null && booktitle != null && bookauthor != null
   */
  public Item(String itemid, String itemtitle, String itemauthor, String itemcategory)
  {
    assert itemid != null && itemtitle != null && itemauthor != null
           : "Precondition violation : invalid null data";
    
    assert itemcategory != "dvd" || itemcategory != "book"
    		: "Precondition violation : invalid item category";

    id         = itemid;
    title      = itemtitle;
    author     = itemauthor;
    category   = itemcategory;
    loanRecord = null;
  }

  /**
   * returns unique book id.
   *
   * @return unique book id
   * @postcondition result != null
   */
  public String getId() { return id; }

  /**
   * returns book title.
   *
   * @return book title
   * @postcondition result != null
   */
  public String getTitle() { return title; }

  /**
   * returns book author.
   *
   * @return book author
   * @postcondition result != null
   */
  public String getAuthor()     { return author;     }
  
  /**
   * returns item category.
   *
   * @return book author
   * @postcondition result != null
   */
  public String getCategory()     { return category;     }

  /**
   * returns current loan record.
   *
   * @return current loan record (null, if the book is available).
   */
  public Loan getLoanRecord()
  {
    return loanRecord;
  }

  /**
   * sets current loan record.
   * @param checkoutRecord check out data
   * @precondition checkoutRecord != null
   */
  public void checkOutItem(Loan checkoutRecord)
  {
    assert loanRecord == null : "Precondition failed : Book already checked out";

    loanRecord = checkoutRecord;
  }

  /**
   * clears check out record.
   * @param loan checkout data for the book returned
   * @precondition @loan must be the same as the stored loan record
   */
  public void returnItem(Loan loan)
  {
    assert loanRecord == loan : "Precondition failed : Book not checked out";

    loanRecord = null;
  }

  /** item id. */
  private String id;

  /** item title. */
  private String title;

  /** item author. */
  private String author;
  
  /** item author. */
  private String category;

  /** current loan record. */
  private Loan   loanRecord;
}
