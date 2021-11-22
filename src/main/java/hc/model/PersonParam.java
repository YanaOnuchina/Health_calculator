package hc.model;

import java.io.Serializable;
import java.util.Date;

public class PersonParam implements Serializable {

    private float weight;
    private float height;
    private int age;
    private Gender gender;
    private Activity activity;
    private Date date;

    public PersonParam() {}

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setDate(Date date) {this.date = date;}

    public Date getDate(){
        return date;
    }

    public float getNorma() {
        return activity.getCoefficient() * (weight*10 + height*6.25f - age*5 + gender.getValue());
    }
}
