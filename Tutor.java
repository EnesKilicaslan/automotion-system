/**
 * Created by eneskilicaslan
 *
 *  Class Tutor represents Tutor users
 *  We can make real Tutor object
 *  Tutors are Students for other courses
 */
public class Tutor extends Student
{
    private Course tutoredCourse;

    /**
     *          Constructor of the Class Tutor
     * @param theName name of the Tutor
     * @param theSSN   Social Security Number (SSN)
     * @param theStudentNo Student number
     */
    Tutor(String theName, int theSSN, int theStudentNo)
    {
        super(theName, theSSN, theStudentNo);
    }

    /**
     * Prints the courses of the tutor to the screen
     * ( Tutors have courses because they are student for other courses)
     */
    public void listMyCourses()
    {
        System.out.printf("I am tutor of the %s course", this.getTutoredCourse() );
        System.out.println("and I am enrolled these courses:");

        for( Course temp : courses )
            System.out.println(temp);
    }


    /**
     *          Get the course where The Tutor is tutor
     * @return  return the tutored course
     */
    public Course getTutoredCourse()
    {
        return tutoredCourse;
    }


    /**
     *          Set the course where the Tutor is tutor
     * @param theTutoredCourse the course where Tutor will be tutor
     */
    public void setTutoredCourse(Course theTutoredCourse)
    {
        this.tutoredCourse = theTutoredCourse;
    }

    /**
     *          Adds Course To teachered Course
     *          But Tutors can not use this function because They are not teacher
     * @param newCourse the course which will be added
     */
    public void addCourseToTeacheredCourses(Course newCourse)
    {
        System.out.println("YOU CAN NOT USE @@@@THIS METHOD");
    }

    /**
     *      Representation of the Class Tutor as String
     * @return combine of the name, SSN, Student number as String
     */
    @Override
    public String toString()
    {
        return this.getName() + " " + this.getSSN() + " " + this.getStudentNo();
    }

}
