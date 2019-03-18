package Model;

import java.util.ArrayList;

public class zestawDanychISS {
    
    private ArrayList<modelDanychISS> zestawDanychISS;
    private modelDanychISS mdiss;
    
    public zestawDanychISS(){
        zestawDanychISS = new ArrayList<>(2);
        mdiss = new modelDanychISS();
    }
    
    public void dodajOdczyt(long czas, double lati, double longi) {
        mdiss.setTimestamp(czas);
        mdiss.setLatitude(lati);
        mdiss.setLongitude(longi);
        zestawDanychISS.add(mdiss);
    }
    
    public int rozmiarTablicy(){
        return zestawDanychISS.size();
    }
    
    public modelDanychISS odczytNtyElement(int index) {
        mdiss = zestawDanychISS.get(index);
        return mdiss;
    }
    
    public modelDanychISS odczytOstatniElement() {
        mdiss = zestawDanychISS.get(zestawDanychISS.size() - 1);
        return mdiss;
    }
    
    public modelDanychISS odczytPrzedOstatniElement() {
        mdiss = zestawDanychISS.get(zestawDanychISS.size() - 2);
        return mdiss;
    }
}
