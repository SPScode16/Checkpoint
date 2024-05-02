// SprintEntryTest.java
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SprintEntryTest {

    @Test
    public void testGetRepetitions() {
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 4;
        // Cast the Entry instance to SprintEntry to access getRepetitions() method
        int result = ((SprintEntry) instance).getRepetitions();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRecovery() {
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 2;
        // Cast the Entry instance to SprintEntry to access getRecovery() method
        int result = ((SprintEntry) instance).getRecovery();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEntry() {
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        String expResult = "Alice sprinted 4x300m in 0:16:7 with 2 minutes recovery on 1/2/2003\n";
        String result = instance.getEntry();
        assertEquals(expResult, result);
    }
}
