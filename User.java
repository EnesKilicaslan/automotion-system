/**
 * Created by eneskilicaslan on 23/02/16.
 */



import java.util.ArrayList;

/**
 *  User is an abstract class and it is too general to create object
 */
public abstract class User implements Person
{

    private final String name;
    private final int SSN;

    protected ArrayList<Course> courses;

    /**
     *          Constructor for the class User
     *
     * @param theName name of the User
     * @param theSSN    Social Security Number of the User
     */
    User(String theName, int theSSN)
    {

        this.name = theName;
        this.SSN = theSSN;
        this.courses = new ArrayList<Course>();

    }

    /**
     *          Get the Name of The User
     * @return  the value of the user name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     *          Get the SSN of The User
     * @return  return the value of Social Security Number (SSN)
     */
    public int getSSN()
    {
        return this.SSN;
    }

    public abstract void addCourseToteacherCourses(Course theCourse);
    public abstract void listMyCourses();
    public abstract void seeTheDocumentsOfTheCourse(Course theCourse, DateAndTime todayDate);
}
