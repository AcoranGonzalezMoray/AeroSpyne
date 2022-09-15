package gui;
import model.*;
import javax.swing.*;

import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.*;

class MyReservationGUI extends JDialog{

    private JButton cancel;
    private JButton cancelReservation;
    private JButton updateReservation;
    private JButton showDetails; 
    private JComboBox myReservation;



    public MyReservationGUI(JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("My Reservation");
        myReservation = new JComboBox();
        AddItemReservation(system, DNI);
        
        Container panel= getContentPane();
        panel.setLayout(new FlowLayout());

        JPanel LabelPan1 = new JPanel();
        LabelPan1.setLayout(new BoxLayout(LabelPan1, BoxLayout.X_AXIS));
     
        JPanel Text = new JPanel();
        Text.setLayout(new BoxLayout(Text, BoxLayout.Y_AXIS));

        JPanel BUTTONS = new JPanel();
        BUTTONS.setLayout(new BoxLayout(BUTTONS, BoxLayout.Y_AXIS));

        JPanel allPanel = new JPanel();
        allPanel.setLayout(new BoxLayout(allPanel, BoxLayout.X_AXIS));

        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                dispose();
            }
        });

        
        cancelReservation = new JButton("Cancel Reservation");
        cancelReservation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cancelReservation(system);
                myReservation.removeAllItems();
                AddItemReservation(system, DNI);

            }
        });

        
        updateReservation = new JButton("Update Reservation");
        updateReservation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(myReservation.getSelectedItem().toString().compareTo("You have not made a reservation yet")!=0){

                    ReservationUpdateGUI dialogo__ = new ReservationUpdateGUI(MyReservationGUI.this, system, DNI, system.getAllReservations().get(myReservation.getSelectedIndex()).getReferenceNumber(), system.getAllReservations().get(myReservation.getSelectedIndex()).getInsurance());
                    dialogo__.setVisible(true);
                    LabelPan1.removeAll();
                    myReservation.removeAllItems();
                    System.out.println(myReservation);
                    AddItemReservation(system, DNI);
                    LabelPan1.add(new JLabel("My Reservation: "));
                    LabelPan1.add(myReservation);
                    LabelPan1.updateUI();
                    Text.updateUI();
                    allPanel.updateUI();
                }

            }
        });

        showDetails= new JButton("Show Details");
        showDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                
                ReservationDetailsGUI dialogo_ = new ReservationDetailsGUI(frame, system, getFlight(system), getReservation(system));
                dialogo_.setVisible(true);
            }
        });

        LabelPan1.add(new JLabel("My Reservation: "));
        LabelPan1.add(myReservation);
        Text.add(LabelPan1);
        Text.add(cancel);
        BUTTONS.add(showDetails);
        BUTTONS.add(updateReservation);
        BUTTONS.add(cancelReservation);

        allPanel.add(Text);
        allPanel.add(BUTTONS);
        panel.add(allPanel);
        setContentPane(panel);
        setLocation(350,250);
        panel.setPreferredSize( new Dimension(680, 100));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }

    public void cancelReservation(AeroSpyne system){
        if(system.getAllReservations().get(myReservation.getSelectedIndex()).getInsurance()!=null){
            system.removeTravelInsurance( system.getAllReservations().get(myReservation.getSelectedIndex()).getInsurance().getReferenceNumber());
        }
        system.removeReservation(
            system.getAllReservations().get(myReservation.getSelectedIndex()).getReferenceNumber()
        );

        
    }

    public Reservation getReservation(AeroSpyne system){
        return system.getAllReservations().get(myReservation.getSelectedIndex());
    }

    public Flight getFlight(AeroSpyne system){
        return  system.getAllReservations().get(myReservation.getSelectedIndex()).getFlight();
    }

    public  void AddItemReservation(AeroSpyne system, String DNI){
        if(system.getAllReservations().isEmpty()){
            myReservation.addItem("You have not made a reservation yet");
        }else{
            myReservation.removeAll();
        }
        boolean isEmpty = true;
        for(int i=0;i<system.getAllReservations().size();i++){
            if(system.getAllReservations().get(i).getClientDNI().compareTo(DNI)==0){
                myReservation.addItem(system.getAllReservations().get(i));
                isEmpty = false;
            }
        }
        if(isEmpty){
            myReservation.addItem("You have not made a reservation yet");
        }
    }
}

