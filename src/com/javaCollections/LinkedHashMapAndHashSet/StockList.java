package com.javaCollections.LinkedHashMapAndHashSet;

import java.util.Collections;
// import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> stockList;

    public StockList() {
        // code was
        // this.stockList =  new HashMap<>();
        this.stockList =  new LinkedHashMap<>();
    }

    // returning an unmodifiable Map
    public Map<String, StockItem> getStockList() {
        // the way I would have guessed
        // return new HashMap<>(stockList);
        // the previous example actually allowed a user to think they were updating the Map<>, but it was only the copy
        // therefore the update never occurred and could be confusing. Unmodifiable counts for Maps, Sets, and Lists
        // and is actually faster because there is no need to create a copy first
        return Collections.unmodifiableMap(stockList);
    }

    public int addStock(StockItem item) {
        if(item != null) {
            // getOrDefault gets the item if it already exists in the Map<>, if not, uses the item passed in
            StockItem inStock = stockList.getOrDefault(item.getName(), item);
            // next if the item already exists, adjust the stock
            if(inStock != item) {
                // if it doesn't exist on the map, create a new stockItem and pass in the amount for quant
                item.adjustStockQuantity(inStock.getQuantityInStock());
            }
            // essentially if the item exists on the Map, adjust the quant by the amount passed in from item
            stockList.put(item.getName(), item);
            return item.getQuantityInStock();
        }
        return 0;
    }

    public int sellStock(String itemName, int quantity) {
        StockItem inStock = stockList.get(itemName);
        // perform a similar check to reserving
        if((inStock != null) && (quantity > 0)) {
            return inStock.finalizeStock(quantity);
        }
         return 0;
//        the old approach to selling the availableStock()
//        if the item to sell doesn't exist default to "null"
//        StockItem inStock = stockList.getOrDefault(itemName, null);
//
//        if((inStock != null) && (inStock.getQuantityInStock() >= quantity) && (quantity > 0)) {
//            // make the quant negative because already determined the number is greater than 0
//            inStock.adjustStockQuantity(-quantity);
//            return quantity;
//        }
//        return 0;
    }

    public StockItem getStockItem(String itemName) {
        return stockList.get(itemName);
    }

    // reserving items
    public int reserveStock(String itemName, int reserveQuantity) {
        // get stockItem from stockList (if exists) ((key of the stockList map is the itemName))
        StockItem inStock = stockList.get(itemName);
        // perform check on result
        if((inStock != null) && (reserveQuantity > 0)) {
            return inStock.reserveStock(reserveQuantity);
        }
        // else, if there wasn't a match
        return 0;
    }

    // un-reserving items
    public int unreserveStock(String itemName, int unreserveQuantity) {
        StockItem onStockList = stockList.get(itemName);
        // similar to above
        if((onStockList != null) && (unreserveQuantity > 0)) {
            return onStockList.unreserveStock(unreserveQuantity);
        }
        // similar to above
        return 0;
    }

    public Map<String, Double> PriceList() {
        // will be based on the order of insertion w/ LinkedHashMap
        Map<String, Double> prices =  new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : stockList.entrySet()) {
            prices.put(item.getKey(), item.getValue().getItemPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(stockList);
    }

    @Override
    public String toString() {
        // previously all examples modified a single item, however toString can return a more complex list
        // instruction from IntelliJ
        // StringBuilder s = new StringBuilder("\n Stock Item List \n");
        String s = "\n Stock Item List \n";
        double totalPrice = 0.0;

        for(Map.Entry<String, StockItem> item : stockList.entrySet()) {
            // for each of the items, getValue() from Map
            StockItem stockItem = item.getValue();
            // to get total value of each item in stock
            double totalStockValue = stockItem.getItemPrice() * stockItem.getQuantityInStock();

            // format string s (from class direction)
            s = s + stockItem + ". There are " + stockItem.getQuantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f", totalStockValue) + "\n";
            // from IntelliJ
            // s.append(stockItem).append(". There are ").append(stockItem.getQuantityInStock()).append(" in stock. Value of items ").append(totalStockValue);
            totalPrice += totalStockValue;
        }
        return s + "Total value of stock: " + String.format("%.2f", totalPrice);
    }
}