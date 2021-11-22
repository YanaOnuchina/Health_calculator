package hc;

import hc.model.Activity;
import hc.model.Gender;
import hc.model.PersonParam;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PersonalData extends JDialog{

    private List<PersonParam> allPersonParams = new ArrayList<>();
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
    private final JTextField calculateField;

    float norma;

    public PersonalData(float norma) {
        this.norma = norma;
        this.setSize(800, 600);
        this.setLocation(500, 200);
        this.setResizable(false);
        this.setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        JButton cancel = new JButton("<html><h2><font color=\"black\">Отмена"); /*ПОМЕНЯТЬ ЦВЕТ И РАЗМЕР*/
        cancel.setBounds(500, 450, 200, 40);
        this.add(cancel);
        cancel.addActionListener(e -> this.dispose());

        JLabel rostText = new JLabel("<html><h2><font color=\"black\">Рост");
        this.add(rostText);
        rostText.setBounds(145,40,60,80);
        Rost = new JTextField();
        Rost.setBounds(50,100,220,40);
        this.add(Rost);
        this.setLayout(null);

        JLabel vesText = new JLabel("<html><h2><font color=\"black\">Вес");
        this.add(vesText);
        vesText.setBounds(145,130,60,80);
        Ves = new JTextField();
        Ves.setBounds(50,190,220,40);
        this.add(Ves);
        this.setLayout(null);

        JLabel ageText = new JLabel("<html><h2><font color=\"black\">Возраст");
        this.add(ageText);
        ageText.setBounds(125,220,90,80);
        Age = new JTextField();
        Age.setBounds(50,280,220,40);
        this.add(Age);
        this.setLayout(null);

        JLabel polText = new JLabel("<html><h2><font color=\"black\">Пол");
        this.add(polText);
        polText.setBounds(145,310,60,80);
        BoxPol = new JComboBox<>(GENDERS);
        BoxPol.setBounds(50,370,220,40);
        this.add(BoxPol);
        this.setLayout(null);

        JLabel actText = new JLabel("<html><h2><font color=\"black\">Активность");
        this.add(actText);
        actText.setBounds(115,400,110,80);
        BoxAct = new JComboBox<>(ACTIVITIES);
        BoxAct.setBounds(50,460,220,40);
        this.add(BoxAct);

        this.setLayout(null);

        calculateField = new JTextField(String.format("%.2f", this.norma));
        calculateField.setBounds(500,180,200,40);
        calculateField.setEditable(false);
        this.add(calculateField);
        this.setLayout(null);

        JButton Graphic = new JButton("<html><h2><font color=\"black\">График"); /*ПОМЕНЯТЬ ЦВЕТ И РАЗМЕР*/
        Graphic.setBounds(500, 280, 200, 40);
        Graphic.addActionListener(e -> {
            Graphic dialog = new Graphic();
            dialog.setVisible(true);
        });
        this.add(Graphic);
        this.setLayout(null);


        JButton Calculate = new JButton("<html><h2><font color=\"black\">Рассчитать");
        Calculate.setBounds(500,130, 200,40);
        Calculate.addActionListener(e -> {
                this.norma = getPersonParamFromForm().getNorma();
                calculateField.setText(String.format("%.2f", this.norma));
        });
        this.add(Calculate);
        this.setLayout(null);

        JButton save = new JButton("<html><h2><font color=\"black\">Сохранить");
        save.setBounds(500,400,200,40);
        save.addActionListener(e -> savePersonData(getPersonParamFromForm()));
        this.add(save);
        this.setLayout(null);

        this.loadSavedData();

    }

    private void loadSavedData() {
        try {
            boolean exists = (new File(FILE_NAME)).isFile();
            if (exists) {
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                allPersonParams = (List<PersonParam>) ois.readObject();
                if (!allPersonParams.isEmpty()) {
                    PersonParam personParam = allPersonParams.get(allPersonParams.size() - 1);
                    Rost.setText(Float.toString(personParam.getHeight()));
                    Ves.setText(Float.toString(personParam.getWeight()));
                    Age.setText(Integer.toString(personParam.getAge()));
                    BoxPol.setSelectedItem(personParam.getGender());
                    BoxAct.setSelectedItem(personParam.getActivity());
                    this.norma = getPersonParamFromForm().getNorma();
                    calculateField.setText(String.format("%.2f", this.norma));
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void savePersonData(PersonParam personParam) {
        try {
            OutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            allPersonParams.add(personParam);
            objectOutputStream.writeObject(allPersonParams);
            objectOutputStream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private PersonParam getPersonParamFromForm() {
        PersonParam personParam = new PersonParam();
        personParam.setHeight(Float.parseFloat(Rost.getText()));
        personParam.setWeight(Float.parseFloat(Ves.getText()));
        personParam.setAge(Integer.parseInt(Age.getText()));
        personParam.setGender((Gender) BoxPol.getSelectedItem());
        personParam.setActivity((Activity) BoxAct.getSelectedItem());
        personParam.setDate(new Date());
        return personParam;
    }
    float gettingNorma(){
        return norma;
    }
}
