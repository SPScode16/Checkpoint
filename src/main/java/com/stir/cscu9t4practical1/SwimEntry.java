// SwimEntry.java
package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {
    private String where;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String where) {
        super(n, d, m, y, h, min, s, dist);
        this.where = where;
    }

    // Getter for specific attribute of SwimEntry
    public String getWhere() {
        if (where.equals("outdoors")) {
            return "outdoors";
        } else {
            return "in a pool";
        }
    }

    // Overriding the getEntry method to include where the swim took place
    @Override
    public String getEntry() {
        return getName() + " swam " + getDistance() + " km " + getWhere() + " in "
                + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
    }
}
