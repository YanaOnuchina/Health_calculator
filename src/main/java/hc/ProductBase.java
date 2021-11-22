package hc;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductBase extends JDialog{
    ArrayList<String> productName;
    ArrayList<Double> calories;


    public ProductBase(ArrayList<String> productName,ArrayList<Double> calories) {

        this.calories = calories;
        this.productName = productName;

        this.setSize(800, 600);
        this.setLocation(500, 200);
        this.setResizable(false);
        this.setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        JButton cancel = new JButton("<html><h2><font color=\"black\">Назад");
        cancel.setBounds(20, 20, 100, 40);
        this.add(cancel);
        cancel.addActionListener(e -> this.dispose());

        JLabel name = new JLabel("<html><h2><font color=\"black\">Название");
        this.add(name);
        name.setBounds(495,20,90,80);

        JTextField newname = new JTextField();
        newname.setBounds(480,80,120,40);
        newname.setEditable(true);
        this.add(newname);

        JLabel calorlable = new JLabel("<html><h2><font color=\"black\">Ккал/100 г.");
        this.add(calorlable);
        calorlable.setBounds(635,20,150,80);

        JTextField newcal = new JTextField();
        newcal.setBounds(620,80,120,40);
        newcal.setEditable(true);
        this.add(newcal);

        DefaultListModel<String> model = new DefaultListModel<>();

        for(int i = 0; i < productName.size(); i++){
            String string = String.format("%s%30.30s",productName.get(i)+" / ", calories.get(i).toString());
            model.addElement(string);
        }

        JList<String> list1 = new JList<>(model);
        JScrollPane dungeon1 =  new JScrollPane(list1);
        dungeon1.setBounds(200,200,400,300);
        this.add(dungeon1);

        JButton save = new JButton("<html><h2><font color=\"black\">Добавить");
        save.setBounds(550, 140, 120, 40);
        save.addActionListener(e ->{
        productName.add(newname.getText());
        calories.add(Double.parseDouble(newcal.getText()));
            model.addElement(newname.getText() + "   " + newcal.getText());
        });
        this.add(save);
        this.setLayout(null);
    }

}









