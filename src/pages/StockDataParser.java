package pages;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StockDataParser {

    private static List<String> stockDataList = new ArrayList<>();

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

        // Sort the list by time in descending order (most recent first)
        Collections.sort(stockDataObjects, new Comparator<StockData>() {
            @Override
            public int compare(StockData o1, StockData o2) {
                return o2.getTime().compareTo(o1.getTime());
            }
        });

        // Store the sorted stock data in a string list
        for (StockData stockData : stockDataObjects) {
            stockDataList.add(String.format("Time: %s, Open: %s, High: %s, Low: %s, Close: %s, Volume: %s",
                    stockData.getTime(), stockData.getOpen(), stockData.getHigh(), stockData.getLow(), stockData.getClose(), stockData.getVolume()));
        }
    }

    // Returns a specific line of stock data
    public static String getStockLine(int lineNumber) {
        if (lineNumber < 0 || lineNumber >= stockDataList.size()) {
            return "Invalid line number.";
        }
        return stockDataList.get(lineNumber);
    }

    // Returns a section of stock data
    public static List<String> getStockSection(int pageNumber) {
        List<String> stockSection = new ArrayList<>();
        int start = (pageNumber - 1) * 10;
        int end = Math.min(start + 10, stockDataList.size());

        for (int i = start; i < end; i++) {
            stockSection.add(getStockLine(i));
        }
        return stockSection;
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
