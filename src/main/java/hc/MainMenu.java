package hc;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        this.setTitle("Health calculator 2.0");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocation(500, 200);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JButton button1 = new JButton("Употреблённые продукты");
        button1.addActionListener(e -> {
            PersonalDataDialog dialog = new PersonalDataDialog();
            dialog.setVisible(true);
        });

        JButton button2 = new JButton("Персональные данные");
        button2.addActionListener(e -> {
            PersonalDataDialog dialog = new PersonalDataDialog();
            dialog.setVisible(true);
        });

        JButton button3 = new JButton("База продуктов");
        button3.addActionListener(e -> {
            PersonalDataDialog dialog = new PersonalDataDialog();
            dialog.setVisible(true);
        });

        JButton button4 = new JButton("Выход");
        button4.addActionListener(e -> {
            PersonalDataDialog dialog = new PersonalDataDialog();
            dialog.setVisible(true);
        });

        panel.add(button1, gbc);
        gbc.gridy++;

        panel.add(button2, gbc);
        gbc.gridy++;

        panel.add(button3, gbc);
        gbc.gridy++;

        panel.add(button4, gbc);


    }
}
