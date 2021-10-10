package hc;

import javax.swing.*;
import java.awt.*;

public class PersonalDataDialog extends JDialog {

    public PersonalDataDialog() {
        this.setSize(800, 600);
        this.setLocation(500,200);
        this.setResizable(false);
        this.setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        panel.add(new JLabel("В разработке"));
    }

}
