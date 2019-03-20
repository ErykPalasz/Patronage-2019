package Controller;

import Model.zestawDanychISS;
import Model.modelDanychISS;

import View.issApp;

import static java.lang.Math.*;

public class issAppController implements Runnable{
    
    zestawDanychISS daneiss = new zestawDanychISS();
    issApp widok;
    
    // licznik 5 sekund (pasek ładowania)
    public void run(){
        this.licznik();
    }
    
    void licznik(){
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
    
//    public void buttonPress(){
//        MOCKdanychzAPI(0);
//            run();
//            MOCKdanychzAPI(1);
//
//            updateVelocityToView();
//            updateDistanceToView();
//    }
    
    //###################################
    
    public static class obslugaAPI {
        przeplywDanych przeplyw = new przeplywDanych();
        
        //todo pobranie danych z api
        //MOCK
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
        
        // przekazanie do modelu
        void dodajodczyt(int timestamp, double lati, double longi){
            daneiss.dodajOdczyt(timestamp,lati,longi);
        }
        
        // przekazanie prędkości i odległości do widoku
//    void updateVelocityToView(){
//        widok.updatePredkosc(obliczPredkosc());
//    }
//
//    void updateDistanceToView(){
//        widok.updateDroga(obliczDroge());
//    }
    }
    
    public static class operacjeNaDanych {
        
        zestawDanychISS daneiss = new zestawDanychISS();
        
        double liczDroge(int index){
            modelDanychISS a = daneiss.odczytNtyElement(index);
            modelDanychISS b = daneiss.odczytNtyElement(index + 1);
            
            int R = 6371;
            double dLat = toRadians(b.latitude() - a.latitude());
            double dLon = toRadians(b.longitude() - a.longitude());
            double rLat1 = toRadians(a.latitude());
            double rLat2 = toRadians(b.latitude());
            double aa = sin(dLat/2) * sin(dLat/2) + cos(rLat1) * cos(rLat2) * sin(dLon/2) * sin(dLon/2);
            double cc = 2 * atan2(sqrt(aa), sqrt(1-aa));
            double dd = R * cc;
            
            return dd;
        }
        
        public double liczLacznaDroge(){
            int index = 0;
            double droga = 0.0;
            // int size = daneiss.rozmiarTablicy();
            
            while (daneiss.odczytNtyElement(index + 1) != null){
                droga += liczDroge(index);
                index++;
            }
            
            return droga;
        }
        
        public double liczPredkosc(){
            modelDanychISS a = daneiss.odczytPrzedOstatniElement();
            modelDanychISS b = daneiss.odczytOstatniElement();
            
            return liczDroge(daneiss.rozmiarTablicy() - 1)/(b.timestamp()-a.timestamp());
        }
    }
}