/**
 * Created by eneskilicaslan
 *
 *  Student class that represents the Student Users
 *  The Class ha one private member which is student number (studentNO)
 *
 */
public class Student extends User
{
    private final int studentNo;

    /**
     *      Constructer for the class User
     *      we can create real objects with the constructer
     *
     * @param theName name of the Student
     * @param theSSN    Social Security Number (SSN)
     * @param theStudentNo Student number
     */
    Student(String theName, int theSSN, int theStudentNo)
    {
        super(theName, theSSN);
        this.studentNo = theStudentNo;
    }

    /**
     *         Similar to Copy Constructer in C++
     *         This constructer is Used by some functions to create an object with the same values
     * @param theStudent
     */
    Student(Student theStudent)
    {
        super(theStudent.getName(), theStudent.getSSN());
        this.studentNo = theStudent.getStudentNo();

    }

    /**
     *  Prints the Courses to the screen
     */
    public void listMyCourses()
    {
        System.out.println("I am Student, and I am enrolled these courses:");
        for( Course temp : courses )
            System.out.println(temp);
    }

    /**
     *          if User wants to see the Documents on the course, then the User uses this function
     *
     * @param theCourse the course where we will see the Documents
     * @param todayDate Today's date, it is important because Students and Tutors can not see older Courses
     */
    public void seeTheDocumentsOfTheCourse(Course theCourse, DateAndTime todayDate)
    {
        System.out.printf("I am %s and I can see these documents on the course %s:  \n", this.getName(), theCourse.getCourseName() );

        for(int i = 0; i < theCourse.getDocuments().size(); i++) {

            Document temp = theCourse.getDocuments().get(i);

            if( temp instanceof  Assignment )
                if(!temp.isOverdue( todayDate) )
                    System.out.printf("%s\n", theCourse.getDocuments().get(i));
        }
    }


    /**
     *          Get the Student Number
     * @return  the value of studentNo
     */
    public int getStudentNo()
    {
        return studentNo;
    }

    /**
     *      Representation of the Student class as String
     * @return  combine of name, SSN , student number as String
     */
    @Override
    public String toString()
    {
        return this.getName() + " " + this.getSSN() + " " + this.getStudentNo();
    }

    /**
     *          Adds Course To teacher courses
     *          BUT STUDENT WILL NOT USE THIS FUNCTION
     * @param theCourse the course which will be added
     */
    @Override
    public void addCourseToteacherCourses(Course theCourse) {
        System.out.println("YOU CAN NOT USE THIS METHOD");

    }

}
