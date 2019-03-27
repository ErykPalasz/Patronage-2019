package Controller;

import Model.modelDanychISS;
import Model.zestawDanychISS;

import static java.lang.Math.*;

public abstract class operacjeNaDanych {
    
    //TODO: ta metoda ma być 'niepubliczna' i wciąż dać się testować
    static double liczDroge(modelDanychISS a, modelDanychISS b){
        
        int R = 6371;
        double dLat = toRadians(b.latitude() - a.latitude());
        double dLon = toRadians(b.longitude() - a.longitude());
        double rLat1 = toRadians(a.latitude());
        double rLat2 = toRadians(b.latitude());
        double aa = sin(dLat/2) * sin(dLat/2) + cos(rLat1) * cos(rLat2) * sin(dLon/2) * sin(dLon/2);
        double cc = 2 * atan2(sqrt(aa), sqrt(1-aa));
        return R * cc;
    }
    
    public static double liczPredkosc(modelDanychISS a, modelDanychISS b){
        return liczDroge(a,b)/(b.timestamp()-a.timestamp());
    }
    
    public static double liczLacznaDroge(zestawDanychISS zestaw){
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
