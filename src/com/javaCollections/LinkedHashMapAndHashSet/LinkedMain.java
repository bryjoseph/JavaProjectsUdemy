package com.javaCollections.LinkedHashMapAndHashSet;

import java.util.Map;

public class LinkedMain {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        // adding items first
        StockItem temp = new StockItem("bread", .86, 100);
        stockList.addStock(temp);

        temp =  new StockItem("milk", 1.50, 10);
        stockList.addStock(temp);

        temp =  new StockItem("eggs", 0.90, 25);
        stockList.addStock(temp);

        temp =  new StockItem("apple", .75, 100);
        stockList.addStock(temp);

        temp =  new StockItem("bran flakes", 3.50, 25);
        stockList.addStock(temp);

        temp =  new StockItem("orange juice", 2.10, 12);
        stockList.addStock(temp);

        temp =  new StockItem("flank steak", 7.85, 8);
        stockList.addStock(temp);

        temp =  new StockItem("dog food", 10.50, 15);
        stockList.addStock(temp);

        System.out.println(stockList);

        // testing the sale of an item
        ShoppingCart bryansCart =  new ShoppingCart("Bryan's Cart");
        sellItem(bryansCart, "orange juice", 1);
        System.out.println(bryansCart);

        sellItem(bryansCart, "flank steak", 9);
        System.out.println(bryansCart);

        // testing item that doesn't exist on StockList
        sellItem(bryansCart, "spinner", 1);

        sellItem(bryansCart, "dog food", 2);
        sellItem(bryansCart, "bran flakes", 2);
        sellItem(bryansCart, "apple", 5);
        System.out.println(bryansCart);
        // after selling what does the current stockList look like (already tested code works removing println)
        // System.out.println(stockList);

        ShoppingCart shoppingCart = new ShoppingCart("Customer");
        sellItem(shoppingCart, "dog food", 5);
        sellItem(shoppingCart, "milk", 1);
        sellItem(shoppingCart, "eggs", 2);
        System.out.println(shoppingCart);

        // test removing
        removeItem(bryansCart, "bran flakes", 1);
        removeItem(bryansCart, "apple", 5);
        System.out.println(bryansCart);

        removeItem(shoppingCart, "milk", 1);
        System.out.println(shoppingCart);

        // test checkout
        checkout(bryansCart);
        System.out.println(stockList);
        System.out.println(bryansCart);









    }

    public static int sellItem(ShoppingCart cart, String item, int quantity) {
        // get the item from the StockList first
        StockItem stockItem = stockList.getStockItem(item);
        // a check to see if the item exists on the stockList
        if(stockItem == null) {
            System.out.println("The store does not sell " + item);
            return 0;
        }
        // next test is making sure there is enough stock of the item on StockList (now including reserved items)
        if(stockList.reserveStock(item, quantity) != 0) {
            return cart.addItemToCart(stockItem, quantity);
        }
        // if the code makes it this far, either the item OR the stock is not sufficient
        return 0;
    }

    public static int removeItem(ShoppingCart cart, String item, int quantity) {
        // get the item from the StockList first
        StockItem stockItem = stockList.getStockItem(item);
        // a check to see if the item exists on the stockList
        if(stockItem == null) {
            System.out.println("The store does not sell " + item);
            return 0;
        }
        // next test is making sure there is enough stock of the item on StockList (now including reserved items)
        if(cart.removeItemFromCart(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        // if the code makes it this far, either the item OR the stock is not sufficient
        return 0;
    }

    // customer needs to checkout
    public static void checkout(ShoppingCart customersShoppingCart) {
        // just checking to make sure a customer has created a shoppingCart
        if(customersShoppingCart.getName() != null) {
            for(Map.Entry<StockItem, Integer> item : customersShoppingCart.getShoppingList().entrySet()) {
                stockList.sellStock(item.getKey().getName(), item.getValue());
            }
            customersShoppingCart.clearBasket();
        }
    }
}
