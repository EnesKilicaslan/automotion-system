/**
 * Created by eneskilicaslan
 */

import java.util.ArrayList;

/**
 *  Teacher class represents teacher users
 *  We can create real Teacher objects
 */
public class Teacher extends  User
{

    private final String mail;
    private ArrayList<Course> teacherCourses;


    /**
     *          Constructor for the Class Teacher
     *          Uses the constructer of super class User
     * @param theName name of the Teacher
     * @param theSSN  Social Security Number(SSN)
     * @param theMail mail address of the Teahcer
     */
    Teacher(String theName, int theSSN, String theMail)
    {
        super(theName, theSSN);
        this.mail = theMail;

        teacherCourses = new ArrayList<Course>();
    }


    /**
     * Prints the Courses of the Teacher to the Screen
     */
    public void listMyCourses()
    {
        System.out.println("I am Teacher, and I can manage these courses:");
        for( Course temp : courses )
            System.out.println(temp);
    }


    /**
     *          adding new user to specified course
     *
     * @param   newUser is the user which will be added
     * @param   theCourse the course where the user will be added to
     * @return  new added User
     */
    public User addUserToCourse(User newUser, Course theCourse)
    {
        if( newUser != null )
        {
            //if the Administrator can not manege the course
            if (this.checkIfMyCourse(theCourse)) {

                if ( !(newUser instanceof Teacher) && !(newUser instanceof Administrator) && theCourse.addUser(newUser) )
                    return newUser;
                else {
                    System.out.printf("User %s could not be added to the course %s\n", newUser, theCourse);
                    return null;
                }
            }
            else {
                System.out.printf("User %s could not be added to the course %s, Because Teacher %s can NOT manege the course \n",
                        newUser.getName(), theCourse.getCourseName(), this.getName());

                return null;
            }
        }
        else
        {
            System.out.printf("The User is null\n");
            return null;
        }

    }


    /**
     *          The aim of this overloaded funcition is to Add tutor of a course
     *          to another course as Student
     *
     * @param   newUser is a Student or Tutor to add the course
     * @param   theCourse is the course which is user will be added
     * @param   asStudent  just to overload the function, in order to add Tutor as Student
     * @return  returns paramater1
     */
    public User addUserToCourse(Student newUser, Course theCourse, boolean asStudent)
    {
        User temp = new Student(newUser);

        if( newUser != null )
        {
            //if the Administrator can not manege the course
            if (this.checkIfMyCourse(theCourse)) {

                //Teacher can not add Teacher or Administrator to any course
                if ( !(temp instanceof Teacher) && !(temp instanceof Administrator) && theCourse.addUser(temp) )
                    return newUser;

                else {
                    System.out.printf("User %s could not be added to the course %s\n", newUser, theCourse);
                    return null;
                }
            }
            else {
                System.out.printf("User %s could not be added to the course %s, Because Teacher %s can NOT manege the course \n",
                        newUser.getName(), theCourse.getCourseName(), this.getName());

                return null;
            }
        }
        else
        {
            System.out.printf("The User is null\n");
            return null;
        }

    }

    /**
     * @param oldUser is the User which will be deleted
     * @param theCourse is the course which the user will be deleted from
     */
    public boolean removeUserFromCourse(User oldUser, Course theCourse)
    {

        if (oldUser != null) {
            //if the Teacher can not manege the course
            if (this.checkIfMyCourse(theCourse)) {

                if ((!(oldUser instanceof Teacher) && !(oldUser instanceof Administrator)) && theCourse.removeUser(oldUser) )
                    return true;
                else {
                    System.out.printf("User %s could not be deleted from the course %s\n", oldUser.getName(), theCourse);
                    return false;
                }

            } else {
                System.out.printf("User %s could not be deleted from the course %s, Because Teacher %s can NOT manege the course \n",
                        oldUser.getName(), theCourse.getCourseName(), this.getName());

                return false;
            }
        } else {
            System.out.printf("The User is null\n");
            return false;
        }

    }


    /**
     *          Gives the ability to upload a document to the User
     * @param theDocument the Document which will be added
     * @param theCourse the Course where the document will be added to
     * @return true if the operation is successful, otherwise return false
     */
    public boolean uploadDocumentToCourse(Document theDocument, Course theCourse)
    {
        if ( theDocument != null) {

            //if the Teacher can not manege the course
            if (this.checkIfMyCourse(theCourse)) {

                theCourse.addDocument(theDocument);
                return true;

            } else {
                System.out.printf("Document %s could not be uploaded to the course %s, Because Teacher %s can NOT manege the course \n",
                        theDocument.getName(), theCourse.getCourseName(), this.getName());

                return false;
            }
        }
        else {
            System.out.printf("The Document is not valid!!\n");
            return false;
        }


    }


    /**
     *      Prints the documents that are visible to the teacher on the course
     * @param theCourse course where the documents are stored
     */
    public void seeTheDocumentsOfTheCourse(Course theCourse)
    {
        System.out.printf("I am %s and I can see these documents on the course %s:  \n", this.getName(), theCourse.getCourseName() );


        for(int i = 0; i < theCourse.getDocuments().size(); i++) {
            System.out.printf("%s\n",theCourse.getDocuments().get(i));
        }
    }

    /**
     *         Prints the documents that are visible to the teacher on the course but it takes the Date as argument
     * @param theCourse
     * @param todayDate
     */
    public void seeTheDocumentsOfTheCourse(Course theCourse, DateAndTime todayDate)
    {
        this.seeTheDocumentsOfTheCourse(theCourse);
    }

    /**
     *          Adds a new course to teacher courses
     * @param newCourse the course which will be added
     */
    @Override
    public void addCourseToteacherCourses(Course newCourse) {
        teacherCourses.add(newCourse);
    }

    /**
     *
     * @param theCourse : the course which will be checked
     * @return return true if the user can manege this course theCourse
     */
    protected boolean checkIfMyCourse(Course theCourse)
    {
        for( Course temp : teacherCourses )
            if( temp == theCourse )
                return true;

        return false;
    }

    /**
     *          Representation of the Class Teacher as String
     * @return  combine of the name, SSN, mail as String
     */
    @Override
    public String toString()
    {
        return this.getName() + " " + this.getSSN() + " "  + this.getMail();
    }

    /**
     *          Get mail address of the Teacher
     * @return  the value of the mail address
     */
    public String getMail() {
        return mail;
    }


}
