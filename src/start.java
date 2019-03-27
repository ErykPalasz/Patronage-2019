import View.issApp;

import javax.swing.*;

public class start {
    public static void main(String[] args) {
        // URL url = new URL("http://api.open-notify.org/iss-now.json");
        JFrame frame = new JFrame("issApp");
        frame.setContentPane(new issApp().ISSspeedAPPview);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
