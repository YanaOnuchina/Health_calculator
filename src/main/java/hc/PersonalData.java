package hc;

import hc.model.Activity;
import hc.model.Gender;
import hc.model.PersonParam;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;

public class PersonalData extends JDialog{

    private List<PersonParam> allPersonParams = new ArrayList<>();
    public static final String FILE_NAME = "person.dat";

    private static final Gender[] GENDERS = {
            new Gender(-161, "Мужской"),
            new Gender(5, "Женский")
    };

    private static final Activity[] ACTIVITIES = {
            new Activity("Минимальная", 1.2f),
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
        this.setTitle("Расчет калорий");
        this.norma = norma;
        this.setSize(800, 600);
        this.setLocation(500, 200);
        this.setResizable(false);
        this.setModal(true);

        JPanel panel = new JPanel();
        Font font1 = new Font("Georgia",Font.BOLD, 15);
        Font spisok = new Font("Bahnschrift",Font.BOLD, 14);
        Font numbers = new Font("Bahnschrift SemiBold",Font.BOLD, 17);
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        JLabel rostText = new JLabel("<html><h2><font color=\"black\">Рост");
        rostText.setFont(font1);
        this.add(rostText);
        rostText.setBounds(138,20,60,80);
        Rost = new JTextField();
        Rost.setBounds(50,80,220,40);
        Rost.setBorder(BorderFactory.createLineBorder(new Color(138, 242, 223),3,false));
        Rost.setFont(numbers);
        this.add(Rost);
        this.setLayout(null);

        JLabel vesText = new JLabel("<html><h2><font color=\"black\">Вес");
        vesText.setFont(font1);
        this.add(vesText);
        vesText.setBounds(143,105,60,80);
        Ves = new JTextField();
        Ves.setBounds(50,165,220,40);
        Ves.setBorder(BorderFactory.createLineBorder(new Color(138, 242, 223),3,false));
        Ves.setFont(numbers);
        this.add(Ves);
        this.setLayout(null);

        JLabel ageText = new JLabel("<html><h2><font color=\"black\">Возраст");
        ageText.setFont(font1);
        this.add(ageText);
        ageText.setBounds(120,190,90,80);
        Age = new JTextField();
        Age.setBounds(50,250,220,40);
        Age.setBorder(BorderFactory.createLineBorder(new Color(138, 242, 223),3,false));
        Age.setFont(numbers);
        this.add(Age);
        this.setLayout(null);

        JLabel polText = new JLabel("<html><h2><font color=\"black\">Пол");
        polText.setFont(font1);
        this.add(polText);
        polText.setBounds(143,275,60,80);
        BoxPol = new JComboBox<>(GENDERS);
        BoxPol.setBounds(50,335,220,40);
        BoxPol.setFont(spisok);
        this.add(BoxPol);
        this.setLayout(null);

        JLabel actText = new JLabel("<html><h2><font color=\"black\">Активность");
        actText.setFont(font1);
        this.add(actText);
        actText.setBounds(105,360,130,80);
        BoxAct = new JComboBox<>(ACTIVITIES);
        BoxAct.setBounds(50,420,220,40);
        BoxAct.setFont(spisok);
        this.add(BoxAct);

        this.setLayout(null);

        calculateField = new JTextField(String.format("%.2f", this.norma));
        calculateField.setBounds(500,180,200,40);
        calculateField.setBackground(new Color(255,255,255));
        calculateField.setFont(numbers);
        calculateField.setBorder(BorderFactory.createLineBorder(new Color(177, 106, 252),3,false));
        calculateField.setEditable(false);
        this.add(calculateField);
        this.setLayout(null);

        JButton Graphic = new JButton("<html><h2><font color=\"black\">График"); /*ПОМЕНЯТЬ ЦВЕТ И РАЗМЕР*/
        Graphic.setBounds(500, 265, 200, 40);
        Graphic.setBackground(new Color(235, 246, 252));
        Graphic.setBorder(BorderFactory.createLineBorder(new Color(149, 175, 252),4,true));
        Graphic.setFont(font1);
        Graphic.addActionListener(e -> {
            Graphic dialog = new Graphic(allPersonParams);
            dialog.setVisible(true);
        });
        this.add(Graphic);
        this.setLayout(null);


        JButton Calculate = new JButton("<html><h2><font color=\"black\">Рассчитать");
        Calculate.setFont(font1);
        Calculate.setBounds(500,130, 200,40);
        Calculate.setBorder(BorderFactory.createLineBorder(new Color(149, 175, 252),4,true));
        Calculate.setBackground(new Color(235, 246, 252));
        Calculate.setFont(font1);
        Calculate.addActionListener(e -> {
                this.norma = getPersonParamFromForm().getNorma();
                calculateField.setText(String.format("%.2f", this.norma));
        });
        this.add(Calculate);
        this.setLayout(null);

        JButton save = new JButton("<html><h2><font color=\"black\">Сохранить");
        save.setBounds(500,350,200,40);
        save.setBackground(new Color(215, 252, 222));
        save.setBorder(BorderFactory.createLineBorder(new Color(0,250,154),4,true));
        save.setForeground(new Color(0,0,0));
        save.setFont(font1);
        save.addActionListener(e -> savePersonData(getPersonParamFromForm()));
        this.add(save);
        this.setLayout(null);

        JButton cancel = new JButton("<html><h2><font color=\"black\">Отмена");
        cancel.setBackground(new Color(250, 222, 222));
        cancel.setBorder(BorderFactory.createLineBorder(new Color(255,99,71),4,true));
        cancel.setFont(font1);
        cancel.setForeground(new Color(000));
        cancel.setBounds(500, 405, 200, 40);
        this.add(cancel);
        cancel.addActionListener(e -> this.dispose());

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
