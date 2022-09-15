package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ReservationUpdateGUI extends JDialog{

    private JButton accept;
    private JComboBox flightCom;
    private JComboBox seats;
    private JLabel price;
    private JLabel priceMult;
    private int number = (int)(Math.random()*10000+1);

    public ReservationUpdateGUI(JDialog frame, AeroSpyne system, String DNI, int referenceN, TravelInsurance insurance){
        super(frame, true);
        this.setTitle("Reservation Update");
        seats = new JComboBox();
        price = new JLabel("0.0€");
        priceMult =  new JLabel("0.0€");
        flightCom = new JComboBox();
        AddItemFlight(system);
        AddItemPrice();
        
        Container panel= getContentPane();
        panel.setLayout(new FlowLayout());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JPanel LabelPan1 = new JPanel();
        LabelPan1.setLayout(new BoxLayout(LabelPan1, BoxLayout.X_AXIS));
        JPanel LabelPan2 = new JPanel();
        LabelPan2.setLayout(new BoxLayout(LabelPan2, BoxLayout.X_AXIS));
        JPanel LabelPan3 = new JPanel();
        LabelPan3.setLayout(new BoxLayout(LabelPan3, BoxLayout.X_AXIS));
        JPanel LabelPan4 = new JPanel();
        LabelPan4.setLayout(new BoxLayout(LabelPan4, BoxLayout.X_AXIS));    
        JPanel LabelPan5 = new JPanel();
        LabelPan5.setLayout(new BoxLayout(LabelPan5, BoxLayout.X_AXIS));     
        JPanel Text = new JPanel();
        Text.setLayout(new BoxLayout(Text, BoxLayout.Y_AXIS));

        JPanel All = new JPanel();
        All.setLayout(new BoxLayout(All, BoxLayout.Y_AXIS));

        accept = new JButton("Update Your Reservation");
        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(seats.getSelectedIndex()!=0){
                    system.removeReservation(referenceN);
                    if(insurance!=null){
                        insurance.setOrigin(system.getAllflights().get(flightCom.getSelectedIndex()).getOrigin());
                        insurance.setDestination(system.getAllflights().get(flightCom.getSelectedIndex()).getDestination());
                        insurance.setArrivalDate(system.getAllflights().get(flightCom.getSelectedIndex()).getArrivalDate());
                        insurance.setDepartureDate(system.getAllflights().get(flightCom.getSelectedIndex()).getDepartureDate());
                        insurance.setReferenceNumberReservation(number);
                        Reservation reservation = new Reservation(seats.getSelectedIndex(), number , system.getAllflights().get(flightCom.getSelectedIndex()), DNI, insurance);
                        system.addReservation(reservation);
                    }else{
                        Reservation reservation = new Reservation(seats.getSelectedIndex(), number , system.getAllflights().get(flightCom.getSelectedIndex()), DNI);
                        system.addReservation(reservation);
                    }
                    
                    setVisible(false);
                    dispose();
                }
            }
        });

        seats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                priceMult.setText(getTotalPriceMult(system).substring(0, 4));
                price.setText(getTotalprice(system,Float.parseFloat(getTotalPriceMult(system).substring(0, 4))));
            }
        });
        
        buttonPanel.add(accept);
        LabelPan1.add(new JLabel("Flight: "));
        LabelPan1.add(flightCom);
        LabelPan2.add(new JLabel("Number Seats: "));LabelPan2.add(seats);
        LabelPan3.add(new JLabel("Reference Number: "+number));
        LabelPan5.add(new JLabel("Exchange management expenses: "));LabelPan5.add(priceMult);
        LabelPan4.add(new JLabel("Total Price: "));LabelPan4.add(price);
        Text.add(LabelPan1);
        Text.add(LabelPan2);
        Text.add(LabelPan5);
        Text.add(LabelPan4);
        Text.add(LabelPan3);
        All.add(Text);
        All.add(buttonPanel);

        panel.add(All);
        setContentPane(panel);
        setLocation(550,250);
        panel.setPreferredSize( new Dimension(400, 155));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }

    public String getTotalprice(AeroSpyne system, float mult){
        return String.valueOf((system.getAllflights().get(flightCom.getSelectedIndex()).getPrice()*seats.getSelectedIndex())+mult);
    }

    public String getTotalPriceMult(AeroSpyne system){
        return String.valueOf((system.getAllflights().get(flightCom.getSelectedIndex()).getPrice()*seats.getSelectedIndex())*0.4);
    }
    public void AddItemPrice(){
        seats.addItem("-SELECT NUM SEATS");
        for(int i=1;i<6;i++){
            seats.addItem(i);
        }
        
    }

    public  void AddItemFlight(AeroSpyne system){
        for(int i=0;i<system.getAllflights().size();i++){
            flightCom.addItem(system.getAllflights().get(i).getOrigin()+"-"+system.getAllflights().get(i).getDestination()+"  Price: "+system.getAllflights().get(i).getPrice()+"€");
        }
    }
}

