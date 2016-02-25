/**
 * Created by eneskilicaslan on 24/02/16.
 */
public class Time {
    private int hour;
    private int minute;

    Time(int theHour, int theMinute)
    {
        this.setHour(theHour);
        this.setMinute(theMinute);
    }

    public void setHour(int theHour)
    {
        this.hour = theHour;
    }

    public void setMinute(int theMinute)
    {
        this.minute = theMinute;
    }

    public int getHour()
    {
        return this.hour;
    }

    public int getMinute()
    {
        return this.minute;
    }

    public boolean isGreaterThan(Time other)
    {
        if(this.getHour() > other.getHour())
            return true;

        else if(this.getMinute() > other.getMinute())
            return true;

        else
            return false;
    }

    @Override
    public String toString()
    {
        return String.format("%d:%d", this.getHour(), this.getMinute() );
    }

}
