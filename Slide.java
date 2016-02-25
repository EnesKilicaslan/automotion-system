/**
 * Created by eneskilicaslan
 */

import java.util.ArrayList;

/**
 *  Slide is a specific document
 *  Slides does not have deadline or LateDeadline
 */
class Slide extends GeneralDocument
{
    private ArrayList<String> slides;

    /**
     *          Constructor for the Class Slide
     *          Uses the constructer of the super class GeneralDocument
     * @param theName the name of the slide
     */
    Slide(String theName)
    {
        super(theName);
        slides = new ArrayList<String>();
    }


    /**
     *          Adds one slide(page) to the slides
     * @param oneSlide the page that will be added
     */
    public void addSlide(String oneSlide)
    {
        slides.add(oneSlide);
    }

    /**
     *          Gets one slide(page) at the specified index
     * @param index the index to use on the ArrayList slides
     * @return the slide(page) at the index
     */
    public String getOneSlide(int index)
    {
        return slides.get(index);
    }

    /**
     *      This function comes from interface Document so we have to override it
     * @param rightNow the today's date , but it does not matter
     * @return false, because Slide does not have a deadline or latedeadline
     */
    public boolean isOverdue(DateAndTime rightNow) {
        return false;
    }
}
