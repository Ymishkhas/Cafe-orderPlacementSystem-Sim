import Cafe_produtcts.CafeProduct;
import Delivery.*;
import Payment.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderModel {

    // Data Fields
    private int id;
    private List<CafeProduct> cart;
    private double amount;
    private String customerPhone;
    private Date date;
    private Payment paymentOption;
    private Delivery deliveryOption;
    private double tax = 1.15;

    // Constructor
    public OrderModel() {
        this.cart = new ArrayList<>();
        this.id = (int) (Math.random() * 100) + 1;
    }

    // Setters and Getters
    public int getId() {
        return id;
    }

    public List<CafeProduct> getCart() {
        return cart;
    }
    public void addToCart(CafeProduct product) {
        cart.add(product);
        calculateAmount();
    }
    public void addToCart(List<CafeProduct> products) {
        for (CafeProduct product: products) {
            cart.add(product);
        }
        calculateAmount();
    }
    public void removeFromCart(CafeProduct product) {
        cart.remove(product);
        calculateAmount();
    }
    public void removeFromCart(List<CafeProduct> products) {
        for (CafeProduct product: products) {
            cart.remove(product);
        }
        calculateAmount();
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Date getDate() {
        return date;
    }

    public Payment getPaymentOption() {
        return paymentOption;
    }
    public void setPaymentOption(String option) {
        if (option.equalsIgnoreCase("cash")) {
            this.paymentOption = new Cash();
        } else if (option.equalsIgnoreCase("apple pay")) {
            this.paymentOption = new ApplePay();
        }
    }

    public Delivery getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(String option) {
        if (option.equalsIgnoreCase("pickup")) {
            this.deliveryOption = new PickUp();
        }
    }

    // Operations
    public void calculateAmount() {
        double sum = 0;
        for (CafeProduct product: cart) {
            sum += product.calc_total();
        }

        this.amount = sum * tax;
    }

    // Order Invoice
    public String getInvoice() {
        this.date = new Date();

        String details = "";
        details += "=================================================================================\n";
        details += "                                     FCIT Cafe                                   \n";
        details += "                                      Invoice                                    \n";
        details += "=================================================================================\n";

        details += "\nOrder Number: #" + getId();
        details += "\nOrder Date: " + getDate();
        details += "\nPayment Method: " + getPaymentOption().toString();
        details += "\nDelivery Method: " + getDeliveryOption().toString();
        details += "\nCustomer Contact: " + getCustomerPhone();
        details += "\n\n";

        details += String.format("%-60s %s %9s\n","Product", "Quantity",  "Cost");
        for (int i = 0; i < cart.size(); i++) {
            details += i+1 + ". ";
            details += (cart.get(i).toString());
            details += "\n";
        }

        details += "\n";
        details += "Total amount(with 15% tax): " + String.format("%.2f", getAmount()) + " SAR";

        details += "\n\n\n";
        details += "                     Thank you for your orders and choosing us!                    \n";
        details += "                             We hope to see you again                              ";
        details += "\n=================================================================================\n";

        return details;
    }
}
