/**
 * Created by eneskilicaslan
 * Document is an interface that represents every kind of Documents
 */
public interface Document {
    void setName(String theName);
    String getName();
    boolean isOverdue(DateAndTime rightNow);
}
