import org.junit.jupiter.api.Test;

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
    void setPercentFull() {
        Cup c = new Cup("Orange Juice", 85.5);
        c.setPercentFull(90.5);
        assertEquals(90.5, c.getPercentFull(), 0.001);
    }
}