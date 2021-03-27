import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    @Test
    void getLiquidType() {
        Cup c = new Cup("Orange Juice", 85.5);
        assertEquals("Orange Juice", c.getLiquidType());
    }

    @Test
    void getPercentFull() {
        Cup c = new Cup("Orange Juice", 85.5);
        assertEquals(85.5, c.getPercentFull(), 0.001);
    }

    @Test
    void setLiquidType() {
        Cup c = new Cup("Orange Juice", 85.5);
        c.setLiquidType("water");
        assertEquals("water", c.getLiquidType());
    }

    @Test
    void testIsEmpty() {
        Cup c = new Cup("Orange Juice", 85.5);
        assertFalse(c.isEmpty());
    }

    @Test
    void testSetBadPercentThrows(){
        Cup c = new Cup("Orange Juice", 85.5);

        assertThrows(IllegalArgumentException.class,
                () -> c.setPercentFull(-1)
        );
    }
    @Test
    void setPercentFull() {
        Cup c = new Cup("Orange Juice", 85.5);
        c.setPercentFull(90.5);
        assertEquals(90.5, c.getPercentFull(), 0.001);
    }

    @Test
    void testSetLiquidWithNull(){
        Cup c = new Cup("Water", 75.5);
        c.setLiquidType(null);
        assertNotNull(c.getLiquidType());
    }

    @Disabled("Disable until bug fixed...")
    @Test
    void testToTestExternalLibrary(){
        //external code
        //...
        fail();
    }

    @Test
    void testObjectCreation(){
        Cup c = new Cup("Water", 75.5);
        assertEquals("Water", c.getLiquidType());
        assertEquals(75.5, c.getPercentFull(), 0.001);
    }
    // similar to above but runs all asserts and returns results of
    // each instead of stopping function after first fail.
    @Test
    void testObjectCreationWithAssertAll(){
        Cup c = new Cup("Water", 75.5);
        assertAll("Correctly builds object",
                () -> assertEquals("Water", c.getLiquidType()),
                () -> assertEquals(75.5, c.getPercentFull(), 0.001)
        );
    }

    public double guessThePercent(Cup c){
        while(true){
            double guess = (Math.random() * (100 - 0) + 0);
            if(Math.abs(guess - c.getPercentFull()) < 1){
                return guess;
            }
        }
    }

    @Test
    void guessThePercent(){
        Cup c = new Cup("Water", 50);
        assertTimeoutPreemptively(Duration.ofSeconds(5),
                () -> guessThePercent(c) > 0);
    }
}