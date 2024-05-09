import Cafe_produtcts.CafeProduct;
import Delivery.Delivery;
import Payment.Payment;
import Subscribers.*;

import java.util.List;

public class Controller {

    // Observer
    Subscriber kitchenObserver = new Kitchen();

    // Model and views
    private OrderModel orderModel;
    private MenuView menuView;
    private CartView cartView;
    private CheckoutView checkoutView;

    // Constructor
    public Controller(OrderModel orderModel, MenuView menuView, CartView cartView, CheckoutView checkoutView) {
        this.orderModel = orderModel;
        this.menuView = menuView;
        this.cartView = cartView;
        this.checkoutView = checkoutView;

        // Listeners for input from the views
        this.menuView.setNotifyConrtoller(new NotifyController());
        this.cartView.setNotifyConrtoller(new NotifyController());
        this.checkoutView.setNotifyConrtoller(new NotifyController());
    }

    // Setters and Getters
    public int getOrderId() {
        return orderModel.getId();
    }

    public List<CafeProduct> getOrderCart() {
        return orderModel.getCart();
    }
    public void addToOrderCart(List<CafeProduct> products) {
        orderModel.addToCart(products);
    }
    public void removeFromOrderCart(List<CafeProduct> products) {
        orderModel.removeFromCart(products);
    }

    public String getCustomerPhone() {
        return orderModel.getCustomerPhone();
    }
    public void setCustomerPhone(String customerPhone) {
        orderModel.setCustomerPhone(customerPhone);
    }

    public Payment getOrderPaymentOption() {
        return orderModel.getPaymentOption();
    }
    public void setOrderPaymentOption(String option) {
        orderModel.setPaymentOption(option);
    }

    public Delivery getDeliveryOption() {
        return orderModel.getDeliveryOption();
    }
    public void setOrderDeliveryOption(String option) {
        orderModel.setDeliveryOption(option);
    }

    public String getOrderInvoice() {
        return orderModel.getInvoice();
    }


    // Update Views
    public void updateMenu() {
        menuView.printMenu();
    }

    public void updateCheckOut(List<CafeProduct> products) {
        checkoutView.printSummary(products);
    }

    public void updateCart(List<CafeProduct> products) {
        cartView.printCart(products);
    }

    // Notify kitchen observer
    public void notifyKitchen(String orderDetails) {
        kitchenObserver.notify(orderDetails);
    }

    // Listener class
    //-----------------------------------------------------------------------
    class NotifyController {
        public void getMenu(List<CafeProduct> products) {
            menuView.items = products;
            updateMenu();
        }

        public void getCart(List<CafeProduct> products){
            updateCart(products);
        }

        public void getCheckout(List<CafeProduct> products){
            updateCheckOut(products);
        }

        // Here we will actually contact the model, update the model, get invoice from it, and notify any observers
        public String confirmOrder(List<CafeProduct> products, String phone, String deliveryOpt, String paymentOpt) {

            // If any fail, can stop and handle
            setCustomerPhone(phone);
            setOrderDeliveryOption(deliveryOpt);
            setOrderPaymentOption(paymentOpt);
            addToOrderCart(products);

            String invoice = getOrderInvoice();
            notifyKitchen(invoice);
            return invoice;
        }
    }
}