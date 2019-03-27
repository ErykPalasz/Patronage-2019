package View;

import Model.zestawDanychISSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Test")
class issAppTest extends zestawDanychISSTest {
    //TODO: aktualizacja
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
            assertAll("licznik",
                    ()-> {
                        widok.updateLicznik(5);
                        assertEquals("100%", widok.getLicznik());
                    },
                    ()-> {
                        widok.updateLicznik(0);
                        assertEquals("0%", widok.getLicznik());
                    },
                    ()-> {
                        widok.updateLicznik(2.5);
                        assertEquals("50%", widok.getLicznik());
                    }
            );
        }
    }
    
    
    @BeforeEach
    void setUp() {
    }
    
    @Test
    void updatePredkosc() {
    }
    
    @Test
    void getPredkosc() {
    }
    
    @Test
    void updateDroga() {
    }
    
    @Test
    void getDroga() {
    }
    
    @Test
    void updateLicznik() {
    }
    
    @Test
    void getLicznik() {
    }
}