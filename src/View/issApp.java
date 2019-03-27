package View;

import Controller.API;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class issApp extends JFrame {
    public JPanel           ISSspeedAPPview;
    private JButton         startButton;
    private JProgressBar    piecsekund;
    private JLabel          obliczDroga;
    private JLabel          obliczPredkosc;
    
    // słuchacz startu
    public issApp() {
        startButton.addActionListener(new wciskStart());
    }
    
    // setters and getters
    public void updatePredkosc(double velocity) {
        obliczPredkosc.setText(String.valueOf(velocity));
    }
    public String getPredkosc() {
        return obliczPredkosc.getText();
    }
    public void updateDroga(double distance) {
        obliczDroga.setText(String.valueOf(distance));
    }
    public String getDroga() {
        return obliczDroga.getText();
    }
    
    //TODO: Aktualizacja licznika
    public void updateLicznik(double cz){
        double procent = cz * 20;
        piecsekund.setValue((int) procent);
    }
    public String getLicznik(){
        return piecsekund.getString();
    }
}

// słuchacz
class wciskStart implements ActionListener{
    API api;
    
    //TODO: słuchacz przycisku [start]
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            api.buttonPress();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}