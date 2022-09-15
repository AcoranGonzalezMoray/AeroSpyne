package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SearchFlightGUI extends JDialog{

    private JButton cancel;
    private JButton showDetails;
    private JComboBox myFlight;
    private JTextArea details;



    public SearchFlightGUI (JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("Admin - Search Flight");
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

        showDetails= new JButton("Show Details");
        showDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                showDetail(system, DNI);
            }
        });

        LabelPan1.add(new JLabel("Flight in the system:  "));
        LabelPan1.add(myFlight);
        Text.add(LabelPan1);
        BUTTONS.add(cancel);
        BUTTONS.add(showDetails);

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

    public void showDetail(AeroSpyne system, String DNI){
        if(!system.getAllflights().isEmpty()){
            details.setText(system.getAllflights().get(myFlight.getSelectedIndex()).toString());
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

