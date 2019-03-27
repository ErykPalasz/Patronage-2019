package Controller;

import View.issApp;

/*==================================================
* pobiera dane z API i zapisuje je do ZESTAWU danych
* ==================================================*/
public class API extends przeplywDanych{
    
    //TODO: pobranie danych z api
    private void pobierzDane(){
        /*
        * pobieranie danych
        * */
        
        /*
        * zapis tych danych
        * */
        // dodajodczyt( coś );
    }
    
    // 0 albo 1
    private void pobierzDane(int odczyt){
        /*
        * udawanie pobierania danych z API
        * */
        
        /*
        * zapis tych danych
        * */
        switch (odczyt){
            case 0:
                dodajodczyt(1552696562, 51.3865, 4.7025);
                break;
            case 1:
                dodajodczyt(1552696679, 51.5185, 16.3822);
                break;
        }
    }
    
    private class licznik implements Runnable{
        double sekundy;
        licznik(double sekundy){
            this.sekundy = sekundy;
        }
        licznik(){
            this.sekundy = 5.0;
        }
        
        @Override
        public void run() {
            this.liczSekundy(sekundy);
        }
        
        private void liczSekundy(double sekundy){
            double czas = sekundy;
            while (czas>0){
                try {
                    czas -= 0.01;
                    Thread.sleep(10L);
                    widok.updateLicznik(czas);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void buttonPress(){
        licznik licz = new licznik(7.0);
        int c = 0;
    
        do {
            pobierzDane(c);
        
            if (c > 0) {
                updateVelocityToView();
                updateDistanceToView();
            }
        
            licz.run(); c++;
        
        } while (c <= 1);
    }
}
