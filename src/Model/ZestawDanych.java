package Model;

import java.util.ArrayList;

public class ZestawDanych {
//    private ModelDanych model;
    private ArrayList<ModelDanych> dane;
    
    ZestawDanych() {
        dane = new ArrayList<>(20);
    }
    
    public void dodajOdczyt(long timestamp, double latitude, double longitude) {
        ModelDanych md = new ModelDanych(timestamp, latitude, longitude);
        dane.add(md);
    }
    
    public void dodajOdczyt(ModelDanych model) {
        dane.add(model);
    }
    
    public long rozmiarZestawu() {
        return dane.size();
    }
    
    public ModelDanych getNtyOdczyt(int index) {
        return dane.get(index);
    }
    
    public ModelDanych getPrzedOstatni() {
        return dane.get(dane.size() - 2);
    }
    
    public ModelDanych getOstatni() {
        return dane.get(dane.size() - 1);
    }
}
