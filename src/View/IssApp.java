package View;

import Controller.API;
import Model.ZestawDanych;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssApp extends JFrame {
    private JPanel          issAppView;
    private JButton         startButton;
    private JProgressBar    piecSekund;
    private JLabel          obliczonaDroga;
    private JLabel          obliczonaPredkosc;
    private ZestawDanych    zestaw;
    
    
    private IssApp() {
        startButton.addActionListener(new startBtnClicked(7.0));
    }
    
    private class startBtnClicked implements ActionListener{
        private double start;
    
        public startBtnClicked(double start) {
            this.start = start;
        }
        
        //TODO: słuchacz przycisku [start]
        @Override
        public void actionPerformed(ActionEvent event) {
            API.licznik licz = new API.licznik(start);
            
            int c = 0;
    
            do {
                API.pobierzDane(c);
        
                if (c > 0) {
                    updatePredkosc(80); //TODO
                    updateDroga(1410); //TODO
                }
        
                licz.run(); c++;
        
            } while (c <= 1);
        }
    }
    
    // setters and getters
    public void updatePredkosc(double velocity) {
        obliczonaPredkosc.setText(String.valueOf(velocity));
    }
    public String getPredkosc() {
        return obliczonaPredkosc.getText();
    }
    
    public void updateDroga(double distance) {
        obliczonaDroga.setText(String.valueOf(distance));
    }
    public String getDroga() {
        return obliczonaDroga.getText();
    }
    
    public void updateLicznik(double cz){
        double procent = cz * 20;
        piecSekund.setValue((int) procent);
    }
    public String getLicznik(){
        return piecSekund.getString();
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("ISS speed police control app");
        frame.setContentPane(new IssApp().issAppView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}