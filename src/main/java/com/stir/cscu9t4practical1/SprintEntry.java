// SprintEntry.java
package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {
    private int repetitions;
    private int recovery;

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int repetitions, int recovery) {
        super(n, d, m, y, h, min, s, dist);
        this.repetitions = repetitions;
        this.recovery = recovery;
    }

    // Getters for specific attributes of SprintEntry
    public int getRepetitions() {
        return repetitions;
    }

    public int getRecovery() {
        return recovery;
    }

    // Overriding the getEntry method to include repetitions and recovery
    @Override
    public String getEntry() {
        return getName() + " sprinted " + repetitions + "x" + getDistance() + "m in "
                + getHour() + ":" + getMin() + ":" + getSec() + " with " + recovery +
                " minutes recovery on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
    }
}
