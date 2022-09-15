package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFlightGUI extends JDialog{

    
    private JTextField origin;
    private JTextField destination;
    private JTextField departureDate;
    private JTextField arrivalDate;
    private JTextField duration;
    private JTextField price;
    private JTextField referenceNumber;
    private JButton addFlight;
    private JButton cancel; 

    public AddFlightGUI(JFrame frame,  AeroSpyne system){
        super(frame, true);
        this.setTitle("Admin - Add FLight");

        origin = new JTextField(10);
        destination = new JTextField(12);
        departureDate = new JTextField(26);
        arrivalDate = new JTextField(26);
        duration = new JTextField(10);
        price = new JTextField(12);
        referenceNumber = new JTextField(12);
        departureDate.setText("dd/mm/yyyy - hh:mm");
        arrivalDate.setText("dd/mm/yyyy - hh:mm");

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

        addFlight = new JButton("Add Flight");
        addFlight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Date start_f =  new Date(Integer.parseInt(departureDate.getText().substring(0, 2)),Integer.parseInt(departureDate.getText().substring(3, 5)), Integer.parseInt(departureDate.getText().substring(6, 10)), Integer.parseInt(departureDate.getText().substring(13, 15)), Integer.parseInt(departureDate.getText().substring(16, 18)));
                Date end_f =   new Date(Integer.parseInt(arrivalDate.getText().substring(0, 2)),Integer.parseInt(arrivalDate.getText().substring(3, 5)), Integer.parseInt(arrivalDate.getText().substring(6, 10)), Integer.parseInt(arrivalDate.getText().substring(13, 15)), Integer.parseInt(arrivalDate.getText().substring(16, 18)));
                System.out.println(arrivalDate.getText().substring(0, 1));
                Flight flight = new Flight(origin.getText(), destination.getText(), start_f, end_f, Integer.parseInt(duration.getText()),Float.parseFloat(price.getText()),Integer.parseInt(referenceNumber.getText()));
                system.addFlight(flight);
                setVisible(false);
                dispose();
            }
        });

        cancel= new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                dispose();
            }
        });

        buttonPanel.add(addFlight);
        buttonPanel.add(Box.createRigidArea(new Dimension(15, 0)));
        buttonPanel.add(cancel);

        LabelPan1.add(new JLabel("Origin: "));LabelPan1.add(origin);
        LabelPan2.add(new JLabel("Destination: "));LabelPan2.add(destination);
        LabelPan3.add(new JLabel("Departure Date: "));LabelPan3.add(departureDate);
        LabelPan4.add(new JLabel("Arrival Date:"));LabelPan4.add(arrivalDate);
        LabelPan5.add(new JLabel("Duration: "));LabelPan5.add(duration);
        LabelPan6.add(new JLabel("Price: "));LabelPan6.add(price);
        LabelPan7.add(new JLabel("Reference Number: "));LabelPan7.add(referenceNumber);

        Text.add(LabelPan1);
        Text.add(LabelPan2);
        Text.add(LabelPan3);
        Text.add(LabelPan4);
        Text.add(LabelPan5);
        Text.add(LabelPan6);
        Text.add(LabelPan7);

        All.add(Text);
        All.add(buttonPanel);

        panel.add(All, BorderLayout.PAGE_START);
        
        setContentPane(panel);
        setLocation(550,250);
        setSize(350,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }

}
