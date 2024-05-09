package Cafe_produtcts;

import Cafe_produtcts.Beverages.*;
import Cafe_produtcts.Coffee.*;
import Cafe_produtcts.Pastries.*;


public class CafeProductsFactory {
    public CafeProduct getProduct(String product) {
        switch (product) {
            case "American Coffee": return new AmericanCoffee();
            case "Cappucchino": return new Cappuccino();
            case "Espresso": return new Espresso();
            case "French Coffee": return new FrenchCoffee();
            case "Spanish Latte": return new SpanishLatte();

            case "Chocolate Cake": return new Chocolatecake();
            case "Cookies": return new Cookies();
            case "Halloumi Sandwich": return new HalloumiSandwich();
            case "Tuna Club": return new TunaClub();

            case "Mojito": return new Mojito();
            case "Orange Juice": return new OrangeJuice();
            case "Water": return new Water();
        }
        return null;
    }
}
