/**
 * Created by eneskilicaslan on 24/02/16.
 */
public class DateAndTime {
    private int year;
    private int month;
    private int day;
    private Time time;

    DateAndTime(int theYear, int theMonth, int theDay, Time theTime)
    {
        this.setYear(theYear);
        this.setDay(theDay);
        this.setTime(theTime);
        this.setMonth(theMonth);
    }

    public void setYear(int theYear)
    {
        this.year = theYear;
    }

    public void setMonth(int theMonth)
    {
        this.month = theMonth;
    }

    public void setDay(int theDay)
    {
        this.day = theDay;
    }

    public void setTime(Time theTime)
    {
        this.time = theTime;
    }

    public int getYear()
    {
        return this.year;
    }

    public int getMonth()
    {
        return this.month;
    }

    public int getDay()
    {
        return this.day;
    }

    public Time getTime()
    {
        return this.time;
    }

    @Override
    public String toString()
    {
        return String.format("%d.%d.%d - %s",
                this.getYear(), this.getMonth(), this.getDay(), this.getTime() );

    }

    public boolean isGreaterThan(DateAndTime other)
    {
        if(this.getYear() > other.getYear())
            return true;
        else if(this.getMonth() > other.getMonth())
            return true;
        else if(this.getDay() > other.getDay())
            return true;
        else if(this.getTime().isGreaterThan(other.getTime()))
            return true;
        else
            return false;
    }

}
