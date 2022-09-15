package model;
public class Flight {

    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private int duration;
    private float price;
    private  int referenceNumber;


    public Flight(String origin, String destination, Date departureDate, Date arrivalDate, int duaration, float price,int referenceNumber) {

        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duaration;
        this.price = price;
        this.referenceNumber = referenceNumber;
    }



    
    public String getOrigin() {
        return origin;
    }




    public void setOrigin(String origin) {
        this.origin = origin;
    }




    public String getDestination() {
        return destination;
    }




    public void setDestination(String destination) {
        this.destination = destination;
    }




    public int getReferenceNumber() {
        return this.referenceNumber;
    }

    public float getprice() {
        return this.price;
    }

    public String getFlight(){
        return this.origin+" - "+this.destination+"      from  "+this.price+"€";
    }

    


    public Date getDepartureDate() {
        return departureDate;
    }




    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }




    public Date getArrivalDate() {
        return arrivalDate;
    }




    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }




    public int getDuration() {
        return duration;
    }




    public void setDuration(int duration) {
        this.duration = duration;
    }




    public float getPrice() {
        return price;
    }




    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Origin: "+this.origin+"   Destination: "+this.destination+"\nDepartureDate: "+this.departureDate+" ArrivalDate: "+this.arrivalDate+"\nDuration: "+this.duration+" Price: "+this.price+"\nReference Number: "+this.referenceNumber;
    }

}
