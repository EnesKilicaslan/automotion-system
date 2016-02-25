/**
 * Created by eneskilicaslan
 *
 *          Reference of this class can hold Assignments like  quiz, homework or group project.
 * Assignement Class is an abstract class so you can not create object of the class but you can use as reference
 * Every Assignment must have A deadline and a late deadline
 * This class extends The GeneralDocument class
 */
abstract class Assignment extends GeneralDocument {

    private DateAndTime deadline;
    private DateAndTime lateDeadline;

    /**
     *
     * @param name the name of the Assignment
     * @param theDeadline the deadline of the Assignment
     * @param theLateDeadline the last day of the Assignment
     */
    Assignment(String name, DateAndTime theDeadline, DateAndTime theLateDeadline)
    {
        super(name);
        this.setDeadline(theDeadline);
        this.setLateDeadline(theLateDeadline);
    }


    /**
     *      Sets the deadline
     * @param theDeadline the value that will be setted to the deadline
     */
    public final void setDeadline(DateAndTime theDeadline)
    {
        this.deadline = theDeadline;
    }


    /**
     *      Gets the deadline
     * @return the value of the deadline field
     */
    public DateAndTime getDeadline()
    {
        return this.deadline;
    }


    /**
     *         Sets the lateDeadline
     * @param theLateDeadline the value of the lateDeadline
     */
    public final void setLateDeadline(DateAndTime theLateDeadline)
    {
        this.lateDeadline = theLateDeadline;
    }

    /**
     *        desides if the lateDeadline is passed
     * @param theTodayDate is the Today's date
     * @return true if the lateDeadline is passed, otherwise returns true
     */
    public boolean isOverdue(DateAndTime theTodayDate)
    {
        return this.getLateDeadline().isGreaterThan(theTodayDate);
    }

    /**
     *      Gets the LateDeadline
     * @return the value of the lateDeadline field
     */
    public DateAndTime getLateDeadline()
    {
        return this.lateDeadline;
    }

}
