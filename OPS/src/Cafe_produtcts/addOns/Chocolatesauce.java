package Cafe_produtcts.addOns;

import Cafe_produtcts.CafeProduct;
import Cafe_produtcts.Coffee.Coffee;


public class Chocolatesauce extends Coffee_addOns {

    public Chocolatesauce(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Carmel Sauce";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 2;
    }
}
