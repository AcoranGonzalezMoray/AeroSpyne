package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateUserGUI extends JDialog{

    private JButton cancel;
    private JButton updateUser;
    private JComboBox myUser;
    private JTextField clientName;
    private JTextField clientSurname;
    private JTextField clientEmail;
    private JTextField clientPassword;
    private JTextField clientDNI;
    private JTextField clientTelephone;


    public UpdateUserGUI (JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("Admin - Update User");
        clientName = new JTextField(10);
        clientSurname = new JTextField(12);
        clientEmail = new JTextField(10);
        clientPassword = new JTextField(12);
        clientDNI = new JTextField(10);
        clientTelephone = new JTextField(12);
        myUser = new JComboBox();
        AddItemUser(system, DNI);
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

        JPanel LabelPan6 = new JPanel();
        LabelPan6.setLayout(new BoxLayout(LabelPan6, BoxLayout.X_AXIS));

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
                system.removeClient(system.getAllclients().get(myUser.getSelectedIndex()).getDNI());
                Client client = new Client(clientName.getText(),clientSurname.getText(), clientEmail.getText(), clientPassword.getText(), clientDNI.getText(), clientTelephone.getText());
                system.addClient(client);
                setVisible(false);
                dispose();
            }
        });

        myUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                showUser(system, DNI);
            }
        });

        LabelPan.add(new JLabel("Users in the system:  "));
        LabelPan.add(myUser);

        LabelPan1.add(new JLabel("Name: "));LabelPan1.add(clientName);
        LabelPan2.add(new JLabel("Surname: "));LabelPan2.add(clientSurname);
        LabelPan3.add(new JLabel("Email: "));LabelPan3.add(clientEmail);
        LabelPan4.add(new JLabel("Password: "));LabelPan4.add(clientPassword);
        LabelPan5.add(new JLabel("DNI: "));LabelPan5.add(clientDNI);LabelPan5.add(new JLabel(" IMPORTANTE(8 dígitos 1 letra)"));
        LabelPan6.add(new JLabel("Telephone: "));LabelPan6.add(clientTelephone);

        Text.add(LabelPan);
        Text.add(LabelPan1);
        Text.add(LabelPan2);
        Text.add(LabelPan3);
        Text.add(LabelPan4);
        Text.add(LabelPan5);
        Text.add(LabelPan6);
        BUTTONS.add(cancel);
        BUTTONS.add(updateUser);

        allPanel.add(Text);
        allPanel.add(BUTTONS);
        panel.add(allPanel);
        setContentPane(panel);
        setLocation(350,250);
        panel.setPreferredSize( new Dimension(400, 250));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }

    public void showUser(AeroSpyne system, String DNI){
        if(!system.getAllclients().isEmpty()){
           clientName.setText(system.getAllclients().get(myUser.getSelectedIndex()).getName());
           clientSurname.setText(system.getAllclients().get(myUser.getSelectedIndex()).getSurname());
           clientEmail.setText(system.getAllclients().get(myUser.getSelectedIndex()).getEmail());
           clientPassword.setText(system.getAllclients().get(myUser.getSelectedIndex()).getPassword());
           clientTelephone.setText(system.getAllclients().get(myUser.getSelectedIndex()).getTelephone());
           clientDNI.setText(system.getAllclients().get(myUser.getSelectedIndex()).getDNI());
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

        if(!system.getAllclients().isEmpty()){
            myUser.addItem("You have not made a complaint yet");
        }
        
    }
}

