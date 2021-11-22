package hc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Gender && Objects.equals(name, ((Gender) obj).name);
    }

}
