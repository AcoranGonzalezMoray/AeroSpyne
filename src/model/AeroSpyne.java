package model;
import java.util.List;
import java.util.ArrayList;

public class AeroSpyne {
    public List<Client> clients =new ArrayList<Client>();
    public List<Reservation> reservations = new ArrayList<Reservation>();
    public List<Flight> Flights = new ArrayList<Flight>();
    public List<Complaint> complaints = new ArrayList<Complaint>();
    public List<TravelInsurance> travelInsurance  =new ArrayList<TravelInsurance>();
    public List<Card> cards =new ArrayList<Card>();

    public AeroSpyne() {}



    public boolean validation(String email, String password){
        for(int i = 0; i< this.clients.size(); i++ ){
            if(this.clients.get(i).getEmail().compareTo(email)==0 && this.clients.get(i).getPassword().compareTo(password)==0){
                return true;
            }
        }
        return false;
    }
 
    //########################### Client ##########################
    public boolean addClient(Client client){
        if(this.getClient(client.getClientDNI()) instanceof Client){
            return false;
        }

        this.clients.add(client);
        return true;
    }

    public boolean removeClient(String clientDNI){
        if(this.getClient(clientDNI) instanceof Client){
            for(int i = 0; i< this.clients.size(); i++ ){
                if(this.clients.get(i).getClientDNI().compareTo(clientDNI)==0){
                    this.clients.remove(this.clients.get(i));
                    return true;
                }
            }
            
        }

        return false;
    }

    public Client getClient(String clientDNI){
        for(int i = 0; i< this.clients.size(); i++ ){
            if(this.clients.get(i).getClientDNI().compareTo(clientDNI)==0){
                return this.clients.get(i);
            }
        }
        return null;
    }

    public List<Client> getAllclients(){
        return this.clients;
    }
    //########################### RESERVATION ##########################
    public boolean addReservation(Reservation reservation){
        if(this.getReservation(reservation.getReferenceNumber()) instanceof Reservation){
            return false;
        }

        this.reservations.add(reservation);
        return true;
    }

    public boolean removeReservation(int referenceNumber){
        if(this.getReservation(referenceNumber) instanceof Reservation){
            for(int i = 0; i< this.reservations.size(); i++ ){
                if(this.reservations.get(i).getReferenceNumber() == referenceNumber){
                    this.reservations.remove(this.reservations.get(i));
                    return true;
                }
            }
            
        }

        return false;
    }

    public Reservation getReservation(int referenceNumber){
        for(int i = 0; i< this.reservations.size(); i++ ){
            if(this.reservations.get(i).getReferenceNumber()==referenceNumber){
                return this.reservations.get(i);
            }
        }
        return null;
    }
    
    public List<Reservation> getAllReservations(){
        return this.reservations;
    }
    //########################### FLIGHT ##########################
    public boolean addFlight(Flight flight){
        if(this.getFlight(flight.getReferenceNumber()) instanceof Flight){
            return false;
        }

        this.Flights.add(flight);
        this.Country.add(flight.getOrigin());
        this.Country.add(flight.getDestination());
        return true;
    }

    public boolean removeFlight(int referenceNumber){
        if(this.getFlight(referenceNumber) instanceof Flight){
            for(int i = 0; i< this.Flights.size(); i++ ){
                if(this.Flights.get(i).getReferenceNumber() == referenceNumber){
                    this.Flights.remove(this.Flights.get(i));
                    return true;
                }
            }
            
        }

        return false;
    }

    public Flight getFlight(int referenceNumber){
        for(int i = 0; i< this.Flights.size(); i++ ){
            if(this.Flights.get(i).getReferenceNumber()==referenceNumber){
                return this.Flights.get(i);
            }
        }
        return null;
    }
        
    public List<Flight> getAllflights(){
        return this.Flights;
    }

    public List<String> getAllCountry(){
        return this.Country;
    }
    //########################### COMPLAINT ##########################
    public boolean addComplaint(Complaint complaint_ ){
        if(this.getComplaint(complaint_.getReferenceNumber()) instanceof Complaint){
            return false;
        }

        this.complaints.add(complaint_);
        return true;
    }

    public boolean removeComplaint(int referenceNumber){
        if(this.getComplaint(referenceNumber) instanceof Complaint){
            for(int i = 0; i< this.Flights.size(); i++ ){
                if(this.complaints.get(i).getReferenceNumber() == referenceNumber){
                    this.complaints.remove(this.complaints.get(i));
                    return true;
                }
            }
            
        }

        return false;
    }

    public Complaint getComplaint(int referenceNumber){
        for(int i = 0; i< this.complaints.size(); i++ ){
            if(this.complaints.get(i).getReferenceNumber()==referenceNumber){
                return this.complaints.get(i);
            }
        }
        return null;
    }
        
    public List<Complaint> getAllComplaint(){
        return this.complaints;
    }

    //########################### TRAVEL INSURANCE ##########################
    private  List<String> Country= new ArrayList<String>();
    public boolean addTravelInsurance(TravelInsurance travel ){
        if(this.getTravelInsurance(travel.getReferenceNumber()) instanceof TravelInsurance){
            return false;
        }

        this.travelInsurance.add(travel);
        return true;
    }

    public boolean removeTravelInsurance(int referenceNumber){
        if(this.getTravelInsurance(referenceNumber) instanceof TravelInsurance){
            for(int i = 0; i< this.travelInsurance.size(); i++ ){
                if(this.travelInsurance.get(i).getReferenceNumber() == referenceNumber){
                    this.travelInsurance.remove(this.travelInsurance.get(i));
                    return true;
                }
            }
            
        }

        return false;
    }

    public TravelInsurance getTravelInsurance(int referenceNumber){
        for(int i = 0; i< this.travelInsurance.size(); i++ ){
            if(this.travelInsurance.get(i).getReferenceNumber()==referenceNumber){
                return this.travelInsurance.get(i);
            }
        }
        return null;
    }
        
    public List<TravelInsurance> getAllTravelInsurance(){
        return this.travelInsurance;
    }
    

//########################### Card##########################
    public boolean addCard(Card card){
        if(this.getCard(card.getOwnersName()) instanceof Card){
            return false;
        }

        this.cards.add(card);
        return true;
    }
    
    public Card getCard(String name){
        for(int i = 0; i< this.cards.size(); i++ ){
            if(this.cards.get(i).getOwnersName().compareTo(name)==0){
                return this.cards.get(i);
            }
        }
        return null;
    }
    public boolean getCardB(String name){
        for(int i = 0; i< this.cards.size(); i++ ){
            if(this.cards.get(i).getOwnersName().compareTo(name)==0){
                return true;
            }
        }
        return false;
    }

}