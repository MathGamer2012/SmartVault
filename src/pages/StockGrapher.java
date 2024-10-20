package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.json.JSONException;

public class StockGrapher extends JPanel {

    private String myTickerSymbol;

    public StockGrapher(String tickSymbol) {
        this.myTickerSymbol = tickSymbol;
        setPreferredSize(new Dimension(800, 400));
        prepareUI();
    }

    private void prepareUI() {
        setLayout(new BorderLayout());

        MyChart myChart = new MyChart();
        myChart.setPreferredSize(new Dimension(800, 400));

        AlphaVantageGraph api = new AlphaVantageGraph();
        String jsonResponse = api.getStockData("394YWOGE00QS4ANO", myTickerSymbol);

        if (jsonResponse != null) {
            try {
                StockGraphParser.parseStockData(jsonResponse);
                List<Integer> closingPrices = StockGraphParser.getClosingPrices();
                myChart.updateList(closingPrices);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to fetch stock data.");
        }

        add(myChart, BorderLayout.CENTER);
    }

    private class MyChart extends JComponent {
        private List<Integer> chartList = new ArrayList<>();

        public void updateList(List<Integer> l) {
            chartList = l;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (chartList != null && !chartList.isEmpty()) {
                paintChart(g);
            } else {
                System.out.println("Chart list is empty.");
            }
        }

        private void paintChart(Graphics g) {
            Graphics2D graphics2d = (Graphics2D) g;
            graphics2d.setColor(Color.blue);

            int width = getWidth();
            int height = getHeight();

            int maxPrice = Collections.max(chartList);
            int minPrice = Collections.min(chartList);

            double hDiv = (double) width / (double) (chartList.size() - 1);
            double vDiv = (double) height / (double) (maxPrice - minPrice);

            for (int i = 0; i < chartList.size() - 1; i++) {
                int value1 = chartList.get(i);
                int value2 = chartList.get(i + 1);

                graphics2d.drawLine(
                        (int) (i * hDiv),
                        height - ((int) ((value1 - minPrice) * vDiv)),
                        (int) ((i + 1) * hDiv),
                        height - ((int) ((value2 - minPrice) * vDiv))
                );
            }

            graphics2d.drawRect(0, 0, width, height);
        }
    }
}
