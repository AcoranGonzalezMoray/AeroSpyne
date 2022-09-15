package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddUserGUI extends JDialog{

    
    private JTextField clientName;
    private JTextField clientSurname;
    private JTextField clientEmail;
    private JTextField clientPassword;
    private JTextField clientDNI;
    private JTextField clientTelephone;
    private JButton addUser;
    private JButton cancel;

    public AddUserGUI(AeroSpyne system){
        this.setTitle("Admin - Add User");

        clientName = new JTextField(10);
        clientSurname = new JTextField(12);
        clientEmail = new JTextField(10);
        clientPassword = new JTextField(12);
        clientDNI = new JTextField(10);
        clientTelephone = new JTextField(12);

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

        JPanel Text = new JPanel();
        Text.setLayout(new BoxLayout(Text, BoxLayout.Y_AXIS));

        JPanel All = new JPanel();
        All.setLayout(new BoxLayout(All, BoxLayout.Y_AXIS));

        addUser = new JButton("Add User");
        addUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Client client = new Client(clientName.getText(),clientSurname.getText(), clientEmail.getText(), clientPassword.getText(), clientDNI.getText(), clientTelephone.getText());
                system.addClient(client);
                dispose();
            }
        });

        cancel= new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });

        buttonPanel.add(addUser);
        buttonPanel.add(Box.createRigidArea(new Dimension(15, 0)));
        buttonPanel.add(cancel);

        LabelPan1.add(new JLabel("Name: "));LabelPan1.add(clientName);
        LabelPan2.add(new JLabel("Surname: "));LabelPan2.add(clientSurname);
        LabelPan3.add(new JLabel("Email: "));LabelPan3.add(clientEmail);
        LabelPan4.add(new JLabel("Password: "));LabelPan4.add(clientPassword);
        LabelPan5.add(new JLabel("DNI: "));LabelPan5.add(clientDNI);LabelPan5.add(new JLabel(" IMPORTANTE(8 dígitos 1 letra)"));
        LabelPan6.add(new JLabel("Telephone: "));LabelPan6.add(clientTelephone);

        Text.add(LabelPan1);
        Text.add(LabelPan2);
        Text.add(LabelPan3);
        Text.add(LabelPan4);
        Text.add(LabelPan5);
        Text.add(LabelPan6);

        All.add(Text);
        All.add(buttonPanel);

        panel.add(All, BorderLayout.PAGE_START);
        
        setContentPane(panel);
        setLocation(550,250);
        setSize(350,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
