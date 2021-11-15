package hc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu extends JFrame {

    ArrayList<String> productName = new ArrayList<>();
    ArrayList<Double> calories = new ArrayList<>();

    public MainMenu() {

        try {
            infoloading();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            PersonalData dialog = new PersonalData();
        });

        JButton button3 = new JButton("База продуктов");
        button3.addActionListener(e -> {
            PersonalDataDialog dialog = new PersonalDataDialog();
            dialog.setVisible(true);
        });

        JButton Exit = new JButton("Выход");
        Exit.setBounds(350, 500, 100, 40);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });


        panel.add(button1, gbc);
        gbc.gridy++;

        panel.add(button2, gbc);
        gbc.gridy++;

        panel.add(button3, gbc);
        gbc.gridy++;

        panel.add(Exit, gbc);

        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                    try {
                        FileWriter fw = new FileWriter("Jabroni.txt",false);
                        for (int i = 0; i < productName.size(); i++) {
                            fw.write(productName.get(i));
                            fw.append("\n");
                            fw.write(String.valueOf(calories.get(i)));
                            fw.append("\n");
                        }

                        fw.close();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

    }
    public void infoloading() throws IOException {
        FileReader fr = new FileReader("Jabroni.txt");
       try (Scanner scanner = new Scanner(fr)) {
           while (scanner.hasNext()) {
               productName.add(scanner.nextLine());
               calories.add(Double.parseDouble(scanner.nextLine()));
           }
       }

       fr.close();

    }
}
