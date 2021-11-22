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

        JButton button1 = new JButton("<html><h3><font color=\"black\">Начать новый день");
        button1.setBounds(300, 130, 200, 50);
        button1.addActionListener(e -> {
            newday dialog = new newday(productName,calories);
            dialog.setVisible(true);
        });

        JButton button2 = new JButton("<html><h3><font color=\"black\">Персональные данные");
        button2.setBounds(300, 210, 200, 50);
        PersonalData dialog = new PersonalData(norma);
        button2.addActionListener(e -> {
            dialog.setVisible(true);
        });

        JButton button3 = new JButton("<html><h3><font color=\"black\">База продуктов");
        button3.setBounds(300, 290, 200, 50);
        button3.addActionListener(e -> {
            ProductBase dialog2 = new ProductBase(productName,calories);
            dialog2.setVisible(true);
        });

        JButton Exit = new JButton("<html><h3><font color=\"black\">Выход");
        Exit.setBounds(300, 370, 200, 50);
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
