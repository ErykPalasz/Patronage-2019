package Model;

import java.util.ArrayList;

public class zestawDanychISS {
    
    private ArrayList<modelDanychISS> zestawDanychISS;
    
    public zestawDanychISS(){
        zestawDanychISS = new ArrayList<>(2);
    }
    
    // zapis
    public void dodajOdczyt(long timestamp, double latitude, double longitude) {
        modelDanychISS mdiss = new modelDanychISS(timestamp, latitude, longitude);
        zestawDanychISS.add(mdiss);
    }
    
    // ilość elementów
    public int rozmiarTablicy(){
        return zestawDanychISS.size();
    }
    
    // odczyt
    public modelDanychISS odczytNtyElement(int index) {
        return zestawDanychISS.get(index);
    }
    
    public modelDanychISS odczytOstatniElement() {
        return zestawDanychISS.get(zestawDanychISS.size() - 1);
    }
    
    public modelDanychISS odczytPrzedOstatniElement() {
        return zestawDanychISS.get(zestawDanychISS.size() - 2);
    }
}
