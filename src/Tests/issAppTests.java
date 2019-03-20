package Tests;
import Controller.issAppController;
import Model.zestawDanychISS;
import View.issApp;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testy zestawu danych")
class testyDanych {
    private zestawDanychISS dane;
    private issApp widok;
    private issAppController kontroler; // licznik
    private issAppController.operacjeNaDanych operacje; // obliczenia
    private issAppController.przeplywDanych przeplyw; // przepływ
    private issAppController.obslugaAPI api;
    
    @Test@DisplayName("Działa instancjonowanie")
    void jestInstancjonowane(){
        new zestawDanychISS();
        new issApp();
        new issAppController();
        new issAppController.operacjeNaDanych();
        new issAppController.przeplywDanych();
        new issAppController.obslugaAPI();
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
            
            @Nested@DisplayName("Wykonuje poprawnie operacje")
            class OperacjeNaDanych{
                
                @BeforeEach
                void kontrolerOperacji(){
                    operacje = new issAppController.operacjeNaDanych();
                }
                
                @Test@DisplayName("Liczenie pojedyńczego, najnowszego, fragmentu drogi")
                void liczPojFragDrogi(){
                    assertEquals(808.5906322652344,operacje.liczDroge(dane.odczytPrzedOstatniElement(),dane.odczytOstatniElement()));
                }
                
//                @Disabled
//                @Test@DisplayName("Liczenie łącznej przebytej drogi")
//                void liczCalaDroga(){
//                    fail("jeszcze nie zaimplementowane");
//                }
                
                @Test@DisplayName("Liczenie aktualnej prędkości względem ziemi")
                void liczAktuPredkosc(){
                    assertEquals(6.911031045002003,operacje.liczPredkosc(dane.odczytPrzedOstatniElement(),dane.odczytOstatniElement()));
    
                }
            }
        }
    }
}

@Deprecated
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