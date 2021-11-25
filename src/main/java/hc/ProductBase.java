package hc;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The class contains methods and objects for creating a separate window of product base.
 *
 * @author Mityulya Evgeniy, Matoshka Ivan.
 * @version 1.0.
 */
public class ProductBase extends JDialog{
    ArrayList<String> productName;
    ArrayList<Double> calories;

    /**
     * ProductBase constructor process elements for creating new window.
     *
     * @param productName name elements of the products base.
     * @param calories calories number elements of the product base.
     */
    public ProductBase(ArrayList<String> productName,ArrayList<Double> calories) {

        this.calories = calories;
        this.productName = productName;

        this.setTitle("Список продуктов");
        this.setSize(800, 600);
        this.setLocation(500, 200);
        this.setResizable(false);
        this.setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        Font font1 = new Font("Georgia",Font.BOLD, 15);
        Font numbers = new Font("Bahnschrift SemiBold",Font.BOLD, 17);
        Font spisok = new Font("Bahnschrift",Font.BOLD, 14);
        Font bigname = new Font("Georgia",Font.BOLD, 25);

        JButton cancel = new JButton("<html><h2><font color=\"black\">Назад");
        cancel.setBounds(20, 20, 100, 40);
        cancel.setBackground(new Color(250, 222, 222));
        cancel.setBorder(BorderFactory.createLineBorder(new Color(255,99,71),4,true));
        cancel.setFont(font1);
        this.add(cancel);
        cancel.addActionListener(e -> this.dispose());

        JLabel name = new JLabel("<html><h2><font color=\"black\">Название");
        name.setFont(font1);
        this.add(name);
        name.setBounds(491,200,100,80);


        JTextField newname = new JTextField();
        newname.setBounds(480,260,120,40);
        newname.setBorder(BorderFactory.createLineBorder(new Color(177, 106, 252),3,false));
        newname.setFont(numbers);
        newname.setEditable(true);
        this.add(newname);

        JLabel products = new JLabel("<html><font color=\"black\">Продукты");
        products.setFont(bigname);
        this.add(products);
        products.setBounds(170,65,150,80);

        JLabel productn = new JLabel("<html><font color=\"black\">Название ( Ккал/100 г. )");
        productn.setFont(font1);
        this.add(productn);
        productn.setBounds(37,96,350,80);

        JLabel calorlable = new JLabel("<html><h2><font color=\"black\">Ккал/100г.");
        calorlable.setFont(font1);
        this.add(calorlable);
        calorlable.setBounds(625,200,150,80);

        JTextField newcal = new JTextField();
        newcal.setBounds(620,260,120,40);
        newcal.setFont(numbers);
        newcal.setBorder(BorderFactory.createLineBorder(new Color(177, 106, 252),3,false));
        newcal.setEditable(true);
        this.add(newcal);

        DefaultListModel<String> model = new DefaultListModel<>();

        for(int i = 0; i < productName.size(); i++){
            String string = String.format(productName.get(i) + " ( " + calories.get(i).toString()+ " ) ");
            model.addElement(string);
        }

        JList<String> list1 = new JList<>(model);
        list1.setFont(spisok);
        JScrollPane dungeon1 =  new JScrollPane(list1);
        dungeon1.setBounds(35,150,400,300);
        dungeon1.setBorder(BorderFactory.createLineBorder(new Color(149, 175, 252),3,true));
        this.add(dungeon1);

        JButton save = new JButton("<html><h2><font color=\"black\">Добавить");
        save.setBounds(550, 320, 120, 40);
        save.setFont(font1);
        save.setBackground(new Color(215, 252, 235));
        save.setBorder(BorderFactory.createLineBorder(new Color(0,250,154),4,true));
        save.addActionListener(e ->{
        productName.add(newname.getText());
        calories.add(Double.parseDouble(newcal.getText()));
            model.addElement(newname.getText() + " ( " + newcal.getText() + " )  ");
        });
        this.add(save);
        this.setLayout(null);
    }

}









