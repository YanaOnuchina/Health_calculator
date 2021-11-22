package hc.model;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Activity && Objects.equals(name, ((Activity) obj).name);
    }

    public float getCoefficient() {
        return coefficient;
    }
}
