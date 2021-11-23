package hc;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class newday extends JDialog{
    ArrayList<String> productName;
    ArrayList<Double> calories;
    int i;
    double calculate =0;
    int length;

    public newday(ArrayList<String> productName,ArrayList<Double> calories,float norma) {
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
        Calculate.addActionListener(e -> {
            if (calculate <= norma) {
                JLabel sravn = new JLabel("<html><h2><font color=\"black\">молодец");
                this.add(sravn);
                sravn.setBounds(145,40,60,80);
            }else {JLabel sravn = new JLabel("<html><h2><font color=\"black\">ты лох");
                this.add(sravn);
                sravn.setBounds(145,40,60,80);}

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
        saveb.setBounds(400, 125, 100, 40);
        this.add(saveb);
        /*if (ncalories.getText().equals("")){
            saveb.setEnabled(false);}else{
            saveb.setEnabled(true);
        }*/
        saveb.addActionListener(e -> {
            i = list1.getSelectedIndex();
            calculate =calculate+ calories.get(i)*Integer.parseInt(ncalories.getText());
        });




        this.setLayout(null);
    }









}
