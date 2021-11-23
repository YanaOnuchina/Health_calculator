package hc;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class newday extends JDialog{

    int i;
    double calculate =0;
    double val;


    public newday(ArrayList<String> productName,ArrayList<Double> calories,float norma) {
        this.setSize(800, 600);
        this.setLocation(500,200);
        this.setResizable(false);
        this.setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);


        JTextField proverka = new JTextField();
        proverka.setBounds(480,300,120,40);
        proverka.setEditable(true);
        this.add(proverka);


        JLabel sravn = new JLabel();
        this.add(sravn);
        sravn.setBounds(145,30,250,80);

        JLabel sravn1 = new JLabel();
        this.add(sravn1);
        sravn1.setBounds(145,20,250,80);

        JLabel text = new JLabel();
        this.add(text);
        text.setBounds(250,70,250,80);

        JButton cancel = new JButton("<html><h2><font color=\"black\">Назад");
        cancel.setBounds(20, 20, 100, 40);
        this.add(cancel);
        cancel.addActionListener(e -> this.dispose());

        JButton Calculate = new JButton("<html><h2><font color=\"black\">Рассчитать");
        Calculate.setBounds(520,400, 150,40);
        this.add(Calculate);
        Calculate.addActionListener(e -> {
            if (calculate <= norma) {
                text.setText("<html><h2><font color=\"black\">молодец");
                proverka.setText(Double.toString(norma-calculate));
            }else {
                text.setText("<html><h2><font color=\"black\">худей");
                proverka.setText(Double.toString(calculate-norma));
            }
        });
        DefaultListModel<String> model = new DefaultListModel<>();
        for(int i = 0; i < productName.size(); i++){
            String string = String.format(productName.get(i));
            model.addElement(string);
        }
        JList<String> list1 = new JList<>(model);
        JScrollPane dungeon1 =  new JScrollPane(list1);
        dungeon1.setBounds(100,100,150,300);
        this.add(dungeon1);

        JTextField ncalories = new JTextField();
        ncalories.setBounds(480,80,120,40);
        ncalories.setEditable(true);
        this.add(ncalories);



        JButton saveb = new JButton("<html><h2><font color=\"black\">Добавить");
        saveb.setBounds(400, 125, 120, 40);
        this.add(saveb);
        saveb.addActionListener(e -> {
           try{ i = list1.getSelectedIndex();}catch(Exception m){}
            if (i == -1)  {
                sravn.setText("Вы не выбрали ни одного продукта");

            }
            try{val = Double.parseDouble(ncalories.getText());} catch (Exception k){sravn1.setText("Вы ввели неверное значение в поле");}
            calculate =calculate+ (calories.get(i)/100)*val;
            sravn1.setText("");
            sravn.setText("");
        });

        this.setLayout(null);
    }









}
