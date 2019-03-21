package View;

import Controller.issAppController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class issApp extends JFrame {
    public JPanel ISSspeedAPPview;
    
    private JButton startButton;
    private JProgressBar piecsekund;
    private JLabel obliczDroga;
    private JLabel obliczPredkosc;
    
    // słuchacz startu
    public issApp(){
        startButton.addActionListener(new wciskStart());
    }
    
    // setters and getters
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

// słuchacz
class wciskStart implements ActionListener{
    private issAppController controller = new issAppController();
    
    //TODO: słuchacz przycisku [start]
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
        
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}