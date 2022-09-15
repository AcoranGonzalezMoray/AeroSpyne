package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ReservationDetailsGUI extends JDialog{

    private JButton accept;

    public ReservationDetailsGUI(JFrame frame, AeroSpyne system, Flight flight, Reservation reservation){
        super(frame, true);
        this.setTitle("Reservation Information");

        Container panel= getContentPane();
        panel.setLayout(new FlowLayout());
        
        

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JPanel LabelPan = new JPanel();
        LabelPan.setLayout(new BoxLayout(LabelPan, BoxLayout.X_AXIS));
        JPanel LabelPan1 = new JPanel();
        LabelPan1.setLayout(new BoxLayout(LabelPan1, BoxLayout.X_AXIS));
        JPanel LabelPan2 = new JPanel();
        LabelPan2.setLayout(new BoxLayout(LabelPan2, BoxLayout.X_AXIS));
        JPanel LabelPan3 = new JPanel();
        LabelPan3.setLayout(new BoxLayout(LabelPan3, BoxLayout.X_AXIS));
        JPanel LabelPan4 = new JPanel();
        LabelPan4.setLayout(new BoxLayout(LabelPan4, BoxLayout.X_AXIS));

        JPanel Text = new JPanel();
        Text.setLayout(new BoxLayout(Text, BoxLayout.Y_AXIS));

        JPanel All = new JPanel();
        All.setLayout(new BoxLayout(All, BoxLayout.Y_AXIS));

        accept = new JButton("Accept");
        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                dispose();
            }
        });


        buttonPanel.add(accept);
        LabelPan1.add(new JLabel("Origin: "+flight.getOrigin()));
        LabelPan1.add(new JLabel("  Destination: "+flight.getDestination()));
        LabelPan2.add(new JLabel("DepartureDate: "+flight.getDepartureDate()));
        LabelPan2.add(new JLabel("  ArrivalDate: "+flight.getArrivalDate()));
        LabelPan3.add(new JLabel("Duration: "+flight.getDuration()+" minutes"));
        LabelPan3.add(new JLabel("  Flight Number: "+flight.getReferenceNumber()));
        LabelPan.add(new JLabel("  Reservation Number: "+reservation.getReferenceNumber()));
        LabelPan.add(new JLabel("  Seats: "+reservation.getNumberSeats()));
        LabelPan3.add(new JLabel("  TotalPrice: "+reservation.getTotalPrice()+"€"));
        LabelPan4.add(new JLabel("  Travel Insurance: "+ Insurance(reservation)));

        Text.add(LabelPan);
        Text.add(LabelPan1);
        Text.add(LabelPan2);
        Text.add(LabelPan4);
        Text.add(LabelPan3);
        All.add(Text);
        All.add(buttonPanel);

        panel.add(All);
        setContentPane(panel);
        setLocation(550,250);
        panel.setPreferredSize( new Dimension(400, 125));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }
    public String Insurance(Reservation reservation){
        if(reservation.getInsurance()!=null){
            return reservation.getInsurance().getName()+"   more information in the tab 'My Travel Insurance' ";
        }else{
            return"No";
        }
    }
}
