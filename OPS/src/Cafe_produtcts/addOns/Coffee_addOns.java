package Cafe_produtcts.addOns;

import Cafe_produtcts.CafeProduct;
import Cafe_produtcts.Coffee.Coffee;

public abstract class Coffee_addOns extends Coffee {
    Coffee coffee;

    public Coffee_addOns(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getPrice() {
        return coffee.getPrice();
    }

}
