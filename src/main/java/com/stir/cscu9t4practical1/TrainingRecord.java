// TrainingRecord.java
package com.stir.cscu9t4practical1;

import java.util.ArrayList;
import java.util.List;

public class TrainingRecord {
    private List<Entry> entries;

    public TrainingRecord() {
        entries = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    // Lookup entry by date
    public String lookupEntry(int day, int month, int year) {
        StringBuilder result = new StringBuilder();
        boolean found = false;
        for (Entry e : entries) {
            if (e.getDay() == day && e.getMonth() == month && e.getYear() == year) {
                result.append(e.getEntry()).append("\n");
                found = true;
            }
        }
        if (!found) {
            result.append("Sorry couldn't find anything for this date");
        }
        return result.toString();
    }

    // Lookup entry by athlete's name
    public String lookupEntry(String name) {
        StringBuilder result = new StringBuilder();
        boolean found = false;
        for (Entry e : entries) {
            if (e.getName().equals(name)) {
                result.append(e.getEntry()).append("\n");
                found = true;
            }
        }
        if (!found) {
            result.append("Sorry couldn't find anything for this athlete");
        }
        return result.toString();
    }

    public Integer getNumberOfEntries() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumberOfEntries'");
    }
}
