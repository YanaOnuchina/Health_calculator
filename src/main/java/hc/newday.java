package hc;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class newday extends JDialog{
    ArrayList<String> productName;
    ArrayList<Double> calories;


    public newday(ArrayList<String> productName,ArrayList<Double> calories) {
        this.setSize(800, 600);
        this.setLocation(500,200);
        this.setResizable(false);
        this.setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        JButton cancel = new JButton("<html><h2><font color=\"black\">Назад");
        cancel.setBounds(20, 20, 100, 40);
        this.add(cancel);
        cancel.addActionListener(e -> this.dispose());

        JButton Calculate = new JButton("<html><h2><font color=\"black\">Рассчитать");
        Calculate.setBounds(520,400, 150,40);
        this.add(Calculate);

        DefaultListModel<String> model = new DefaultListModel<>();
        for(int i = 0; i < productName.size(); i++){
            String string = String.format(productName.get(i));
            model.addElement(string);
        }
        JList<String> list1 = new JList<>(model);
        JScrollPane dungeon1 =  new JScrollPane(list1);
        dungeon1.setBounds(100,100,150,300);
        this.add(dungeon1);

        this.setLayout(null);
    }









}
