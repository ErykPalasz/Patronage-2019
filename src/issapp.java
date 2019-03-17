import View.GUI;

public class issapp {
    public static void main(String[] args) {
        // URL url = new URL("http://api.open-notify.org/iss-now.json");
        
        // **************** MOCK *********************
        int timestamp1 = 1552696562, timestamp2 = 1552696679;
        double latitude1 = 51.3865, longitude1 = 4.7025,
                latitude2 = 51.5185, longitude2 = 16.3822;
        // *******************************************
        GUI gui = new GUI();
        gui.setVisible(true);
    
        //TODO: widok: GUI z przyciskami
        //TODO: kontroler: przekazanie danych do i z modelu
        //TODO: model: magazynowanie danych i obliczenia
    }
}
