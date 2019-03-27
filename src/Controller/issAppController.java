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
}

