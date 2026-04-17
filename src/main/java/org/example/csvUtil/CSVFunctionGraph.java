package org.example.csvUtil;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CSVFunctionGraph extends JFrame {

    private static final int TRIM_MAX_Y = 100;

    public CSVFunctionGraph(String csvFilePath, boolean trim) {
        super("Graph");

        XYDataset dataset = createDataset(csvFilePath);

        String fileName = new File(csvFilePath).getName().replace(".csv", "");

        JFreeChart chart = ChartFactory.createXYLineChart(
                fileName,
                "X",
                "Y",
                dataset
        );

        if (trim) {
            XYPlot plot = chart.getXYPlot();
            plot.getRangeAxis().setRange(-TRIM_MAX_Y, TRIM_MAX_Y);
        }

        setContentPane(new ChartPanel(chart));
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private XYDataset createDataset(String csvFilePath) {
        XYSeries series = new XYSeries("f(x)");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                if (values.length >= 2) {
                    try {
                        double x = Double.parseDouble(values[0]);
                        double y = Double.parseDouble(values[1]);
                        series.add(x, y);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error reading CSV file: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return new XYSeriesCollection(series);
    }

    public static void displayChart(String path) {
        new CSVFunctionGraph(path, false).setVisible(true);
    }
}