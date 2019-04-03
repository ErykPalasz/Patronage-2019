package Controller;

import Model.ModelDanych;
import Model.ZestawDanych;
import org.jetbrains.annotations.NotNull;

import static java.lang.Math.*;
import static java.lang.Math.sqrt;

public abstract class Obliczenia {
    
    private static double liczDroge(@NotNull ModelDanych a, @NotNull ModelDanych b){
        
        int R = 6371;
        double dLat = toRadians(b.getLatitude() - a.getLatitude());
        double dLon = toRadians(b.getLongitude() - a.getLongitude());
        double rLat1 = toRadians(a.getLatitude());
        double rLat2 = toRadians(b.getLatitude());
        double aa = sin(dLat/2) * sin(dLat/2) + cos(rLat1) * cos(rLat2) * sin(dLon/2) * sin(dLon/2);
        double cc = 2 * atan2(sqrt(aa), sqrt(1-aa));
        return R * cc;
    }
    
    public static double liczPredkosc(@NotNull ZestawDanych zestaw){
        ModelDanych a = zestaw.getPrzedOstatni();
        ModelDanych b = zestaw.getOstatni();
        return liczDroge(a,b)/(b.getTimestamp()-a.getTimestamp()); // jednostka odległości / sekunde
    }
    
    public static double liczLacznaDroge(@NotNull ZestawDanych zestaw){
        int index = 0;
        double droga = 0.0;
        long size = zestaw.rozmiarZestawu()-1;
        ModelDanych a, b;
        
        while (index < size){
            a = zestaw.getNtyOdczyt(index);
            b = zestaw.getNtyOdczyt(index+1);
            
            droga += liczDroge(a, b);
            index++;
        }
        
        return droga;
    }
}