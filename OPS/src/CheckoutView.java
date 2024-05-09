import Cafe_produtcts.*;


import java.util.List;
import java.util.Scanner;

public class CheckoutView {

    // Listen to customer input and notify controller
    Controller.NotifyController notifyController;

    // To read customer input
    Scanner read = new Scanner(System.in);

    public void printSummary(List<CafeProduct> cart) {
        System.out.println();
        System.out.println("=================================================================================");
        System.out.println("                                 Checkout Process                                ");
        System.out.println("=================================================================================");
        System.out.println();

        // Get customer contact info
        System.out.print("> Enter your phone number: ");
        String phone = read.next();

        // Select payment option
        System.out.print("> Selected payment option( 1.Cash / 2.Apple Pay ): ");
        int option = read.nextInt();
        String paymentOpt = "Cash"; // default
        if (option==1) {
            paymentOpt = "Cash";
        } else if (option==2) {
            paymentOpt = "Apple Pay";
        }

        // Select delivery option
        System.out.println("> Selected delivery option: Pick up");

        System.out.print("Confirm order(Y/N): ");
        String confirm = read.next();
        String deliveryOpt = "pickup"; // default

        if (confirm.equalsIgnoreCase("Y")) {
            // Set up the model and get an invoice
            String invoice = notifyController.confirmOrder(cart, phone, deliveryOpt, paymentOpt);
            System.out.println();
            System.out.println(invoice);
        } else {
            notifyController.getCart(cart);
        }
    }

    public void setNotifyConrtoller(Controller.NotifyController notifyController) {
        this.notifyController = notifyController;
    }
}
