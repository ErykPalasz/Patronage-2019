package Controller;

import Model.zestawDanychISSTest;
import View.issApp;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Test")
class przeplywDanychTest extends zestawDanychISSTest {
    
    //TODO: Aktualizacja
    //TODO: testy przekazania danych do widoku
    @Nested
    @DisplayName("Przekazania danych")
    class Przekazania{
        
        @BeforeEach
        void kontrolerPrzekazania() {
//            przeplyw = new issAppController.przeplywDanych();
//            widok = new issApp();
        }
        
        //TODO: TEST przekazanie predkosci
//                    @Test@DisplayName("")
        
        //TODO: TEST przekazanie drogi
        
        //TODO: TEST przekazanie postępu do licznika pięciosekundowego
    }
    
    @BeforeEach
    void setUp() {
    }
    
    @Test
    void dodajodczyt() {
    }
    
    @Test
    void pokazodczyt() {
    }
}