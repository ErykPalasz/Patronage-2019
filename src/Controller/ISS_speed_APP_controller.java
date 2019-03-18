package Controller;

import Model.zestawDanychISS;
import Model.modelDanychISS;

import View.ISS_speed_App;

import static java.lang.Math.*;

public class ISS_speed_APP_controller implements Runnable{
    
    zestawDanychISS daneiss = new zestawDanychISS();
    ISS_speed_App widok;
    
    //todo pobranie danych z api
    //MOCK
    void MOCKdanychzAPI(int odczyt) {
        if (odczyt == 0) {
            dodajodczyt(1552696562, 51.3865, 4.7025);
        }else if (odczyt == 1) {
            dodajodczyt(1552696679, 51.5185, 16.3822);
        }else {
            System.out.println(odczyt);
        }
    }
    
    //przekazanie do modelu
    void dodajodczyt(int timestamp, double lati, double longi){
        daneiss.dodajOdczyt(timestamp,lati,longi);
    }
    
    // obliczanie prędkości z dwóch ostatnich odczytów
    double obliczPredkosc() {
        modelDanychISS a = daneiss.odczytPrzedOstatniElement();
        modelDanychISS b = daneiss.odczytOstatniElement();
        
        int R = 6371;
        double dLat = toRadians(b.Latitude() - a.Latitude());
        double dLon = toRadians(b.Longitude() - a.Longitude());
        double rLat1 = toRadians(a.Latitude());
        double rLat2 = toRadians(b.Latitude());
        double aa = sin(dLat/2) * sin(dLat/2) + cos(rLat1) * cos(rLat2) * sin(dLon/2) * sin(dLon/2);
        double cc = 2 * atan2(sqrt(aa), sqrt(1-aa));
        double dd = R * cc;
    
        return dd/(b.Timestamp()-a.Timestamp());
    }
    
    // obliczanie łącznej przebytej drogi na podstawie wszystkich odczytów
    double obliczDroge() {
        int index = 0;
        double droga=0;
        
        while (daneiss.odczytNtyElement(index + 1) != null){
            modelDanychISS a = daneiss.odczytNtyElement(index);
            modelDanychISS b = daneiss.odczytNtyElement(index + 1);
    
            int R = 6371;
            double dLat = toRadians(b.Latitude() - a.Latitude());
            double dLon = toRadians(b.Longitude() - a.Longitude());
            double rLat1 = toRadians(a.Latitude());
            double rLat2 = toRadians(b.Latitude());
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
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void buttonPress(){
        MOCKdanychzAPI(0);
//        for (int i = 0; i < 1; i++) {
            run();
            MOCKdanychzAPI(1);
            
            updateVelocityToView();
            updateDistanceToView();
//        }
    }
}