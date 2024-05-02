// SwimEntryTest.java
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwimEntryTest {

    @Test
    public void testGetWhere() {
        Entry instanceA = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "outdoors");
        String expResultA = "outdoors";
        // Cast the Entry instance to SwimEntry to access getWhere() method
        String resultA = ((SwimEntry) instanceA).getWhere();
        assertEquals(expResultA, resultA);

        Entry instanceB = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "pool");
        String expResultB = "in a pool";
        // Cast the Entry instance to SwimEntry to access getWhere() method
        String resultB = ((SwimEntry) instanceB).getWhere();
        assertEquals(expResultB, resultB);
    }

    @Test
    public void testGetEntry() {
        Entry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "outdoors");
        String expResult = "Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003\n";
        String result = instance.getEntry();
        assertEquals(expResult, result);
    }
}
