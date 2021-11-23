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
        Font font1 = new Font("Georgia",Font.BOLD, 15);
        Font spisok = new Font("Bahnschrift",Font.BOLD, 14);
        Font font2 = new Font("Georgia",Font.BOLD, 20);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);


        JTextField proverka = new JTextField();
        proverka.setBounds(520,250,150,40);
        proverka.setBorder(BorderFactory.createLineBorder(new Color(177, 106, 252),3,false));
        proverka.setEditable(true);
        this.add(proverka);


        JLabel sravn = new JLabel();
        this.add(sravn);
        sravn.setBounds(600,300,250,80);

        JLabel sravn1 = new JLabel();
        this.add(sravn1);
        sravn1.setBounds(350,250,180,80);

        JLabel text = new JLabel();
        this.add(text);
        text.setBounds(250,70,250,80);

        JButton cancel = new JButton("<html><h2><font color=\"black\">Назад");
        cancel.setBounds(20, 20, 100, 40);
        cancel.setBackground(new Color(250, 222, 222));
        cancel.setBorder(BorderFactory.createLineBorder(new Color(255,99,71),4,true));
        cancel.setFont(font1);
        this.add(cancel);
        cancel.addActionListener(e -> this.dispose());

        JButton Calculate = new JButton("<html><h2><font color=\"black\">Рассчитать");
        Calculate.setBounds(520,300, 150,40);
        Calculate.setFont(font1);
        this.add(Calculate);
        Calculate.addActionListener(e -> {
            if (calculate <= norma) {
                text.setText("<html><h2><font color=\"black\">Молодец! Сегодня ты сжег" + "калорий"); /* Вставить разницу калорий*/
                text.setFont(font1);
                proverka.setText(Double.toString(norma-calculate));
            }else {
                text.setText("<html><h2><font color=\"black\">Атата! Кушай меньше!");
                text.setFont(font1);
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
        dungeon1.setBounds(100,170,170,300);
        dungeon1.setBorder(BorderFactory.createLineBorder(new Color(149, 175, 252),3,true));
        dungeon1.setFont(spisok);
        this.add(dungeon1);

        JLabel gramms = new JLabel("<html><font color=\"black\">Граммы");
        gramms.setFont(font2);
        this.add(gramms);
        gramms.setBounds(385,195,130,80);

        JLabel products = new JLabel("<html><font color=\"black\">Продукты");
        products.setFont(font2);
        this.add(products);
        products.setBounds(125,110,130,80);

        JLabel ostatok = new JLabel("<html><font color=\"black\">Остаток");
        ostatok.setFont(font2);
        this.add(ostatok);
        ostatok.setBounds(550,195,200,80);

        JTextField ncalories = new JTextField();
        ncalories.setBounds(350,250,150,40);
        ncalories.setBorder(BorderFactory.createLineBorder(new Color(177, 106, 252),3,false));
        ncalories.setEditable(true);
        this.add(ncalories);



        JButton saveb = new JButton("<html><h2><font color=\"black\">Добавить");
        saveb.setBounds(350, 300, 150, 40);
        saveb.setBackground(new Color(215, 252, 235));
        saveb.setBorder(BorderFactory.createLineBorder(new Color(0,250,154),4,true));
        saveb.setFont(font1);
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
