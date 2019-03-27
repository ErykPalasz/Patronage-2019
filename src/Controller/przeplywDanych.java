package Controller;

import Model.modelDanychISS;
import Model.zestawDanychISS;
import View.issApp;
/*==========================================
* przekazuje dane między ZESTAWEM i WIDOKIEM
* ==========================================*/
public abstract class przeplywDanych extends zestawDanychISS{
    // przekazanie do modelu
    //TODO: ????? przekazać obiekt zamiast danych
    public void dodajodczyt(int timestamp, double lati, double longi){
        dodajOdczyt(timestamp,lati,longi);
    }
    
    //TODO: nie wiem co, ale ma się dać testować
    public modelDanychISS pokazodczyt(int index){
        return odczytNtyElement(index);
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
