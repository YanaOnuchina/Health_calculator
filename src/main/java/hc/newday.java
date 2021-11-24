package hc;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class newday extends JDialog{

    int i;
    double calculate =0;
    double val;
    double vel;
    double gimnastica;
    double beg;
    double num;

    public newday(ArrayList<String> productName,ArrayList<Double> calories,float norma) {
        this.setTitle("Начать");
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
        sravn.setBounds(360,320,348,80);
        sravn.setFont(font1);
        sravn.setForeground(new Color(150,10,10));

        JLabel sravn1 = new JLabel();
        this.add(sravn1);
        sravn1.setBounds(360,340,348,80);
        sravn1.setFont(font1);
        sravn1.setFont(font1);
        sravn1.setForeground(new Color(150,10,10));

        JLabel text = new JLabel();
        this.add(text);
        text.setBounds(340,20,450,180);

        JButton cancel = new JButton("<html><h2><font color=\"black\">Назад");
        cancel.setBounds(20, 20, 100, 40);
        cancel.setBackground(new Color(250, 222, 222));
        cancel.setBorder(BorderFactory.createLineBorder(new Color(255,99,71),4,true));
        cancel.setFont(font1);
        this.add(cancel);
        cancel.addActionListener(e -> this.dispose());

        JTextField ncalories = new JTextField();
        ncalories.setBounds(350,250,150,40);
        ncalories.setBorder(BorderFactory.createLineBorder(new Color(177, 106, 252),3,false));
        ncalories.setEditable(true);
        this.add(ncalories);

        JButton Calculate = new JButton("<html><h2><font color=\"black\">Рассчитать");
        Calculate.setBounds(520,300, 150,40);
        Calculate.setBackground(new Color(215, 252, 235));
        Calculate.setBorder(BorderFactory.createLineBorder(new Color(0,250,154),4,true));
        Calculate.setFont(font1);
        this.add(Calculate);
        Calculate.addActionListener(e -> {
            if (calculate <= norma) {
                text.setText("<html><h2><font color=\"black\">Молодец! Сегодня ты уложился в норму. Так держать! На экране видна твоя разница калорий, продолжай в том же духе, но не перестарайся :)");
                text.setFont(font1);
                num = Math.round((norma-calculate)*100);
                num = num/100;
                proverka.setText(Double.toString(num));
                proverka.setBorder(BorderFactory.createLineBorder(new Color(0,250,154),3,false));
            }else {
                vel =(60*(calculate-norma))/350;
                vel = Math.round(vel);
                gimnastica =(60*(calculate-norma))/260;
                gimnastica = Math.round(gimnastica);
                beg =(60*(calculate-norma))/550;
                beg = Math.round(beg);
                text.setText("<html><h2><font color=\"black\">Эх, сегодня у твоего желудка не лучший день. Ты явно перестарался с обедом, признавайся. На экране видна твоя разница, а именно лишние калории. Вот несколько способов сжечь эти калории: "+ vel+" минут(-ы) езды на велосипеде, "+gimnastica+" минут(-ы) гимнастики или "+beg+" минут(-ы) бега");
                text.setFont(font1);
                num = Math.round((calculate - norma)*100);
                num = num/100;
                proverka.setText(Double.toString(num));
                proverka.setBorder(BorderFactory.createLineBorder(new Color(255,99,71),3,false));
            }
        });
        DefaultListModel<String> model = new DefaultListModel<>();
        for(int i = 0; i < productName.size(); i++){
            String string = String.format(productName.get(i));
            model.addElement(string);
        }
        JList<String> list1 = new JList<>(model);
        JScrollPane dungeon1 =  new JScrollPane(list1);
        dungeon1.setBounds(40,170,280,300);
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
        products.setBounds(120,110,130,80);

        JLabel ostatok = new JLabel("<html><font color=\"black\">Разница");
        ostatok.setFont(font2);
        this.add(ostatok);
        ostatok.setBounds(550,195,200,80);

        JButton saveb = new JButton("<html><h2><font color=\"black\">Добавить");
        saveb.setBounds(350, 300, 150, 40);
        saveb.setBackground(new Color(215, 252, 235));
        saveb.setBorder(BorderFactory.createLineBorder(new Color(0,250,154),4,true));
        saveb.setFont(font1);
        this.add(saveb);
        saveb.addActionListener(e -> {
           try{ i = list1.getSelectedIndex();}catch(Exception m){}
            if (i == -1)  {
                sravn.setText("Вы не выбрали ни одного продукта!");

            }
            try{val = Double.parseDouble(ncalories.getText());} catch (Exception k){sravn1.setText("Вы ввели неверное значение в поле!");}
            calculate =calculate+ (calories.get(i)/100)*val;
            sravn1.setText("");
            sravn.setText("");
        });
        this.setLayout(null);
    }









}
