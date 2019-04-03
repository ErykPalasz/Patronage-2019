package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZestawDanychTest {
    private ZestawDanych zestaw;
    private ModelDanych model0;
    private ModelDanych model1;
    
    @BeforeEach
    void setUp() {
        zestaw = new ZestawDanych();
    }
    
    @AfterEach
    void tearDown() {
        zestaw = null;
    }
    
    @Test
    void przedDodaniem() {
        assertEquals(0,
                zestaw.rozmiarZestawu(),
                "rozmiar przed dodaniem"
        );
    }
    
    @Nested
    class PoDodaniu {
        
        @BeforeEach
        void dodajDane() {
            model0 = new ModelDanych(1552696562, 51.3865, 4.7025);
            model1 = new ModelDanych(1552696679, 51.5185, 16.3822);
    
            zestaw.dodajOdczyt(model0);
            zestaw.dodajOdczyt(1552696679, 51.5185, 16.3822);
        }
    
        @Test
        void rozmiarZestawu() {
            assertEquals(2,
                    zestaw.rozmiarZestawu(),
                    "rozmiar po dodaniu"
            );
        }
    
        @Test
        void getNtyOdczyt() {
            assertAll("[model0] Nty odczyt",
                    () -> assertEquals(model0.getTimestamp(), zestaw.getNtyOdczyt(0).getTimestamp(),"timestamp"),
                    () -> assertEquals(model0.getLatitude(), zestaw.getNtyOdczyt(0).getLatitude(),"latitude"),
                    () -> assertEquals(model0.getLongitude(), zestaw.getNtyOdczyt(0).getLongitude(),"longitude")
            );
            assertAll("[model1] Nty odczyt",
                    () -> assertEquals(model1.getTimestamp(), zestaw.getNtyOdczyt(1).getTimestamp(),"timestamp"),
                    () -> assertEquals(model1.getLatitude(), zestaw.getNtyOdczyt(1).getLatitude(),"latitude"),
                    () -> assertEquals(model1.getLongitude(), zestaw.getNtyOdczyt(1).getLongitude(),"longitude")
            );
        }
    
        @Test
        void getPrzedOstatni() {
            assertAll("[model0] get przedostatni odczyt",
                    () -> assertEquals(model0.getTimestamp(), zestaw.getPrzedOstatni().getTimestamp()),
                    () -> assertEquals(model0.getLatitude(), zestaw.getPrzedOstatni().getLatitude()),
                    () -> assertEquals(model0.getLongitude(), zestaw.getPrzedOstatni().getLongitude())
            );
        }
    
        @Test
        void getOstatni() {
            assertAll(
                    () -> assertEquals(model1.getTimestamp(), zestaw.getOstatni().getTimestamp()),
                    () -> assertEquals(model1.getLatitude(), zestaw.getOstatni().getLatitude()),
                    () -> assertEquals(model1.getLongitude(), zestaw.getOstatni().getLongitude())
            );
        }
    }
}