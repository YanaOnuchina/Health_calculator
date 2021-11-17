package hc;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
public class ProductBase extends JDialog{

    /* private TableColumnModel columnModel;
    private Object[] columnsHeader1 = new String[] {"Название продукта"};
    private Object[] columnsHeader2 = new String[] {"Количество калорий на 100 грамм"};
    public ProductBase(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTable table1 = new JTable(, columnsHeader1);*/

    public ProductBase() {
        this.setSize(800, 600);
        this.setLocation(500, 200);
        this.setResizable(false);
        this.setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        panel.add(new JLabel("Работаю"));


    }


}









