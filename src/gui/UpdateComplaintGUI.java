package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateComplaintGUI extends JDialog{

    private JButton cancel;
    private JButton updateUser;
    private JComboBox myComplaint;
    private JTextField title;
    private JTextField description;
    private JTextField date;
    private JTextField referenceNumber;
    private JTextField clientDNI;


    public UpdateComplaintGUI (JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("Admin - Update Complaint");
        title = new JTextField(10);
        description = new JTextField(12);
        date = new JTextField(10);
        referenceNumber = new JTextField(12);
        clientDNI = new JTextField(10);
        myComplaint = new JComboBox();
        AddItemComplaint(system, DNI);
        showUser(system, DNI);
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

        updateUser= new JButton("Update Complaint");
        updateUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                system.removeComplaint(system.getAllComplaint().get(myComplaint.getSelectedIndex()).getReferenceNumber());
                Date date_ = new Date(Integer.parseInt(date.getText().substring(0, 2)), Integer.parseInt(date.getText().substring(3, 5)), Integer.parseInt(date.getText().substring(6, 10)), Integer.parseInt(date.getText().substring(14, 16)), Integer.parseInt(date.getText().substring(17, 19)));
                Complaint complaint = new Complaint(title.getText(),description.getText(), date_, clientDNI.getText(), Integer.parseInt(referenceNumber.getText()));
                system.addComplaint(complaint);
                setVisible(false);
                dispose();
            }
        });

        myComplaint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                showUser(system, DNI);
            }
        });

        LabelPan.add(new JLabel("Users in the system:  "));
        LabelPan.add(myComplaint);

        LabelPan1.add(new JLabel("Title: "));LabelPan1.add(title);
        LabelPan2.add(new JLabel("Desciption: "));LabelPan2.add(description);
        LabelPan3.add(new JLabel("Date: "));LabelPan3.add(date);
        LabelPan4.add(new JLabel("Reference Number: "));LabelPan4.add(referenceNumber);
        LabelPan5.add(new JLabel("DNI: "));LabelPan5.add(clientDNI);LabelPan5.add(new JLabel(" IMPORTANTE(8 dígitos 1 letra)"));

        Text.add(LabelPan);
        Text.add(LabelPan1);
        Text.add(LabelPan2);
        Text.add(LabelPan3);
        Text.add(LabelPan4);
        Text.add(LabelPan5);

        BUTTONS.add(cancel);
        BUTTONS.add(updateUser);

        allPanel.add(Text);
        allPanel.add(BUTTONS);
        panel.add(allPanel);
        setContentPane(panel);
        setLocation(350,250);
        panel.setPreferredSize( new Dimension(400, 220));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }

    public void showUser(AeroSpyne system, String DNI){
        if(!system.getAllComplaint().isEmpty()){
           title.setText(system.getAllComplaint().get(myComplaint.getSelectedIndex()).getTitle());
           description.setText(system.getAllComplaint().get(myComplaint.getSelectedIndex()).getDescription());
           date.setText(system.getAllComplaint().get(myComplaint.getSelectedIndex()).getDate().toString());
           referenceNumber.setText(String.valueOf(system.getAllComplaint().get(myComplaint.getSelectedIndex()).getReferenceNumber()));
           clientDNI.setText(system.getAllComplaint().get(myComplaint.getSelectedIndex()).getClientDNI());
        }
    }

    public  void AddItemComplaint(AeroSpyne system, String DNI){
        if(system.getAllComplaint().isEmpty()){
            myComplaint.addItem("You have not made a complaint yet");
        }else{
            myComplaint.removeAll();
        
        }
        for(int i=0;i<system.getAllComplaint().size();i++){
            myComplaint.addItem(system.getAllComplaint().get(i).getTitle()+" - "+system.getAllComplaint().get(i).getClientDNI());
        }

        if(!system.getAllComplaint().isEmpty()){
            myComplaint.addItem("You have not made a complaint yet");
        }
        
    }
}

