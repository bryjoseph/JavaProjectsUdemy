package com.javaCollections.LinkedHashMapAndHashSet;

// to use in a sorted collection, implement Comparable
public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double itemPrice;
    // initialize a new stockItem to 0 in stock at first
    private int quantityStock /* = 0 */;
    private int reserved;


    // constructor without stockQuantity
    public StockItem(String name, double itemPrice) {
        this.name = name;
        this.itemPrice = itemPrice;
        this.quantityStock = 0; // can initialize here, or in member variable, not both
        this.reserved = 0;
    }

    // constructor with stockQuantity
    public StockItem(String name, double itemPrice, int quantityStock) {
        this.name = name;
        this.itemPrice = itemPrice;
        this.quantityStock = quantityStock;
        this.reserved = 0;
    }

    // Getters
    public String getName() { return name; }
    public double getItemPrice() { return itemPrice; }
    public int getQuantityInStock() { return quantityStock - reserved; }
    public int getReserved() { return reserved; }

    //Setter for price (name is "final")
    public void setItemPrice(double itemPrice) {
        if(itemPrice > 0) {
            this.itemPrice = itemPrice;
        }
    }

    // method to create a reserved amount for a specific item
    public int reserveStock(int reserveAmount) {
        // calling the getQuant method above (already includes - reserved)
        if(reserveAmount <= getQuantityInStock()) {
            reserved += reserveAmount;
            return reserveAmount;
        }
        return 0;
    }

    // method to release the reserved amount of a specific item
    public int unreserveStock(int unreserveAmount) {
        if(unreserveAmount <= reserved) {
            return reserved -= unreserveAmount;
        }
        return 0;
    }

    // not a set quantity, more accurate to adjust stock quantity
    public void adjustStockQuantity(int quantity) {
        int newStockQuantity = this.quantityStock + quantity;
        if(newStockQuantity >= 0) {
            this.quantityStock = newStockQuantity;
        }
    }

    public int finalizeStock(int stockQuantity) {
        if(stockQuantity <= reserved) {
            quantityStock -= stockQuantity;
            reserved -= stockQuantity;
            return stockQuantity;
        }
        return 0;
    }


    // overriding hashCode, equals because I am guessing a Set is involved
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals()");
        // if the comparison is to itself return true immediately
        if(this == obj) {
            return true;
        }
        // we know comparing the obj to null OR if this != obj return false
        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        // only comparing the name in the equals method
        String stockItemName = ((StockItem) obj).getName();
        return this.name.equals(stockItemName);
    }
    // overriding compareTo in order to sort the StockItems in a new List-based class
    @Override
    public int compareTo(StockItem stockItem) {
        // System.out.println("Entering StockItem.compareTo()");
        // test if the object passed in is the same first
        if(this == stockItem) {
            return 0;
        }
        // check != null
        if(stockItem != null) {
            return this.name.compareToIgnoreCase(stockItem.getName());
        }
        // add exception
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": $" + String.format("%.2f", this.itemPrice) + ". Reserved Quantity: (" + this.reserved + ")";
    }
}
