package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GroceryCounterTest {

    @Test
    void testInitialTotalAndOverflow() {
        GroceryCounter counter = new GroceryCounter();
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }

    @Test
    void testIncrementing() {
        GroceryCounter counter = new GroceryCounter();
        counter.tens();
        counter.tens();
        counter.hundreths();
        assertEquals("$20.01", counter.total());
    }

    @Test
    void testOverflow() {
        GroceryCounter counter = new GroceryCounter();
        for (int i = 0; i < 10000; i++) {
            counter.hundreths();
        }
        assertEquals("$0.00", counter.total());
        assertEquals(1, counter.overflows());
    }

    @Test
    void testClear() {
        GroceryCounter counter = new GroceryCounter();
        counter.tens();
        counter.ones();
        counter.clear();
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }
}
