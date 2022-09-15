package model;
import java.time.LocalDateTime;

public class Reservation {

    private String origin;
    private String destination;
    private Date reservationDate;
    private int numberSeats;
    private TravelInsurance insurance = null;
    private Flight flight;
    private String clientDNI;
    private float totalPrice;
    private int referenceNumber;


    public Reservation(int numberSeats, int referenceNumber, Flight flight, String DNI) {
        LocalDateTime locaDate = LocalDateTime.now();
        this.reservationDate = new Date(locaDate.getDayOfMonth(), locaDate.getMonthValue(), locaDate.getYear(), locaDate.getHour(), locaDate.getMinute());
        this.numberSeats = numberSeats;
        this.totalPrice = flight.getprice()*numberSeats;
        this.referenceNumber = referenceNumber;
        this.flight = flight;
        this.clientDNI = DNI;
        this.origin=flight.getOrigin();
        this.destination=flight.getDestination();
    }
    
    public Reservation(int numberSeats, int referenceNumber, Flight flight, String DNI, TravelInsurance insurance) {
        LocalDateTime locaDate = LocalDateTime.now();
        this.reservationDate = new Date(locaDate.getDayOfMonth(), locaDate.getMonthValue(), locaDate.getYear(), locaDate.getHour(), locaDate.getMinute());
        this.numberSeats = numberSeats;
        this.totalPrice = flight.getprice()*numberSeats;
        this.referenceNumber = referenceNumber;
        this.flight = flight;
        this.clientDNI = DNI;
        this.insurance = insurance;
        this.origin=flight.getOrigin();
        this.destination=flight.getDestination();
    }
    public Reservation(Date date,int numberSeats, int referenceNumber, Flight flight, String DNI) {
 
        this.reservationDate = date;
        this.numberSeats = numberSeats;
        this.totalPrice = flight.getprice()*numberSeats;
        this.referenceNumber = referenceNumber;
        this.flight = flight;
        this.clientDNI = DNI;
        this.origin=flight.getOrigin();
        this.destination=flight.getDestination();
    }
    public Reservation(Date date,int numberSeats, int referenceNumber, Flight flight, String DNI,  TravelInsurance insurance) {
 
        this.reservationDate = date;
        this.numberSeats = numberSeats;
        this.totalPrice = flight.getprice()*numberSeats;
        this.referenceNumber = referenceNumber;
        this.flight = flight;
        this.clientDNI = DNI;
        this.insurance = insurance;
        this.origin=flight.getOrigin();
        this.destination=flight.getDestination();
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
        return referenceNumber;
    }


    public Date getReservationDate() {
        return reservationDate;
    }



    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }



    public int getNumberSeats() {
        return numberSeats;
    }



    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }



    public float getTotalPrice() {
        return totalPrice;
    }

    public TravelInsurance getInsurance() {
        return insurance;
    }

    public void setInsurance(TravelInsurance insurance) {
        this.insurance = insurance;
    }



    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }



    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }



    public Flight getFlight() {
        return flight;
    }



    public void setFlight(Flight flight) {
        this.flight = flight;
    }



    public void setClientDNI(String dNI) {
        clientDNI = dNI;
    }



    public String getClientDNI() {
        return clientDNI;
    }

    @Override
    public String toString() {
        return "Origin: "+flight.getOrigin()+" Destination: "+flight.getDestination()+" Reference Number: "+referenceNumber;
    }


}
