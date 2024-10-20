
package pages;

import org.json.JSONObject;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StockGraphParser {

    private static List<StockData> stockDataList = new ArrayList<>();

    // Parses the JSON response and stores the stock data in a list
    public static void parseStockData(String jsonResponse) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONObject timeSeries = jsonObject.getJSONObject("Time Series (5min)");

        List<StockData> stockDataObjects = new ArrayList<>();

        // Iterate over the keys (time points) in the time series
        for (String time : timeSeries.keySet()) {
            JSONObject dataPoint = timeSeries.getJSONObject(time);
            String open = dataPoint.getString("1. open");
            String high = dataPoint.getString("2. high");
            String low = dataPoint.getString("3. low");
            String close = dataPoint.getString("4. close");
            String volume = dataPoint.getString("5. volume");

            // Create a StockData object and add it to the list
            StockData stockData = new StockData(time, open, high, low, close, volume);
            stockDataObjects.add(stockData);
        }

        // Sort the list by time in ascending order
        Collections.sort(stockDataObjects, new Comparator<StockData>() {
            @Override
            public int compare(StockData o1, StockData o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });

        stockDataList = stockDataObjects;
    }

    // Returns the parsed stock data list
    public static List<StockData> getStockDataList() {
        return stockDataList;
    }

    // Returns a list of closing prices as integers for the graph
    public static List<Integer> getClosingPrices() {
        List<Integer> closingPrices = new ArrayList<>();
        for (StockData data : stockDataList) {
            closingPrices.add((int) Double.parseDouble(data.getClose()));
        }
        return closingPrices;
    }

    // Inner class to represent stock data at a specific time
    static class StockData {
        private String time;
        private String open;
        private String high;
        private String low;
        private String close;
        private String volume;

        // Constructor to initialize the stock data fields
        public StockData(String time, String open, String high, String low, String close, String volume) {
            this.time = time;
            this.open = open;
            this.high = high;
            this.low = low;
            this.close = close;
            this.volume = volume;
        }

        // Getters for the stock data fields
        public String getTime() {
            return time;
        }

        public String getOpen() {
            return open;
        }

        public String getHigh() {
            return high;
        }

        public String getLow() {
            return low;
        }

        public String getClose() {
            return close;
        }

        public String getVolume() {
            return volume;
        }
    }
}
