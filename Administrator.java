/**
 * Created by eneskilicaslan
 * Administrator objects manege courses
 * But there can be only one Administrator in a Course
 * Administrators can add every kind of users to the course that they manege
 *
 */
public class Administrator extends Teacher
{
    String degree;

    /**
     *      Constructor for Administrator class
     * @param theName name of the Administrator
     * @param theSSN  Social Security Number
     * @param theMail Mail address od the Administrator
     * @param theDegree Degree of Administrator, For example: Prof, Ass. Prof
     */
    Administrator(String theName, int theSSN, String theMail, String theDegree)
    {
        super(theName, theSSN, theMail);
        this.degree = theDegree;
    }


    /**
     *          Administrator creates course with the function
     * @param theCourseName name of the Course, For examle: CSE-222
     * @return Reference for the creted course object
     */
    public Course createCourse(String theCourseName)
    {
        Course temp;
        temp = new Course( theCourseName, this.getName() );
        this.addCourseToteacherCourses(temp);

        return temp;
    }


    /**
     *              The aim of this function is adding new user to specified course
     *              The Difference between Administrator and Teacher is that Administrator can
     *              add Teacher to the specified course
     *
     * @param   newUser is the user which will be added
     * @param   theCourse the course where the user will be added to
     * @return  new added User
     */
    public User addUserToCourse(User newUser, Course theCourse)
    {
        if(newUser != null) {
            //if the Administrator can not manege the course
            if (this.checkIfMyCourse(theCourse)) {

                if (theCourse.addUser(newUser)) {
                    if(newUser instanceof  Teacher)
                        ((Teacher) newUser).addCourseToteacherCourses(theCourse);

                    return newUser;
                }
                else {
                    System.out.printf("User %s could not be added to the course %s\n", newUser.getName(), theCourse);
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
     *              The aim of this function is removing user from specified course
     *              The Difference between Administrator and Teacher is that Administrator can
     *              remove Teacher from the specified course
     *
     * @param oldUser is the User which will be deleted
     * @param theCourse is the course which the user will be deleted from
     */
    public boolean removeUserFromCourse(User oldUser, Course theCourse) {

        if (oldUser != null) {
            //if the Administrator can not manege the course
            if (this.checkIfMyCourse(theCourse)) {

                if (theCourse.removeUser(oldUser))
                    return true;
                else {
                    System.out.printf("User %s could not be added to the course %s\n", oldUser, theCourse);
                    return false;
                }

            } else {
                System.out.printf("User %s could not be added to the course %s, Because Teacher %s can NOT manege the course \n",
                        oldUser.getName(), theCourse.getCourseName(), this.getName());

                return false;
            }
        } else {
            System.out.printf("The User is null\n");
            return false;
        }

    }

    /**
     *  Lists the Courses of the Administrator
     */
    public void listMyCourses()
    {
        System.out.println("I am Administrator, and I can manage these courses:");
        for( Course temp : courses )
            System.out.println(temp);
    }

}