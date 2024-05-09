package Cafe_produtcts.addOns;

import Cafe_produtcts.CafeProduct;
import Cafe_produtcts.Coffee.Coffee;

public class CaramelSauce extends Coffee_addOns {

    public CaramelSauce(Coffee coffee){
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
