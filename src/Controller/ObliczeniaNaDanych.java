package Controller;

import Model.modelDanychISS;
import Model.zestawDanychISS;
import org.jetbrains.annotations.NotNull;

import static java.lang.Math.*;

/*================================================
* dokonuje OBLICZEŃ na podstawie dostępnych danych
* ================================================*/
public abstract class ObliczeniaNaDanych {
    
    static double liczDroge(@NotNull modelDanychISS a, @NotNull modelDanychISS b){
        
        int R = 6371;
        double dLat = toRadians(b.latitude() - a.latitude());
        double dLon = toRadians(b.longitude() - a.longitude());
        double rLat1 = toRadians(a.latitude());
        double rLat2 = toRadians(b.latitude());
        double aa = sin(dLat/2) * sin(dLat/2) + cos(rLat1) * cos(rLat2) * sin(dLon/2) * sin(dLon/2);
        double cc = 2 * atan2(sqrt(aa), sqrt(1-aa));
        return R * cc;
    }
    
    public static double liczPredkosc(@NotNull zestawDanychISS zestaw){
        modelDanychISS a = zestaw.odczytPrzedOstatniElement();
        modelDanychISS b = zestaw.odczytOstatniElement();
        return liczDroge(a,b)/(b.timestamp()-a.timestamp()); // jednostka odległości / sekunde
    }
    
    public static double liczLacznaDroge(@NotNull zestawDanychISS zestaw){
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
