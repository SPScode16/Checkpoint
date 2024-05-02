// CycleEntryTest.java
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CycleEntryTest {

    @Test
    public void testGetTerrain() {
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        String expResult = "asphalt";
        // Cast the Entry instance to CycleEntry to access getTerrain() method
        String result = ((CycleEntry) instance).getTerrain();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTempo() {
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        String expResult = "moderate";
        // Cast the Entry instance to CycleEntry to access getTempo() method
        String result = ((CycleEntry) instance).getTempo();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEntry() {
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        String expResult = "Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo\n";
        String result = instance.getEntry();
        assertEquals(expResult, result);
    }
}
