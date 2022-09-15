package gui;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ComplaintGUI extends JDialog{

    private JButton submit;
    private JTextField title;
    private JTextArea description;
    private int number = (int)(Math.random()*10000+1);

    public ComplaintGUI(JFrame frame, AeroSpyne system, String DNI){
        super(frame, true);
        this.setTitle("Complaint");

        Container panel= getContentPane();
        panel.setLayout(new FlowLayout());
        
        title = new JTextField();
        description = new JTextArea();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JPanel LabelPan1 = new JPanel();
        LabelPan1.setLayout(new BoxLayout(LabelPan1, BoxLayout.X_AXIS));
        JPanel LabelPan2 = new JPanel();
        LabelPan2.setLayout(new BoxLayout(LabelPan2, BoxLayout.X_AXIS));
        JPanel LabelPan3 = new JPanel();
        LabelPan3.setLayout(new BoxLayout(LabelPan3, BoxLayout.X_AXIS));

        JPanel Text = new JPanel();
        Text.setLayout(new BoxLayout(Text, BoxLayout.Y_AXIS));

        JPanel All = new JPanel(); 
        All.setLayout(new BoxLayout(All, BoxLayout.Y_AXIS));

        submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Complaint complaint = new Complaint(title.getText(), description.getText(), DNI, number);
                system.addComplaint(complaint);
                setVisible(false);
                dispose();
            }
        });


        buttonPanel.add(submit);
        LabelPan1.add(new JLabel("Title: "));LabelPan1.add(title);
        LabelPan2.add(new JLabel("Description: "));LabelPan2.add(description);
        LabelPan3.add(new JLabel("Your DNI: "));LabelPan3.add(new JLabel(DNI));

        Text.add(LabelPan1);
        Text.add(LabelPan2);
        Text.add(LabelPan3);
        All.add(Text);
        All.add(buttonPanel);

        panel.add(All);
        setContentPane(panel);
        setLocation(550,250);
        panel.setPreferredSize( new Dimension(200, 125));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
    }
}
