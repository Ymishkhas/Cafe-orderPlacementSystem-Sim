import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Cafe_produtcts.*;
import Cafe_produtcts.Coffee.*;
import Cafe_produtcts.addOns.*;

public class MenuView {

    // Observer to listen if customer wants checkout and notify controller
    Controller.NotifyController notifyController;

    // To read customer input
    Scanner read = new Scanner(System.in);

    // List holding tmp items until customer confirms
    List<CafeProduct> items = new ArrayList<>();

    public void printMenu() {
        System.out.println("============================================================");
        System.out.println("                    Welcome to FCIT Cafe                    ");
        System.out.println("============================================================");
        System.out.println();

        System.out.println("                           Menu                             ");
        System.out.println("============================================================");
        System.out.println("                          Coffee                            ");
        System.out.println("    1. American Coffee");
        System.out.println("    2. Cappucchino");
        System.out.println("    3. Espresso");
        System.out.println("    4. French Coffee");
        System.out.println("    5. Spanish Latte");
        System.out.println();
        System.out.println("                          Pastries                          ");
        System.out.println("    6. Chocolate Cake");
        System.out.println("    7. Cookies");
        System.out.println("    8. Halloumi Sandwich");
        System.out.println("    9. Tuna Club");
        System.out.println();
        System.out.println("                          Beverages                         ");
        System.out.println("    10. Mojito");
        System.out.println("    11. Orange Juice");
        System.out.println("    12. Water");
        System.out.println();

        // Read input
        CafeProductsFactory factory = new CafeProductsFactory();
        int choice = -1;
        System.out.print("Select: ");
        choice = read.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1: printCoffeeCustomization(factory.getProduct("American Coffee")); break;
                case 2: printCoffeeCustomization(factory.getProduct("Cappucchino")); break;
                case 3: printCoffeeCustomization(factory.getProduct("Espresso")); break;
                case 4: printCoffeeCustomization(factory.getProduct("French Coffee")); break;
                case 5: printCoffeeCustomization(factory.getProduct("Spanish Latte")); break;

                case 6: printPastrieCustomization(factory.getProduct("Chocolate Cake")); break;
                case 7: printPastrieCustomization(factory.getProduct("Cookies")); break;
                case 8: printPastrieCustomization(factory.getProduct("Halloumi Sandwich")); break;
                case 9: printPastrieCustomization(factory.getProduct("Tuna Club")); break;

                case 10: printBeverageCustomization(factory.getProduct("Mojito")); break;
                case 11: printBeverageCustomization(factory.getProduct("Orange Juice")); break;
                case 12: printBeverageCustomization(factory.getProduct("Water")); break;
            }

            System.out.println("\nYou can go to your cart by entering 0");
            System.out.print("Select: ");
            choice = read.nextInt();
        }

        notifyController.getCart(items);

    }

    public void printCoffeeCustomization(CafeProduct coffee) {

        System.out.println("");
        System.out.println("Customize " + coffee.getDescription());

        System.out.println("> Choose desired Add-ons:");
        System.out.println("1. Caramel Sauce");
        System.out.println("2. Cream");
        System.out.println("3. Whipped Cream");
        System.out.println("4. That's enough");

        int choice = 0;
        while(choice != 4) {
            System.out.print("Add: ");
            choice = read.nextInt();
            switch (choice) {
                case 1: coffee =  new CaramelSauce((Coffee) coffee); break;
                case 2: coffee =  new Cream((Coffee) coffee); break;
                case 3: coffee =  new Whippedcream((Coffee) coffee); break;
            }
        }

        System.out.print("> Select the size(S/L): ");
        String size = read.next();
        coffee.setSize(size);

        System.out.print("> Select item quantity: ");
        int qyt = read.nextInt();
        coffee.setQty(qyt);

        System.out.print("> Confirm customizations(Y/N): ");
        String confirm = read.next();
        if (confirm.equalsIgnoreCase("Y")) {
            items.add(coffee);
            System.out.println("\nAdded: " + coffee.getDescription());
        } else {
            coffee = null;
        }
    }

    public void printPastrieCustomization(CafeProduct Pastrie) {

        System.out.println("");
        System.out.println("Customize " + Pastrie.getDescription());

        System.out.print("> Select item quantity: ");
        int qyt = read.nextInt();
        Pastrie.setQty(qyt);

        System.out.print("> Confirm customizations(Y/N): ");
        String confirm = read.next();
        if (confirm.equalsIgnoreCase("Y")) {
            items.add(Pastrie);
            System.out.println("Added: " + Pastrie.getDescription());
        } else {
            Pastrie = null;
        }
    }
    public void printBeverageCustomization(CafeProduct beverage) {

        System.out.println("");
        System.out.println("Customize " + beverage.getDescription());

        System.out.print("> Select the size(S/L): ");
        String size = read.next();
        beverage.setSize(size);

        System.out.print("> Select item quantity: ");
        int qyt = read.nextInt();
        beverage.setQty(qyt);

        System.out.print("> Confirm customizations(Y/N): ");
        String confirm = read.next();
        if (confirm.equalsIgnoreCase("Y")) {
            items.add(beverage);
            System.out.println("Added: " + beverage.getDescription());
        } else {
            beverage = null;
        }
    }

    public void setNotifyConrtoller(Controller.NotifyController notifyController) {
        this.notifyController = notifyController;
    }
}