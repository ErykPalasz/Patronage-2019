package Controller;

import Model.zestawDanychISS;
import Model.zestawDanychISSTest;
import View.issApp;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Test")
class operacjeNaDanychTest extends zestawDanychISSTest {
    zestawDanychISS dane;
    
    @Test
    @DisplayName("Instancjonowanie")
    void instancjonowanie(){
        new zestawDanychISS();
    }
    
    @Nested
    @DisplayName("Obliczenia")
    class Obliczenia {
    
        @BeforeEach
        void setUp() {
            dane = new zestawDanychISS();
            dane.dodajOdczyt(1552696562, 51.3865, 4.7025);  // 0
            dane.dodajOdczyt(1552696679, 51.5185, 16.3822); // 1
        }
    
        @Test
        @DisplayName("Liczenie pojedyńczego, najnowszego, fragmentu drogi")
        void liczDroge() {
            assertEquals(
                    808.5906322652344,
                    operacjeNaDanych.liczDroge(
                            dane.odczytPrzedOstatniElement(),
                            dane.odczytOstatniElement()
                    )
            );
        }
    
        @Test
        @DisplayName("Liczenie łącznej przebytej drogi")
        void liczLacznaDroge() {
            // tylko dwa parametry
            assertEquals(
                    operacjeNaDanych.liczDroge(
                            dane.odczytPrzedOstatniElement(), dane.odczytOstatniElement()
                    ),
                    operacjeNaDanych.liczLacznaDroge(dane),
                    "dwa parametry"
            );
        
            // dodaje trzeci i łączna droga powinna być większa
            dane.dodajOdczyt(1552696562, 51.3865, 4.7025);  // 0
            assertEquals(
                    operacjeNaDanych.liczDroge(
                            dane.odczytNtyElement(0),
                            dane.odczytNtyElement(1)
                    ) + operacjeNaDanych.liczDroge(
                            dane.odczytNtyElement(1),
                            dane.odczytNtyElement(2)
                    ),
                
                    operacjeNaDanych.liczLacznaDroge(dane),
                    "trzy parametry"
            );
        }
    
        @Test
        @DisplayName("Liczenie aktualnej prędkości względem ziemi")
        void liczPredkosc() {
            assertEquals(
                    6.911031045002003,
                    operacjeNaDanych.liczPredkosc(
                            dane.odczytPrzedOstatniElement(),
                            dane.odczytOstatniElement()
                    )
            );
        }
    }
}