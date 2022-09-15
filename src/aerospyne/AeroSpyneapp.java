package aerospyne;
import gui.*;
import javax.swing.UIManager;
import model.*;
import file.AeroSpyneFile;
public class AeroSpyneapp {
    public static void main (String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {
        }
        AeroSpyneFile file=new AeroSpyneFile();
        new MainGUI(file);
    }
}