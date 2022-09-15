package model;
public class TravelInsurance {

    private String name;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String coverage;
    private int passengers;
    private String DNI;
    private int referenceNumber;
    private int referenceNumberReservation = 0;
    
    public TravelInsurance(String name, String origin, String destination, Date departureDate, Date arrivalDate,
            int passengers, String coverage, int referenceNumber, String DNI) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengers = passengers;
        this.coverage = coverage;
        this.DNI = DNI;
        this.referenceNumber = referenceNumber;

    }
    
    public TravelInsurance(String name, String origin, String destination, Date departureDate, Date arrivalDate,
        int passengers, String coverage, int referenceNumber, String DNI, int referenceReservation) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengers = passengers;
        this.coverage = coverage;
        this.DNI = DNI;
        this.referenceNumber = referenceNumber;
        this.referenceNumberReservation = referenceReservation;

    }
    

    public String getName() {
        return name;
    }

    public int getReferenceNumberReservation() {
        return referenceNumberReservation;
    }

    public void setReferenceNumberReservation(int referenceNumberReservation) {
        this.referenceNumberReservation = referenceNumberReservation;
    }


    public void setName(String name) {
        this.name = name;
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


    public int getPassengers() {
        return passengers;
    }


    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }


    public String getCoverage() {
        return coverage;
    }


    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }


    public int getReferenceNumber() {
        return referenceNumber;
    }


    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    
    public String getDNI() {
        return DNI;
    }


    public void setDNI(String dNI) {
        DNI = dNI;
    }


    @Override
    public String toString() {
        return "DNI=" + DNI + ", End of coverage=" + arrivalDate + ", Start Of Coverage=" + departureDate +"\n coverage=" + coverage
                + "\n origin="+ origin+", destination=" + destination + "\n name=" + name  + ", passengers=" + passengers + ", referenceNumber=" + referenceNumber + ", Reservation="+referenceNumberReservation+"]";
    }


    
    
}
