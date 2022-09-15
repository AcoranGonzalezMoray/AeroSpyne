package model;
import java.text.DecimalFormat;

public class Date {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minutes;

    
    public Date(int day, int month, int year, int hour, int minutes) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;

    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = 00;
        this.minutes = 00;
    }
    
    
    public String getDay() {
        return new DecimalFormat("00").format(this.day);
    }

    public String getMonth() {
        return new DecimalFormat("00").format(this.month);
    }

    public String getYear() {
        return new DecimalFormat("00").format(this.year);
    }

    public String getHour() {
        return new DecimalFormat("00").format(this.hour);
    }

    public String getMinutes() {
        return new DecimalFormat("00").format(this.minutes);
    }



    @Override
    public String toString() {
        return new DecimalFormat("00").format(this.day)+"/"+ new DecimalFormat("00").format(this.month)+"/"+ new DecimalFormat("0000").format(this.year)+"    "+new DecimalFormat("00").format(this.hour)+":"+ new DecimalFormat("00").format(this.minutes);
    }

    
}
