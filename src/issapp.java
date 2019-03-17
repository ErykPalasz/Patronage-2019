import View.ISS_speed_App;

import javax.swing.*;

public class issapp {
    public static void main(String[] args) {
        // URL url = new URL("http://api.open-notify.org/iss-now.json");
        
        // **************** MOCK *********************
        int timestamp1 = 1552696562, timestamp2 = 1552696679;
        double latitude1 = 51.3865, longitude1 = 4.7025,
                latitude2 = 51.5185, longitude2 = 16.3822;
        // *******************************************
    
        JFrame frame = new JFrame("ISS_speed_App");
        frame.setContentPane(new ISS_speed_App().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    
        //TODO: widok: ISS_speed_App z przyciskami
        //TODO: kontroler: przekazanie danych do i z modelu
        //TODO: model: magazynowanie danych i obliczenia
    }
}
