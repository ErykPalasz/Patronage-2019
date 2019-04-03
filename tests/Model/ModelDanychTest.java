package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelDanychTest {
    private ModelDanych model;
    
    @BeforeEach
    void setUp() {
        model = new ModelDanych(2137, 20.0002, 69.69);
    }
    
    @AfterEach
    void tearDown() {
        model = null;
    }
    
    @Test
    void getTimestamp() {
        assertEquals(2137, model.getTimestamp());
    }
    
    @Test
    void getLatitude() {
        assertEquals(20.0002, model.getLatitude());
    }
    
    @Test
    void getLongitude() {
        assertEquals(69.69, model.getLongitude());
    }
    
    @Test
    void dodawanie() {
        assertEquals(0.03, model.dodawanie(0.01, 0.02), "0.01 + 0.02 = 0.03");
    }
}