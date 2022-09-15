package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RemoveFlightGUI extends JDialog{

    private JButton cancel;
    private JButton removeFlight;
    private JComboBox myFlight;
    private JTextArea details;



    public RemoveFlightGUI (JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("Admin - Remove Flight");
        myFlight = new JComboBox();
        AddItemFlight(system, DNI);
        details = new JTextArea();
        details.setEditable(false);
        Container panel= getContentPane();
        panel.setLayout(new FlowLayout());

        JPanel LabelPan1 = new JPanel();
        LabelPan1.setLayout(new BoxLayout(LabelPan1, BoxLayout.X_AXIS));
     
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

        removeFlight= new JButton("Remove Flight");
        removeFlight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                removeFlight(system, DNI);
                myFlight.removeAllItems();
                AddItemFlight(system, DNI);
            }
        });

        LabelPan1.add(new JLabel("Flights in the system:  "));
        LabelPan1.add(myFlight);
        Text.add(LabelPan1);
        BUTTONS.add(cancel);
        BUTTONS.add(removeFlight);

        allPanel.add(Text);
        allPanel.add(details);
        allPanel.add(BUTTONS);
        panel.add(allPanel); 
        setContentPane(panel);
        setLocation(350,250);
        panel.setPreferredSize( new Dimension(400, 150));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }

    public void removeFlight(AeroSpyne system, String DNI){
        system.removeFlight(
            system.getAllflights().get(myFlight.getSelectedIndex()).getReferenceNumber()
        );
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

