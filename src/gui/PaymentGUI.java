package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.AeroSpyne;
import model.Card;
import model.Date;
import model.Flight;
import model.Reservation;
import model.TravelInsurance;
class PaymentGUI extends JDialog{

    private JButton Pay;
    private JComboBox myPayment;
    private JLabel one;
    private JLabel two;
    private JLabel three;
    private JLabel four;
    private JLabel five;
    private JTextField one_;
    private JTextField one_1;
    private JTextField one_2;
    private JTextField one_3;
    private JTextField two_;
    private JTextField three_;
    private JTextField four_;
    private JLabel five_;

    public PaymentGUI(JFrame frame,AeroSpyne system , int seats, int number, Flight flight, String DNI, TravelInsurance travel, Boolean check, String price){
        super(frame, true);
        this.setTitle("Payment");
        one = new JLabel("Card Number: ");
        two = new JLabel("Expiration Date: ");
        three = new JLabel("CVV: ");
        four = new JLabel("Owner Name: ");
        five = new JLabel("Total: ");

        one_ = new JTextField("xxxx");
        one_1= new JTextField("xxxx");
        one_2 = new JTextField("xxxx");
        one_3 = new JTextField("xxxx");
        two_ =  new JTextField("dd/mm/yyyy");
        three_=  new JTextField("xxx");
        four_ =  new JTextField();
        four_.setText(system.getClient(DNI).getName());
        five_ =  new JLabel(price);
        
        if(system.getCardB(system.getClient(DNI).getEmail())){
            String AccountN =String.valueOf(system.getCard(system.getClient(DNI).getEmail()).getAccountNumber());
            one_.setText(AccountN.substring(0, 5));
            one_1.setText(AccountN.substring(4, 9));
            one_2.setText(AccountN.substring(8, 13));
            one_3.setText(AccountN.substring(12, 16));
            two_.setText(system.getCard(system.getClient(DNI).getEmail()).getExpirationDate().toString().substring(0,11));
            three_.setText(String.valueOf(system.getCard(system.getClient(DNI).getEmail()).getSecurityCode()));
        }
        
        myPayment = new JComboBox();
        myPayment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(myPayment.getSelectedIndex()==0){
                    one.setText("Card Number: ");
                    two.setText("Expiration Date: ");two_.setText("dd/mm/yyyy");
                    three.setText("CVV: ");three_.setText("xxx");
                    four.setText("Owner Name: ");four_.setVisible(true);
                    four_.setText(system.getClient(DNI).getName());
                    five.setText("Total: ");
                    if(system.getCardB(system.getClient(DNI).getEmail())){
                        String AccountN =String.valueOf(system.getCard(system.getClient(DNI).getEmail()).getAccountNumber());
                        one_.setText(AccountN.substring(0, 5));
                        one_1.setText(AccountN.substring(4, 9));
                        one_2.setText(AccountN.substring(8, 13));
                        one_3.setText(AccountN.substring(12, 16));
                        two_.setText(system.getCard(system.getClient(DNI).getEmail()).getExpirationDate().toString().substring(0,11));
                        three_.setText(String.valueOf(system.getCard(system.getClient(DNI).getEmail()).getSecurityCode()));
                    }
                       
                }else if(myPayment.getSelectedIndex()==1){
                    one.setText("Card Number: ");
                    two.setText("Username: ");two_.setText("");
                    three.setText("Email: ");three_.setText("");
                    four.setText("");four_.setVisible(false);
                    five.setText("Total: ");
                    if(system.getCardB(system.getClient(DNI).getEmail())){
                        String AccountN =String.valueOf(system.getCard(system.getClient(DNI).getEmail()).getAccountNumber());
                        one_.setText(AccountN.substring(0, 5));
                        one_1.setText(AccountN.substring(4, 9));
                        one_2.setText(AccountN.substring(8, 13));
                        one_3.setText(AccountN.substring(12, 16));
                    }
                    three_.setText(system.getClient(DNI).getEmail());
                }
            }
        });

        myPayment.addItem("Credit/Debit Card");
        myPayment.addItem("PayPal");


        Container panel= getContentPane();
        panel.setLayout(new FlowLayout());

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

        Pay= new JButton("Pay and reserve");
        Pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(check){
                    Reservation reservation = new Reservation(seats, number , flight, DNI, travel);
                    system.addReservation(reservation);
                }else{
                    Reservation reservation = new Reservation(seats, number , flight, DNI);
                    system.addReservation(reservation);
                }
                
                if(myPayment.getSelectedIndex()==0){
                    if(!system.getCardB(system.getClient(DNI).getEmail())){
                        String number2 =String.valueOf(one_.getText()+one_1.getText()+one_2.getText()+one_3.getText());
                        Date deadline = new Date(Integer.parseInt(two_.getText().substring(0, 2)),Integer.parseInt(two_.getText().substring(3, 5)), Integer.parseInt(two_.getText().substring(6, 10)));
                        Card card = new Card(system.getClient(DNI).getEmail(), deadline ,Integer.parseInt(three_.getText()),number2 ,Float.parseFloat(price) );
                        system.addCard(card);
                    }else{
                        String number2 =String.valueOf(one_.getText()+one_1.getText()+one_2.getText()+one_3.getText());
                        system.getCard(system.getClient(DNI).getEmail()).setAccountNumber(number2);
                        system.getCard(system.getClient(DNI).getEmail()).setSecurityCode(Integer.parseInt(three_.getText()));
                        Date deadline = new Date(Integer.parseInt(two_.getText().substring(0, 2)),Integer.parseInt(two_.getText().substring(3, 5)), Integer.parseInt(two_.getText().substring(6, 10)));
                        system.getCard(system.getClient(DNI).getEmail()).setExpirationDate(deadline);


                    }
                }
                setVisible(false);
                dispose();
            }
        });


        LabelPan1.add(new JLabel("Select payment method: "));
        LabelPan1.add(myPayment);

        LabelPan2.add(one);LabelPan2.add(one_);LabelPan2.add(one_1);LabelPan2.add(one_2);LabelPan2.add(one_3);
        LabelPan3.add(two);LabelPan3.add(two_);
        LabelPan4.add(three);LabelPan4.add(three_);
        LabelPan5.add(four);LabelPan5.add(four_);
        LabelPan6.add(five);LabelPan6.add(five_);

        Text.add(LabelPan1);
        Text.add(LabelPan2);
        Text.add(LabelPan3);
        Text.add(LabelPan4);
        Text.add(LabelPan5);
        BUTTONS.add(LabelPan6);
        BUTTONS.add(Pay);

        allPanel.add(Text);
        allPanel.add(BUTTONS);
        panel.add(allPanel);
        setContentPane(panel);
        setLocation(350,250);
        panel.setPreferredSize( new Dimension(300, 200));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }
    
}