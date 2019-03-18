package Controller;

import Model.daneISS;
import Model.modelDanychISS;

import View.ISS_speed_App;

import static java.lang.Math.*;

public class ISS_speed_APP_controller implements Runnable{
    
    daneISS daneiss = new daneISS();
    ISS_speed_App widok;
    
    //todo pobranie danych z api
    //**************** MOCK *********************
    void MOCKdanychzAPI() {
        dodajodczyt(1552696562, 51.3865, 4.7025);
        dodajodczyt(1552696679, 51.5185, 16.3822);
    }
    //*******************************************
    
    
    //przekazanie do modelu
    void dodajodczyt(int timestamp, double lati, double longi){
        daneiss.dodajOdczyt(timestamp,lati,longi);
    }
    
    // obliczanie prędkości z dwóch ostatnich odczytów
    double obliczPredkosc() {
        modelDanychISS a = daneiss.odczytPrzedOstatniElement();
        modelDanychISS b = daneiss.odczytOstatniElement();
        
        int R = 6371;
        double dLat = toRadians(b.getLatitude() - a.getLatitude());
        double dLon = toRadians(b.getLongitude() - a.getLongitude());
        double rLat1 = toRadians(a.getLatitude());
        double rLat2 = toRadians(b.getLatitude());
        double aa = sin(dLat/2) * sin(dLat/2) + cos(rLat1) * cos(rLat2) * sin(dLon/2) * sin(dLon/2);
        double cc = 2 * atan2(sqrt(aa), sqrt(1-aa));
        double dd = R * cc;
    
        return dd/(b.getTimestamp()-a.getTimestamp());
    }
    
    // obliczanie łącznej przebytej drogi na podstawie wszystkich odczytów
    double obliczDroge() {
        int index = 0;
        double droga=0;
        
        while (daneiss.odczytIndexElement(index + 1) != null){
            modelDanychISS a = daneiss.odczytIndexElement(index);
            modelDanychISS b = daneiss.odczytIndexElement(index + 1);
    
            int R = 6371;
            double dLat = toRadians(b.getLatitude() - a.getLatitude());
            double dLon = toRadians(b.getLongitude() - a.getLongitude());
            double rLat1 = toRadians(a.getLatitude());
            double rLat2 = toRadians(b.getLatitude());
            double aa = sin(dLat/2) * sin(dLat/2) + cos(rLat1) * cos(rLat2) * sin(dLon/2) * sin(dLon/2);
            double cc = 2 * atan2(sqrt(aa), sqrt(1-aa));
            double dd = R * cc;
    
            droga += dd;
        }
        
        return droga;
    }
    
    // przekazanie prędkości i odległości do widoku
    void updateVelocityToView(){
        widok.updatePredkosc(obliczPredkosc());
    }
    void updateDistanceToView(){
        widok.updateDroga(obliczDroge());
    }
    
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
                Thread.sleep(10L);    // 1000L = 1000 ms = 1 s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
