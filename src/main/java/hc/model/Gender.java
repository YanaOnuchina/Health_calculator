package hc.model;

import java.io.Serializable;

public class Gender implements Serializable {
    final private int value;
    final private String name;

    public Gender(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}
