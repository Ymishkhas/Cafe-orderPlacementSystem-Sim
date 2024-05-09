package Cafe_produtcts.addOns;

import Cafe_produtcts.CafeProduct;
import Cafe_produtcts.Coffee.Coffee;
public class Cream extends Coffee_addOns {

    public Cream(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Cream";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 3;
    }
}
