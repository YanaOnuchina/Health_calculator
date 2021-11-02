package hc;

import javax.swing.*;
import java.awt.*;


public class PersonalData extends JDialog{
    public PersonalData() {
        this.setSize(800, 600);
        this.setLocation(500, 200);
        this.setResizable(false);
        this.setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        JButton Nazad = new JButton("<html><h2><font color=\"black\">Назад"); /*НАЙТИ КАК ПОМЕНЯТЬ ЦВЕТ И РАЗМЕР*/
        Nazad.setBounds(40, 20, 100, 40);
        this.add(Nazad);
        Nazad.addActionListener(e -> {
            this.dispose();
        });

        JLabel RostText = new JLabel("<html><h2><font color=\"black\">Рост");
        this.add(RostText);
        RostText.setBounds(130,70,60,80);
        JTextField Rost = new JTextField();
        Rost.setBounds(50,130,200,40);
        this.add(Rost);
        this.setLayout(null);


        JLabel VesText = new JLabel("<html><h2><font color=\"black\">Вес");
        this.add(VesText);
        VesText.setBounds(135,160,60,80);
        JTextField Ves = new JTextField();
        Ves.setBounds(50,220,200,40);
        this.add(Ves);
        this.setLayout(null);

        String Pol[] = { "                     Мужской","                     Женский"};
        JComboBox BoxPol = new JComboBox(Pol);
        BoxPol.setBounds(50,310,200,40);
        this.add(BoxPol);
        this.setLayout(null);

        String Activities[] = { " Отсутствует или минимальная "," Тренировка 3 раза в неделю", " Тренировка 5 раз в неделю"," Тренировка каждый день","Ежедневная физическая нагрузка(профи)"};
        JComboBox BoxAct = new JComboBox(Activities);
        BoxAct.setBounds(50,400,257,40);
        this.add(BoxAct);

        this.setLayout(null);

        JTextField CalculateField = new JTextField();
        CalculateField.setBounds(500,180,200,40);
        this.add(CalculateField);
        this.setLayout(null);
        JButton Calculate = new JButton("<html><h2><font color=\"black\">Рассчитать");
        Calculate.setBounds(500,130,
200,40);
        this.add(Calculate);

        JButton Exit = new JButton("<html><h2><font color=\"black\">Сохранить");
        Exit.setBounds(500,400,200,40);
        this.add(Exit);


        this.setVisible(true);


    }

}
