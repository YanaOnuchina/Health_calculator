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

        JTextField Rost = new JTextField();
        Rost.setBounds(50,130,200,40);
        this.add(Rost);
        this.setLayout(null);

        JTextField Ves = new JTextField();
        Ves.setBounds(50,220,200,40);
        this.add(Ves);
        this.setLayout(null);

        String Pol[] = { "                     Мужской","                     Женский"};
        JComboBox BoxPol = new JComboBox(Pol);
        BoxPol.setBounds(50,310,200,40);
        this.add(BoxPol);
        this.setLayout(null);


        this.setVisible(true);


    }

}
