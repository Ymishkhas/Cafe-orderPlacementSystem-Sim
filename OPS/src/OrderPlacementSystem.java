public class OrderPlacementSystem {
    public static void main(String[] args) {

        // Initialize the model
        OrderModel orderModel = new OrderModel();

        // Initialize the views
        MenuView menuView = new MenuView();
        CartView cartView = new CartView();
        CheckoutView checkoutView = new CheckoutView();

        // Initialize the controller
        Controller controller = new Controller(orderModel, menuView, cartView, checkoutView);

        // Ask for the menu and start
        controller.updateMenu();
    }
}