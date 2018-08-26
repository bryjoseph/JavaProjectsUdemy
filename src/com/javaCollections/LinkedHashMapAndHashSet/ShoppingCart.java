package com.javaCollections.LinkedHashMapAndHashSet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {

    private final String name;
    private final Map<StockItem, Integer> shoppingList;

    public ShoppingCart(String name) {
        this.name = name;
        // code was
        // this.shoppingList = new HashMap<>();
        this.shoppingList = new TreeMap<>();
    }

    public String getName() { return name; }

    public int addItemToCart(StockItem item, int quantity) {
        // basic checking first
        if((item != null) && (quantity > 0)) {
            int inCart = shoppingList.getOrDefault(item, 0);
            shoppingList.put(item, inCart + quantity);
            return inCart;
        }
        return 0;
    }

    // removing item from Cart
    public int removeItemFromCart(StockItem item, int quantity) {
        // again basic checking first
        if((item != null) && (quantity > 0)) {
            // still fetching the current amount in the cart IF the item is not == null
            int inCart = shoppingList.getOrDefault(item, 0);
            // either way from line 35, there will be an int value here
            int newQuantity = inCart - quantity;
            if(newQuantity > 0) {
                // if newQuant is greater than zero that means the quant removed had items left over in cart
                shoppingList.put(item, newQuantity);
                return quantity;
            } else if (newQuantity == 0) {
                // if newQuant is zero, the quant removed did not have items left over and should therefore not be in cart
                shoppingList.remove(item);
            }
        }
        return 0;
    }

    // part of code challenge to clear cart after customer checks out
    public void clearBasket() {
        // instead of iterating through each item, calling .clear() to wipe entire shoppingList
        this.shoppingList.clear();
    }

    // similar to stockList returning unmodifiable shoppingList
    public Map<StockItem, Integer> getShoppingList() {
        return Collections.unmodifiableMap(shoppingList);
    }

    @Override
    public String toString() {
        String s = "\n Shopping List: " + name + " contains " + shoppingList.size() + ((shoppingList.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        // just a note, this is terrible string concatenation. .append() is much better option
        for(Map.Entry<StockItem, Integer> item : shoppingList.entrySet()) {
            // IntelliJ suggestion about using a string concatenation in a loop
            //  s.append(item.getKey()).append(". ").append(item.getValue()).append(" purchased \n");
            // because each time the string is concat, the entire thing is copied to a new string
            s = s + item.getKey() + ". " + "(" + item.getValue() + ")" + ((shoppingList.size() == 1) ? " purchase" : " purchased") + "\n";
            // the key in this map is the StockItem, the value is the quantity of that item
            totalCost += item.getKey().getItemPrice() * item.getValue();
        }
        return s + " Total cost: $" + String.format("%.2f", totalCost);
    }
}
