/**
 * Created by eneskilicaslan
 */

import java.util.ArrayList;

/**
 *  Class Course is not a subclass or superclass
 *  Represents courses(lectures) created by any Administrator
 */
public class Course {

    private final String courseName;
    private final String administratorName;

    private ArrayList<User> users;
    private ArrayList<Document> documents;


    /**
     * Constructor for the class Course
     * Creates ArrayList objects for users and documents
     *
     * @param theCourseName        The name of the Course
     * @param theAdministratorName The name of the Adminisrator who created this course
     */
    public Course(String theCourseName, String theAdministratorName) {
        this.administratorName = theAdministratorName;
        this.courseName = theCourseName;
        users = new ArrayList<User>();
        documents = new ArrayList<Document>();
    }

    /**
     * Adds User to the Course
     *
     * @param newUser the User which will be added to the course
     * @return returns reference to the created User
     */
    public boolean addUser(User newUser) {
        try {
            users.add(newUser);
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("The User could not be added %s", e.getCause());
            return false;
        }
    }

    /**
     * Removes the specified User from the Course
     *
     * @param oldUser the User which will be deleted from the course
     * @return return true if the process is successful otherwise return false
     */
    public boolean removeUser(User oldUser) {
        if (!this.checkIfMyUser(oldUser))
            return false;

        try {
            users.remove(oldUser);
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("The User could not be deleted %s", e.getCause());
            return false;
        }
    }




    /**
     *  Prints the users to the screen by group
     */
    public void listUsers()
    {
        boolean line = true;

        System.out.printf("Administrator of the course %s:  %s\n", this, this.getAdministratorName());


        for( User temp : users)
        {
            if(temp instanceof Teacher ) {
                if(line)
                    System.out.printf("Teachers of the course %s:\n", this);
                System.out.printf("\t%s\n", temp);
                line = false;
            }
        }

        line = true;

        for( User temp : users)
        {
            if(temp instanceof Tutor ) {
                if(line)
                    System.out.printf("Tutors of the course %s:\n", this);
                System.out.printf("\t%s\n", temp);
                line = false;
            }
        }

        line = true;

        for( User temp : users)
        {
            if(temp instanceof Student && !(temp instanceof Tutor)) {
                if(line)
                    System.out.printf("Students of the course %s:\n", this);
                System.out.printf("\t%s\n", temp);
                line = false;
            }
        }

    }

    /**
     *          Adds document to the course
     * @param theAssignment the document which will be added to the course
     * @return true  if the process is successful, otherwise returns false
     */
    public boolean addDocument(Document theAssignment)
    {
        documents.add(theAssignment);
        return true;
    }

    /**
     *          Gets The ArrayList Doucuments
     * @return  reference to the documents field
     */
    public ArrayList<Document> getDocuments() {
        return documents;
    }

    /**
     *          representation of Course as String
     * @return  Course name
     */
    public String toString()
    {
        return this.getCourseName();
    }

    /**
     *          Get the name of the course
     * @return  the value of the course field
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     *          Get the Administrator of the Course
     * @return  the value of the adminstratorName field
     */
    public String getAdministratorName() { return administratorName;  }

    /**
     *          Checks if the User belongs to the course
     * @param theUser the User which will be checked
     * @return  true if the User exist in the course
     */
    private boolean checkIfMyUser(User theUser)
    {
        for(User temp : users)
            if(theUser == temp)
                return true;

        return false;
    }

}
