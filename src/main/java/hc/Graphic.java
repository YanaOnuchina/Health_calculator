package hc;


import hc.model.PersonParam;
import org.computronium.bakesale.barchart.BarChartModel;
import org.computronium.bakesale.barchart.BarChartPanel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * The class contains methods and objects for working with the chart.
 *
 * @author Onuchina Yana.
 * @version 1.0.
 */
public class Graphic extends JDialog{

    private BarChartPanel barChartPanel;
    private List<PersonParam> allPersonParams;

    /**
     * The constructor creates a new window for the chart.
     *
     * @param allPersonParams persons parametr.
     */
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
    /**
     * This is the createBarChartPanel() method dor creating chart.
     */
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

            /**
             * The constructor returns a value to create a graph.
             *
             * @return the length of the labels.
             */
            public int getBarCount()
            {
                return LABELS.length;
            }
            /**
             * The constructor returns a value to create a graph.
             *
             * @return labels index.
             */
            public String getLabel( int index )
            {
                return LABELS[index];
            }
            /**
             * The constructor returns a value to create a graph.
             *
             * @return weights index.
             */
            public double getValue( int index )
            {
                return WEIGHTS[index];
            }
            /**
             * The constructor returns a value to create a graph.
             *
             * @return color of labels.
             */
            public Color getColor( int index )
            {
                return Color.BLUE;
            }
        } );
        barChartPanel.setYAxisLabel("Вес(кг)");
    }
}
