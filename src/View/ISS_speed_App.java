package View;

import Controller.ISS_speed_APP_controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ISS_speed_App extends JFrame {
    public JPanel ISSspeedAPPview;
    
    private JButton startButton;
    private JProgressBar piecsekund;
    private JLabel obliczDroga;
    private JLabel obliczPredkosc;
    
    public ISS_speed_App(){
        startButton.addActionListener(new wciskStart());
    }
    
    public void updatePredkosc(double vel){
        obliczPredkosc.setText(String.valueOf(vel));
    }
    
    public String getPredkosc(){
        return obliczPredkosc.getText();
    }
    
    public void updateDroga(double dis){
        obliczDroga.setText(String.valueOf(dis));
    }
    
    public String getDroga(){
        return obliczDroga.getText();
    }
    
    public void updateLicznik(double cz){
        double procent = cz * 20;
        piecsekund.setValue((int) procent);
    }
    
    public String getLicznik(){
        return piecsekund.getString();
    }
}

class wciskStart implements ActionListener{
    private ISS_speed_APP_controller controller = new ISS_speed_APP_controller();
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        controller.buttonPress();
    }
}