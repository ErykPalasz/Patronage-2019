package View;

import javax.swing.*;

public class ISS_speed_App extends JFrame {
    
    public JPanel panel1;
    private JButton startButton;
    private JProgressBar piecsekund;
    private JComboBox comboBoxIlosc;
    private JLabel obliczDroga;
    private JLabel obliczPredkosc;
    
    public void updatePredkosc(double vel){
        obliczPredkosc.setText(String.valueOf(vel));
    }
    
    public void updateDroga(double dis){
        obliczDroga.setText(String.valueOf(dis));
    }
}
