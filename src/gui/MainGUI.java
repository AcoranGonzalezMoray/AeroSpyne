package gui;
import aerospyne.*;
import file.AeroSpyneFile;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainGUI extends JFrame {

    private static AeroSpyne system= new AeroSpyne();


    private JTextField origin;
    private JTextField destination;
    private JButton signin;
    private JList listItem;
    private DefaultListModel modelo;
    private String DNI;
    private TitledBorder titleBorder;
    private JLabel label;
    private JTextField signIn;
    private Boolean signInState = false;
    private Boolean signin_state_Admin = false;
    private JButton signup;
    private JButton filter;
    private JButton filter2;
    private JButton signOut;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu reservation;
    private JMenuItem itemReserve, itemMyReservations;
    private JMenuItem itemSignIn, itemSignUp, itemExit;
    private JMenu travelInsurance;
    private JMenuItem itemMyTravelInsurance;
    private JMenu complaint;
    private JMenuItem itemComplaint, itemMyComplaint;

    private JMenu manageUser;
    private JMenuItem itemAddUser, itemRemoveUser, itemSearchUser, itemUpdateUser;
    private JMenu manageFlight;
    private JMenuItem itemAddFlight, itemRemoveFlight, itemSearchFlight, itemUpdateFlight;
    private JMenu manageComplaint;
    private JMenuItem  itemRemoveComplaint, itemSearchComplaint, itemUpdateComplaint;

    private void constructMenu(AeroSpyneFile file) {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Menu");
        itemSignIn = new JMenuItem("Sign In");
        itemSignUp = new JMenuItem("Sign Up");
        itemExit = new JMenuItem("Exit");
        signIn = new JTextField(5);
        signIn.setText("F");
        menu.add(itemSignIn);
        menu.add(itemSignUp);
        menu.add(itemExit);
        menuBar.add(menu);
        itemSignIn.setVisible(true);
        itemSignUp.setVisible(true);
        if(signin_state_Admin){
            itemSignIn.setVisible(false);
            itemSignUp.setVisible(false);
            manageUser= new JMenu("Manage User");
            manageFlight= new JMenu("Manage Travel");
            manageComplaint = new JMenu("Manage Complaint");
            
            itemAddUser = new JMenuItem("Add User");
            itemRemoveUser = new JMenuItem("Remove User");
            itemSearchUser =  new JMenuItem("Search User");
            itemUpdateUser=  new JMenuItem("Update User");
            manageUser.add(itemAddUser);
            manageUser.add(itemRemoveUser);
            manageUser.add(itemSearchUser);
            manageUser.add(itemUpdateUser);

            itemAddFlight = new JMenuItem("Add Flight");
            itemRemoveFlight = new JMenuItem("Remove Flight");
            itemSearchFlight =  new JMenuItem("Search Flight");
            itemUpdateFlight=  new JMenuItem("Update Flight");
            manageFlight.add(itemAddFlight);
            manageFlight.add(itemRemoveFlight);
            manageFlight.add(itemSearchFlight);
            manageFlight.add(itemUpdateFlight);


            itemRemoveComplaint = new JMenuItem("Remove Complaint");
            itemSearchComplaint =  new JMenuItem("Search Complaint");
            itemUpdateComplaint=  new JMenuItem("Update Complaint");
            manageComplaint.add(itemRemoveComplaint);
            manageComplaint.add(itemSearchComplaint);
            manageComplaint.add(itemUpdateComplaint);

            menuBar.add(manageUser);
            menuBar.add(manageFlight);
            menuBar.add(manageComplaint);
            itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                file.saveToFile(system);
                dispose();
            }
             });
            itemAddUser.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    AddUserGUI dialogo = new AddUserGUI(system);
                    dialogo.setVisible(true);
                }
            });
            itemRemoveUser.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    RemoveUserGUI dialogo = new RemoveUserGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
            itemSearchUser.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    SearchUserGUI dialogo = new SearchUserGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
            itemUpdateUser.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    UpdateUserGUI dialogo = new UpdateUserGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
            itemAddFlight.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    AddFlightGUI dialogo = new AddFlightGUI(MainGUI.this, system);
                    dialogo.setVisible(true);
                    
                    modelo = new DefaultListModel();
                    for(int i = 0 ;i<system.getAllflights().size();i++){
                        modelo.add(i,system.getAllflights().get(i).getFlight());
                    }
                    listItem.setModel(modelo);
                }
            });
            itemRemoveFlight.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    RemoveFlightGUI dialogo = new RemoveFlightGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
            itemSearchFlight.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    SearchFlightGUI dialogo = new SearchFlightGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
            itemUpdateFlight.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    UpdateFlightGUI dialogo = new UpdateFlightGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                    modelo = new DefaultListModel();
                    for(int i = 0 ;i<system.getAllflights().size();i++){
                        modelo.add(i,system.getAllflights().get(i).getFlight());
                    }
                    listItem.setModel(modelo);
                    
                }
            });
            itemRemoveComplaint.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    RemoveComplaintGUI dialogo = new RemoveComplaintGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
            itemSearchComplaint.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    SearchComplaintGUI dialogo = new SearchComplaintGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
            itemUpdateComplaint.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    UpdateComplaintGUI dialogo = new UpdateComplaintGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
        }
        if(signInState){
            itemSignIn.setVisible(false);
            itemSignUp.setVisible(false);
            reservation = new JMenu("Reservation");
            travelInsurance = new JMenu("Travel Insurance");
            complaint = new JMenu("Complaint");
            itemReserve = new JMenuItem("Reserve");
            itemMyReservations = new JMenuItem("My Reservation");
            itemMyTravelInsurance = new JMenuItem("My Travel Insurance");
            itemComplaint =  new JMenuItem("Submit a Complaint");
            itemMyComplaint= new JMenuItem("My Complaint");
            reservation.add(itemReserve);
            reservation.add(itemMyReservations);
            travelInsurance.add(itemMyTravelInsurance);
            complaint.add(itemComplaint);
            complaint.add(itemMyComplaint);
            menuBar.add(reservation);
            menuBar.add(travelInsurance);
            menuBar.add(complaint);
            itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                file.saveToFile(system);
                dispose();
            }
            });
            itemMyTravelInsurance.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    MyTravelInsurance dialogo = new MyTravelInsurance(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
            itemComplaint.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    ComplaintGUI dialogo = new ComplaintGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
            itemMyComplaint.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    MyComplaintGUI dialogo = new MyComplaintGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
            itemReserve.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    ReserveGUI dialogo = new ReserveGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });

            itemMyReservations.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    MyReservationGUI dialogo = new MyReservationGUI(MainGUI.this,system, DNI);
                    dialogo.setVisible(true);
                }
            });
        }
    }

    private Component constructControls(AeroSpyneFile file) {
        origin = new JTextField(10);
        destination = new JTextField(10);
        signin = new JButton("Sign in");
        signup = new JButton("Sign up");
        signOut = new JButton("Sign Out");
        filter = new JButton();
        filter2 = new JButton();

        try {
          Image img_filter = ImageIO.read(new FileInputStream("src/icons/filter_v2.png"));
          Image img_reload = ImageIO.read(new FileInputStream("src/icons/reload.png"));
          Image img_sign_in = ImageIO.read(new FileInputStream("src/icons/sign-in.png"));
          Image img_sign_up = ImageIO.read(new FileInputStream("src/icons/sign-up.png"));
          filter.setIcon(new ImageIcon(img_filter));
          filter2.setIcon(new ImageIcon(img_reload));
          signin.setIcon(new ImageIcon(img_sign_in ));
          signup.setIcon(new ImageIcon(img_sign_up ));
        } catch (IOException ex) {
          System.out.println(ex);
        }
          
        label = new JLabel("Sign In Please"); 
        titleBorder =  BorderFactory.createTitledBorder(label.getText());
        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
        JPanel search = new JPanel();
        search.setLayout(new BoxLayout(search, BoxLayout.X_AXIS));
        JPanel search2 = new JPanel();
        search2.setLayout(new BoxLayout(search2, BoxLayout.X_AXIS));
        JPanel order = new JPanel();
        order.setLayout(new BoxLayout(order, BoxLayout.PAGE_AXIS));
        JPanel orderIn = new JPanel();
        orderIn.setLayout(new BoxLayout(orderIn, BoxLayout.X_AXIS));
        search.add(new JLabel("Origin:          "));search.add(origin);
        search2.add(new JLabel("Destination:"));search2.add(destination);
        JPanel login= new JPanel();
        login.setLayout(new BoxLayout(login, BoxLayout.X_AXIS));

        login.add(signin);
        login.add(signup);
        order.add(search);
        order.add(search2);
        orderIn.add(filter);
        orderIn.add(filter2);
        order.add(orderIn);
        order.setBorder(BorderFactory.createTitledBorder("Filter"));
        east.add(order);
        east.add(login);
        east.setBorder(titleBorder);

        itemSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SignInGUI dialogo = new SignInGUI(MainGUI.this,system);
                dialogo.setVisible(true);

                signInState =  dialogo.getSign();
                signin_state_Admin = dialogo.getSignAdmin();
                if(signInState){
                    label.setText(dialogo.getName());
                    titleBorder.setTitle(label.getText());
                    repaint();
                    constructMenu(file);
                    DNI = dialogo.getDNI(system);
                }

                if(signin_state_Admin){
                    label.setText(dialogo.getName());
                    titleBorder.setTitle(label.getText());
                    repaint();
                    constructMenu(file);
                    DNI = dialogo.getDNI(system);
                }
            }
        });

        itemSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SignUpGUI dialogo = new SignUpGUI(system);
                dialogo.setVisible(true);
            }
        });

        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                file.saveToFile(system);
                dispose();
            }
        });

        filter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                modelo.clear();;
                int j = 0;
                //.replaceAll("\\s","")
                for(int i=0;i<system.getAllflights().size();i++){
                    if(system.getAllflights().get(i).getOrigin().replaceAll("\\s","").toLowerCase().compareTo(origin.getText().replaceAll("\\s","").toLowerCase())== 0
                    && system.getAllflights().get(i).getDestination().replaceAll("\\s","").toLowerCase().compareTo(destination.getText().replaceAll("\\s","").toLowerCase())== 0){
                        modelo.add(j,system.getAllflights().get(i).getFlight());
                        j++;
                    }
                    
                }
                if(modelo.isEmpty()){
                    modelo.add(0, "No available flights have been found for your search");
                }
                
            }
        });
        filter2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                modelo.clear();;
                modelo = new DefaultListModel();
                for(int i = 0 ;i<system.getAllflights().size();i++){
                    modelo.add(i,system.getAllflights().get(i).getFlight());
                }
                listItem.setModel(modelo);
            }
        });
        signin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SignInGUI dialogo = new SignInGUI(MainGUI.this,system);
                dialogo.setVisible(true);

                signInState =  dialogo.getSign();
                signin_state_Admin = dialogo.getSignAdmin();
                if(signInState){
                    label.setText(dialogo.getName());
                    titleBorder.setTitle(label.getText());
                    repaint();
                    constructMenu(file);
                    DNI = dialogo.getDNI(system);
                    login.removeAll();
                    login.add(signOut);
                }

                if(signin_state_Admin){
                    label.setText(dialogo.getName());
                    titleBorder.setTitle(label.getText());
                    repaint();
                    constructMenu(file);
                    DNI = dialogo.getDNI(system);
                    login.removeAll();
                    login.add(signOut);
                }
                
            }
        });
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SignUpGUI dialogo = new SignUpGUI(system);
                dialogo.setVisible(true);
            }
        });

        signOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                signInState = false;
                signin_state_Admin = false;
                login.removeAll();
                login.add(signin);
                login.add(signup);
                label.setText("Sign In Please");
                titleBorder.setTitle(label.getText());
                repaint();
                constructMenu(file);
            }
        });

        listItem.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                //if (!arg0.getValueIsAdjusting()) {
                try{
                    FlightGUI dialogo = new FlightGUI(MainGUI.this,system, system.getAllflights().get(listItem.getSelectedIndex()));
                    dialogo.setVisible(true);
                    modelo = new DefaultListModel();
                    for(int i = 0 ;i<system.getAllflights().size();i++){
                        modelo.add(i,system.getAllflights().get(i).getFlight());
                    }
                    listItem.setModel(modelo);
                }catch(IndexOutOfBoundsException exception){
                    System.out.print("");
                }
                  
                //}
            }
        });
        
        return east;
    }

    private Component constructInfo() {
        listItem=new JList();
        modelo = new DefaultListModel();
        for(int i = 0 ;i<system.getAllflights().size();i++){
            modelo.add(i,system.getAllflights().get(i).getFlight());
        }
        listItem.setModel(modelo);
        return new JScrollPane(listItem);
    }

    public MainGUI(AeroSpyneFile file){
        super("AeroSpyne");
        file.loadFromFile(system);
        constructMenu(file);
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(constructInfo(), BorderLayout.CENTER);
        pane.add(constructControls(file), BorderLayout.EAST);
        setContentPane(pane);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                file.saveToFile(system);
                e.getWindow().dispose();
            }
        });
        setLocation(350,250);
        setSize(550,270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
