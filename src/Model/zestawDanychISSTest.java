package Model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@Tag("Test")
public class zestawDanychISSTest {
    zestawDanychISS dane;
    
    @Test@DisplayName("Instancjonowanie")
    void instancjonowanie(){
        new zestawDanychISS();
    }
    
    @Nested@DisplayName("Kiedy nowa")
    class KiedyNowa {
    
        @BeforeEach
        void setUp() {
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