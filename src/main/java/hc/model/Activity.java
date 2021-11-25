package hc.model;

import java.io.Serializable;
import java.util.Objects;
/**
 * The class contains methods for personal calculation.
 *
 * @author Onuchina Yana.
 * @version 1.0.
 */
public class Activity implements Serializable {

    public static final Activity LOWEST = new Activity("Отсутствует или минимальная", 1.2f);
    public static final Activity LOW = new Activity("Тренировка 3 раза в неделю", 1.38f);
    public static final Activity MEDIUM = new Activity("Тренировка 5 раз в неделю", 1.46f);
    public static final Activity HIGH = new Activity("Тренировка каждый день", 1.64f);
    public static final Activity HIGHEST = new Activity("Физическая работа", 1.9f);

    final private String name;
    final private float coefficient;

    /**
     * Activity constructor gets activity information.
     *
     * @param name of activity.
     * @param coefficient coefficient for activity.
     */
    public Activity(String name, float coefficient) {
        this.name = name;
        this.coefficient = coefficient;
    }

    /**
     * This constructor return name information.
     *
     * @return name of activity.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * This constructor return obj instanceof Activity information.
     *
     * @param obj connected with activity.
     * @return obj instanceof Activity information.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Activity && Objects.equals(name, ((Activity) obj).name);
    }

    /**
     * This constructor return obj instanceof Activity information.
     *
     * @return coefficient for activity
     */
    public float getCoefficient() {
        return coefficient;
    }
}
