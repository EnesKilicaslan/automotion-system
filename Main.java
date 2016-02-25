import java.util.Date;

/**
 * Created by eneskilicaslan
 * Includes Some Test scenarios for Student Automation System
 *      -Creating Courses
 *      -Adding Users to the Courses
 *      -Deleting Users from the Course
 *      -Showing the course list of any User
 *
 *      and more..
 *
 *
 */
public class Main {

    public static void main(String[] args)
    {
        Time early = new Time( 15, 30);
        Time late = new Time( 8, 00);

        DateAndTime yesterday = new DateAndTime(2016, 02, 14, late);
        DateAndTime today     = new DateAndTime( 2016 , 02 , 15, early);
        DateAndTime tomorrow  = new DateAndTime(2016, 02,  16, late);
        DateAndTime nextWeek  = new DateAndTime(2016, 02,  23, early);


        Document firstQuiz = new Quiz("First Quiz", today, tomorrow);
        Document secondQuiz = new Quiz("Second Quiz",yesterday, today);

        Administrator yusuf, erdogan, erkan;

        yusuf   = new Administrator("Yusuf Sinan Akgul", 10001, "Prof"      , "ysakgul@gtu.edu.tr");
        erdogan = new Administrator("Erdogan Sevilgen" , 10002, "Ass. Prof" , "sevilgen@gtu.edu.tr");
        erkan   = new Administrator("Erkan Zergeroglu" , 10003, "Ass. Prof" , "ezergeroglu@gtu.edu.tr");

        Course cse241, cse222, cse244;

        cse241 = yusuf.createCourse("CSE-241");
        cse222 = erdogan.createCourse("CSE-222");
        cse244 = erkan.createCourse("CSE-244");


        Teacher necmettin, arzu, mustafa;

        necmettin = new Teacher("Necmettin Carkici", 10004, "ncarkici@gtu.edu.tr" );
        arzu      = new Teacher("Arzu Kakisim", 10005, "arzukakisim@gtu.edu.tr");
        mustafa   = new Teacher("Mustafa Fatih Tunali", 10006, "mftunali@gtu.edu.tr");


        //teacher necmettin manages two courses: cse222 and cse241
        erdogan.addUserToCourse(necmettin, cse222);
        yusuf.addUserToCourse(necmettin, cse241);

        //teacher mustafa manages only the course cse222
        //now there are two teachers on the course cse222: teacher necmettin and mustafa
        erdogan.addUserToCourse(mustafa, cse222);

        //only teacher arzu manages the course cse244
        erkan.addUserToCourse(arzu, cse244);

        //Tutors
        User enes, halil;

        enes  = new Tutor("Enes Kilicaslan", 10007, 141044088);
        halil = new Tutor("Halil Yilmaz", 10008, 141044089);


        //Students
        User ahmet, mehmet, veli, ali;

        ahmet  = new Student("Ahmet Yildirim", 10009, 141044090);
        mehmet = new Student("Mehmet Kara", 10010, 141044091);
        veli   = new Student("Veli Babacan", 10011, 141044092);
        ali    = new Student("Ali Atabak", 10012, 141044093);


        //enes is tutor for the course cse222 and student for the course cse241
        enes = necmettin.addUserToCourse(enes, cse222);
        halil = necmettin.addUserToCourse((Tutor) halil, cse241, true);

        //halil is tutor for the course cse244 and student for the courses cse241, cse222
        halil = arzu.addUserToCourse((Tutor) halil, cse244);
        halil = mustafa.addUserToCourse((Tutor) halil, cse222, true); //make a tutor Student for another course
        halil = necmettin.addUserToCourse((Tutor) halil, cse241, true);

        //Student ahmet and mehmet is student for all of the three courses: cse241, cse22, cse244
        ahmet = necmettin.addUserToCourse(ahmet, cse241);
        ahmet = necmettin.addUserToCourse(ahmet, cse222);
        ahmet = arzu.addUserToCourse(ahmet, cse244);

        mehmet = necmettin.addUserToCourse(mehmet, cse241);
        mehmet = necmettin.addUserToCourse(mehmet, cse222);
        mehmet = arzu.addUserToCourse(mehmet, cse244);

        //Student veli is student for the courses cse222 and cse244
        veli = necmettin.addUserToCourse(veli, cse222);
        veli = arzu.addUserToCourse(veli, cse244);

        //Student ali is student for the courses cse241 and cse222
        ali = necmettin.addUserToCourse(ali, cse241);
        ali = necmettin.addUserToCourse(ali, cse222);

        cse222.listUsers();

        //********************** WRONG REMOVING AND ADDING USERS ATTEMPTS **************************
        //***                                                                                    ***
        ///                         UNCOMMENT THEM AND SEE THE RESULTS
        //***                                                                                    ***
        //******************************************************************************************

        //necmettin.addUserToCourse(yusuf, cse222); // A teacher can not add Administrator
        //necmettin.removeUserFromCourse(ali, cse244); //Teacher necmettin does not manege the course cse222
        //necmettin.removeUserFromCourse(mustafa, cse222); //A Teacher can not delete another user
        //necmettin.removeUserFromCourse(erdogan, cse222); //A Teacher can not delete the Administrator
        //yusuf.addUserToCourse(necmettin, cse222);

        System.out.println("****************************************************************");

        necmettin.uploadDocumentToCourse(firstQuiz, cse222);
        necmettin.uploadDocumentToCourse(secondQuiz, cse222);

        necmettin.seeTheDocumentsOfTheCourse(cse222);//Teacher necmettin can see every document on the course

        System.out.println("****************************************************************");

        enes.seeTheDocumentsOfTheCourse(cse222, nextWeek);
        System.out.println("********************* Let's change today's date to the future ");

        enes.seeTheDocumentsOfTheCourse(cse222, yesterday); // tutor or student can not see older courses








    }
}
