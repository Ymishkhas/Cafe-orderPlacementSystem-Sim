package Cafe_produtcts;

public abstract class CafeProduct {

    private double price = 0;
    private int qty = 1;
    private String size = "";
    private String description = "";

    // Setters and Getters
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double calc_total(){
        return getPrice()*getQty();
    }

    // To string
    @Override
    public String toString() {
        String size = getSize();
        String description = getDescription();
        double cost = calc_total();
        int qty = getQty();

        String formattedString = String.format("%-60s %s %15s",size + description, qty,  cost + " SAR");
        return formattedString;
    }

}
