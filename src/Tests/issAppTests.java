package Tests;
import Controller.issAppController;
import Model.zestawDanychISS;
import View.issApp;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//todo poprekładać klasy testów do odpowiednich pakietów
// niestety nie da się mieć wszystkiego w jednym pliczku :(

//        dane.dodajOdczyt(1552696562, 51.3865, 4.7025);  // 0
//        dane.dodajOdczyt(1552696679, 51.5185, 16.3822); // 1

@DisplayName("Testy zestawu danych")
class testyDanych {
    zestawDanychISS dane;
    
    @Test@DisplayName("Działa instancjonowanie")
    void jestInstancjonowane(){
        new zestawDanychISS();
    }
    
    @Nested@DisplayName("Kiedy nowa")
    class KiedyNowe{
        
        @BeforeEach
        void nowaTablica(){
            dane = new zestawDanychISS();
        }
        
        @Test@DisplayName("Jest pusta")
        void jestPusta(){
            assertEquals(0,dane.rozmiarTablicy());
        }
        
        @Nested@DisplayName("Po dodaniu elementu")
        class PoDodaniu{
            
            @BeforeEach
            void dodajElement(){
                dane.dodajOdczyt(1552696562, 51.3865, 4.7025);  // 0
                dane.dodajOdczyt(1552696679, 51.5185, 16.3822); // 1
            }
            
            @Test@DisplayName("Już nie jest pusta")
            void nieJestPusta(){
                assertEquals(2,dane.rozmiarTablicy());
                assertNotNull(dane);
            }
            
            @Nested@DisplayName("Zwraca poprawnie element")
            class OdpowiednieElementy{
                
                @Test@DisplayName("Ostatni")
                void ostatniElement(){
                    assertEquals(1552696679,dane.odczytNtyElement(dane.rozmiarTablicy()-1).timestamp());
                    assertEquals(dane.odczytNtyElement(dane.rozmiarTablicy()-1),dane.odczytOstatniElement());
                }
                
                @Test@DisplayName("Przedostatni")
                void przedostatniElement(){
                    assertEquals(1552696562,dane.odczytNtyElement(dane.rozmiarTablicy()-2).timestamp());
                    assertEquals(dane.odczytNtyElement(dane.rozmiarTablicy()-2),dane.odczytPrzedOstatniElement());
                }
            }
        }
    }
}

class testyWidoku {
    private final issApp widok = new issApp();
    
    @Test
    void testAktualizacjiPredkosci() {
        widok.updatePredkosc(1.2);
        assertEquals("1.2", widok.getPredkosc());
    }
    
    @Test
    void testAktualizacjiDrogi() {
        widok.updateDroga(1.2);
        assertEquals("1.2", widok.getDroga());
    }
    
    @Test
    void testAktualizacjiLicznika(){
        assertAll("licznik",()->{
            widok.updateLicznik(5);
            assertEquals("100%", widok.getLicznik());
            
            widok.updateLicznik(0);
            assertEquals("0%", widok.getLicznik());
            
            widok.updateLicznik(2.5);
            assertEquals("50%", widok.getLicznik());
        });
    }
}

class testyOperacjiNaDanych {
    private final issApp widok = new issApp();
    private final zestawDanychISS dane = new zestawDanychISS();
    private final issAppController.operacjeNaDanych operacje = new issAppController.operacjeNaDanych();
    
    @BeforeEach
    void init(){
        dane.dodajOdczyt(1552696562, 51.3865, 4.7025);  // 0
        dane.dodajOdczyt(1552696679, 51.5185, 16.3822); // 1
    }
    
    @Test
    void testLiczeniaDrogi(){
        assertAll("pojedynczy fragment drogi",()->{
            assertEquals(117,(dane.odczytOstatniElement().timestamp() - dane.odczytPrzedOstatniElement().timestamp()));
        });
    }
    
    @Test
    void testLiczeniaLaczenjdrogi(){
        dane.dodajOdczyt(1552696562, 51.3865, 4.7025);
        dane.dodajOdczyt(1552696679, 51.5185, 16.3822);
        
        assertAll("cała droga",()->{
        
        });
    }
    
    @Test
    void testLiczeniaPredkosci(){
        dane.dodajOdczyt(1552696562, 51.3865, 4.7025);
        dane.dodajOdczyt(1552696679, 51.5185, 16.3822);
        
        assertAll("prędkość",()->{
        
        });
    }
}