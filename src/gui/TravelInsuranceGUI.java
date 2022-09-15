package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class TravelInsuranceGUI extends JDialog{

    private JButton Continue;
    private JComboBox travelInsuranceCom;
    private JComboBox passenger;
    private JTextField start;
    private JTextField end;
    private JComboBox startCountry;
    private JComboBox endCountry;
    private JLabel price;
    private TravelInsurance travel;
    private int number2 = (int)(Math.random()*10000+1);

    public TravelInsuranceGUI(JFrame frame, AeroSpyne system, String DNI, int number, int seats, Flight flight, String priceT){
        super(frame, true);
        this.setTitle("Hire Travel Insurance");

        start = new JTextField();
        end = new JTextField();
        startCountry = new JComboBox();
        endCountry =  new JComboBox();
        start.setText(flight.getDepartureDate().toString());
        start.setEditable(false);
        end.setEditable(false);
        startCountry.setEditable(false);
        endCountry.setEditable(false);
        end.setText(flight.getArrivalDate().toString());
        passenger = new JComboBox();
        price = new JLabel("0.0€");
        price.setText(priceT);
        travelInsuranceCom = new JComboBox();
        AddItemTravelInsurance(system);
        AddItemTravelInsuranceCountry(system);
        AddItemPrice();
        setCountry(flight);
        passenger.setSelectedIndex(seats);
        Container panel= getContentPane();
        panel.setLayout(new FlowLayout());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JPanel LabelPan1 = new JPanel();
        LabelPan1.setLayout(new BoxLayout(LabelPan1, BoxLayout.Y_AXIS));
        JPanel LabelPan2 = new JPanel();
        LabelPan2.setLayout(new BoxLayout(LabelPan2, BoxLayout.Y_AXIS));
        JPanel LabelPan3 = new JPanel();
        LabelPan3.setLayout(new BoxLayout(LabelPan3, BoxLayout.Y_AXIS));
        JPanel LabelPan4 = new JPanel();
        LabelPan4.setLayout(new BoxLayout(LabelPan4, BoxLayout.Y_AXIS));       

        JPanel LabelPan5 = new JPanel();
        LabelPan5.setLayout(new BoxLayout(LabelPan5, BoxLayout.Y_AXIS));
        JPanel LabelPan6 = new JPanel();
        LabelPan6.setLayout(new BoxLayout(LabelPan6, BoxLayout.Y_AXIS));     
        JPanel LabelPan7 = new JPanel();
        LabelPan7.setLayout(new BoxLayout(LabelPan7, BoxLayout.X_AXIS));    
        JPanel LabelPan8 = new JPanel();
        LabelPan8.setLayout(new BoxLayout(LabelPan8, BoxLayout.X_AXIS));    

        JPanel LabelPanX= new JPanel();
        LabelPanX.setLayout(new BoxLayout(LabelPanX, BoxLayout.X_AXIS));
        JPanel LabelPanX2= new JPanel();
        LabelPanX2.setLayout(new BoxLayout(LabelPanX2, BoxLayout.X_AXIS));
        JPanel LabelPanX3= new JPanel();
        LabelPanX3.setLayout(new BoxLayout(LabelPanX3, BoxLayout.X_AXIS));

        JPanel Text = new JPanel();
        Text.setLayout(new BoxLayout(Text, BoxLayout.Y_AXIS));

        JPanel All = new JPanel();
        All.setLayout(new BoxLayout(All, BoxLayout.Y_AXIS));

        Continue = new JButton("Continue");
        Continue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(passenger.getSelectedIndex()!=0){
                    //Date start_f =  new Date(Integer.parseInt(start.getText().substring(0, 2)),Integer.parseInt(start.getText().substring(3, 5)), Integer.parseInt(start.getText().substring(6, 10)), Integer.parseInt(start.getText().substring(14, 16)), Integer.parseInt(start.getText().substring(17, 19)));
                    //Date end_f =   new Date(Integer.parseInt(end.getText().substring(0, 2)),Integer.parseInt(end.getText().substring(3, 5)), Integer.parseInt(end.getText().substring(6, 10)), Integer.parseInt(end.getText().substring(14, 16)), Integer.parseInt(end.getText().substring(17, 19)));
                    TravelInsurance travel = new TravelInsurance(system.getAllTravelInsurance().get(travelInsuranceCom.getSelectedIndex()).getName() ,system.getAllCountry().get(startCountry.getSelectedIndex()), system.getAllCountry().get(endCountry.getSelectedIndex()), flight.getDepartureDate(), flight.getArrivalDate(), passenger.getSelectedIndex(), system.getAllTravelInsurance().get(travelInsuranceCom.getSelectedIndex()).getCoverage(), number2, DNI, number);
                    system.addTravelInsurance(travel);
                    AddTravelInsurance(travel);
                    setVisible(false);
                    dispose();
                }
            }
        });

        passenger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                price.setText(getTotalprice(system));
            }
        });
        
        buttonPanel.add(Continue);
        LabelPan1.add(new JLabel("Product"));
        LabelPan1.add(travelInsuranceCom);

        LabelPan2.add(new JLabel("Start Of Coverage"));
        LabelPan2.add(start);
        LabelPan3.add(new JLabel("End of coverage"));
        LabelPan3.add(end);

        LabelPan4.add(new JLabel("Country Of Origin"));
        LabelPan4.add(startCountry);
        LabelPan5.add(new JLabel("Country Of Destination"));
        LabelPan5.add(endCountry);

        LabelPan6.add(new JLabel("Number Passenger "));LabelPan6.add(passenger);
        LabelPan7.add(new JLabel("Total Price: "));LabelPan7.add(price);
        LabelPan8.add(new JLabel("   Reference Number: "+number2));

        LabelPanX.add(LabelPan2);
        LabelPanX.add(LabelPan3);
        LabelPanX2.add(LabelPan4);
        LabelPanX2.add(LabelPan5);
        LabelPanX3.add(LabelPan7);
        LabelPanX3.add(LabelPan8);

        Text.add(LabelPan1);
        Text.add(LabelPanX);
        Text.add(LabelPanX2);
        Text.add(LabelPan6);
        Text.add(LabelPanX3);
        All.add(Text);
        All.add(buttonPanel);

        panel.add(All);
        setContentPane(panel);
        setLocation(550,250);
        panel.setPreferredSize( new Dimension(400, 225));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }

    public String getTotalprice(AeroSpyne system){
        return String.valueOf(system.getAllflights().get(travelInsuranceCom.getSelectedIndex()).getPrice()*passenger.getSelectedIndex());
    }

    public void AddItemPrice(){
        passenger.addItem("-SELECT NUM PASSENGER");
        for(int i=1;i<10;i++){
            passenger.addItem(i);
        }
        
    }
    public TravelInsurance getTravelInsurance(){
        return travel;
    }
    public void  AddTravelInsurance(TravelInsurance travelType){
        this.travel = travelType;
    }
    public  void AddItemTravelInsuranceCountry(AeroSpyne system){
        for(int i=0;i<system.getAllCountry().size();i++){
            startCountry.addItem(system.getAllCountry().get(i));
            endCountry.addItem(system.getAllCountry().get(i));
        }
    }

    public  void AddItemTravelInsurance(AeroSpyne system){
        for(int i=0;i<system.getAllTravelInsurance().size();i++){
            if(system.getAllTravelInsurance().get(i).getDNI().compareTo("Admin")==0){
                travelInsuranceCom.addItem(system.getAllTravelInsurance().get(i).getName());
            }
        }
    }
    
    public void setCountry(Flight flight){
        
        for(int i = 0;i<startCountry.getItemCount() ;i++){
            if(startCountry.getItemAt(i).toString().compareTo(flight.getOrigin())==0){
               startCountry.setSelectedIndex(i);
               break;
            }
        }
        
        for(int i = 0;i<endCountry.getItemCount() ;i++){
            if(endCountry.getItemAt(i).toString().compareTo(flight.getDestination())==0){
               endCountry.setSelectedIndex(i);
               break;
            }
        }
    }
} 

