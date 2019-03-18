package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class daneISS {
    
    private ArrayList<modelDanychISS> zestawDanychISS = new ArrayList<>();
    private modelDanychISS mdi;
    
    public void dodajOdczyt(int czas, double lati, double longi) {
        mdi.setTimestamp(czas);
        mdi.setLatitude(lati);
        mdi.setLongitude(longi);
        
        zestawDanychISS.add(mdi);
    }
    
    public modelDanychISS odczytIndexElement(int index) {
        mdi = zestawDanychISS.get(index);
        return mdi;
    }
    
    public modelDanychISS odczytOstatniElement() {
        mdi = zestawDanychISS.get(zestawDanychISS.size() - 1);
        return mdi;
    }
    
    public modelDanychISS odczytPrzedOstatniElement() {
        mdi = zestawDanychISS.get(zestawDanychISS.size() - 2);
        return mdi;
    }
    
    //todo odczyt predkosci
    //todo odczyt drogi
   
}
