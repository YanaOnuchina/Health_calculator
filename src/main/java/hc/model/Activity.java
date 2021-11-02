package hc.model;

import java.io.Serializable;

public class Activity implements Serializable {

    final private String name;
    final private float coefficient;

    public Activity(String name, float coefficient) {
        this.name = name;
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return name;
    }

    public float getCoefficient() {
        return coefficient;
    }
}
