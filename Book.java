/**
 * Created by eneskilicaslan
 *
 * The Book is a specific document
 * It does not have a deadline or lateDeadline
 *
 */
class Book extends GeneralDocument
{
    private String text;

    /**
     *          Constructor for Book Class
     * @param theName name of the Book
     * @param theText content of the book
     */
    Book(String theName, String theText)
    {
        super(theName);
        this.setText(theText);
    }

    /**
     *          Set the text field
     * @param theText the value which will be setted
     */
    public void setText(String theText)
    {
        this.text = theText;
    }

    /**
     *      This function comes from interface Document so we have to override it
     * @param rightNow the today's date , but it does not matter
     * @return false, because Book does not have a deadline or latedeadline
     */
    public boolean isOverdue(DateAndTime rightNow) {
        return false;
    }
}