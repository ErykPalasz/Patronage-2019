package Controller;

import Model.modelDanychISS;
import Model.zestawDanychISS;
import View.issApp;

/*==========================================
* przekazuje dane między ZESTAWEM i WIDOKIEM
* ==========================================*/
public abstract class przeplywDanych{
    issApp widok;
    zestawDanychISS zestaw = new zestawDanychISS();
    
    // przekazanie do modelu
    //TODO: przekazać obiekt zamiast danych
    public void dodajodczyt(int timestamp, double lati, double longi){
        zestaw.dodajOdczyt(timestamp,lati,longi);
    }
    
    //TODO: nie wiem, ale ma się dać testować
    public modelDanychISS pokazodczyt(int index){
        return zestaw.odczytNtyElement(index);
    }

    //przekazanie prędkości i odległości do widoku
    void updateVelocityToView(){
        widok.updatePredkosc(
                ObliczeniaNaDanych.liczPredkosc(zestaw)
        );
    }
        
    void updateDistanceToView(){
            widok.updateDroga(
                    ObliczeniaNaDanych.liczLacznaDroge(zestaw)
            );
        }
}
