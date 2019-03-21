package Controller;

import Model.zestawDanychISS;
import Model.modelDanychISS;

import View.issApp;

import static java.lang.Math.*;

public class issAppController implements Runnable{
    
    zestawDanychISS daneiss = new zestawDanychISS();
    private issApp widok;
    
    //licznik 5 sekund (pasek ładowania)
    public void run(){
        this.licznik();
    }
    
    private void licznik(){
        double czas = 5.0;
        while (czas>0){
            try {
                czas -= 0.01;
                widok.updateLicznik(czas);
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
//    //TODO: zaktualizować funkcjonalność przycisku
//    public void buttonPress(){
//        MOCKdanychzAPI(0);
//            run();
//            MOCKdanychzAPI(1);
//
//            updateVelocityToView();
//            updateDistanceToView();
//    }

    public static class obslugaAPI {
        przeplywDanych przeplyw = new przeplywDanych();
        
        //TODO: pobranie danych z api
        void MOCKdanychzAPI(int odczyt) {
            if (odczyt == 0) {
                przeplyw.dodajodczyt(1552696562, 51.3865, 4.7025);
            }else if (odczyt == 1) {
                przeplyw.dodajodczyt(1552696679, 51.5185, 16.3822);
            }else {
                System.out.println(odczyt);
            }
        }
    }
    
    public static class przeplywDanych {
        zestawDanychISS daneiss = new zestawDanychISS();
        issApp widok = new issApp();
        operacjeNaDanych operacje;
        
        // przekazanie do modelu
        //TODO: ????? przekazać obiekt zamiast danych
        void dodajodczyt(int timestamp, double lati, double longi){
            daneiss.dodajOdczyt(timestamp,lati,longi);
        }
        
        //TODO: nie wiem co, ale ma się dać testować
        modelDanychISS pokazodczyt(int index){
            return daneiss.odczytNtyElement(index);
        }
        
//        //przekazanie prędkości i odległości do widoku
//        //TODO: dogonić aktualizację
//        void updateVelocityToView(){
//            operacje = new operacjeNaDanych();
//            widok.updatePredkosc(operacje.liczPredkosc());
//        }

//        //TODO: dogonić aktualizację
//        void updateDistanceToView(){
//            operacje = new operacjeNaDanych();
//            widok.updateDroga(operacje.liczDroge());
//        }
    }
    
    public static class operacjeNaDanych {
        
        //TODO: ta metoda ma być 'niepubliczna' i wciąż dać się testować
        public double liczDroge(modelDanychISS a, modelDanychISS b){
            
            int R = 6371;
            double dLat = toRadians(b.latitude() - a.latitude());
            double dLon = toRadians(b.longitude() - a.longitude());
            double rLat1 = toRadians(a.latitude());
            double rLat2 = toRadians(b.latitude());
            double aa = sin(dLat/2) * sin(dLat/2) + cos(rLat1) * cos(rLat2) * sin(dLon/2) * sin(dLon/2);
            double cc = 2 * atan2(sqrt(aa), sqrt(1-aa));
            return R * cc;
        }
    
        public double liczPredkosc(modelDanychISS a, modelDanychISS b){
            return liczDroge(a,b)/(b.timestamp()-a.timestamp());
        }
        
        public double liczLacznaDroge(zestawDanychISS zestaw){
            int index = 0;
            double droga = 0.0;
            int size = zestaw.rozmiarTablicy()-1;
            modelDanychISS a, b;
            

            while (index < size){
                a = zestaw.odczytNtyElement(index);
                b = zestaw.odczytNtyElement(index+1);
                
                droga += liczDroge(a, b);
                index++;
            }

            return droga;
        }
    }
}