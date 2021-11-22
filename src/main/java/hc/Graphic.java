package hc;


import hc.model.PersonParam;
import org.computronium.bakesale.barchart.BarChartModel;
import org.computronium.bakesale.barchart.BarChartPanel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class Graphic extends JDialog{

    private BarChartPanel barChartPanel;
    private List<PersonParam> allPersonParams;

    public Graphic(List<PersonParam> allPersonParams) {
        this.allPersonParams = allPersonParams;

        this.setSize(800, 600);
        this.setLocation(500, 200);
        this.setResizable(false);
        this.setModal(true);

        if (allPersonParams.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Нет данных.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else {
            createBarChartPanel();

            getContentPane().add(barChartPanel);
        }

    }

    private void createBarChartPanel()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        barChartPanel = new BarChartPanel();

        int skipCount = Math.max(0, allPersonParams.size() - 10);

        final String[] LABELS = allPersonParams.stream().skip(skipCount)
                .map(PersonParam::getDate)
                .map(dateFormat::format).toArray(String[]::new);
        final double[] WEIGHTS = allPersonParams.stream().skip(skipCount)
                .map(PersonParam::getWeight)
                .mapToDouble(Float::doubleValue).toArray();
        Double dataMinY = Arrays.stream(WEIGHTS).min().getAsDouble();

        barChartPanel.setDataMinY(dataMinY.intValue());
        barChartPanel.setTitle("График изменения веса");
        barChartPanel.setModel( new BarChartModel()
        {


            public int getBarCount()
            {
                return LABELS.length;
            }

            public String getLabel( int index )
            {
                return LABELS[index];
            }

            public double getValue( int index )
            {
                return WEIGHTS[index];
            }

            public Color getColor( int index )
            {
                return Color.BLUE;
            }
        } );
        barChartPanel.setYAxisLabel("Вес(кг)");
    }
}
