package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RemoveComplaintGUI extends JDialog{

    private JButton cancel;
    private JButton removeComplaint;
    private JComboBox myComplaint;
    private JTextArea details;



    public RemoveComplaintGUI (JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("Admin - Remove Complaint");
        myComplaint = new JComboBox();
        AddItemComplaint(system, DNI);
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

        removeComplaint= new JButton("Remove Complaint");
        removeComplaint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                removeComplaint(system, DNI);
                myComplaint.removeAllItems();
                AddItemComplaint(system, DNI);
            }
        });

        LabelPan1.add(new JLabel("Complaints in the system:  "));
        LabelPan1.add(myComplaint);
        Text.add(LabelPan1);
        BUTTONS.add(cancel);
        BUTTONS.add(removeComplaint);

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

    public void removeComplaint(AeroSpyne system, String DNI){
        system.removeFlight(
            system.getAllComplaint().get(myComplaint.getSelectedIndex()).getReferenceNumber()
        );
    }

    public  void AddItemComplaint(AeroSpyne system, String DNI){
        if(system.getAllComplaint().isEmpty()){
            myComplaint.addItem("You have not made a complaint yet");
        }else{
            myComplaint.removeAll();
        
        }
        for(int i=0;i<system.getAllComplaint().size();i++){
            myComplaint.addItem(system.getAllComplaint().get(i).getTitle());
        }
        
    }
}

