package file;
import model.AeroSpyne;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import model.Card;
import model.Client;
import model.Complaint;
import model.Date;
import model.Flight;
import model.Reservation;
import model.TravelInsurance;

public class AeroSpyneFile {
    String name = "AeroSpyne.text";
    
    public void saveToFile(AeroSpyne system){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(name);
            pw = new PrintWriter(fichero);
            voidfile();
            pw.write("\n"+system.clients.size()+" , ");
            for (int i = 0; i < system.clients.size(); i++){
                pw.write(system.clients.get(i).getName()+" , "+system.clients.get(i).getSurname()+" , "+system.clients.get(i).getEmail()+" , "+system.clients.get(i).getPassword()+" , "+system.clients.get(i).getClientDNI()+" , "+system.clients.get(i).getTelephone()+" , ");
            }

            pw.write("\n"+system.Flights.size()+" , ");
            for (int i = 0; i < system.Flights.size(); i++){
                pw.write(system.Flights.get(i).getOrigin()+" , "+system.Flights.get(i).getDestination()+" , "+system.Flights.get(i).getDepartureDate().getDay()+" , "+system.Flights.get(i).getDepartureDate().getMonth()+" , "+system.Flights.get(i).getDepartureDate().getYear()+" , "+system.Flights.get(i).getDepartureDate().getHour()+" , "+system.Flights.get(i).getDepartureDate().getMinutes()+" , "+system.Flights.get(i).getArrivalDate().getDay()+" , "+system.Flights.get(i).getArrivalDate().getMonth()+" , "+system.Flights.get(i).getArrivalDate().getYear()+" , "+system.Flights.get(i).getArrivalDate().getHour()+" , "+system.Flights.get(i).getArrivalDate().getMinutes()+" , "+system.Flights.get(i).getDuration()+" , "+system.Flights.get(i).getPrice()+" , "+system.Flights.get(i).getReferenceNumber()+" , ");
            }        

            pw.write("\n"+system.complaints.size()+" , ");
            for (int i = 0; i < system.complaints.size(); i++){
                pw.write(system.complaints.get(i).getTitle()+" , "+system.complaints.get(i).getDescription()+" , "+system.complaints.get(i).getDate().getDay()+" , "+system.complaints.get(i).getDate().getMonth()+" , "+system.complaints.get(i).getDate().getYear()+" , "+system.complaints.get(i).getDate().getHour()+" , "+system.complaints.get(i).getDate().getMinutes()+" , "+system.complaints.get(i).getClientDNI()+" , "+system.complaints.get(i).getReferenceNumber()+" , ");
            }

            pw.write("\n"+system.travelInsurance.size()+" , ");
            for (int i = 0; i < system.travelInsurance.size(); i++){
                if(system.travelInsurance.get(i).getReferenceNumberReservation()!=0){
                    pw.write(1+" , "+system.travelInsurance.get(i).getName()+" , "+system.travelInsurance.get(i).getOrigin()+" , "+system.travelInsurance.get(i).getDestination()+" , "+system.travelInsurance.get(i).getDepartureDate().getDay()+" , "+system.travelInsurance.get(i).getDepartureDate().getMonth()+" , "+system.travelInsurance.get(i).getDepartureDate().getYear()+" , "+system.travelInsurance.get(i).getDepartureDate().getHour()+" , "+system.travelInsurance.get(i).getDepartureDate().getMinutes()+" , "+system.travelInsurance.get(i).getArrivalDate().getDay()+" , "+system.travelInsurance.get(i).getArrivalDate().getMonth()+" , "+system.travelInsurance.get(i).getArrivalDate().getYear()+" , "+system.travelInsurance.get(i).getArrivalDate().getHour()+" , "+system.travelInsurance.get(i).getArrivalDate().getMinutes()+" , "+system.travelInsurance.get(i).getPassengers()+" , "+system.travelInsurance.get(i).getCoverage()+" , "+system.travelInsurance.get(i).getReferenceNumber()+" , "+system.travelInsurance.get(i).getDNI()+" , "+system.travelInsurance.get(i).getReferenceNumberReservation()+" , ");
            
                }else{
                    pw.write(0+" , "+system.travelInsurance.get(i).getName()+" , "+system.travelInsurance.get(i).getOrigin()+" , "+system.travelInsurance.get(i).getDestination()+" , "+system.travelInsurance.get(i).getDepartureDate().getDay()+" , "+system.travelInsurance.get(i).getDepartureDate().getMonth()+" , "+system.travelInsurance.get(i).getDepartureDate().getYear()+" , "+system.travelInsurance.get(i).getDepartureDate().getHour()+" , "+system.travelInsurance.get(i).getDepartureDate().getMinutes()+" , "+system.travelInsurance.get(i).getArrivalDate().getDay()+" , "+system.travelInsurance.get(i).getArrivalDate().getMonth()+" , "+system.travelInsurance.get(i).getArrivalDate().getYear()+" , "+system.travelInsurance.get(i).getArrivalDate().getHour()+" , "+system.travelInsurance.get(i).getArrivalDate().getMinutes()+" , "+system.travelInsurance.get(i).getPassengers()+" , "+system.travelInsurance.get(i).getCoverage()+" , "+system.travelInsurance.get(i).getReferenceNumber()+" , "+system.travelInsurance.get(i).getDNI()+" , ");
                }
            }    
            
            pw.write("\n"+system.reservations.size()+" , ");
            for (int i = 0; i < system.reservations.size(); i++){
                if(system.reservations.get(i).getInsurance()!=null){
                    pw.write(1+" , "+system.reservations.get(i).getReservationDate().getDay()+" , "+system.reservations.get(i).getReservationDate().getMonth()+" , "+system.reservations.get(i).getReservationDate().getYear()+" , "+system.reservations.get(i).getReservationDate().getHour()+" , "+system.reservations.get(i).getReservationDate().getMinutes()+" , "+system.reservations.get(i).getNumberSeats()+" , "+system.reservations.get(i).getReferenceNumber()+" , "+system.reservations.get(i).getFlight().getReferenceNumber()+" , "+system.reservations.get(i).getClientDNI()+" , "+system.reservations.get(i).getInsurance().getReferenceNumber()+" , ");
                }else{
                    pw.write(0+" , "+system.reservations.get(i).getReservationDate().getDay()+" , "+system.reservations.get(i).getReservationDate().getMonth()+" , "+system.reservations.get(i).getReservationDate().getYear()+" , "+system.reservations.get(i).getReservationDate().getHour()+" , "+system.reservations.get(i).getReservationDate().getMinutes()+" , "+system.reservations.get(i).getNumberSeats()+" , "+system.reservations.get(i).getReferenceNumber()+" , "+system.reservations.get(i).getFlight().getReferenceNumber()+" , "+system.reservations.get(i).getClientDNI()+" , ");
                }
            }
            pw.write("\n"+system.cards.size()+" , ");
            for (int i = 0; i < system.cards.size(); i++){
                pw.write(system.cards.get(i).getOwnersName()+" , "+system.cards.get(i).getExpirationDate().getDay()+" , "+system.cards.get(i).getExpirationDate().getMonth()+" , "+system.cards.get(i).getExpirationDate().getYear()+" , "+system.cards.get(i).getSecurityCode()+" , "+system.cards.get(i).getAccountNumber()+" , "+system.cards.get(i).getAmount()+" , ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }


    public void loadFromFile(AeroSpyne system){

        try{
            Scanner s=new Scanner(new File(name));
            
            //Usuario
            s.useDelimiter(" , ");
            int n = Integer.parseInt(s.next().trim());
            for(int i=0;i<n;i++){
                Client cliente = new Client(s.next().replace("\n", ""), s.next(), s.next(), s.next(), s.next(), s.next().replaceAll("\\n\\r", ""));
                system.addClient(cliente);
            }
            
            //Vuelos
            int c= Integer.parseInt(s.next().trim());
            for(int i=0;i<c;i++){
                Flight vuelo1 = new Flight(s.next().replace("\n", ""), s.next(),  new Date(Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim())) , new Date(Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim())), Integer.parseInt(s.next().trim()), Float.parseFloat(s.next().trim()), s.nextInt());
                system.addFlight(vuelo1);
            }
            
            
            //Reclamaciones
            int d= Integer.parseInt(s.next().trim());
            for(int i=0;i<d;i++){
                Complaint complaint = new Complaint(s.next().replace("\n", ""), s.next(), new Date(Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim())) ,s.next(), Integer.parseInt(s.next()));
                system.addComplaint(complaint);
            }
            
            //Seguro de Viaje
            int f=Integer.parseInt(s.next().trim());
            for(int i=0;i<f;i++){
                if(s.nextInt()==0){
                    TravelInsurance Totaltravelpack = new TravelInsurance(s.next(), s.next() ,s.next() ,new Date(Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()))  ,new Date(Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()))  , Integer.parseInt(s.next()), s.next().toString(),Integer.parseInt(s.next()) ,s.next());
                    system.addTravelInsurance(Totaltravelpack);
                }else{
                    TravelInsurance Totaltravelpack = new TravelInsurance(s.next(), s.next() ,s.next() ,new Date(Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()))  ,new Date(Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()))  , Integer.parseInt(s.next()), s.next().toString(),Integer.parseInt(s.next()) ,s.next(), Integer.parseInt(s.next()));
                    system.addTravelInsurance(Totaltravelpack);
                }
                
            }
            
            //Reservas
            int e= Integer.parseInt(s.next().trim());
            for(int i=0;i<e;i++){
                if(s.nextInt()==0){
                    Reservation reservation = new Reservation(new Date(Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim())), Integer.parseInt(s.next()), Integer.parseInt(s.next()), system.getFlight(Integer.parseInt(s.next())), s.next());
                    system.addReservation(reservation);
                }else{
                    Reservation reservation = new Reservation(new Date(Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim())), Integer.parseInt(s.next()), Integer.parseInt(s.next()), system.getFlight(Integer.parseInt(s.next())), s.next(), system.getTravelInsurance(Integer.parseInt(s.next())));
                    system.addReservation(reservation);
                }
            }
            
            //Tarjetas C/D
            int y= Integer.parseInt(s.next().trim());
            for(int i=0;i<y;i++){
                Card card = new Card(s.next().replace("\n", ""),new Date(Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim()), Integer.parseInt(s.next().trim())), Integer.parseInt(s.next()),s.next(), Float.parseFloat(s.next()));
                system.addCard(card);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void voidfile(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(name);
            pw = new PrintWriter(fichero);
            pw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}