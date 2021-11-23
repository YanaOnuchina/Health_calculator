package hc;

import javax.swing.*;
import java.awt.*;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;


public class MainMenu extends JFrame {

    ArrayList<String> productName = new ArrayList<>();
    ArrayList<Double> calories = new ArrayList<>();
    float norma = 0;

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

        Font font = new Font("Georgia",Font.BOLD, 14);

        JButton button1 = new JButton("<html><font color=\"black\">Начать новый день");
        button1.setBounds(292, 130, 216, 50);
        button1.setBackground(new Color(0,250,154));
        button1.setFont(font);

        button1.addActionListener(e -> {
            newday dialog = new newday(productName,calories, norma);
            dialog.setVisible(true);
        });

        JButton button2 = new JButton("<html><font color=\"black\">Персональные данные");
        button2.setBounds(292, 210, 216, 50);
        button2.setBackground(Color.white);
        button2.setFont(font);

        PersonalData dialog = new PersonalData(norma);
        button2.addActionListener(e -> {
            dialog.setVisible(true);
        });

        JButton button3 = new JButton("<html><font color=\"black\">База продуктов");
        button3.setBounds(292, 290, 216, 50);
        button3.setBackground(Color.white);
        button3.setFont(font);
        button3.addActionListener(e -> {
            ProductBase dialog2 = new ProductBase(productName,calories);
            dialog2.setVisible(true);
        });

        JButton Exit = new JButton("<html><font color=\"black\">Выход");
        Exit.setBackground(new Color(255,99,71));
        Exit.setFont(font);
        Exit.setBounds(292, 370, 216, 50);
        Exit.addActionListener(e -> System.exit(1));

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(Exit);

        this.setLayout(null);

        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                    try {
                        FileWriter fw = new FileWriter("Jabroni.txt",false);
                        norma = dialog.gettingNorma();
                        fw.write(Float.toString(norma));
                        fw.append("\n");
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
           norma = Float.parseFloat(scanner.nextLine());
           while (scanner.hasNext()) {
               productName.add(scanner.nextLine());
               calories.add(Double.parseDouble(scanner.nextLine()));
           }
       }

       fr.close();

    }
}
