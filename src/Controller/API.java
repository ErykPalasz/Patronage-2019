package Controller;

import Model.ModelDanych;
import View.IssApp;

public abstract class API{
    
    //TODO: pobranie danych z api
    public ModelDanych pobierzDane(){
        /*
         * pobieranie danych
         * */

        /*
         * zwracanie tych danych
         * */
        return null;
    }

    // fake
    // 0 albo 1
    public static ModelDanych pobierzDane(long odczyt){
        ModelDanych model;
        if (odczyt == 0) {
            model = new ModelDanych(1552696562, 51.3865, 4.7025);
            return model;
        } else if (odczyt == 1) {
            model = new ModelDanych(1552696679, 51.5185, 16.3822);
            return model;
        } else return model = new ModelDanych(0, 0, 0);
    }

    // -----------------------------------------
    public static class licznik implements Runnable{
        
        private IssApp widok; //!
        
        double sekundy;
        // construktory
        public licznik(double sekundy){
            this.sekundy = sekundy;
        }
        public licznik(){
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
                    //TODO: return (?)
                    widok.updateLicznik(czas);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
