package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SearchUserGUI extends JDialog{

    private JButton cancel;
    private JButton showDetails;
    private JComboBox myUser;
    private JTextArea details;



    public SearchUserGUI (JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("Admin - Search User");
        myUser = new JComboBox();
        AddItemUser(system, DNI);
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

        LabelPan1.add(new JLabel("Users in the system:  "));
        LabelPan1.add(myUser);
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
        if(!system.getAllclients().isEmpty()){
            details.setText(system.getAllclients().get(myUser.getSelectedIndex()).toString());
        }
    }

    public  void AddItemUser(AeroSpyne system, String DNI){
        if(system.getAllclients().isEmpty()){
            myUser.addItem("You have not made a complaint yet");
        }else{
            myUser.removeAll();
        
        }
        for(int i=0;i<system.getAllclients().size();i++){
            myUser.addItem(system.getAllclients().get(i).getEmail());
        }

        if(!system.getAllComplaint().isEmpty()){
            myUser.addItem("You have not made a complaint yet");
        }
        
    }
}

