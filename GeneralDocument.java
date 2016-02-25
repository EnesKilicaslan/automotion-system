/**
 * Created by eneskilicaslan.
 *
 * GeneralDocument is an abstract class
 * Implements the functions of the interface Document
 */
abstract class GeneralDocument implements Document {
    private String name;

    /**
     *             Constructor for The Class GeneralDocument
     *
     * @param name the name of the GeneralDocument
     */
    public GeneralDocument(String name) {
        this.name = name;
    }

    /**
     *          Get the name of the GeneralDocument
     * @return  the value of the name field
     */
    public String getName()
    {
        return this.name;
    }

    /**
     *          Set the name of the GeneralDocument
     *
     * @param theName the value to be setted to the name field
     */
    public void setName(String theName)
    {
        this.name = theName;
    }
}
