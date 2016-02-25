/**
 * Created by eneskilicaslan on 24/02/16.
 */

import java.util.ArrayList;

class Quiz extends Assignment
{
    private ArrayList<String> questions;
    private ArrayList<String> answers;

    public Quiz(String name, DateAndTime theDeadline, DateAndTime theLateDeadline)
    {
        super(name, theDeadline, theLateDeadline);
        questions = new ArrayList<String>();
        answers   = new ArrayList<String>();
    }

    public String toString()
    {
        return "Quiz: " + this.getName();
    }
    ///Soru soracak    ******** public void addQuestion()
}