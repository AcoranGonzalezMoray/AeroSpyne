package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyTravelInsurance extends JDialog{

    private JButton cancel;
    private JButton showDetails;
    private JComboBox myComplaint;
    private JTextArea details;



    public MyTravelInsurance(JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("My Travel Insurance");
        myComplaint = new JComboBox();
        AddItemTravelInsurance(system, DNI);
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

        LabelPan1.add(new JLabel("My TravelInsurance: "));
        LabelPan1.add(myComplaint);
        Text.add(LabelPan1);
        BUTTONS.add(cancel);
        BUTTONS.add(showDetails);

        allPanel.add(Text);
        allPanel.add(details);
        allPanel.add(BUTTONS);
        panel.add(allPanel);
        setContentPane(panel);
        setLocation(220,250);
        panel.setPreferredSize( new Dimension(550, 280));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }

    public void showDetail(AeroSpyne system, String DNI){ 
        boolean isEmpty = true;
        for(int i=0;i<system.getAllTravelInsurance().size();i++){
            if(system.getAllTravelInsurance().get(i).getDNI().compareTo(DNI)==0){
                isEmpty = false;
                break;
            }
        }
        if(!isEmpty){
            details.setText(system.getAllTravelInsurance().get(myComplaint.getSelectedIndex()+3).toString());
        }
    }

    public  void AddItemTravelInsurance(AeroSpyne system, String DNI){
        if(system.getAllTravelInsurance().isEmpty()){
            myComplaint.addItem("You have not yet taken out travel insurance");
        }else{
            myComplaint.removeAll();
        
        }
        boolean isEmpty = true;
        for(int i=0;i<system.getAllTravelInsurance().size();i++){
            if(system.getAllTravelInsurance().get(i).getDNI().compareTo(DNI)==0){
                myComplaint.addItem(system.getAllTravelInsurance().get(i).getName()+" - "+system.getAllTravelInsurance().get(i).getReferenceNumber());
                isEmpty = false;
            }
            
        }

        if(isEmpty){
            myComplaint.addItem("You have not yet taken out travel insurance");
        }
        
    }
}

