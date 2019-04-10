package Controller;

import Model.ZestawDanych;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObliczeniaTest {
    private ZestawDanych zestaw;
    
    @BeforeEach
    void setUp() {
        zestaw = new ZestawDanych();
        zestaw.dodajOdczyt(1552696562, 51.3865, 4.7025);
        zestaw.dodajOdczyt(1552696679, 51.5185, 16.3822);
    }
    
    @AfterEach
    void tearDown() {
        zestaw = null;
    }
    
    @Test
    void liczPredkosc() {
        assertEquals(
                6.911031045002003,
                Obliczenia.liczPredkosc(zestaw),
                "liczPredkosc(zestaw)"
        );
    }
    
    @Test
    void liczLacznaDroge() {
        assertEquals(
                808.5906322652344,
                Obliczenia.liczLacznaDroge(zestaw),
                "liczLacznaDroge(zestaw)"
        );
    }
}