package hc.model;

import java.io.Serializable;
import java.util.Objects;

public class Activity implements Serializable {

    public static final Activity LOWEST = new Activity("Отсутствует или минимальная", 1.2f);
    public static final Activity LOW = new Activity("Тренировка 3 раза в неделю", 1.38f);
    public static final Activity MEDIUM = new Activity("Тренировка 5 раз в неделю", 1.46f);
    public static final Activity HIGH = new Activity("Тренировка каждый день", 1.64f);
    public static final Activity HIGHEST = new Activity("Физическая работа", 1.9f);

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
