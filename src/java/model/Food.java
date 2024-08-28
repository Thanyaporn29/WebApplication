package model;

public class Food {
    private String name;
    private String levelSweet;  
    private String size;        
    private int price;

    // Default constructor
    public Food() {
    }

    // Parameterized constructor
    public Food(String name, String levelSweet, String size, int price) {
        this.name = name;
        this.levelSweet = levelSweet;
        this.size = size;
        this.price = price;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevelSweet() {
        return levelSweet;
    }

    public void setLevelSweet(String levelSweet) {
        this.levelSweet = levelSweet;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price >= 0) { // Ensure the price is non-negative
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    // toString() method for easy debugging and logging
    @Override
    public String toString() {
        return "Food [name=" + name + ", levelSweet=" + levelSweet + ", size=" + size + ", price=" + price + "]";
    }
}
