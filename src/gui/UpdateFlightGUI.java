package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFlightGUI extends JDialog{

    private JButton cancel;
    private JButton updateUser;
    private JComboBox myFlight;
    private JTextField origin;
    private JTextField destination;
    private JTextField departureDate;
    private JTextField arrivalDate;
    private JTextField duration;
    private JTextField price;
    private JTextField referenceNumber;


    public UpdateFlightGUI(JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("Admin - Update User");

        origin = new JTextField(10);
        destination = new JTextField(12);
        departureDate = new JTextField(10);
        arrivalDate = new JTextField(12);
        duration = new JTextField(10);
        price = new JTextField(12);
        referenceNumber = new JTextField(12);
        departureDate.setText("dd/mm/yyyy");
        arrivalDate.setText("dd/mm/yyyy");

        myFlight = new JComboBox();
        AddItemFlight(system, DNI);
        showFlight(system, DNI);
        Container panel= getContentPane();
        panel.setLayout(new FlowLayout());

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

        JPanel LabelPan5 = new JPanel();
        LabelPan5.setLayout(new BoxLayout(LabelPan5, BoxLayout.X_AXIS));

        JPanel LabelPan6 = new JPanel();
        LabelPan6.setLayout(new BoxLayout(LabelPan6, BoxLayout.X_AXIS));

        JPanel LabelPan7 = new JPanel();
        LabelPan7.setLayout(new BoxLayout(LabelPan7, BoxLayout.X_AXIS));

        JPanel Text = new JPanel();
        Text.setLayout(new BoxLayout(Text, BoxLayout.Y_AXIS));

        JPanel BUTTONS = new JPanel();
        BUTTONS.setLayout(new BoxLayout(BUTTONS, BoxLayout.X_AXIS));

        JPanel allPanel = new JPanel();
        allPanel.setLayout(new BoxLayout(allPanel, BoxLayout.Y_AXIS));

        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                dispose();
            }
        });

        updateUser= new JButton("Update User");
        updateUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                system.removeFlight(system.getAllflights().get(myFlight.getSelectedIndex()).getReferenceNumber());

                Date start_f =  new Date(Integer.parseInt(departureDate.getText().substring(0, 2)),Integer.parseInt(departureDate.getText().substring(3, 5)), Integer.parseInt(departureDate.getText().substring(6, 10)), Integer.parseInt(departureDate.getText().substring(14, 16)), Integer.parseInt(departureDate.getText().substring(17, 19)));
                Date end_f =   new Date(Integer.parseInt(arrivalDate.getText().substring(0, 2)),Integer.parseInt(arrivalDate.getText().substring(3, 5)), Integer.parseInt(arrivalDate.getText().substring(6, 10)), Integer.parseInt(arrivalDate.getText().substring(14, 16)), Integer.parseInt(arrivalDate.getText().substring(17, 19)));
                Flight flight = new Flight(origin.getText(), destination.getText(), start_f, end_f, Integer.parseInt(duration.getText()),Float.parseFloat(price.getText()),Integer.parseInt(referenceNumber.getText()));
                system.addFlight(flight);

                setVisible(false);
                dispose();
            }
        });

        myFlight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                showFlight(system, DNI);
            }
        });

        LabelPan.add(new JLabel("Users in the system:  "));
        LabelPan.add(myFlight);


        LabelPan1.add(new JLabel("Origin: "));LabelPan1.add(origin);
        LabelPan2.add(new JLabel("Destination: "));LabelPan2.add(destination);
        LabelPan3.add(new JLabel("Departure Date: "));LabelPan3.add(departureDate);
        LabelPan4.add(new JLabel("Arrival Date:"));LabelPan4.add(arrivalDate);
        LabelPan5.add(new JLabel("Duration: "));LabelPan5.add(duration);
        LabelPan6.add(new JLabel("Price: "));LabelPan6.add(price);
        LabelPan7.add(new JLabel("Reference Number: "));LabelPan7.add(referenceNumber);

        Text.add(LabelPan);
        Text.add(LabelPan1);
        Text.add(LabelPan2);
        Text.add(LabelPan3);
        Text.add(LabelPan4);
        Text.add(LabelPan5);
        Text.add(LabelPan6);
        Text.add(LabelPan7);
        BUTTONS.add(cancel);
        BUTTONS.add(updateUser);

        allPanel.add(Text);
        allPanel.add(BUTTONS);
        panel.add(allPanel);
        setContentPane(panel);
        setLocation(350,250);
        panel.setPreferredSize( new Dimension(460, 300));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }

    public void showFlight(AeroSpyne system, String DNI){
        if(!system.getAllflights().isEmpty()){
            origin.setText(system.getAllflights().get(myFlight.getSelectedIndex()).getOrigin());
            destination.setText(system.getAllflights().get(myFlight.getSelectedIndex()).getDestination());
            departureDate.setText(system.getAllflights().get(myFlight.getSelectedIndex()).getDepartureDate().toString());
            arrivalDate.setText(system.getAllflights().get(myFlight.getSelectedIndex()).getArrivalDate().toString());
            duration.setText(String.valueOf(system.getAllflights().get(myFlight.getSelectedIndex()).getDuration()));
            price.setText(String.valueOf(system.getAllflights().get(myFlight.getSelectedIndex()).getprice()));
            referenceNumber.setText(String.valueOf(system.getAllflights().get(myFlight.getSelectedIndex()).getReferenceNumber()));
        }
    }

    public  void AddItemFlight(AeroSpyne system, String DNI){
        if(system.getAllflights().isEmpty()){
            myFlight.addItem("You have not made a complaint yet");
        }else{
            myFlight.removeAll();
        
        }
        for(int i=0;i<system.getAllflights().size();i++){
            myFlight.addItem(system.getAllflights().get(i).getFlight());
        }
        
    }
}

