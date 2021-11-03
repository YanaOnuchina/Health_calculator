package hc;

import hc.model.Activity;
import hc.model.Gender;
import hc.model.Person;

import javax.swing.*;
import java.awt.*;
import java.io.*;


public class PersonalData extends JDialog{

    public static final String FILE_NAME = "person.dat";

    private static final Gender[] GENDERS = {
            new Gender(-161, "Мужской"),
            new Gender(5, "Женский")
    };

    private static final Activity[] ACTIVITIES = {
            new Activity("Отсутствует или минимальная", 1.2f),
            new Activity("Тренировка 3 раза в неделю", 1.38f),
            new Activity("Тренировка 5 раз в неделю", 1.46f),
            new Activity("Тренировка каждый день", 1.64f),
            new Activity("Физическая работа", 1.9f)
    };

    private final JTextField Rost;
    private final JTextField Ves;
    private final JTextField Age;
    private final JComboBox<Gender> BoxPol;
    private final JComboBox<Activity> BoxAct;

    public PersonalData() {
        this.setSize(800, 600);
        this.setLocation(500, 200);
        this.setResizable(false);
        this.setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        JButton Cancel = new JButton("<html><h2><font color=\"black\">Отмена"); /*ПОМЕНЯТЬ ЦВЕТ И РАЗМЕР*/
        Cancel.setBounds(500, 450, 200, 40);
        this.add(Cancel);
        Cancel.addActionListener(e -> this.dispose());
        JLabel RostText = new JLabel("<html><h2><font color=\"black\">Рост");
        this.add(RostText);
        RostText.setBounds(145,40,60,80);
        Rost = new JTextField();
        Rost.setBounds(50,100,220,40);
        this.add(Rost);
        this.setLayout(null);


        JLabel VesText = new JLabel("<html><h2><font color=\"black\">Вес");
        this.add(VesText);
        VesText.setBounds(145,130,60,80);
        Ves = new JTextField();
        Ves.setBounds(50,190,220,40);
        this.add(Ves);
        this.setLayout(null);


        JLabel AgeText = new JLabel("<html><h2><font color=\"black\">Возраст");
        this.add(AgeText);
        AgeText.setBounds(125,220,90,80);
        Age = new JTextField();
        Age.setBounds(50,280,220,40);
        this.add(Age);
        this.setLayout(null);

        JLabel PolText = new JLabel("<html><h2><font color=\"black\">Пол");
        this.add(PolText);
        PolText.setBounds(145,310,60,80);
        BoxPol = new JComboBox<>(GENDERS);
        BoxPol.setBounds(50,370,220,40);
        this.add(BoxPol);
        this.setLayout(null);

        JLabel ActText = new JLabel("<html><h2><font color=\"black\">Активность");
        this.add(ActText);
        ActText.setBounds(115,400,110,80);
        BoxAct = new JComboBox<>(ACTIVITIES);
        BoxAct.setBounds(50,460,220,40);
        this.add(BoxAct);

        this.setLayout(null);

        JTextField CalculateField = new JTextField();
        CalculateField.setBounds(500,180,200,40);
        CalculateField.setEditable(false);
        this.add(CalculateField);
        this.setLayout(null);
        JButton Calculate = new JButton("<html><h2><font color=\"black\">Рассчитать");
        Calculate.setBounds(500,130, 200,40);
        Calculate.addActionListener(e -> CalculateField.setText(String.format("%.2f", getPerson().getNorma())));
        this.add(Calculate);

        JButton Save = new JButton("<html><h2><font color=\"black\">Сохранить");
        Save.setBounds(500,400,200,40);
        Save.addActionListener(e -> savePersonData(getPerson()));
        this.add(Save);

        this.loadSavedData();

        this.setVisible(true);


    }

    private void loadSavedData() {
        try {
            boolean exists = (new File(FILE_NAME)).isFile();
            if (exists) {
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Person person = (Person) ois.readObject();
                Rost.setText(Float.toString(person.getHeight()));
                Ves.setText(Float.toString(person.getWeight()));
                Age.setText(Integer.toString(person.getAge()));

            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void savePersonData(Person person) {
        try {
            OutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Person getPerson() {
        Person person = new Person();
        person.setHeight(Float.parseFloat(Rost.getText()));
        person.setWeight(Float.parseFloat(Ves.getText()));
        person.setAge(Integer.parseInt(Age.getText()));
        person.setGender((Gender) BoxPol.getSelectedItem());
        person.setActivity((Activity) BoxAct.getSelectedItem());
        return person;
    }

}
