package Testy;
import Model.zestawDanychISS;
import View.ISS_speed_App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestyDanych {
    private final zestawDanychISS testDanych = new zestawDanychISS();
    
    @Test
    void testZapisuDanych(){
        
        testDanych.dodajOdczyt(1552696562, 51.3865, 4.7025);
        assertAll("pierwszy odczyt", ()->{
            assertEquals(1552696562, testDanych.odczytNtyElement(testDanych.rozmiarTablicy() - 1).Timestamp());
            assertEquals(51.3865, testDanych.odczytNtyElement(testDanych.rozmiarTablicy() - 1).Latitude());
            assertEquals(4.7025, testDanych.odczytNtyElement(testDanych.rozmiarTablicy() - 1).Longitude());
        });
        
        testDanych.dodajOdczyt(1552696679, 51.5185, 16.3822);
        assertAll("drugi odczyt", ()->{
            assertEquals(1552696679, testDanych.odczytNtyElement(testDanych.rozmiarTablicy() - 1).Timestamp());
            assertEquals(51.5185, testDanych.odczytNtyElement(testDanych.rozmiarTablicy() - 1).Latitude());
            assertEquals(16.3822, testDanych.odczytNtyElement(testDanych.rozmiarTablicy() - 1).Longitude());
        });
    }
    
    @Test
    void testIstnieniaDanych(){
        testDanych.dodajOdczyt(1552696562, 51.3865, 4.7025);
        testDanych.dodajOdczyt(1552696679, 51.5185, 16.3822);
        assertEquals(2, testDanych.rozmiarTablicy());
        
        testDanych.dodajOdczyt(1552696679, 51.5185, 16.3822);
        assertEquals(3, testDanych.rozmiarTablicy());
    }
}


