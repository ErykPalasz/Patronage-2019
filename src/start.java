import View.ISS_speed_App;

import javax.swing.*;

public class start {
    public static void main(String[] args) {
        // URL url = new URL("http://api.open-notify.org/iss-now.json");
    
        JFrame frame = new JFrame("ISS_speed_App");
        frame.setContentPane(new ISS_speed_App().ISSspeedAPPview);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
