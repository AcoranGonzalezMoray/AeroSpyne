package model;
import java.time.LocalDateTime;
public class Complaint{

    private String title;
    private String description;
    private Date date;
    private String clientDNI;
    private int referenceNumber;

    public Complaint(String title, String description,  String clientDNI, int referenceNumber) {
        LocalDateTime locaDate = LocalDateTime.now();
        this.title = title;
        this.description = description;
        this.date = new Date(locaDate.getDayOfMonth(), locaDate.getMonthValue(), locaDate.getYear(), locaDate.getHour(), locaDate.getMinute());
        this.clientDNI = clientDNI;
        this.referenceNumber = referenceNumber;
    }

    public Complaint(String title, String description, Date date  ,String clientDNI, int referenceNumber) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.clientDNI = clientDNI;
        this.referenceNumber = referenceNumber;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClientDNI() {
        return clientDNI;
    }

    public void setClientDNI(String clientDNI) {
        this.clientDNI = clientDNI;
    }

    public int getReferenceNumber() {
        return this.referenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Override
    public String toString() {
        return "User: "+this.getClientDNI()+"\n"+"Title: "+this.getTitle()+"\n Description: "+this.getDescription()+"\n  Reference Number: "+this.getReferenceNumber()+"  Date: "+this.date;
    }
     
    

}