package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssApp extends JFrame {
    private JPanel          issAppView;
    private JButton         startButton;
    private JProgressBar    piecSekund;
    private JLabel          obliczDroga;
    private JLabel          obliczPredkosc;
    
    
    private IssApp() {
        startButton.addActionListener(new startBtnClicked(  ));
    }
    
    private class startBtnClicked implements ActionListener{
        
        //TODO: słuchacz przycisku [start]
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
        
        }
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