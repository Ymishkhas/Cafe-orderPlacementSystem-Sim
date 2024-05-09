import Cafe_produtcts.CafeProduct;

import java.util.List;
import java.util.Scanner;

public class CartView {

    // Listen to customer input and notify controller
    Controller.NotifyController notifyController;

    // To read customer input
    Scanner read = new Scanner(System.in);

    public void printCart(List<CafeProduct> cart) {
        System.out.println();
        System.out.println("=================================================================================");
        System.out.println("                                    Your Cart                                    ");
        System.out.println("=================================================================================");
        System.out.println();

        String heading = String.format("%-60s %s %9s","Product", "Quantity",  "Cost");
        System.out.println(heading);
        int sum = 0;
        for (int i = 0; i < cart.size(); i++) {
            System.out.print(i+1 + ". ");
            System.out.println(cart.get(i));
            sum += cart.get(i).calc_total();
        }

        System.out.println();
        System.out.println("Total amount: " + sum + " SAR");

        System.out.println();
        System.out.print("> Continue to checkout(C), remove some products(R), or go back to menu(M): ");
        String ans = read.next();
        if (ans.equalsIgnoreCase("R")) {

            int choice = 0;
            while(choice != -1) {
                System.out.print("Remove(Enter 0 to stop): ");
                choice = read.nextInt() - 1;
                if (choice < cart.size() && choice >= 0) {
                    cart.remove(cart.get(choice));
                }
            }
            printCart(cart);

        } else if (ans.equalsIgnoreCase("M")) {
            notifyController.getMenu(cart);
        } else if (ans.equalsIgnoreCase("C")) {
            notifyController.getCheckout(cart);
        }
    }

    public void setNotifyConrtoller(Controller.NotifyController notifyController) {
        this.notifyController = notifyController;
    }
}
