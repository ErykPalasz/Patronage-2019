package Controller;

/*==================================================
* pobiera dane z API i zapisuje je do ZESTAWU danych
* ==================================================*/
public abstract class obslugaAPI extends przeplywDanych{
    
    //TODO: pobranie danych z api
    void MOCKdanychzAPI(int odczyt) {
        if (odczyt == 0) {
            dodajodczyt(1552696562, 51.3865, 4.7025);
        }else if (odczyt == 1) {
            dodajodczyt(1552696679, 51.5185, 16.3822);
        }else {
            System.out.println(odczyt);
        }
    }
}
