package Cafe_produtcts.addOns;

import Cafe_produtcts.CafeProduct;
import Cafe_produtcts.Coffee.Coffee;


public class Whippedcream extends Coffee_addOns {
    public Whippedcream(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 4;
    }
}
