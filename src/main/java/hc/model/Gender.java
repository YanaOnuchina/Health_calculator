package hc.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * The class contains methods for personal calculation.
 *
 * @author Onuchina Yana.
 * @version 1.0.
 */
public class Gender implements Serializable {
    /**
     * One of the gender.
     */
    public static final Gender MALE = new Gender(-161, "Мужской");
    /**
     * One of the gender.
     */
    public static final Gender FEMALE = new Gender(5, "Женский");

    final private int value;
    final private String name;

    /**
     * Gender constructor gets gender information.
     *
     * @param value activity coefficient for gender.
     * @param name gender of a person.
     */
    public Gender(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * This method return gender information.
     *
     * @return activity coefficient for gender.
     */
    public int getValue() {
        return value;
    }

    /**
     * This method return gender of a person.
     *
     * @return name of gender.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * This method return object of activity.
     *
     * @param obj connected with activity
     * @return obj instanceof Gender
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Gender && Objects.equals(name, ((Gender) obj).name);
    }

}
