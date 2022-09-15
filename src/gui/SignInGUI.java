package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SignInGUI extends JDialog{

    
    private JTextField clientEmail;
    private JTextField clientPassword;
    private Boolean signIn = false;
    private Boolean signInAdmin = false;
    private JButton accept;
    private JButton cancel;

    public SignInGUI(JFrame frame, AeroSpyne system){
        super(frame, true);
        this.setTitle("Sign In");


        clientEmail = new JTextField(10);
        clientPassword = new JTextField(12);

        Container panel= getContentPane();
        panel.setLayout(new FlowLayout());
        
        

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));


        JPanel LabelError = new JPanel();
        LabelError.setLayout(new BoxLayout(LabelError, BoxLayout.X_AXIS));

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
                
                for(int i=0;i<system.getAllclients().size();i++){
                    if(system.getAllclients().get(i).getEmail().toLowerCase().compareTo(clientEmail.getText().toLowerCase())==0 &&
                    system.getAllclients().get(i).getPassword().toLowerCase().compareTo(clientPassword.getText().toLowerCase())==0){
                        if(clientEmail.getText().toLowerCase().compareTo("Admin".toLowerCase())==0 && clientPassword.getText().toLowerCase().compareTo("Admin".toLowerCase())==0){
                           signInAdmin = true;
                        }else{
                            signIn = true; 
                        }
                        setVisible(false);
                        dispose();
                    }
                }
                if(signIn == false){
                        LabelError.removeAll();
                        LabelError.add(new JLabel("Wrong email or password, please try again"), BorderLayout.PAGE_START);
                        LabelError.updateUI();
                }
            }
        });

        cancel= new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });

        buttonPanel.add(accept);
        buttonPanel.add(Box.createRigidArea(new Dimension(15, 0)));
        buttonPanel.add(cancel);

        LabelPan3.add(new JLabel("Email: "));LabelPan3.add(clientEmail);
        LabelPan4.add(new JLabel("Password: "));LabelPan4.add(clientPassword);


        Text.add(LabelPan3);
        Text.add(LabelPan4);


        All.add(Text);
        All.add(buttonPanel);

        panel.add(LabelError, BorderLayout.PAGE_START);
        panel.add(All);
        setContentPane(panel);
        setLocation(550,250);
        panel.setPreferredSize( new Dimension(300, 125));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }

    public String getName(){

        return clientEmail.getText();
    }

    public String getDNI(AeroSpyne system){
        for(int i=0;i<system.getAllclients().size();i++){
            if(system.getAllclients().get(i).getEmail().toLowerCase().compareTo(clientEmail.getText().toLowerCase())==0 &&
            system.getAllclients().get(i).getPassword().toLowerCase().compareTo(clientPassword.getText().toLowerCase())==0){
                return system.getAllclients().get(i).getClientDNI();

            }
        }
        return "3453";
    }

    public Boolean getSign(){

        return signIn;
    }

    public Boolean getSignAdmin(){
        return signInAdmin;
    }
}
