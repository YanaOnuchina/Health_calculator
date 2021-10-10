package hc;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        this.setTitle("Health calculator 1.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JButton button1 = new JButton("Персональные данные");
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                PersonalDataDialog dialog = new PersonalDataDialog();
                dialog.setVisible(true);
            }
        });

        JButton button2 = new JButton("База продуктов");
        button2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                PersonalDataDialog dialog = new PersonalDataDialog();
                dialog.setVisible(true);
            }
        });

        JButton button3 = new JButton("Употреблённые продукты");
        button3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                PersonalDataDialog dialog = new PersonalDataDialog();
                dialog.setVisible(true);
            }
        });

        JButton button4 = new JButton("Начать новый день");
        button4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                PersonalDataDialog dialog = new PersonalDataDialog();
                dialog.setVisible(true);
            }
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