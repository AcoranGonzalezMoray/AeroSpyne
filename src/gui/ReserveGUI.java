package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ReserveGUI extends JDialog{

    private JButton accept;
    private JComboBox flightCom;
    private JLabel A;
    private JLabel B;   
    private JCheckBox check1;
    private JComboBox seats;
    private JLabel price;
    private int number = (int)(Math.random()*10000+1);
    private TravelInsurance travel;
    private boolean check=false;

    public ReserveGUI(JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("Reserve");
        check1=new JCheckBox("Add travel insurance");
        seats = new JComboBox();
        price = new JLabel("0.0€");
        A=new JLabel("");
        B=new JLabel("");
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
        JPanel LabelPan6 = new JPanel();
        LabelPan6.setLayout(new BoxLayout(LabelPan6, BoxLayout.X_AXIS));
        JPanel LabelPan7 = new JPanel();
        LabelPan7.setLayout(new BoxLayout(LabelPan7, BoxLayout.X_AXIS));
        JPanel Text = new JPanel();
        Text.setLayout(new BoxLayout(Text, BoxLayout.Y_AXIS));

        JPanel All = new JPanel();
        All.setLayout(new BoxLayout(All, BoxLayout.Y_AXIS));
        check1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (check1.isSelected()==true) {
                    TravelInsuranceGUI dialogo = new TravelInsuranceGUI(frame,system, DNI, number, seats.getSelectedIndex(), system.getAllflights().get(flightCom.getSelectedIndex()), price.getText());
                    dialogo.setVisible(true);
                    travel = dialogo.getTravelInsurance();
                    check=true;
                }else{
                    check=false;
                }
            }
        });
        accept = new JButton("Reserve");
        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(seats.getSelectedIndex()!=0){
                    PaymentGUI payment = new PaymentGUI(frame,system,seats.getSelectedIndex(), number , system.getAllflights().get(flightCom.getSelectedIndex()), DNI, travel, check, price.getText());
                    payment.setVisible(true);
                    setVisible(false);
                    dispose();
                }
            }
        });

        seats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                price.setText(getTotalprice(system));
            }
        });
        flightCom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                A.setText(system.getAllflights().get(flightCom.getSelectedIndex()).getArrivalDate().toString());
                B.setText(system.getAllflights().get(flightCom.getSelectedIndex()).getDepartureDate().toString());
            }
        });
        buttonPanel.add(accept);
        LabelPan1.add(new JLabel("Flight: "));
        LabelPan1.add(flightCom);
        LabelPan6.add(new JLabel("Departure Date: "));LabelPan6.add(B);
        LabelPan7.add(new JLabel("Arrival Date: "));LabelPan7.add(A);
        LabelPan2.add(new JLabel("Number Seats: "));LabelPan2.add(seats);
        LabelPan3.add(new JLabel("Reference Number: "+number));
        LabelPan4.add(new JLabel("Total Price: "));LabelPan4.add(price);
        LabelPan5.add(check1);
        Text.add(LabelPan1);
        Text.add(LabelPan6);
        Text.add(LabelPan7);
        Text.add(LabelPan2);
        Text.add(LabelPan4);
        Text.add(LabelPan3);
        All.add(Text);
        All.add(LabelPan5);
        All.add(buttonPanel);

        panel.add(All);
        setContentPane(panel);
        setLocation(450,250);
        panel.setPreferredSize( new Dimension(400, 200));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }

    public String getTotalprice(AeroSpyne system){
        return String.valueOf(system.getAllflights().get(flightCom.getSelectedIndex()).getPrice()*seats.getSelectedIndex());
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
        A.setText(system.getAllflights().get(flightCom.getSelectedIndex()).getArrivalDate().toString());
        B.setText(system.getAllflights().get(flightCom.getSelectedIndex()).getDepartureDate().toString());
    }
}

